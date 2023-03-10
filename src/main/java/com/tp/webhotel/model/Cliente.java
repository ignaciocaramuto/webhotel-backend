package com.tp.webhotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity // Almacena la entidad en forma de tabla en la db automaticamente
@Getter
@Setter
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente",nullable = false,updatable = false)
    @JsonProperty("id_cliente")
    private int idCliente;
    private String apellido;
    private String nombre;
    @JsonProperty("fecha_nacimiento")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private String email;
    private String clave;
    @JsonProperty("nro_tarjeta_credito")
    @Column(name = "nro_tarjeta_credito")
    private int nroTarjetaCredito;

    public Cliente() {}
    public Cliente(String apellido, String nombre, Date fechaNacimiento, String email, String clave) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.clave = clave;
    }

    public String toString() {
        return "\nPersona [id=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido
                + ", email=" + email + "]";
    }
}
