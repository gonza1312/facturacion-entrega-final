package com.example.facturacionentregaproyectofinalroldan.repositories;

import com.example.facturacionentregaproyectofinalroldan.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
