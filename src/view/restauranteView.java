package view;

import controller.restauranteController;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.pedidoModel;
import java.util.*;

public class restauranteView extends javax.swing.JFrame {

    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelCentral;
    private JTable tablaPedidos;
    private JScrollPane scrollPane;
    private restauranteController controller;
    public restauranteView() {
        initComponents();
        controller = new restauranteController(this, new pedidoModel());
        redimensionarIconos();
        configurarVista();
        configurarTabla();
        precio1.setVisible(false);
        precio2.setVisible(false);
        precio3.setVisible(false);
        precio4.setVisible(false);
        precio5.setVisible(false);
        precio6.setVisible(false);
        spinnerIcon1.setVisible(false);
        spinnerIcon2.setVisible(false);
        spinnerIcon3.setVisible(false);
        spinnerIcon4.setVisible(false);
        spinnerIcon5.setVisible(false);
        spinnerIcon6.setVisible(false);
        icon1.setVisible(false);
        icon2.setVisible(false);
        icon3.setVisible(false);
        icon4.setVisible(false);
        icon5.setVisible(false);
        icon6.setVisible(false);
        comida1.setVisible(false);
        comida2.setVisible(false);
        comida3.setVisible(false);
        comida4.setVisible(false);
        comida5.setVisible(false);
        comida6.setVisible(false);
        btnAgregar.setVisible(false);
    }

    private void redimensionarIconos() {
        
        redimensionarImagenJLabel(icon1, "/Icons/icon1.jpg", 200, 200);
        redimensionarImagenJLabel(icon2, "/Icons/icon2.jpg", 200, 200);
        redimensionarImagenJLabel(icon3, "/Icons/icon3.jpg", 200, 200);
        redimensionarImagenJLabel(icon4, "/Icons/icon4.jpg", 200, 200);
        redimensionarImagenJLabel(icon5, "/Icons/icon5.jpg", 200, 200);
        redimensionarImagenJLabel(icon6, "/Icons/icon6.jpg", 200, 200);
    }

