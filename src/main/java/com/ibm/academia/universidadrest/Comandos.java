package com.ibm.academia.universidadrest;

import com.ibm.academia.universidadrest.entities.*;
import com.ibm.academia.universidadrest.enums.Pizarron;
import com.ibm.academia.universidadrest.enums.TipoEmpleado;
import com.ibm.academia.universidadrest.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private ProfesorDAO profesorDAO;

    @Override
    public void run(String... args) throws Exception {

        /*Persona empleado = new Empleado(null, "Jorge", "Arreguin", "DNI2", new Direccion("calle 1", "1", "54943", "depto 1", "piso 2", "Ciudad de México"), new BigDecimal(25000), TipoEmpleado.ADMINISTRATIVO);
        System.out.println(empleadoDAO.guardar(empleado).toString());*/

        /* Aula aula1 = new Aula(null, 1, "10x15", 50, Pizarron.PIZARRA_BLANCA);
        System.out.println(aulaDAO.guardar(aula1).toString()); */

        /*Pabellon pabellon1 = new Pabellon(null, 75.0, "Pabellon 2", new Direccion("calle 1", "numero 1", "12345", "depto 2", "piso 2", "Ciudad de Mexico"));
        System.out.println(pabellonDAO.guardar(pabellon1).toString());*/

        /* Profesor profesor1 = new Profesor(null, "Marcos", "Arreguin", "DNI1", new Direccion("calle 1", "1", "54943", "depto 1", "piso 2", "Ciudad de México"), new BigDecimal(25000));
        System.out.println(profesorDAO.guardar(profesor1).toString()); */

        /* Profesor profesor1 = new Profesor(null, "Martha", "Perez", "DNI6", new Direccion("brisa", "29", "54943", "depto 7", "piso 4", "Ciudad Labor"), new BigDecimal(12000));
        Set<Carrera> carreras =  new HashSet<>();
        carreras.add(carreraDao.buscarPorId(6).get());
        profesor1.setCarreras(carreras);
        System.out.println(profesorDAO.guardar(profesor1).toString()); */

        /* Carrera carrera1 = new Carrera(null, "Programacion I", 48, 4);
        Set<Profesor> profesores = new HashSet<>();
        profesores.add(profesor1);
        carrera1.setProfesores(profesores);
        System.out.println(carreraDao.guardar(carrera1).toString()); */

        System.out.println();
        System.out.println("realiza busqueda...");
        System.out.println();
        profesorDAO.buscaProfesoresPorCarrera("Matematicas").forEach(System.out::println);
        //profesorDAO.buscarTodos().forEach(System.out::println);
    }
}
