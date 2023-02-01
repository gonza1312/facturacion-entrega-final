package com.example.facturacionentregaproyectofinalroldan.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="Cliente")
public class Cliente {
    @Column(name="clienteId")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int clienteId;
    @Column(name="dni")
    private int dni;

    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;

    @OneToMany(mappedBy = "ventaId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Venta> ventasClientes;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Venta> getVentasClientes() {
        return ventasClientes;
    }

    public void setVentasClientes(List<Venta> ventasClientes) {
        this.ventasClientes = ventasClientes;
    }
}
