package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.entities.Profesor;

public interface ProfesorDAO extends PersonaDAO {
    public Iterable<Persona> findProfesoresByCarrera(String carrera);
}
