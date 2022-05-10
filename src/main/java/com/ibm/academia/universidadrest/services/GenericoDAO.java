package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Carrera;

import java.util.Optional;

public interface GenericoDAO<E> {
    public Optional<E> buscarPorId(Integer id);
    public E guardar(E entidad);
    public Iterable<E> buscarTodos();
    public void eliminarPorId(Integer id);
}
