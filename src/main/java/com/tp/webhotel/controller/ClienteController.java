package com.tp.webhotel.controller;

import java.sql.Date;
import java.util.List;

import com.tp.webhotel.dtos.ClienteDto;
import com.tp.webhotel.model.Cliente;
import com.tp.webhotel.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@CrossOrigin(origins = {"http://localhost:8080"}) Esto se utiliza para permitir las peticiones de ciertos origenes unicamente, cuando tengamos el front lo descomentamos
@RestController
@RequestMapping(path = "api/cliente")
@AllArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody @Valid ClienteDto clienteDto){
        clienteService.create(clienteDto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente update(@PathVariable("id") int id,@RequestBody @Valid ClienteDto clienteDto) {
        return clienteService.update(id,clienteDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        clienteService.delete(id);
    }

}
