package org.aitororm;


import org.aitororm.entities.Modulo;
import org.aitororm.entities.Profesor;
import org.aitororm.repositories.ModuloRepository;
import org.aitororm.repositories.ProfesorRepository;

import java.util.Optional;

public class App 
{
    public static void main( String[] args )
    {
        Profesor p1 = new Profesor("p1", "p1", "p1", "11111111");
        Modulo m1 = new Modulo("nombre1", "curso1", 2, p1);
        Modulo m2 = new Modulo("nombre2", "curso2", 3, p1);
        Modulo m3 = new Modulo("nombre3", "curso3", 4, p1);

        ProfesorRepository profesores = new ProfesorRepository();
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

        modulos.close();
    }
}
