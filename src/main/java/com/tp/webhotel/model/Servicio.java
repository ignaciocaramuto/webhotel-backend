package com.tp.webhotel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio",nullable = false,updatable = false)
    private int idServicio;
    private String denominacion;
    private String descripcion;
    private double costo;

    public Servicio(){}

    public Servicio(int idServicio,String denominacion,String descripcion,double costo){
        this.idServicio = idServicio;
        this.denominacion = denominacion;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
