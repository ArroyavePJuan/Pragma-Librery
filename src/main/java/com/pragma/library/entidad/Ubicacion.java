package com.pragma.library.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "ubicaciones")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ubicacion_id")
    private Integer id;

    @Column(name = "piso", length = 20)
    private String piso;

    @Column(name = "salon", length = 20)
    private String salon;

    @Column(name = "estante", length = 20)
    private String estante;

    @Transient
    private String mensajeError;

    public Ubicacion() {
    }

    public Ubicacion(Integer id, String piso, String salon, String estante, String mensajeError) {
        this.id = id;
        this.piso = piso;
        this.salon = salon;
        this.estante = estante;
        this.mensajeError = mensajeError;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
