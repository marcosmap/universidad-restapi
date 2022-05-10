package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona> {
    public Optional<Persona> buscaPorNombreYApellido(String nombre, String apellido);
    public Optional<Persona> buscaPorDni(String dni);
    public Iterable<Persona> buscaPersonaPorApellido(String apellido);
}
