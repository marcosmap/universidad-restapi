package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository {

    // @Query("select p from Profesor p where p.carrera.nombre = ?1")
    // @Query("select p from Profesor p join fetch p.carrera c where c.nombre = ?1")
    /* @Query(value = "",nativeQuery = true)
    public Iterable<Persona> buscaProfesoresPorCarrera(String carrera); */
}
