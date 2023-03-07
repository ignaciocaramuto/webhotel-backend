package com.tp.webhotel.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class TipoHabitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_habitacion",nullable = false,updatable = false)
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

}
