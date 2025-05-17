package model;

import java.util.ArrayList;
import java.util.List;


public class menuModel {
    private List<productoModel> productos; 

    public menuModel() {
        this.productos = new ArrayList<>();
    }

    
    public void agregarProducto(productoModel producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (buscarProducto(producto.getNombre()) != null) {
            throw new IllegalStateException("El producto ya existe en el menú");
        }
        productos.add(producto);
    }

    
    public boolean eliminarProducto(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no válido");
        }
        return productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombreProducto));
    }

    
    public productoModel buscarProducto(String nombreProducto) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombreProducto))
                .findFirst()
                .orElse(null);
    }

    
    public List<productoModel> getProductos() {
        return new ArrayList<>(productos); 
    }

    
    public void mostrarMenu() {
        if (productos.isEmpty()) {
            System.out.println("El menú está vacío.");
            return;
        }
        productos.forEach(p -> 
            System.out.printf("Nombre: %s | Precio: $%.2f | Stock: %d%n", 
                p.getNombre(), p.getPrecio(), p.getStock())
        );
    }
}