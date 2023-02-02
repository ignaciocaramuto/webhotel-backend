package com.tp.webhotel.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Habitacion implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int nroHabitacion;
    private int idTipoHabitacion;

    public Habitacion(){}

    public Habitacion(int nroHabitacion,int idTipoHabitacion){
        this.nroHabitacion = nroHabitacion;
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }
}




