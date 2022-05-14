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

    @Override
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }

    @Override
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido) {
        return ((CarreraRepository)repository).buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
    }
}
