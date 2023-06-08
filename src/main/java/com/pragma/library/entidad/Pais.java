package com.pragma.library.entidad;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Integer id;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @OneToMany(mappedBy = "pais")
    private List<Autor> autor;

    public Pais() {
    }

    public Pais(Integer id, String nombre, List autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
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

    public List getAutor() {
        return autor;
    }

    public void setAutor(List autor) {
        this.autor = autor;
    }
}
