package com.pragma.library.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer id;

    @Column(name = "nombreCategoria", unique = true, length = 30)
    private String nombre;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Transient
    private String mensajeError;

    public Categoria() {
    }

    public Categoria(Integer id, String nombre, String descripcion, String mensajeError) {
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
