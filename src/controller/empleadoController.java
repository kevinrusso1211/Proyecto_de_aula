package controller;

import java.io.*;
import java.util.ArrayList;
import model.empleadoModel;

public class empleadoController {

    private ArrayList<empleadoModel> listaEmpleado;
    private final File carpetaEmpleados;

    public empleadoController() {
        listaEmpleado = new ArrayList<>();
        carpetaEmpleados = new File("empleados");

        if (!carpetaEmpleados.exists()) {
            carpetaEmpleados.mkdir();
        }
        cargarEmpleado();
    }

    public void agregarEmpleado(empleadoModel empleado) {
        listaEmpleado.add(empleado);
        guardarEmpleado(empleado);
    }

    private void guardarEmpleado(empleadoModel empleado) {
        try {
            File archivo = new File(carpetaEmpleados, empleado.getNombre() + ".txt");
            FileWriter writer;
            writer = new FileWriter(archivo);
            writer.write(empleado.toFileString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarEmpleado() {
        File[] archivos = carpetaEmpleados.listFiles((dir, name) -> name.endsWith(".txt"));
        if (archivos != null) {
            for (File archivo : archivos) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(archivo));
                    StringBuilder content = new StringBuilder();
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        content.append(linea).append("\n");
                    }
                    reader.close();
                    empleadoModel empleado = empleadoModel.fromFileString(content.toString().trim());
                    if (empleado != null) {
                        listaEmpleado.add(empleado);
                    }
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        }
    }

    public ArrayList<empleadoModel> getListaEmpleado() {
        return listaEmpleado;
    }
}
