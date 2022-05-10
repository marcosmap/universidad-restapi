package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.repositories.PersonaRepository;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO {
    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Persona> buscaPorNombreYApellido(String nombre, String apellido) {
        return repository.buscaPorNombreYApellido(nombre, apellido);
    }

    @Override
    public Optional<Persona> buscaPorDni(String dni) {
        return repository.buscaPorDni(dni);
    }

    @Override
    public Iterable<Persona> buscaPersonaPorApellido(String apellido) {
        return repository.buscaPersonaPorApellido(apellido);
    }
}
