package com.tp.webhotel.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TipoHabitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private int idTipoHabitacion;
    private String denominacion;
    private String descripcion;
    @Column(name = "capacidad_personas")
    @JsonProperty("capacidad_personas")
    private int capacidadPersonas;
    @Column(name = "precio_por_dia")
    @JsonProperty("precio_por_dia")
    private float precioPorDia;

    public TipoHabitacion(){}

    public TipoHabitacion(int idTipoHabitacion,String denominacion,String descripcion,int capacidadPersonas,float precioPorDia){
        this.idTipoHabitacion = idTipoHabitacion;
        this.denominacion = denominacion;
        this.descripcion = descripcion;
        this.capacidadPersonas = capacidadPersonas;
        this.precioPorDia = precioPorDia;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
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

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public float getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(float precioPorDia) {
        this.precioPorDia = precioPorDia;
    }
}
