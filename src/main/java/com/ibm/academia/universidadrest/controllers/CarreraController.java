package com.ibm.academia.universidadrest.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.exceptions.BadRequestException;
import com.ibm.academia.universidadrest.exceptions.NotFoundException;
import com.ibm.academia.universidadrest.services.CarreraDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private CarreraDao carreraDao;

    @GetMapping("/lista/carreras")
    public List<Carrera> buscarTodas() {
        List<Carrera> carreras = (List<Carrera>) carreraDao.buscarTodos();
        if (carreras.isEmpty())
            throw new BadRequestException("No existen carreras");
        return carreras;
    }

    @GetMapping("/id/{carreraId}")
    public Carrera buscaCarreraPorId(@PathVariable Integer carreraId) {
        Optional<Carrera> carrera = carreraDao.buscarPorId(carreraId);
        if (!carrera.isPresent())
            throw new BadRequestException(String.format("La carrera con ID: %d no existe",carreraId));
        return carrera.get();
    }

    @PostMapping
    public ResponseEntity<?> guardaCarrera(@Valid @RequestBody Carrera carrera, BindingResult result) {

        Map<String, Object> validaciones = new HashMap<String, Object>();
        if (result.hasErrors()) {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista errores", listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Carrera carreraGuardada = carreraDao.guardar(carrera);
        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }

    /**
     * endpoint para actualizar un objeto carrera
     * @param carreraId parametro id de la carrera para buscarla en la bd
     * @param carrera ingresar los paramteros de la carrera a actualizar
     * @return regresa la carrera con los datos actualizados
     * @NotFoundException en caso de que no pueda actualizar el objeto carrera
     * @Author MMAP 15/05/2022
     */
    @PutMapping("/upd/carreraId/{carreraId}")
    public ResponseEntity<?> actualizarCarrera (@PathVariable Integer carreraId, @RequestBody Carrera carrera) {
        Optional<Carrera> oCarrera = carreraDao.buscarPorId(carreraId);
        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID: %d no existe",carreraId));
        Carrera carreraActualizada = carreraDao.actualizar(oCarrera.get(), carrera);
        return new ResponseEntity<Carrera>(carreraActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/carreraId/{carreraId}")
    public ResponseEntity<?> eliminarCarrera(@PathVariable Integer carreraId) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Optional<Carrera> carrera = carreraDao.buscarPorId(carreraId);
        if (!carrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID: %d no existe",carreraId));
        carreraDao.eliminarPorId(carreraId);
        respuesta.put("OK", "Carrera ID: " + carreraId + " eliminada exitosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

}
