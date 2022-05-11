package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Pabellon;
import com.ibm.academia.universidadrest.repositories.PabellonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository>{
    @Autowired
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }
}
