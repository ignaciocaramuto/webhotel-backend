package com.tp.webhotel.service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.tp.webhotel.model.Cliente;
import com.tp.webhotel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public void agregarNuevoCliente(Cliente cliente) {
        // Optional porque puede no existir
        Optional<Cliente> clientePorEmail = clienteRepository.findClienteByEmail(cliente.getEmail());
        if (clientePorEmail.isPresent()){
            throw new IllegalStateException("El email ya fue registrado.");
        }
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(int id) {
        boolean existe = clienteRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("El cliente con id " + id + " no existe.");
        }
        clienteRepository.deleteById(id);
    }

    @Transactional /* Permite no utilizar querys y usar los setters de la entidad y
    usarlos para actualizarlos automaticamente cuando es posible */
    public void actualizarCliente(
            int id,
            String apellido,
            String nombre,
            String email,
            String clave,
            Date fechaNacimiento,
            int nroTarjetaCredito) {
       Cliente cliente = clienteRepository.findById(id)
               .orElseThrow(() -> new IllegalStateException(
                       "El cliente con id " + id + " no existe."
       ));

       if (apellido != null && apellido.length() > 0 && !Objects.equals(cliente.getApellido(), apellido)) {
           cliente.setApellido(apellido);
       }
       if (nombre != null && nombre.length() > 0 && !Objects.equals(cliente.getNombre(), nombre)) {
           cliente.setNombre(nombre);
       }
       // TODO: Agregar validacián de email válido
       if (email != null && email.length() > 0 && !Objects.equals(cliente.getEmail(), email)) {
           Optional<Cliente> clientePorEmail = clienteRepository.findClienteByEmail(email);
           if (clientePorEmail.isPresent()){
               throw new IllegalStateException("El email ya está tomado.");
           }
           cliente.setEmail(email);
       }
       if (clave != null && clave.length() > 0 && !Objects.equals(cliente.getClave(), clave)) {
           cliente.setClave(clave);
       }
       if (fechaNacimiento != null && !Objects.equals(cliente.getFechaNacimiento(), fechaNacimiento)) {
           cliente.setFechaNacimiento(fechaNacimiento);
       }
       if (!Objects.equals(cliente.getTarjetaCredito(), nroTarjetaCredito)) {
           cliente.setTarjetaCredito(nroTarjetaCredito);
       }
    }
}
