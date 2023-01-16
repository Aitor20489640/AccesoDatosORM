package org.aitororm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Direccion direccion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Modulo> modulos;

    public Profesor() {
    }

    public Profesor(String nombre, String primerApellido, String segundoApellido, String telefono, Direccion direccion, Set<Modulo> modulos) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.modulos = modulos;
    }

    public Profesor(String nombre, String primerApellido, String segundoApellido, String telefono, Direccion direccion) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion=" + direccion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return id == profesor.id && Objects.equals(nombre, profesor.nombre) && Objects.equals(primerApellido, profesor.primerApellido) && Objects.equals(segundoApellido, profesor.segundoApellido) && Objects.equals(telefono, profesor.telefono) && Objects.equals(direccion, profesor.direccion) && Objects.equals(modulos, profesor.modulos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, primerApellido, segundoApellido, telefono, direccion);
    }
}
