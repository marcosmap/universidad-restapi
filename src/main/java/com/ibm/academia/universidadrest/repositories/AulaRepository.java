package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Aula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository {

    @Query("select a from Aula a where a.tipoPizarron = ?1")
    public Iterable<Aula> buscarAulasPorTipoPizarron(String tipoPizarron);

    @Query("select a from Aula a where a.pabellon.nombre = ?1")
    public Iterable<Aula> buscarAulasPorNombrePabellon(String nombrePabellon);

    @Query("select a from Aula a where a.numeroAula = ?1")
    public Aula buscaAulaPorNumero(Integer numeroAula);

}
