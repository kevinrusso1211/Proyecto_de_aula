package model;

/**
 * Modelo que representa un producto en el sistema del restaurante.
 */
public class productoModel {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor por defecto
    public productoModel() {}

    // Constructor con parámetros
    public productoModel(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // --- Getters ---
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // --- Setters (con validaciones) ---
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("Precio no puede ser negativo");
        }
        this.precio = precio;
    }

    // --- Métodos de negocio ---
    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        if (cantidad > stock) {
            throw new IllegalStateException("Stock insuficiente");
        }
        stock -= cantidad;
    }

    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        stock += cantidad;
    }

    // --- Representación en texto ---
    @Override
    public String toString() {
        return String.format("Producto: %s | Precio: $%.2f | Stock: %d", nombre, precio, stock);
    }
}