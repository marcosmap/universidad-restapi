package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Alumno;
import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.entities.Profesor;
import com.ibm.academia.universidadrest.repositories.PersonaRepository;
import com.ibm.academia.universidadrest.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {
    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesores") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(carrera);
    }

    @Override
    @Transactional
    public Persona actualizar(Persona profesorEncontrado, Persona profesor) {
        Persona personaActualizada = null;
        profesorEncontrado.setNombre(profesor.getNombre());
        profesorEncontrado.setApellido(profesor.getApellido());
        profesorEncontrado.setDireccion(profesor.getDireccion());
        personaActualizada = repository.save(profesorEncontrado);
        return personaActualizada;
    }

    /* @Override
    public Persona asociarCarreraProfesor(Persona profesor, Carrera carrera) {
        ((Profesor)profesor).setCarreras(carrera);
        return repository.save(profesor);
    } */
}
