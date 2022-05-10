package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraDAOImpl extends GenericoDAOImpl<Carrera, CarreraRepository> implements CarreraDao{
    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }
}
