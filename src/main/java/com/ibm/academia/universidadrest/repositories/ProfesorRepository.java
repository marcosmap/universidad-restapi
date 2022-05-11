package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository {

    @Query("select p from Profesor p where p.carrera.nombre = ?1")
    public Iterable<Persona> findProfesoresByCarrera(String carrera);

}
