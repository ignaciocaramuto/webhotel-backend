package com.tp.webhotel.controller;

import java.sql.Date;
import java.util.List;
import com.tp.webhotel.model.Cliente;
import com.tp.webhotel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = {"http://localhost:8080"}) Esto se utiliza para permitir las peticiones de ciertos origenes unicamente, cuando tengamos el front lo descomentamos
@RestController
@RequestMapping(path = "api/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path="/all")
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping(path = "/register")
    public void registrarNuevoCliente(@RequestBody Cliente cliente){
        clienteService.agregarNuevoCliente(cliente);
    }

    @PutMapping(path = "/{clienteId}")
    public void actualizarCliente(
            @PathVariable("clienteId") int id,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String clave,
            @RequestParam(required = false) Date fechaNacimiento,
            @RequestParam(required = false) int nroTarjetaCredito) {
                clienteService.actualizarCliente(
                        id, apellido, nombre, email, clave, fechaNacimiento, nroTarjetaCredito
                );
    }

    @DeleteMapping(path = "/{clienteId}")
    public void eliminarCliente(@PathVariable("clienteId") int id){
        clienteService.eliminarCliente(id);
    }

}
