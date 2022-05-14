package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Carrera;

import java.util.Optional;

public interface CarreraDao extends GenericoDAO<Carrera> {
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