    private void redimensionarImagenJLabel(JLabel label, String rutaImagen, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(rutaImagen));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(imagenEscalada));
    }

    private void configurarVista() {
        setTitle("Restaurante - Gestión de Pedidos");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(new java.awt.BorderLayout());

        // Panel Superior
        panelSuperior = new javax.swing.JPanel();
        panelSuperior.setBackground(new java.awt.Color(252, 167, 44));
        panelSuperior.setPreferredSize(new java.awt.Dimension(0, 100));
        panelSuperior.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));

        JPanel panelTransparente = new JPanel(new GridBagLayout());
        panelTransparente.setOpaque(false);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.anchor = GridBagConstraints.NORTHWEST;
        gbc1.insets = new Insets(10, 10, 0, 0);
        panelTransparente.add(IconMain, gbc1);

        panelSuperior.add(panelTransparente, BorderLayout.WEST);
        getContentPane().add(panelSuperior, java.awt.BorderLayout.NORTH);

        // Panel Lateral 
        panelLateral = new javax.swing.JPanel();
        panelLateral.setBackground(new java.awt.Color(252, 167, 44));
        panelLateral.setPreferredSize(new java.awt.Dimension(200, 0));
        panelLateral.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 20, 0);
        panelLateral.add(btnCrearPedido, gbc);

        gbc.gridy++;
        panelLateral.add(btnRegresar, gbc);

        getContentPane().add(panelLateral, java.awt.BorderLayout.EAST);

        // Panel Central 
        panelCentral = new javax.swing.JPanel();
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelCentral.setLayout(new java.awt.BorderLayout());

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);
    }

    private void configurarTabla() {
        // Columnas ajustadas a tu requerimiento:
        String[] columnas = {"ID", "Pedido (Plato x Cantidad)", "Precio Unitario", "Total"};

        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Mantienes las celdas no editables
            }
        };

        tablaPedidos = new JTable(modeloTabla);
        tablaPedidos.setAutoCreateRowSorter(true);
        tablaPedidos.setRowHeight(25);
        tablaPedidos.setShowGrid(true);
        tablaPedidos.setGridColor(Color.LIGHT_GRAY);

        scrollPane = new JScrollPane(tablaPedidos);
        panelCentral.add(scrollPane, java.awt.BorderLayout.CENTER);
    }

    public void actualizarTabla(Object[] fila) {
    DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();
    modelo.addRow(fila);
}

    private void setComponentVisibility(boolean visible) {
        Component[] components = {precio1, precio2, precio3, precio4, precio5, precio6,
            spinnerIcon1, spinnerIcon2, spinnerIcon3,
            spinnerIcon4, spinnerIcon5, spinnerIcon6,
            icon1, icon2, icon3, icon4, icon5, icon6,
            comida1, comida2, comida3, comida4, comida5, comida6,
            btnAgregar};

        for (Component c : components) {
            c.setVisible(visible);
        }

        // Resetear precios
        if (visible) {
            precio1.setText("$0");
            precio2.setText("$0");
            precio3.setText("$0");
            precio4.setText("$0");
            precio5.setText("$0");
            precio6.setText("$0");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearPedido = new javax.swing.JButton();
        IconMain = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        icon5 = new javax.swing.JLabel();
        icon6 = new javax.swing.JLabel();
        precio1 = new javax.swing.JTextField();
        precio2 = new javax.swing.JTextField();
        precio3 = new javax.swing.JTextField();
        precio4 = new javax.swing.JTextField();
        precio5 = new javax.swing.JTextField();
        precio6 = new javax.swing.JTextField();
        spinnerIcon1 = new javax.swing.JSpinner();
        spinnerIcon2 = new javax.swing.JSpinner();
        spinnerIcon3 = new javax.swing.JSpinner();
        spinnerIcon4 = new javax.swing.JSpinner();
        spinnerIcon5 = new javax.swing.JSpinner();
        spinnerIcon6 = new javax.swing.JSpinner();
        btnAgregar = new javax.swing.JButton();
        comida1 = new javax.swing.JLabel();
        comida2 = new javax.swing.JLabel();
        comida3 = new javax.swing.JLabel();
        comida4 = new javax.swing.JLabel();
        comida5 = new javax.swing.JLabel();
        comida6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCrearPedido.setText("Crear Pedido");
        btnCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPedidoActionPerformed(evt);
            }
        });

        IconMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo_120x120.png"))); // NOI18N

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon1.jpg"))); // NOI18N

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon2.jpg"))); // NOI18N

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon3.jpg"))); // NOI18N

        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon4.jpg"))); // NOI18N

        icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon5.jpg"))); // NOI18N

        icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon6.jpg"))); // NOI18N

        spinnerIcon1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        spinnerIcon1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerIcon1StateChanged(evt);
            }
        });

        spinnerIcon2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        spinnerIcon2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerIcon2StateChanged(evt);
            }
        });

        spinnerIcon3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        spinnerIcon3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerIcon3StateChanged(evt);
            }
        });

        spinnerIcon4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));
        spinnerIcon4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerIcon4StateChanged(evt);
            }
        });

        spinnerIcon5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        spinnerIcon5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerIcon5StateChanged(evt);
            }
        });

        spinnerIcon6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        spinnerIcon6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerIcon6StateChanged(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        comida1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        comida2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        comida3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        comida4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        comida5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        comida6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCrearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(icon5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1796, 1796, 1796)
                                .addComponent(icon4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(icon6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(IconMain, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comida1)
                            .addComponent(comida2)
                            .addComponent(comida3)
                            .addComponent(comida4)
                            .addComponent(comida5)
                            .addComponent(comida6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precio1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(precio4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(precio2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(precio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(IconMain, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCrearPedido)
                                    .addComponent(btnRegresar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregar))
                            .addComponent(icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1115, 1115, 1115)
                        .addComponent(icon4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(icon6)
                        .addGap(765, 765, 765)
                        .addComponent(comida1)
                        .addGap(45, 45, 45)
                        .addComponent(comida2)
                        .addGap(45, 45, 45)
                        .addComponent(comida3)
                        .addGap(45, 45, 45)
                        .addComponent(comida4)
                        .addGap(45, 45, 45)
                        .addComponent(comida5)
                        .addGap(45, 45, 45)
                        .addComponent(comida6))
                    .addComponent(icon5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPedidoActionPerformed
        scrollPane.setVisible(false);
        JPanel panelContenedorPrincipal = new JPanel(new BorderLayout());
        panelContenedorPrincipal.setBackground(Color.WHITE);

// Panel principal vertical para las dos filas de productos
        JPanel panelVertical = new JPanel();
        panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.Y_AXIS));

// === PRIMERA FILA (productos 1-3) ===
        JPanel panelHorizontal1 = new JPanel();
        panelHorizontal1.setLayout(new FlowLayout(FlowLayout.LEFT));

// Bloque 1
        JPanel bloque1 = new JPanel();
        bloque1.setLayout(new BoxLayout(bloque1, BoxLayout.Y_AXIS));
        bloque1.add(comida1);  // Nuevo label
        bloque1.add(icon1);
        JPanel fila1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fila1.add(spinnerIcon1);
        fila1.add(precio1);
        bloque1.add(fila1);

// Bloque 2 
        JPanel bloque2 = new JPanel();
        bloque2.setLayout(new BoxLayout(bloque2, BoxLayout.Y_AXIS));
        bloque2.add(comida2);  // Nuevo label
        bloque2.add(icon2);
        JPanel fila2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fila2.add(spinnerIcon2);
        fila2.add(precio2);
        bloque2.add(fila2);

// Bloque 3
        JPanel bloque3 = new JPanel();
        bloque3.setLayout(new BoxLayout(bloque3, BoxLayout.Y_AXIS));
        bloque3.add(comida3);  // Nuevo label
        bloque3.add(icon3);
        JPanel fila3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fila3.add(spinnerIcon3);
        fila3.add(precio3);
        bloque3.add(fila3);

// Configuración de tamaño para los primeros 3 bloques
        Dimension tamañoBloque = new Dimension(350, 300);
        bloque1.setPreferredSize(tamañoBloque);
        bloque2.setPreferredSize(tamañoBloque);
        bloque3.setPreferredSize(tamañoBloque);

        panelHorizontal1.add(bloque1);
        panelHorizontal1.add(bloque2);
        panelHorizontal1.add(bloque3);

// Espacio entre filas
        panelVertical.add(panelHorizontal1);
        panelVertical.add(Box.createVerticalStrut(30));  // Margen entre filas

// === SEGUNDA FILA (productos 4-6) ===
        JPanel panelHorizontal2 = new JPanel();
        panelHorizontal2.setLayout(new FlowLayout(FlowLayout.LEFT));

// Bloque 4
        JPanel bloque4 = new JPanel();
        bloque4.setLayout(new BoxLayout(bloque4, BoxLayout.Y_AXIS));
        bloque4.add(comida4);  // Nuevo label
        bloque4.add(icon4);
        JPanel fila4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fila4.add(spinnerIcon4);
        fila4.add(precio4);
        bloque4.add(fila4);

// Bloque 5
        JPanel bloque5 = new JPanel();
        bloque5.setLayout(new BoxLayout(bloque5, BoxLayout.Y_AXIS));
        bloque5.add(comida5);  // Nuevo label
        bloque5.add(icon5);
        JPanel fila5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fila5.add(spinnerIcon5);
        fila5.add(precio5);
        bloque5.add(fila5);

// Bloque 6
        JPanel bloque6 = new JPanel();
        bloque6.setLayout(new BoxLayout(bloque6, BoxLayout.Y_AXIS));
        bloque6.add(comida6);  // Nuevo label
        bloque6.add(icon6);
        JPanel fila6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fila6.add(spinnerIcon6);
        fila6.add(precio6);
        bloque6.add(fila6);

        precio1.setPreferredSize(new Dimension(200, 30));
        precio2.setPreferredSize(new Dimension(200, 30));
        precio3.setPreferredSize(new Dimension(200, 30));
        precio4.setPreferredSize(new Dimension(200, 30));
        precio5.setPreferredSize(new Dimension(200, 30));
        precio6.setPreferredSize(new Dimension(200, 30));

        comida1.setText("Sopa de calabaza");
        comida2.setText("Pechuga a la plancha con pure");
        comida3.setText("postre de maracuya");
        comida4.setText("Gaseosa 2LT");
        comida5.setText("Gaseosa personal");
        comida6.setText("Botella de agua personal");
// Configuración de tamaño igual para los nuevos bloques
        bloque4.setPreferredSize(tamañoBloque);
        bloque5.setPreferredSize(tamañoBloque);
        bloque6.setPreferredSize(tamañoBloque);

        panelHorizontal2.add(bloque4);
        panelHorizontal2.add(bloque5);
        panelHorizontal2.add(bloque6);

        panelVertical.add(panelHorizontal2);

// Panel para el botón (abajo-derecha)
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        panelBoton.add(btnAgregar);
        panelBoton.setOpaque(false);

// Configuración final
        panelContenedorPrincipal.add(panelVertical, BorderLayout.CENTER);
        panelContenedorPrincipal.add(panelBoton, BorderLayout.SOUTH);

// Mostrar todos los componentes
        setComponentVisibility(true);  // Método para mostrar todos los componentes

// Actualizar panel central
        panelCentral.removeAll();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(panelContenedorPrincipal, BorderLayout.CENTER);
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_btnCrearPedidoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        precio1.setVisible(false);
        precio2.setVisible(false);
        precio3.setVisible(false);
        spinnerIcon1.setVisible(false);
        spinnerIcon2.setVisible(false);
        spinnerIcon3.setVisible(false);
        icon1.setVisible(false);
        icon2.setVisible(false);
        icon3.setVisible(false);
        btnAgregar.setVisible(false);

        // 2. Limpiar y restaurar el panelCentral a su estado original
        panelCentral.removeAll(); // Elimina todos los componentes
        panelCentral.setLayout(new BorderLayout()); // Restablece el layout
        panelCentral.add(scrollPane, BorderLayout.CENTER); // Vuelve a agregar la tabla

        // 3. Mostrar la tabla
        scrollPane.setVisible(true);
        tablaPedidos.setVisible(true);

        // 4. Actualizar la interfaz
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void spinnerIcon1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerIcon1StateChanged
        int cantidad = (int) spinnerIcon1.getValue();
        int total = cantidad * 12000;
        precio1.setText("$" + total);
    }//GEN-LAST:event_spinnerIcon1StateChanged

    private void spinnerIcon2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerIcon2StateChanged
        int cantidad = (int) spinnerIcon2.getValue();
        int total = cantidad * 22000;
        precio2.setText("$" + total);
    }//GEN-LAST:event_spinnerIcon2StateChanged

    private void spinnerIcon3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerIcon3StateChanged
        int cantidad = (int) spinnerIcon3.getValue();
        int total = cantidad * 10000;
        precio3.setText("$" + total);
    }//GEN-LAST:event_spinnerIcon3StateChanged

    private void spinnerIcon4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerIcon4StateChanged
        int cantidad = (int) spinnerIcon4.getValue();
        int total = cantidad * 7500;
        precio4.setText("$" + total);
    }//GEN-LAST:event_spinnerIcon4StateChanged

    private void spinnerIcon5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerIcon5StateChanged
        int cantidad = (int) spinnerIcon5.getValue();
        int total = cantidad * 3500;
        precio5.setText("$" + total);
    }//GEN-LAST:event_spinnerIcon5StateChanged

    private void spinnerIcon6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerIcon6StateChanged
        int cantidad = (int) spinnerIcon6.getValue();
        int total = cantidad * 2000;
        precio6.setText("$" + total);
    }//GEN-LAST:event_spinnerIcon6StateChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int cant1 = (Integer) spinnerIcon1.getValue();
        int cant2 = (Integer) spinnerIcon2.getValue();
        int cant3 = (Integer) spinnerIcon3.getValue();
        int cant4 = (Integer) spinnerIcon4.getValue();
        int cant5 = (Integer) spinnerIcon5.getValue();
        int cant6 = (Integer) spinnerIcon6.getValue();

        String plato1 = comida1.getText(); // puedes usar un label en lugar de un JTextField si no es editable
        String plato2 = comida2.getText();
        String plato3 = comida3.getText();
        String plato4 = comida4.getText();
        String plato5 = comida5.getText();
        String plato6 = comida6.getText();

        String precio1s = precio1.getText().replace("$", "");
        String precio2s = precio2.getText().replace("$", "");
        String precio3s = precio3.getText().replace("$", "");
        String precio4s = precio4.getText().replace("$", "");
        String precio5s = precio5.getText().replace("$", "");
        String precio6s = precio6.getText().replace("$", "");

        int p1 = Integer.parseInt(precio1s);
        int p2 = Integer.parseInt(precio2s);
        int p3 = Integer.parseInt(precio3s);
        int p4 = Integer.parseInt(precio4s);
        int p5 = Integer.parseInt(precio5s);
        int p6 = Integer.parseInt(precio6s);

        StringBuilder platos = new StringBuilder();
        int total = 0;

        if (cant1 > 0) {
            platos.append(plato1).append(" x").append(cant1).append(", ");
            total += p1;
        }
        if (cant2 > 0) {
            platos.append(plato2).append(" x").append(cant2).append(", ");
            total += p2;
        }
        if (cant3 > 0) {
            platos.append(plato3).append(" x").append(cant3).append(", ");
            total += p3;
        }
        if (cant4 > 0) {
            platos.append(plato4).append(" x").append(cant4).append(", ");
            total += p4;
        }
        if (cant5 > 0) {
            platos.append(plato5).append(" x").append(cant5).append(", ");
            total += p5;
        }
        if (cant6 > 0) {
            platos.append(plato6).append(" x").append(cant6).append(", ");
            total += p6;
        }

        // Quitar la coma final
        if (platos.length() > 0 && platos.charAt(platos.length() - 2) == ',') {
            platos.setLength(platos.length() - 2);
        }
        
        spinnerIcon1.setValue(0);
        spinnerIcon2.setValue(0);
        spinnerIcon3.setValue(0);
        spinnerIcon4.setValue(0);
        spinnerIcon5.setValue(0);
        spinnerIcon6.setValue(0);

        Map<String, String> datos = new HashMap<>();
        datos.put("platos", platos.toString());
        datos.put("precioTotal", "$" + total);
        datos.put("total", String.valueOf(total));

        // Llamar al controlador
        restauranteController controller = new restauranteController(this, new pedidoModel());
        controller.agregarPedido(datos);

        panelCentral.removeAll(); // Elimina todos los componentes
        panelCentral.setLayout(new BorderLayout()); // Restablece el layout
        panelCentral.add(scrollPane, BorderLayout.CENTER); // Vuelve a agregar la tabla

        // 3. Mostrar la tabla
        scrollPane.setVisible(true);
        tablaPedidos.setVisible(true);

        // 4. Actualizar la interfaz
        panelCentral.revalidate();
        panelCentral.repaint();
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconMain;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCrearPedido;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel comida1;
    private javax.swing.JLabel comida2;
    private javax.swing.JLabel comida3;
    private javax.swing.JLabel comida4;
    private javax.swing.JLabel comida5;
    private javax.swing.JLabel comida6;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JTextField precio1;
    private javax.swing.JTextField precio2;
    private javax.swing.JTextField precio3;
    private javax.swing.JTextField precio4;
    private javax.swing.JTextField precio5;
    private javax.swing.JTextField precio6;
    private javax.swing.JSpinner spinnerIcon1;
    private javax.swing.JSpinner spinnerIcon2;
    private javax.swing.JSpinner spinnerIcon3;
    private javax.swing.JSpinner spinnerIcon4;
    private javax.swing.JSpinner spinnerIcon5;
    private javax.swing.JSpinner spinnerIcon6;
    // End of variables declaration//GEN-END:variables
}
