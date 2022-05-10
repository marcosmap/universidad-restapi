package com.ibm.academia.universidadrest;

import com.ibm.academia.universidadrest.entities.Alumno;
import com.ibm.academia.universidadrest.entities.Carrera;
import com.ibm.academia.universidadrest.entities.Direccion;
import com.ibm.academia.universidadrest.entities.Persona;
import com.ibm.academia.universidadrest.services.AlumnoDAO;
import com.ibm.academia.universidadrest.services.CarreraDAOImpl;
import com.ibm.academia.universidadrest.services.CarreraDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Comandos implements CommandLineRunner {
    @Autowired
    private CarreraDao carreraDao;
    @Autowired
    private AlumnoDAO alumnoDAO;

    @Override
    public void run(String... args) throws Exception {
        //Carrera contabilidad = new Carrera(null, "Contabilidad", 30, 3);
        //Carrera contabilidad = new Carrera(null, "Matematicas", 60, 4);
        //System.out.println(carreraDao.guardar(contabilidad).toString());

        /*Direccion direccion = new Direccion("Andador de la brisa", "29", "54943", "DEPTO1", "PISO 2", "Ciudad de México");
        Persona alumno = new Alumno(null, "Marcos", "Arreguin", "DNI", direccion);
        Persona personaGuardada = alumnoDAO.guardar(alumno);
        System.out.println(personaGuardada.toString());*/

        System.out.println(carreraDao.buscarPorId(3).toString());

        /*List<Persona> listaPersonas = (List<Persona>) alumnoDAO.buscarTodos();
        listaPersonas.forEach(System.out::println);*/
    }
}
