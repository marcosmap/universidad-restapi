package com.ibm.academia.universidadrest.services;

import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.enums.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO{
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
