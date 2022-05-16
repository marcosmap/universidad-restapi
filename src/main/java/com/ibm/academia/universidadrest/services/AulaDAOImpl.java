package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.entities.Pabellon;
import com.ibm.academia.universidadrest.entities.Persona;
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
    public Iterable<Aula> findAulasByPabellonNombre(String nombrePabellon) {
        return ((AulaRepository)repository).findAulasByPabellonNombre(nombrePabellon);
    }

    @Override
    public Aula findByNumeroAula(Integer numeroAula) {
        return ((AulaRepository)repository).findByNumeroAula(numeroAula);
    }

    @Override
    public Aula actualizar(Aula aulaEncontrado, Aula aula) {
        Aula aulaActualizada = null;
        aulaEncontrado.setCantidadPupitres(aula.getCantidadPupitres());
        aulaEncontrado.setPizarron(aula.getPizarron());
        aulaEncontrado.setMedidas(aula.getMedidas());
        aulaActualizada = repository.save(aulaEncontrado);
        return aulaActualizada;
    }

    @Override
    public Aula asociarPabellonAula(Aula aula, Pabellon pabellon) {
        aula.setPabellon(pabellon);
        return repository.save(aula);
    }
}
