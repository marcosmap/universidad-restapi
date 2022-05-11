package com.ibm.academia.universidadrest;

import com.ibm.academia.universidadrest.entities.*;
import com.ibm.academia.universidadrest.enums.Pizarron;
import com.ibm.academia.universidadrest.enums.TipoEmpleado;
import com.ibm.academia.universidadrest.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Comandos implements CommandLineRunner {
    @Autowired
    private EmpleadoDAO empleadoDAO;
    @Autowired
    private AulaDAO aulaDAO;
    @Autowired
    private PabellonDAO pabellonDAO;
    @Autowired
    private CarreraDao carreraDao;

    @Override
    public void run(String... args) throws Exception {

        /*Persona empleado = new Empleado(null, "Jorge", "Arreguin", "DNI2", new Direccion("calle 1", "1", "54943", "depto 1", "piso 2", "Ciudad de México"), new BigDecimal(25000), TipoEmpleado.ADMINISTRATIVO);
        System.out.println(empleadoDAO.guardar(empleado).toString());*/

        /* Aula aula1 = new Aula(null, 1, "10x15", 50, Pizarron.PIZARRA_BLANCA);
        System.out.println(aulaDAO.guardar(aula1).toString()); */

        /*Pabellon pabellon1 = new Pabellon(null, 75.0, "Pabellon 2", new Direccion("calle 1", "numero 1", "12345", "depto 2", "piso 2", "Ciudad de Mexico"));
        System.out.println(pabellonDAO.guardar(pabellon1).toString());*/

        //Profesor profesor1 = new Profesor(null, "Marcos", "Arreguin", "DNI1", new Direccion("calle 1", "1", "54943", "depto 1", "piso 2", "Ciudad de México"), new BigDecimal(25000));
        //System.out.println(profesorDAO.guardar(profesor1).toString());
    }
}
