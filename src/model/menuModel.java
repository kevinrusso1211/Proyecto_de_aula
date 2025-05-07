package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo que gestiona el menú del restaurante, incluyendo operaciones CRUD para productos.
 */
public class menuModel {
    private List<productoModel> productos; // Usamos interfaz List en lugar de ArrayList

    public menuModel() {
        this.productos = new ArrayList<>();
    }

    // --- Métodos CRUD ---

    /**
     * Agrega un producto al menú.
     * @param producto Producto a agregar (no nulo).
     * @throws IllegalArgumentException Si el producto es nulo o ya existe.
     */
    public void agregarProducto(productoModel producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (buscarProducto(producto.getNombre()) != null) {
            throw new IllegalStateException("El producto ya existe en el menú");
        }
        productos.add(producto);
    }

    /**
     * Elimina un producto por nombre.
     * @param nombreProducto Nombre del producto a eliminar (no nulo o vacío).
     * @return true si se eliminó, false si no se encontró.
     */
    public boolean eliminarProducto(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no válido");
        }
        return productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombreProducto));
    }

    /**
     * Busca un producto por nombre (insensible a mayúsculas/minúsculas).
     * @param nombreProducto Nombre a buscar.
     * @return Producto encontrado o null si no existe.
     */
    public productoModel buscarProducto(String nombreProducto) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombreProducto))
                .findFirst()
                .orElse(null);
    }

    // --- Getters y Utilidades ---

    /**
     * @return Lista inmutable de productos para evitar modificaciones externas.
     */
    public List<productoModel> getProductos() {
        return new ArrayList<>(productos); // Devuelve una copia para encapsulamiento
    }

    /**
     * Muestra el menú en consola (útil para debugging).
     */
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