package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.entities.Pabellon;
import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.enums.Pizarron;

public interface AulaDAO extends GenericoDAO<Aula>{
    public Iterable<Aula> findByPizarron(Pizarron tipoPizarron);
    public Iterable<Aula> findAulasByPabellonNombre(String nombrePabellon);
    public Aula findByNumeroAula(Integer numeroAula);
    public Aula actualizar(Aula aulaEncontrado, Aula aula);
    public Aula asociarPabellonAula(Aula aula, Pabellon pabellon);
}
