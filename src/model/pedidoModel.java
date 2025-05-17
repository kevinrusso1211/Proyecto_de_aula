package model;

import java.util.ArrayList;
import java.util.List;


public class pedidoModel {
    private static int contadorIds = 1;
    private List<productoModel> productos;
    private double total;
    private int idPedido;

    
    public pedidoModel() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
        this.idPedido = contadorIds++;
    }

   
    public pedidoModel(int idPedido) {
        this.productos = new ArrayList<>();
        this.total = 0.0;
        this.idPedido = idPedido;
    }

    
    public void agregarProducto(productoModel producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    
    public double calcularTotal() {
        double suma = 0.0;
        for (productoModel p : productos) {
            suma += p.getPrecio();
        }
        this.total = suma;
        return suma;
    }

    
    public List<productoModel> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public int getIdPedido() {
        return idPedido;
    }

   
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
