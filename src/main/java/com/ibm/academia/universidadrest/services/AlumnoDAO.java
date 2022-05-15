package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.entities.Persona;

import java.util.Optional;

public interface AlumnoDAO extends PersonaDAO{

    public Iterable<Persona> buscaAlumnoPorNombreCarrera(String nombre);
    public Persona actualizar(Persona alumnoEncontrado, Persona alumno);
    public Persona asociarCarreraAlumno(Persona alumno, Carrera carrera);

}
