package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository {

    // @Query("select p from Profesor p where p.carrera.nombre = ?1")
    // @Query("select p from Profesor p join fetch p.Carrera c where c.nombre = ?1")
    //@Query(value = "select * from personas, carreras, profesores, profesor_carrera where carreras.nombre = ?1 and carreras.id = profesor_carrera.carrera_id and profesor_carrera.profesor_id = profesores.persona_id and profesores.persona_id = personas.id", nativeQuery = true)
    @Query(value = "select public.personas.nombre, public.personas.apellido from public.personas, public.carreras, public.profesores, public.profesor_carrera " +
            "where public.carreras.nombre = ?1 and " +
            "public.carreras.id = public.profesor_carrera.carrera_id and " +
            "public.profesor_carrera.profesor_id = public.profesores.persona_id and " +
            "public.profesores.persona_id = public.personas.id", nativeQuery = true)
    public Iterable<Persona> buscaProfesoresPorCarrera(String carrera);
}
