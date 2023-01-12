package org.aitororm.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String nia;
    private String telefono;

    public Alumno() {
    }

    public Alumno(String nombre, String primerApellido, String segundoApellido, String nia, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nia = nia;
        this.telefono = telefono;
    }
}
