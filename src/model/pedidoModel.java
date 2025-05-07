package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo simplificado para gestionar pedidos en el restaurante.
 */
public class pedidoModel {
    private static int contadorIds = 1;
    private List<productoModel> productos;
    private double total;
    private int idPedido;

    // Constructor por defecto (usa contador interno)
    public pedidoModel() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
        this.idPedido = contadorIds++;
    }

    // Constructor con ID personalizado (opcional)
    public pedidoModel(int idPedido) {
        this.productos = new ArrayList<>();
        this.total = 0.0;
        this.idPedido = idPedido;
    }

    // Método para agregar productos
    public void agregarProducto(productoModel producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    // Método para calcular el total nuevamente
    public double calcularTotal() {
        double suma = 0.0;
        for (productoModel p : productos) {
            suma += p.getPrecio();
        }
        this.total = suma;
        return suma;
    }

    // Getters
    public List<productoModel> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    // Resumen del pedido
    public String getResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido #").append(idPedido).append("\n");
        for (productoModel p : productos) {
            sb.append("- ").append(p.getNombre()).append(": $").append(p.getPrecio()).append("\n");
        }
        sb.append("Total: $").append(total);
        return sb.toString();
    }
}
