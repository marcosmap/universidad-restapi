package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Aula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {

    //@Query("select a from Aula a where a.tipoPizarron = ?1")
    @Query(value = "select * from public.aulas where tipo_pizarron = '?1'", nativeQuery = true)
    public Iterable<Aula> buscarAulasPorTipoPizarron(String tipoPizarron);

    @Query("select a from Aula a join fetch a.pabellon p where p.nombre = ?1")
    public Iterable<Aula> buscarAulasPorNombrePabellon(String nombrePabellon);

    @Query("select a from Aula a where a.numeroAula = ?1")
    public Aula buscaAulaPorNumero(Integer numeroAula);

}
