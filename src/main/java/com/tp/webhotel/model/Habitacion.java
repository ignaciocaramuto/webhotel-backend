package com.tp.webhotel.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Validated
public class Habitacion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_habitacion",nullable = false,updatable = false)
    private int id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_habitacion",nullable = false)
    private TipoHabitacion tipoHabitacion;

    @Column(name = "nro_habitacion",unique = true)
    @NaturalId(mutable = true)
    private int nroHabitacion;

    public Habitacion(){}

    public Habitacion(int id,TipoHabitacion tipoHabitacion){
        this.id = id;
        this.tipoHabitacion = tipoHabitacion;
    }

}




