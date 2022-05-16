package com.ibm.academia.universidadrest.controllers;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.entities.Pabellon;
import com.ibm.academia.universidadrest.entities.Persona;
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
@RequestMapping("/pabellon")
public class PabellonController {

    @Autowired
    private AulaDAO aulaDAO;
    @Autowired
    private PabellonDAO pabellonDAO;

    @PostMapping
    public ResponseEntity<?> crearPabellon(@RequestBody Pabellon pabellon) {
        Pabellon pabellonGuardado = pabellonDAO.guardar(pabellon);
        return new ResponseEntity<Pabellon>(pabellonGuardado, HttpStatus.CREATED);
    }

    @GetMapping("/pabellones/lista")
    public ResponseEntity<?> obtenerTodos() {
        List<Pabellon> pabellones = (List<Pabellon>) pabellonDAO.buscarTodos();
        if (pabellones.isEmpty())
            throw new NotFoundException("No existen pabellones");
        return new ResponseEntity<List<Pabellon>>(pabellones, HttpStatus.OK);
    }

    @GetMapping("/pabellonId/{pabellonId}")
    public ResponseEntity<?> obtenerPabellonPorId(@PathVariable Integer pabellonId) {
        Optional<Pabellon> pabellonEncontrado = pabellonDAO.buscarPorId(pabellonId);
        if (!pabellonEncontrado.isPresent())
            throw new NotFoundException(String.format("No existe el pabellon con ID: %d", pabellonId));
        return new ResponseEntity<Pabellon>(pabellonEncontrado.get(), HttpStatus.OK);
    }

    @PutMapping("/upd/pabellonId/{pabellonId}")
    public ResponseEntity<?> actualizarPabellon (@PathVariable Integer pabellonId, @RequestBody Pabellon pabellon) {
        Optional<Pabellon> oPabellon = pabellonDAO.buscarPorId(pabellonId);
        if(!oPabellon.isPresent())
            throw new NotFoundException(String.format("El pabellon con ID: %d no existe", pabellonId));
        Pabellon pabellonActualizado = pabellonDAO.actualizar(oPabellon.get(), pabellon);
        return new ResponseEntity<Pabellon>(pabellonActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/pabellonId/{pabellonId}")
    public ResponseEntity<?> eliminarPabellon(@PathVariable Integer pabellonId) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Optional<Pabellon> pabellon = pabellonDAO.buscarPorId(pabellonId);
        if (!pabellon.isPresent())
            throw new NotFoundException(String.format("El alumno con ID: %d no existe", pabellonId));
        pabellonDAO.eliminarPorId(pabellonId);
        respuesta.put("OK", "Pabellon ID: " + pabellonId + " eliminado exitosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

}
