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
    private List<Pais> pais;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private List<Autor> autor;

    public PaisAutor() {
    }

    public PaisAutor(Integer id, List pais, List autor) {
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

    public List getPais() {
        return pais;
    }

    public void setPais(List pais) {
        this.pais = pais;
    }

    public List getAutor() {
        return autor;
    }

    public void setAutor(List autor) {
        this.autor = autor;
    }
}
