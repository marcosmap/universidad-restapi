package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.enums.Pizarron;
import com.ibm.academia.universidadrest.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO{
    @Autowired
    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Aula> findByPizarron(Pizarron tipoPizarron) {
        return ((AulaRepository)repository).findByPizarron(tipoPizarron);
    }

    @Override
    public Iterable<Aula> findAulasByPabellonNombreContains(String nombrePabellon) {
        return ((AulaRepository)repository).findAulasByPabellonNombreContains(nombrePabellon);
    }

    @Override
    public Aula findByNumeroAula(Integer numeroAula) {
        return ((AulaRepository)repository).findByNumeroAula(numeroAula);
    }

}
