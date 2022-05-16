package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Aula;
import com.ibm.academia.universidadrest.entities.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon>{
    public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);
    public Iterable<Pabellon> findPabellonesByNombreContains(String nombrePabellon);
    public Pabellon actualizar(Pabellon pabellonEncontrado, Pabellon pabellon);
}
