package com.tp.webhotel.repository;

import com.tp.webhotel.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionRepository extends JpaRepository<Cliente, Integer> {
}
