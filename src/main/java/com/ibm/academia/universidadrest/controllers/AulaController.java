package com.ibm.academia.universidadrest.controllers;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.entities.Pabellon;
import com.ibm.academia.universidadrest.exceptions.NotFoundException;
import com.ibm.academia.universidadrest.services.AlumnoDAO;
import com.ibm.academia.universidadrest.services.AulaDAO;
import com.ibm.academia.universidadrest.services.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaDAO aulaDAO;
    @Autowired
    private PabellonDAO pabellonDAO;

    @PostMapping
    public ResponseEntity<?> crearAula(@RequestBody Aula aula) {
        Aula aulaGuardada = aulaDAO.guardar(aula);
        return new ResponseEntity<Aula>(aulaGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/aulas/lista")
    public ResponseEntity<?> obtenerTodos() {
        List<Aula> aulas = (List<Aula>) aulaDAO.buscarTodos();
        if (aulas.isEmpty())
            throw new NotFoundException("No existen aulas");
        return new ResponseEntity<List<Aula>>(aulas, HttpStatus.OK);
    }

    @GetMapping("/aulaId/{aulaId}")
    public ResponseEntity<?> obtenerAulaPorId(@PathVariable Integer aulaId) {
        Optional<Aula> aulaEncontrado = aulaDAO.buscarPorId(aulaId);
        if (!aulaEncontrado.isPresent())
            throw new NotFoundException(String.format("No existe el aula con ID: %d", aulaId));
        return new ResponseEntity<Aula>(aulaEncontrado.get(), HttpStatus.OK);
    }

    @PutMapping("/upd/aulaId/{aulaId}")
    public ResponseEntity<?> actualizarAula (@PathVariable Integer aulaId, @RequestBody Aula aula) {
        Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);
        if(!oAula.isPresent())
            throw new NotFoundException(String.format("El aula con ID: %d no existe", aulaId));
        Aula aulaActualizado = aulaDAO.actualizar(oAula.get(), aula);
        return new ResponseEntity<Aula>(aulaActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/aulaId/{aulaId}")
    public ResponseEntity<?> eliminarAula(@PathVariable Integer aulaId) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Optional<Aula> aula = aulaDAO.buscarPorId(aulaId);
        if (!aula.isPresent())
            throw new NotFoundException(String.format("El aula con ID: %d no existe", aulaId));
        aulaDAO.eliminarPorId(aulaId);
        respuesta.put("OK", "Aula ID: " + aulaId + " eliminada exitosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

    @PutMapping("/aulaId/{aulaId}/pabellonId/{pabellonId}")
    public ResponseEntity<?> asignarPabellonAula(@PathVariable Integer aulaId, @PathVariable Integer pabellonId) {
        Optional<Aula> aula = aulaDAO.buscarPorId(aulaId);
        if (!aula.isPresent())
            throw new NotFoundException(String.format("El aula con ID %d no existe", aulaId));
        Optional<Pabellon> pabellon = pabellonDAO.buscarPorId(pabellonId);
        if (!pabellon.isPresent())
            throw new NotFoundException(String.format("El pabellon con ID %d no existe", pabellonId));

        Aula aulaFinal = aulaDAO.asociarPabellonAula(aula.get(), pabellon.get());
        return new ResponseEntity<Aula>(aulaFinal, HttpStatus.OK);
    }

}
