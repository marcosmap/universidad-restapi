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
        System.out.println();
        System.out.println("realiza busqueda...");
        System.out.println();

        aulaDAO.findByPizarron(Pizarron.PIZARRA_BLANCA).forEach(System.out::println);
        // aulaDAO.findAulasByPabellonNombreContains("Pabellon 2").forEach(System.out::println);
        // System.out.println(aulaDAO.findByNumeroAula(1).toString());

        // pabellonDAO.findPabellonesByDireccionLocalidad("Ciudad de Mexico").forEach(System.out::println);
    }
}
