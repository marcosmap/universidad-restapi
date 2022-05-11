package com.ibm.academia.universidadrest.repositories;

import com.ibm.academia.universidadrest.entities.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

    // en estos metodos los query sql o jpql estan integrados en el nombre en ingles
    // @Query("select c from Carrera c where c.cantidadAnios = ?1")
    public Iterable<Carrera> findByCantidadAnios(Integer cantidadAnios);

    // @Query("select c from Carrera c where c.nombre like %?1%")
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    // @Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)")
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    // @Query("select c from Carrera c where c.cantidadAnios > ?1")
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    // @Query("select c from Carrera c where c.profesor.nombre = ?1 and c.profesor.apellido = ?2")
    @Query("select c from Carrera c join fetch c.profesor p where p.nombre = ?1 and p.apellido = ?2")
    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
