package com.ibm.academia.universidadrest.controllers;

import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.entities.Profesor;
import com.ibm.academia.universidadrest.exceptions.NotFoundException;
import com.ibm.academia.universidadrest.services.AlumnoDAO;
import com.ibm.academia.universidadrest.services.CarreraDao;
import com.ibm.academia.universidadrest.services.PersonaDAO;
import com.ibm.academia.universidadrest.services.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    @Qualifier("profesorDAOImpl")
    private PersonaDAO profesorDao;
    @Autowired
    private CarreraDao carreraDao;

    /**
     * Metodo para guardar objetos Persona de tipo Profesor en la bd
     * @param profesor se requiere un objeto de tipo Profesor con los datos
     * @return  retorna los datos del objeto Persona guardado
     * @author MMAP 15/05/2022
     */
    @PostMapping
    public ResponseEntity<?> crearpROFESOR(@RequestBody Persona profesor) {
        Persona personaGuardada = profesorDao.guardar(profesor);
        return new ResponseEntity<Persona>(personaGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/profesores/lista")
    public ResponseEntity<?> obtenerTodos() {
        List<Persona> profesores = (List<Persona>) profesorDao.buscarTodos();
        if (profesores.isEmpty())
            throw new NotFoundException("No existen profesores");
        return new ResponseEntity<List<Persona>>(profesores, HttpStatus.OK);
    }

    @GetMapping("/profesorId/{profesorId}")
    public ResponseEntity<?> obtenerProfesorPorId(@PathVariable Integer profesorId) {
        Optional<Persona> profesorEncontrado = profesorDao.buscarPorId(profesorId);
        if (!profesorEncontrado.isPresent())
            throw new NotFoundException(String.format("No existe el profesor con ID: %d", profesorId));

        return new ResponseEntity<Persona>(profesorEncontrado.get(), HttpStatus.OK);
    }

    @PutMapping("/upd/profesorId/{profesorId}")
    public ResponseEntity<?> actualizarPorfesor (@PathVariable Integer profesorId, @RequestBody Persona profesor) {
        Optional<Persona> oProfesor = profesorDao.buscarPorId(profesorId);
        if(!oProfesor.isPresent())
            throw new NotFoundException(String.format("El porfesor con ID: %d no existe", profesorId));
        Persona profesorActualizado = ((ProfesorDAO)profesorDao).actualizar(oProfesor.get(), profesor);
        return new ResponseEntity<Persona>(profesorActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/profesorId/{profesorId}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Integer profesorId) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Optional<Persona> profesor = profesorDao.buscarPorId(profesorId);
        if (!profesor.isPresent())
            throw new NotFoundException(String.format("El profesor con ID: %d no existe", profesorId));
        profesorDao.eliminarPorId(profesorId);
        respuesta.put("OK", "Profesor ID: " + profesorId + " eliminado exitosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

    /* @PutMapping("/profesorId/{profesorId}/carreraId/{carreraId}")
    public ResponseEntity<?> asignarCarreraProfesor(@PathVariable Integer profesorId, @PathVariable Integer carreraId) {
        Optional<Persona> alumno = profesorDao.buscarPorId(profesorId);
        if (!alumno.isPresent())
            throw new NotFoundException(String.format("El alumno con ID %d no existe", profesorId));
        Optional<Carrera> carrera = carreraDao.buscarPorId(carreraId);
        if (!carrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID %d no existe", carreraId));

        Persona profesorFinal = ((ProfesorDAO)profesorDao).asociarCarreraProfesor(alumno.get(), carrera.get());
        return new ResponseEntity<Persona>(profesorFinal, HttpStatus.OK);
    } */

}
