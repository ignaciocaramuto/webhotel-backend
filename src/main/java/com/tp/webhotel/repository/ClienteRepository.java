package com.tp.webhotel.repository;

import com.tp.webhotel.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Es lo mismo que SELECT * FROM cliente WHERE email = parametro
    Optional<Cliente> findClienteByEmail(String email);
}
