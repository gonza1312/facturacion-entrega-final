package com.example.facturacionentregaproyectofinalroldan.responses;

public class ComprobanteResponse {
    private int ventaId;
    private String fechaComprobante;
    private float precioTotal;
    private int cantidadProductosVendidos;
    private String error;

    public ComprobanteResponse(int ventaId, String fechaComprobante, float precioTotal, int cantidadProductosVendidos, String error) {
        this.ventaId = ventaId;
        this.fechaComprobante = fechaComprobante;
        this.precioTotal = precioTotal;
        this.cantidadProductosVendidos = cantidadProductosVendidos;
        this.error = error;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public String getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(String fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidadProductosVendidos() {
        return cantidadProductosVendidos;
    }

    public void setCantidadProductosVendidos(int cantidadProductosVendidos) {
        this.cantidadProductosVendidos = cantidadProductosVendidos;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
