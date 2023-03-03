package com.tp.webhotel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity // Almacena la entidad en forma de tabla en la db automaticamente
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private int idCliente;
    private String apellido;
    private String nombre;
    private java.sql.Date fechaNacimiento;
    private String email;
    private String clave;
    private int nroTarjetaCredito;

    public Cliente() {}
    public Cliente(String apellido, String nombre, java.sql.Date fechaNacimiento, String email, String clave) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.clave = clave;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public java.sql.Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(java.sql.Date fecha) {
        this.fechaNacimiento = fecha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTarjetaCredito() {
        return this.nroTarjetaCredito;
    }
    public void setTarjetaCredito(int nro) {
        this.nroTarjetaCredito = nro;
    }

    public String toString() {
        return "\nPersona [id=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido
                + ", email=" + email + "]";
    }
}
