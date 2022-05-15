package com.ibm.academia.universidadrest.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.exceptions.BadRequestException;
import com.ibm.academia.universidadrest.services.CarreraDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> guardaCarrera(@RequestBody Carrera carrera) {
        if (carrera.getCantidadAnios() <= 0)
            throw  new BadRequestException("El campo cantidadAnios debe ser mayor a cero");

        if (carrera.getCantidadMaterias() <= 0)
            throw  new BadRequestException("El campo cantidadMaterias debe ser mayor a cero");

        Carrera carreraGuardada = carreraDao.guardar(carrera);

        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }

}
