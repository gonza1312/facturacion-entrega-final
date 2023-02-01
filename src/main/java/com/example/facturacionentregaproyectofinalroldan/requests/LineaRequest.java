package com.example.facturacionentregaproyectofinalroldan.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LineaRequest {

    private int cantidad;

    @JsonProperty("producto_id")
    private int productoId;

    public LineaRequest(int cantidad, int productoId) {
        this.cantidad = cantidad;
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
}
