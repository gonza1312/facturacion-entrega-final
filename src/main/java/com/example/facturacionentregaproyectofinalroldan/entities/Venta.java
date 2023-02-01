package com.example.facturacionentregaproyectofinalroldan.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="Venta")
public class Venta {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int ventaId;

    @OneToMany(mappedBy = "productoVentaId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductoVenta> productos;

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public List<ProductoVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVenta> productos) {
        this.productos = productos;
    }
}
