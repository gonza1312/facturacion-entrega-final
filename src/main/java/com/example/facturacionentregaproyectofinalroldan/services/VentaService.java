package com.example.facturacionentregaproyectofinalroldan.services;

import com.example.facturacionentregaproyectofinalroldan.clients.WorldClockClient;
import com.example.facturacionentregaproyectofinalroldan.entities.Cliente;
import com.example.facturacionentregaproyectofinalroldan.entities.Producto;
import com.example.facturacionentregaproyectofinalroldan.entities.ProductoVenta;
import com.example.facturacionentregaproyectofinalroldan.entities.Venta;
import com.example.facturacionentregaproyectofinalroldan.entities.WorldClock;
import com.example.facturacionentregaproyectofinalroldan.repositories.VentaRepository;
import com.example.facturacionentregaproyectofinalroldan.requests.ComprobanteRequest;
import com.example.facturacionentregaproyectofinalroldan.requests.LineaRequest;
import com.example.facturacionentregaproyectofinalroldan.responses.ComprobanteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    public VentaRepository ventaRepository;

    @Autowired
    public ClienteService clienteService;

    @Autowired
    public ProductoService productoService;

    @Autowired
    public WorldClockClient worldClockClient;

    public Venta obtenerVenta(int id) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        return venta;
    }

    public ComprobanteResponse guardarVenta(ComprobanteRequest comprobanteRequest) {
        if (!existeCliente(comprobanteRequest.getClienteId())) {
            return new ComprobanteResponse(0, null, 0, 0, "No existe el cliente");
        }

        if (!validarProductos(comprobanteRequest.getLineas())) {
            return new ComprobanteResponse(0, null, 0, 0, "No existen productos o no alcanza el stock para venderlos");
        }

        Venta ventaAguardar = generarVenta(comprobanteRequest);

        Venta ventaGuardada = ventaRepository.save(ventaAguardar);

         ComprobanteResponse comprobanteResponse = generarComprobante(ventaGuardada, comprobanteRequest);
        return comprobanteResponse;
    }

    public void borrarVenta(int id) {
        ventaRepository.deleteById(id);
    }

    private boolean existeCliente(int clienteId) {
        Cliente cliente = clienteService.obtenerCliente(clienteId);
        return cliente != null;
    }

    private boolean validarProductos(List<LineaRequest> productos) {

        for (int i = 0; i < productos.size(); i++) {

            LineaRequest productoRequest = productos.get(i);
            Producto producto = productoService.obtenerProducto(productoRequest.getProductoId());

            if (producto == null || productoRequest.getCantidad() > producto.getCantidad()) {
                return false;
            }
        }
        return true;
    }

    private Venta generarVenta(ComprobanteRequest comprobanteRequest) {
        Venta venta = new Venta();
        List<ProductoVenta> productos = new ArrayList<>();

        for (int i = 0; i < comprobanteRequest.getLineas().size(); i++) {

            LineaRequest productoRequest = comprobanteRequest.getLineas().get(i);
            Producto producto = productoService.obtenerProducto(productoRequest.getProductoId());

            int stock = producto.getCantidad() - productoRequest.getCantidad();
            producto.setCantidad(stock);

            productoService.guardarProducto(producto);

            ProductoVenta productoVenta = new ProductoVenta();
            productoVenta.setCantidad(productoRequest.getCantidad());
            productoVenta.setCodigo(producto.getCodigo());
            productoVenta.setDescripcion(producto.getDescripcion());

            float precioTotal = producto.getPrecio() * productoRequest.getCantidad();
            productoVenta.setPrecio(precioTotal);

            productos.add(productoVenta);
        }

        venta.setProductos(productos);

        return venta;
    }

    private ComprobanteResponse generarComprobante(Venta ventaGuardada, ComprobanteRequest comprobanteRequest) {
        float precioTotal = 0;

        for (int i = 0; i < ventaGuardada.getProductos().size(); i++) {
            ProductoVenta producto = ventaGuardada.getProductos().get(i);
            precioTotal = precioTotal + producto.getPrecio();
        }

        int cantidadProductosVendidos = 0;
        for (int i = 0; i < comprobanteRequest.getLineas().size(); i++) {
            LineaRequest request = comprobanteRequest.getLineas().get(i);
            cantidadProductosVendidos = cantidadProductosVendidos + request.getCantidad();
        }

        Date date = new Date();
        String hoy = date.toString();
        WorldClock worldClock = worldClockClient.obtenerDateCurrentTime();

        if (worldClock != null) {
            hoy = worldClock.getCurrentDateTime();
        }


        return new ComprobanteResponse(ventaGuardada.getVentaId(), hoy, precioTotal, cantidadProductosVendidos, null);
    }
}
