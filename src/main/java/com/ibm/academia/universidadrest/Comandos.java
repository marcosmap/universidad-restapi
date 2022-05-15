package com.ibm.academia.universidadrest;

import com.ibm.academia.universidadrest.entities.*;
import com.ibm.academia.universidadrest.enums.Pizarron;
import com.ibm.academia.universidadrest.enums.TipoEmpleado;
import com.ibm.academia.universidadrest.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    @Autowired
    private AlumnoDAO alumnoDAO;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("realiza busqueda...");
        System.out.println();

         /* carreraDao.guardar(new Carrera(null, "Ingeniería en Computación", 48, 4));
        carreraDao.guardar(new Carrera(null, "Contabilidad", 36, 3));
        carreraDao.guardar(new Carrera(null, "Qímico Farmacobiólogo", 60, 5));
        carreraDao.guardar(new Carrera(null, "Actuaría", 55, 4));
        carreraDao.guardar(new Carrera(null, "Medicina", 62, 5)); */

    }
}
