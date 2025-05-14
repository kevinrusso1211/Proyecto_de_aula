package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.ui.TextAnchor;

public class GraficoView extends javax.swing.JFrame {

    public GraficoView(Map<String, Integer> data, String titulo) {
        setTitle(titulo);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultCategoryDataset dataset = crearDataset(data);

        CategoryPlot plot = new CategoryPlot();

        BarRenderer barRenderer = new BarRenderer() {
            private final Paint[] colores = new Paint[]{
                Color.BLUE, Color.RED, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.CYAN, Color.PINK
            };

            @Override
            public Paint getItemPaint(int row, int column) {
                return colores[column % colores.length];
            }
        };
        plot.setDataset(0, dataset);
        plot.setRenderer(0, barRenderer);

        plot.setDataset(1, dataset);
        plot.setRenderer(1, new LineAndShapeRenderer(true, true));

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        plot.setDomainAxis(new CategoryAxis("Fechas"));
        plot.setRangeAxis(new NumberAxis("Total Generado"));
        plot.mapDatasetToRangeAxis(0, 0);
        plot.mapDatasetToRangeAxis(1, 0);

        mostrarPuntoMaximoYMinimo(plot, dataset);

        JFreeChart combinedChart = new JFreeChart(titulo, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        ChartPanel chartPanel = new ChartPanel(combinedChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);

    }

    private DefaultCategoryDataset crearDataset(Map<String, Integer> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0, "Total", "Inicio");
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            dataset.addValue(entry.getValue(), "Total", entry.getKey());
        }
        return dataset;
    }

    private void mostrarPuntoMaximoYMinimo(CategoryPlot plot, DefaultCategoryDataset dataset) {
        if (dataset.getColumnCount() == 0) {
            return;
        }

        String maxFecha = null;
        String minFecha = null;
        double maxValor = Double.MIN_VALUE;
        double minValor = Double.MAX_VALUE;

        for (int i = 0; i < dataset.getColumnCount(); i++) {
            String fecha = dataset.getColumnKey(i).toString();
            if (fecha.equalsIgnoreCase("Inicio")) {
                continue;
            }

            Number valor = dataset.getValue(0, i);
            if (valor != null) {
                double v = valor.doubleValue();
                if (v > maxValor) {
                    maxValor = v;
                    maxFecha = fecha;
                }
                if (v < minValor) {
                    minValor = v;
                    minFecha = fecha;
                }
            }
        }

        if (maxFecha != null && minFecha != null) {
            CategoryTextAnnotation maxAnnotation = new CategoryTextAnnotation("📈 Máx: " + (int) maxValor, maxFecha, maxValor + 20);
            maxAnnotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
            maxAnnotation.setFont(new Font("Arial", Font.BOLD, 12));
            maxAnnotation.setPaint(Color.BLUE);

            CategoryTextAnnotation minAnnotation = new CategoryTextAnnotation("📉 Mín: " + (int) minValor, minFecha, minValor + 20);
            minAnnotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
            minAnnotation.setFont(new Font("Arial", Font.BOLD, 12));
            minAnnotation.setPaint(Color.RED);

            plot.addAnnotation(maxAnnotation);
            plot.addAnnotation(minAnnotation);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
