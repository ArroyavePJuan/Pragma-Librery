package com.pragma.library.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "editoriales")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id")
    private Integer id;

    @Column(name = "nombre", unique = true, length = 30)
    private String nombre;

    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Transient
    private String mensajeError;

    public Editorial() {
    }

    public Editorial(Integer id, String nombre, String descripcion, String mensajeError) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mensajeError = mensajeError;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
