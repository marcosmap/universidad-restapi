package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Alumno;
import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.repositories.AlumnoRepository;
import com.ibm.academia.universidadrest.repositories.CarreraRepository;
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
    @Transactional(readOnly = true)
    public Iterable<Persona> buscaAlumnoPorNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).buscaAlumnoPorNombreCarrera(nombre);
    }

    @Override
    @Transactional
    public Persona actualizar(Persona alumnoEncontrado, Persona alumno) {
        Persona personaActualizada = null;
        alumnoEncontrado.setNombre(alumno.getNombre());
        alumnoEncontrado.setApellido(alumno.getApellido());
        alumnoEncontrado.setDireccion(alumno.getDireccion());
        personaActualizada = repository.save(alumnoEncontrado);
        return personaActualizada;
    }

    @Override
    @Transactional
    public Persona asociarCarreraAlumno(Persona alumno, Carrera carrera) {
        ((Alumno)alumno).setCarrera(carrera);
        return repository.save(alumno);
    }
}
