package com.example.facturacionentregaproyectofinalroldan.controllers;

import com.example.facturacionentregaproyectofinalroldan.entities.Cliente;
import com.example.facturacionentregaproyectofinalroldan.entities.Producto;
import com.example.facturacionentregaproyectofinalroldan.entities.Venta;
import com.example.facturacionentregaproyectofinalroldan.requests.ComprobanteRequest;
import com.example.facturacionentregaproyectofinalroldan.responses.ComprobanteResponse;
import com.example.facturacionentregaproyectofinalroldan.services.ClienteService;
import com.example.facturacionentregaproyectofinalroldan.services.ProductoService;
import com.example.facturacionentregaproyectofinalroldan.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("facturacion")
public class FacturacionController {

    @Autowired
    public ClienteService clienteService;

    @Autowired
    public ProductoService productoService;

    @Autowired
    public VentaService ventaService;

    // CLIENTE
    @GetMapping("cliente/{id}")
    public Cliente obtenerCliente(@PathVariable int id) {
        Cliente cliente = clienteService.obtenerCliente(id);
        return cliente;
    }

    @PostMapping(path = "cliente", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        Cliente clienteGuardado = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok(clienteGuardado);
    }

    @DeleteMapping("cliente/{id}")
    public void borrarCliente(@PathVariable int id) {
        clienteService.borrarCliente(id);
    }

    // PRODUCTO
    @GetMapping("producto/{id}")
    public Producto obtenerProducto(@PathVariable int id) {
        Producto producto = productoService.obtenerProducto(id);
        return producto;
    }

    @PostMapping(path = "producto", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        Producto productoGuardado = productoService.guardarProducto(producto);
        return ResponseEntity.ok(productoGuardado);
    }

    @DeleteMapping("producto/{id}")
    public void borrarProducto(@PathVariable int id) {
        productoService.borrarProducto(id);
    }

    // VENTA
    @GetMapping("venta/{id}")
    public Venta obtenerVenta(@PathVariable int id) {
        Venta venta = ventaService.obtenerVenta(id);
        return venta;
    }

    @PostMapping(path = "venta", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ComprobanteResponse> guardarProducto(@RequestBody ComprobanteRequest comprobanteRequest) {
        ComprobanteResponse ventaGuardada = ventaService.guardarVenta(comprobanteRequest);
        return ResponseEntity.ok(ventaGuardada);
    }

    @DeleteMapping("venta/{id}")
    public void borrarVenta(@PathVariable int id) {
        ventaService.borrarVenta(id);
    }
}
