package com.ibm.academia.universidadrest.controllers;

import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.exceptions.NotFoundException;
import com.ibm.academia.universidadrest.services.AlumnoDAO;
import com.ibm.academia.universidadrest.services.EmpleadoDAO;
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
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    @Qualifier("empleadoDAOImpl")
    private PersonaDAO empleadoDao;

    @PostMapping
    public ResponseEntity<?> crearEmpleado(@RequestBody Persona empleado) {
        Persona personaGuardada = empleadoDao.guardar(empleado);
        return new ResponseEntity<Persona>(personaGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/alumnos/lista")
    public ResponseEntity<?> obtenerTodos() {
        List<Persona> empleados = (List<Persona>) empleadoDao.buscarTodos();
        if (empleados.isEmpty())
            throw new NotFoundException("No existen empleados");
        return new ResponseEntity<List<Persona>>(empleados, HttpStatus.OK);
    }

    @GetMapping("/empleadoId/{empleadoId}")
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable Integer empleadoId) {
        Optional<Persona> empleadoEncontrado = empleadoDao.buscarPorId(empleadoId);
        if (!empleadoEncontrado.isPresent())
            throw new NotFoundException(String.format("No existe el empleado con ID: %d", empleadoId));
        return new ResponseEntity<Persona>(empleadoEncontrado.get(), HttpStatus.OK);
    }

    @PutMapping("/upd/empleadoId/{empleadoId}")
    public ResponseEntity<?> actualizarEmpleado (@PathVariable Integer empleadoId, @RequestBody Persona empleado) {
        Optional<Persona> oEmpleado = empleadoDao.buscarPorId(empleadoId);
        if(!oEmpleado.isPresent())
            throw new NotFoundException(String.format("El alumno con ID: %d no existe", empleadoId));
        Persona alumnoActualizado = ((EmpleadoDAO)empleadoDao).actualizar(oEmpleado.get(), empleado);
        return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/empleadoId/{empleadoId}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Integer empleadoId) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Optional<Persona> empleado = empleadoDao.buscarPorId(empleadoId);
        if (!empleado.isPresent())
            throw new NotFoundException(String.format("El alumno con ID: %d no existe", empleadoId));
        empleadoDao.eliminarPorId(empleadoId);
        respuesta.put("OK", "Alumno ID: " + empleadoId + " eliminado exitosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

}
