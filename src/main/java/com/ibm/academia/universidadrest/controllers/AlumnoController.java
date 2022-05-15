package com.ibm.academia.universidadrest.controllers;

import com.ibm.academia.universidadrest.entities.Alumno;
import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.exceptions.NotFoundException;
import com.ibm.academia.universidadrest.services.AlumnoDAO;
import com.ibm.academia.universidadrest.services.CarreraDao;
import com.ibm.academia.universidadrest.services.PersonaDAO;
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
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO alumnoDAO;
    @Autowired
    private CarreraDao carreraDao;

    /**
     * Metodo para guardar un objeto Persona de tipo Alumno
     * @param alumno Objeto alumno con la información a crear
     * @return retorna una respuesta con los datos del objeto Persona guardada con estatis 201
     * @author MMAP 15/05/2022
     */
    @PostMapping
    public ResponseEntity<?> crearAlumno(@RequestBody Persona alumno) {
        Persona personaGuardada = alumnoDAO.guardar(alumno);
        return new ResponseEntity<Persona>(personaGuardada, HttpStatus.CREATED);
    }

    /**
     * Metodo para consultar todos los alumnos existentes
     * @return lista de objetos Persona de tipo Alumno
     */
    @GetMapping("/alumnos/lista")
    public ResponseEntity<?> obtenerTodos() {
        List<Persona> alumnos = (List<Persona>) alumnoDAO.buscarTodos();
        if (alumnos.isEmpty())
            throw new NotFoundException("No existen alumnos");
        return new ResponseEntity<List<Persona>>(alumnos, HttpStatus.OK);
    }

    /**
     *
     * @param alumnoId
     * @return
     */
    @GetMapping("/alumnoId/{alumnoId}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer alumnoId) {
        Optional<Persona> alumnoEncontrado = alumnoDAO.buscarPorId(alumnoId);
        if (!alumnoEncontrado.isPresent())
            throw new NotFoundException(String.format("No existe el alumno con ID: %d", alumnoId));
        return new ResponseEntity<Persona>(alumnoEncontrado.get(), HttpStatus.OK);
    }

    /**
     *
     * @param alumnoId
     * @param alumno
     * @return
     */
    @PutMapping("/upd/alumnoId/{alumnoId}")
    public ResponseEntity<?> actualizarAlumno (@PathVariable Integer alumnoId, @RequestBody Persona alumno) {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);
        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con ID: %d no existe", alumnoId));
        Persona alumnoActualizado = ((AlumnoDAO)alumnoDAO).actualizar(oAlumno.get(), alumno);
        return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
    }

    /**
     *
     * @param alumnoId
     * @return
     */
    @DeleteMapping("/alumnoId/{alumnoId}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Integer alumnoId) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Optional<Persona> alumno = alumnoDAO.buscarPorId(alumnoId);
        if (!alumno.isPresent())
            throw new NotFoundException(String.format("El alumno con ID: %d no existe", alumnoId));
        alumnoDAO.eliminarPorId(alumnoId);
        respuesta.put("OK", "Alumno ID: " + alumnoId + " eliminado exitosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

    @PutMapping("/alumnoId/{alumnoId}/carreraId/{carreraId}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer alumnoId, @PathVariable Integer carreraId) {
        Optional<Persona> alumno = alumnoDAO.buscarPorId(alumnoId);
        if (!alumno.isPresent())
            throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));
        Optional<Carrera> carrera = carreraDao.buscarPorId(carreraId);
        if (!carrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID %d no existe", carreraId));

        Persona alumnoFinal = ((AlumnoDAO)alumnoDAO).asociarCarreraAlumno(alumno.get(), carrera.get());
        return new ResponseEntity<Persona>(alumnoFinal, HttpStatus.OK);
    }

}
