package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraDAOImpl extends GenericoDAOImpl<Carrera, CarreraRepository> implements CarreraDao{
    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido) {
        return ((CarreraRepository)repository).buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional
    public Carrera actualizar(Carrera carreraEncontrada, Carrera carrera) {
        Carrera carreraActualizada = null;
        carreraEncontrada.setCantidadAnios(carrera.getCantidadAnios());
        carreraEncontrada.setCantidadMaterias(carrera.getCantidadMaterias());
        carreraActualizada = ((CarreraRepository)repository).save(carreraEncontrada);
        return carreraActualizada;
    }
}
