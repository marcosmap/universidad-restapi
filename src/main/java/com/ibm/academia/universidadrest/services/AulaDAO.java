package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.enums.Pizarron;

public interface AulaDAO extends GenericoDAO<Aula>{
    public Iterable<Aula> findByPizarron(Pizarron tipoPizarron);
    public Iterable<Aula> findAulasByPabellonNombre(String nombrePabellon);
    public Aula findByNumeroAula(Integer numeroAula);
}
