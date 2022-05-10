package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

    @Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
    public Optional<Persona> buscaPorNombreYApellido(String nombre, String apellido);

    @Query("select p from Persona p where p.dni = ?1")
    public Optional<Persona> buscaPorDni(String dni);

    @Query("select p from Persona p where p.apellido like %?1%")
    public Iterable<Persona> buscaPersonaPorApellido(String apellido);

    @Query(value = "select * from public.personas where id = ?1", nativeQuery = true)
    public Persona buscarPorId(Integer id);
}
