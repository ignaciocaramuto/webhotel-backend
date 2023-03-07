package com.tp.webhotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Estadia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estadia",nullable = false,updatable = false)
    @JsonProperty("id_estadia")
    private int idEstadia;

    @Column(name = "fecha_ingreso")
    @JsonProperty("fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "fecha_egreso")
    @JsonProperty("fecha_egreso")
    private Date fechaEgreso;
    private String estado;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente",nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;




    public Estadia(){}

    public Estadia(Date fechaIngreso,Date fechaEgreso,String estado,Cliente cliente,Habitacion habitacion){

        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.cliente = cliente;
        this.habitacion = habitacion;

    }

}


