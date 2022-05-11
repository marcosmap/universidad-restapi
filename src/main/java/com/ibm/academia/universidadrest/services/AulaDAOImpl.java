package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO{
    @Autowired
    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }
}
