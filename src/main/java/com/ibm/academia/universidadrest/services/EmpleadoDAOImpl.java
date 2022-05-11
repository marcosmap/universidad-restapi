package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO{
    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleados") PersonaRepository repository) {
        super(repository);
    }
}
