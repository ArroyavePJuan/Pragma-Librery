package com.pragma.library.entidad;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Integer id;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "apellidos")
    private String apellido;

    @Column(name = "pseudonimo", unique = true)
    private String pseudonimo;

    @Column(name = "correo")
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @Transient
    private String mensajeError;

    public Autor() {
    }

    public Autor(Integer id, String nombre, String apellido, String pseudonimo, String email, Pais pais, String mensajeError) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pseudonimo = pseudonimo;
        this.email = email;
        this.pais = pais;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
