package com.tp.webhotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Estadia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEstadia",nullable = false,updatable = false)
    private int idEstadia;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private String estado;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idCliente",nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idHabitacion")
    private Habitacion habitacion;




    public Estadia(){}

    public Estadia(Date fechaIngreso,Date fechaEgreso,String estado,Cliente cliente,Habitacion habitacion){

        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.cliente = cliente;
        this.habitacion = habitacion;

    }

    public int getidEstadia() {
        return idEstadia;
    }

    public void setidEstadia(int idEstadia) {
        this.idEstadia = idEstadia;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}


