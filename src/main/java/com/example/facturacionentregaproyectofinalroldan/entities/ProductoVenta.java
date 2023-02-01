package com.example.facturacionentregaproyectofinalroldan.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductoVenta")
public class ProductoVenta {
    @Column(name="productoVentaId")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int productoVentaId;

    @Column(name="codigo")
    private int codigo;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="precio")
    private float precio;

    public int getProductoVentaId() {
        return productoVentaId;
    }

    public void setProductoVentaId(int productoVentaId) {
        this.productoVentaId = productoVentaId;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
