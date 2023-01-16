package org.aitororm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    @Column(unique = true)
    private String nia;
    private String telefono;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Modulo> modulos;

    public Alumno() {
    }

    public Alumno(String nombre, String primerApellido, String segundoApellido, String nia, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nia = nia;
        this.telefono = telefono;
        this.modulos = new HashSet<>();
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    public void anyadirModulo(Modulo modulo) {
        modulos.add(modulo);
        modulo.getAlumnos().add(this);
    }

    public void eliminarModulo(Modulo modulo) {
        modulos.remove(modulo);
        modulo.getAlumnos().remove(this);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", nia='" + nia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", modulos=" + modulos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && Objects.equals(nombre, alumno.nombre) && Objects.equals(primerApellido, alumno.primerApellido) && Objects.equals(segundoApellido, alumno.segundoApellido) && Objects.equals(nia, alumno.nia) && Objects.equals(telefono, alumno.telefono) && Objects.equals(modulos, alumno.modulos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, primerApellido, segundoApellido, nia, telefono, modulos);
    }
}
