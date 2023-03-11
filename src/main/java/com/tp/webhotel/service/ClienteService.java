package com.tp.webhotel.service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.tp.webhotel.dtos.ClienteDto;
import com.tp.webhotel.model.Cliente;
import com.tp.webhotel.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;


    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDto clienteDto) {
        return clienteRepository.save(clienteDto.toCliente());
    }

    public void delete(int id) {
        clienteRepository.deleteById(id);
    }

    @Transactional /* Permite no utilizar querys y usar los setters de la entidad y
    usarlos para actualizarlos automaticamente cuando es posible */
    public Cliente update(int id, ClienteDto clienteDto) {
       Cliente clienteUpdate =  clienteRepository.getById(id);
       clienteUpdate.setApellido(clienteDto.apellido);
       clienteUpdate.setNombre(clienteDto.nombre);
       clienteUpdate.setEmail(clienteDto.email);
       clienteUpdate.setFechaNacimiento(clienteDto.fechaNacimiento);

       return clienteRepository.save(clienteUpdate);

     }
}
