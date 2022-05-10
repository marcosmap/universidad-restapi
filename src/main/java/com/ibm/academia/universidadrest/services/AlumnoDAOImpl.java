package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Alumno;
import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.repositories.AlumnoRepository;
import com.ibm.academia.universidadrest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO{

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> buscaAlumnoPorNombreCarrera(String nombre) {
        return ((AlumnoDAO)repository).buscaAlumnoPorNombreCarrera(nombre);
    }
}
