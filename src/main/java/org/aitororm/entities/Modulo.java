package org.aitororm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "modulos", uniqueConstraints = @UniqueConstraint(columnNames = {"nombre", "curso"}))
public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String curso;
    private int numHorasSemanales;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Profesor profesor;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "modulos")
    private Set<Alumno> alumnos;

    public Modulo() {
    }

    public Modulo(String nombre, String curso, int numHorasSemanales, Profesor profesor) {
        this.nombre = nombre;
        this.curso = curso;
        this.numHorasSemanales = numHorasSemanales;
        this.profesor = profesor;
        alumnos = new HashSet<>();
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

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return id == modulo.id && numHorasSemanales == modulo.numHorasSemanales && Objects.equals(nombre, modulo.nombre) && Objects.equals(curso, modulo.curso) && Objects.equals(profesor, modulo.profesor) && Objects.equals(alumnos, modulo.alumnos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, curso, numHorasSemanales, profesor);
    }
}
