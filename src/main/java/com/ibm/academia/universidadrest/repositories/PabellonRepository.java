package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Pabellon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

    @Query("select p from Pabellon p where p.localidad = ?1")
    public Iterable<Pabellon> buscaPabellonesPorLocalidad(String localidad);

    @Query("select p from Pabellon p where p.nombre = ?1")
    public Iterable<Pabellon> buscaPabellonesPorNombre(String nombre);

}
