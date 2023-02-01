package com.example.facturacionentregaproyectofinalroldan.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ComprobanteRequest {

    @JsonProperty("cliente_id")
    private int clienteId;
    private List<LineaRequest> lineas;

    public ComprobanteRequest(int clienteId, List<LineaRequest> lineas) {
        this.clienteId = clienteId;
        this.lineas = lineas;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public List<LineaRequest> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaRequest> lineas) {
        this.lineas = lineas;
    }
}
