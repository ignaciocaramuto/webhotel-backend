package com.tp.webhotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.sql.Date;

@Entity // Almacena la entidad en forma de tabla en la db automaticamente
@Getter
@Setter
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente",nullable = false,updatable = false)
    private int id;
    private String apellido;
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Email
    @NaturalId
    private String email;
    private String clave;
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
        return "\nPersona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido
                + ", email=" + email + "]";
    }
}
