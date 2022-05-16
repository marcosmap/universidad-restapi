package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Pabellon;
import com.ibm.academia.universidadrest.repositories.PabellonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO{
    @Autowired
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad) {
        return ((PabellonRepository)repository).findPabellonesByDireccionLocalidad(localidad);
    }

    @Override
    public Iterable<Pabellon> findPabellonesByNombreContains(String nombrePabellon) {
        return ((PabellonRepository)repository).findPabellonesByNombreContains(nombrePabellon);
    }

    @Override
    public Pabellon actualizar(Pabellon pabellonEncontrado, Pabellon pabellon) {
        Pabellon pabellonActualizado = null;
        pabellonEncontrado.setNombre(pabellon.getNombre());
        pabellonEncontrado.setDireccion(pabellon.getDireccion());
        pabellonEncontrado.setMetrosCuadrados(pabellon.getMetrosCuadrados());
        pabellonActualizado = repository.save(pabellonEncontrado);
        return pabellonActualizado;
    }
}
