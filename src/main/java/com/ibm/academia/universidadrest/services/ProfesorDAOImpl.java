package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Profesor;
import com.ibm.academia.universidadrest.repositories.PersonaRepository;
import com.ibm.academia.universidadrest.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {
    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesores") PersonaRepository repository) {
        super(repository);
    }
}
