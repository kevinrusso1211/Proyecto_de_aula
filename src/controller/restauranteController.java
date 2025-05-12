package controller;

import view.restauranteView;
import model.pedidoModel;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.*;

public class restauranteController {

    private restauranteView vista;
    private pedidoModel modelo;
    private int ingreso=0;
    ArrayList<Object> pedidos = new ArrayList<>();

    public restauranteController(restauranteView vista, pedidoModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        crearEstructuraCarpetas(); // Solo crea la carpeta, no carga nada
    }

    private void crearEstructuraCarpetas() {
        String rutaBase = "Fechas";
        String fechaHoy = java.time.LocalDate.now().toString(); // Formato: YYYY-MM-DD
        String rutaCompleta = rutaBase + File.separator + fechaHoy + File.separator + "Pedidos";

        File directorio = new File(rutaCompleta);
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crea todos los directorios necesarios
        }
    }

    public void mostrarVistaRestaurante() {
        crearEstructuraCarpetas(); // Verifica/crea carpeta del día

        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true); // <-- Ya se puede acceder a la tabla

        cargarPedidosDelDia(); // <-- Ahora se llama aquí, ya es seguro
    }

    private void cargarPedidosDelDia() {
        String fechaHoy = java.time.LocalDate.now().toString();
        String rutaCarpeta = "Fechas" + File.separator + fechaHoy + File.separator + "Pedidos";
        File directorio = new File(rutaCarpeta);

        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles((dir, name) -> name.endsWith(".txt"));

            if (archivos != null) {
                for (File archivo : archivos) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                        String id = "", platos = "", precioTotal = "", total = "";
                        String linea;
                        while ((linea = reader.readLine()) != null) {
                            if (linea.startsWith("ID:")) {
                                id = linea.substring(3);
                            } else if (linea.startsWith("Platos:")) {
                                platos = linea.substring(7);
                            } else if (linea.startsWith("PrecioTotal:")) {
                                precioTotal = linea.substring(12);
                            } else if (linea.startsWith("Total:")) {
                                total = linea.substring(6);
                            }
                            pedidos.add(linea);
                        }

                        Object[] fila = { id, platos, precioTotal, total };
                        vista.actualizarTabla(fila); // Método ya en tu vista
                    } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al leer archivo: " + archivo.getName());
                    }
                }
            }
        }
    }
    
    public void agregarPedido(Map<String, String> datosPedido) {
        try {
            String fechaHoy = java.time.LocalDate.now().toString();
            String rutaCarpeta = "Fechas" + File.separator + fechaHoy + File.separator + "Pedidos";
            File directorio = new File(rutaCarpeta);

            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            int nuevoId = directorio.listFiles().length + 1;

            String rutaArchivo = rutaCarpeta + File.separator + "ID_" + nuevoId + ".txt";
            try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
                writer.println("ID:" + nuevoId);
                writer.println("Platos:" + datosPedido.get("platos"));
                writer.println("PrecioTotal:" + datosPedido.get("precioTotal"));
                writer.println("Total:" + datosPedido.get("total"));
            }

            Object[] fila = {
                nuevoId,
                datosPedido.get("platos"),
                datosPedido.get("precioTotal"),
                datosPedido.get("total")
            };
            
            System.out.println("Agregando pedido:");
System.out.println("Platos: " + datosPedido.get("platos"));
System.out.println("Precio Total: " + datosPedido.get("precioTotal"));
System.out.println("Total: " + datosPedido.get("total"));
            vista.actualizarTabla(fila);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el pedido: " + e.getMessage());
        }
    }
    
    //contains()
//    public void calcularIngresoMensual(String mes/*El mes debe estar en numero*/){
//        while(mes==){
//            
//        }
//    }
   
}
