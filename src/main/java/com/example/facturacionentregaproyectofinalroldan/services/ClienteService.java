package com.example.facturacionentregaproyectofinalroldan.services;

import com.example.facturacionentregaproyectofinalroldan.entities.Cliente;
import com.example.facturacionentregaproyectofinalroldan.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    public Cliente obtenerCliente(int id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    public Cliente guardarCliente(Cliente cliente) {
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteGuardado;
    }

    public void borrarCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
