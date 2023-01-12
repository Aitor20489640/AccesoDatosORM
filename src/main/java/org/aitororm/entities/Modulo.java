package org.aitororm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "modulos")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String curso;
    private int numHorasSemanales;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Profesor profesor;

    public Modulo() {
    }

    public Modulo(String nombre, String curso, int numHorasSemanales, Profesor profesor) {
        this.nombre = nombre;
        this.curso = curso;
        this.numHorasSemanales = numHorasSemanales;
        this.profesor = profesor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNumHorasSemanales() {
        return numHorasSemanales;
    }

    public void setNumHorasSemanales(int numHorasSemanales) {
        this.numHorasSemanales = numHorasSemanales;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", numHorasSemanales=" + numHorasSemanales +
                ", profesor=" + profesor +
                '}';
    }
}
