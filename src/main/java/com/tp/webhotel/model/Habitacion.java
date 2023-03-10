package com.tp.webhotel.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Habitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_habitacion",nullable = false,updatable = false)
    @JsonProperty("id_habitacion")
    private int idHabitacion;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idTipoHabitacion",nullable = false)
    private TipoHabitacion tipoHabitacion;

    @Column(name = "nro_habitacion")
    @JsonProperty("nro_habitacion")
    private int nroHabitacion;

    public Habitacion(){}

    public Habitacion(int idHabitacion,TipoHabitacion tipoHabitacion){
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
    }

}




