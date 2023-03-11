package com.tp.webhotel.dtos;

import com.tp.webhotel.model.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Getter
@Setter
@Validated
public class ClienteDto {
    @NotBlank(message = "El campo apellido es requerido")
    public String apellido;
    @NotBlank(message = "El campo nombre es requerido")
    public String nombre;
    public Date fechaNacimiento;

    @Email
    @NotBlank(message = "El campo email es requerido")
    public String email;



    public Cliente toCliente(){
        Cliente cliente = new Cliente();
        cliente.setApellido(this.apellido);
        cliente.setNombre(this.nombre);
        cliente.setFechaNacimiento(this.fechaNacimiento);
        cliente.setEmail(this.email);

        return cliente;

    }
}
