package org.aitororm;


import org.aitororm.entities.Alumno;
import org.aitororm.entities.Direccion;
import org.aitororm.entities.Modulo;
import org.aitororm.entities.Profesor;
import org.aitororm.repositories.AlumnoRepository;

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
        Alumno a1 = new Alumno("a1", "a1", "a1", "1111111", "22222222");
        Alumno a2 = new Alumno("a2", "a2", "a2", "2222222", "33333333");
        a1.anyadirModulo(m1);
        a1.anyadirModulo(m2);
        a1.anyadirModulo(m1);
        a2.anyadirModulo(m2);
        a2.anyadirModulo(m3);


        AlumnoRepository alumnos = new AlumnoRepository();
        System.out.println("\nInserción y lectura Alumno ------ ");
        alumnos.create(a1);
        alumnos.create(a2);
        alumnos.readAll().forEach(System.out::println);

        System.out.println("\nLeer por id ------ ");
        Optional<Alumno> a1Copia = alumnos.read(a1.getId());
        if (a1Copia.isPresent())
            System.out.println(a1Copia);
        else
            System.out.println("El id del alumno no existe");

        System.out.println("\nTras actualizar, lectura ------ ");
        a1.setNombre("Aitor");
        alumnos.update(a1);
        System.out.println(a1);

        System.out.println("\nBorrado y lectura ------ ");
        alumnos.delete(a1);
        alumnos.readAll().forEach(System.out::println);

        alumnos.close();

    }
}
