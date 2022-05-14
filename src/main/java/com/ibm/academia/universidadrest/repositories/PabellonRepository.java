package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Pabellon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

    // @Query("select p from Pabellon p where p.localidad = ?1")
    /* @Query(value = "select * from public.pabellones where localidad = '?1'", nativeQuery = true)
    public Iterable<Pabellon> buscaPabellonesPorLocalidad(String localidad); */
    public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);

    // @Query("select p from Pabellon p where p.nombre = ?1")
    @Query(value = "select * from public.pabellones where nombre = '?1';", nativeQuery = true)
    public Iterable<Pabellon> buscaPabellonesPorNombre(String nombre);

}
