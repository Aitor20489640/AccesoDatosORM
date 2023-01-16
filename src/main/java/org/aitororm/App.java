package org.aitororm;


import org.aitororm.entities.Alumno;
import org.aitororm.entities.Direccion;
import org.aitororm.entities.Modulo;
import org.aitororm.entities.Profesor;
import org.aitororm.repositories.AlumnoRepository;
import org.aitororm.repositories.ModuloRepository;
import org.aitororm.repositories.ProfesorRepository;

import java.util.Optional;

public class App 
{
    public static void main( String[] args )
    {
        Direccion d1 = new Direccion("Calle", 32, "Almazora", "Castellon");
        Profesor p1 = new Profesor("p1", "p1", "p1", "11111111", d1);
        Modulo m1 = new Modulo("nombre1", "curso1", 2, p1);
        Modulo m2 = new Modulo("nombre2", "curso2", 3, p1);
        Modulo m3 = new Modulo("nombre3", "curso3", 4, p1);
        Modulo m4 = new Modulo("nombre2", "curso2", 3, p1);
        Alumno a1 = new Alumno("a1", "a1", "a1", "1111111", "22222222");
        Alumno a2 = new Alumno("a2", "a2", "a2", "2222222", "33333333");
        a1.anyadirModulo(m1);
        a1.anyadirModulo(m2);
        a1.anyadirModulo(m1);
        a2.anyadirModulo(m4);
        a2.anyadirModulo(m3);


        AlumnoRepository alumnos = new AlumnoRepository();
        System.out.println("\nInserción y lectura Alumno ------ ");
        alumnos.create(a1);

        alumnos.create(a2);
        alumnos.readAll().forEach(System.out::println);

        System.out.println("\nLeer por id ------ ");
        Optional<Alumno> a1Copia = alumnos.read(m1.getId());
        if (a1Copia.isPresent())
            System.out.println(a1Copia);
        else
            System.out.println("El id del alumno no existe");

        System.out.println("\nTras actualizar, lectura ------ ");
        a1.setNombre("Aitor");
        alumnos.update(a1);
        System.out.println(a1);

        alumnos.delete(a1);

        System.out.println("\nBorrado y lectura ------ ");
        alumnos.readAll().forEach(System.out::println);

        alumnos.close();
        /*
        ModuloRepository modulos = new ModuloRepository();
        System.out.println("\nInserción y lectura Modulo ------ ");
        modulos.create(m1);
        modulos.create(m2);
        modulos.create(m3);
        modulos.readAll().forEach(System.out::println);

        System.out.println("\nLeer por id ------ ");
        Optional<Modulo> m2Copia = modulos.read(m2.getId());
        if (m2Copia.isPresent())
            System.out.println(m2Copia);
        else
            System.out.println("El id del piloto no existe");

        System.out.println("\nLeer por id que no existe------ ");
        Optional<Modulo> moduloNoExiste = modulos.read(4);
        if (moduloNoExiste.isPresent())
            System.out.println(moduloNoExiste);
        else
            System.out.println("El id del modulo no existe");


        System.out.println("\nTras actualizar, lectura ------ ");
        m3.setNombre("Mates");
        modulos.update(m3);
        System.out.println(m3);

        // Borrado del piloto p3
        modulos.delete(m3);

        // Ver todos
        System.out.println("\nBorrado y lectura ------ ");
        modulos.readAll().forEach(System.out::println);

        modulos.close();*/


    }
}
