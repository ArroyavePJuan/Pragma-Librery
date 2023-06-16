package com.pragma.library.entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paisAutor")
public class PaisAutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public PaisAutor() {
    }

    public PaisAutor(Integer id, Pais pais, Autor autor) {
        this.id = id;
        this.pais = pais;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
