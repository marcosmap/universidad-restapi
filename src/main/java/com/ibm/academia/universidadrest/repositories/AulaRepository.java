package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.enums.Pizarron;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {

    //@Query("select a from Aula a where a.tipoPizarron = ?1")
    public Iterable<Aula> findByPizarron(Pizarron tipoPizarron);

    // @Query("select a from Aula a join fetch a.pabellon p where p.nombre = ?1")
    public Iterable<Aula> findAulasByPabellonNombre(String nombrePabellon);

    // @Query("select a from Aula a where a.numeroAula = ?1")
    public Aula findByNumeroAula(Integer numeroAula);

}
