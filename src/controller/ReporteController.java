package controller;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class ReporteController {

    
    public int calcularTotalDesdeFecha(File raiz, String fechaInicioStr, int dias) {
        List<Path> fechas = obtenerFechasValidas(raiz, fechaInicioStr, dias);
        return sumarTotales(fechas);
    }

   
    public Map<String, Integer> obtenerTotalesPorFecha(File raiz, String fechaInicioStr, int dias) {
        Map<String, Integer> mapaTotales = new LinkedHashMap<>();
        List<Path> fechas = obtenerFechasValidas(raiz, fechaInicioStr, dias);

        for (Path fechaPath : fechas) {
            String nombreFecha = fechaPath.getFileName().toString();
            int totalDia = 0;

            File pedidosFolder = fechaPath.resolve("Pedidos").toFile();
            if (pedidosFolder.exists() && pedidosFolder.isDirectory()) {
                File[] archivos = pedidosFolder.listFiles((dir, name) -> name.endsWith(".txt"));

                if (archivos != null) {
                    for (File archivo : archivos) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                            String linea;
                            while ((linea = reader.readLine()) != null) {
                                if (linea.startsWith("Total:")) {
                                    String valor = linea.replace("Total:", "").trim();
                                    totalDia += Integer.parseInt(valor);
                                }
                            }
                        } catch (IOException | NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            mapaTotales.put(nombreFecha, totalDia);
        }

        return mapaTotales;
    }

   
    private List<Path> obtenerFechasValidas(File raiz, String fechaInicioStr, int dias) {
        LocalDate fechaInicio;
        try {
            fechaInicio = LocalDate.parse(fechaInicioStr); // debe estar en formato YYYY-MM-DD
        } catch (Exception e) {
            System.out.println("Fecha inválida: " + fechaInicioStr);
            return Collections.emptyList();
        }

        List<Path> fechasEncontradas = new ArrayList<>();
        int diasVerificados = 0;

        while (fechasEncontradas.size() < dias && diasVerificados < 365) { 
            Path carpetaFecha = raiz.toPath().resolve(fechaInicio.toString());

            if (Files.exists(carpetaFecha) && Files.isDirectory(carpetaFecha)) {
                fechasEncontradas.add(carpetaFecha);
            }

            fechaInicio = fechaInicio.plusDays(1);
            diasVerificados++;
        }

        return fechasEncontradas;
    }

    
    private int sumarTotales(List<Path> carpetasFecha) {
        int total = 0;

        for (Path fechaPath : carpetasFecha) {
            File pedidosFolder = fechaPath.resolve("Pedidos").toFile();
            if (pedidosFolder.exists() && pedidosFolder.isDirectory()) {
                File[] archivos = pedidosFolder.listFiles((dir, name) -> name.endsWith(".txt"));

                if (archivos != null) {
                    for (File archivo : archivos) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                            String linea;
                            while ((linea = reader.readLine()) != null) {
                                if (linea.startsWith("Total:")) {
                                    String valor = linea.replace("Total:", "").trim();
                                    total += Integer.parseInt(valor);
                                }
                            }
                        } catch (IOException | NumberFormatException e) {
                            e.printStackTrace(); 
                        }
                    }
                }
            }
        }

        return total;
    }
}
