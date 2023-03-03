package com.tp.webhotel.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Habitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private int idHabitacion;
    private int idTipoHabitacion;

    private int nroHabitacion;

    public Habitacion(){}

    public Habitacion(int idHabitacion,int idTipoHabitacion){
        this.idHabitacion = idHabitacion;
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }
}




