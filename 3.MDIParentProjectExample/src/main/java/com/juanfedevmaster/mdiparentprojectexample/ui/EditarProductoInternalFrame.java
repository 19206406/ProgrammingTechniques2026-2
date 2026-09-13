package com.juanfedevmaster.mdiparentprojectexample.ui;

import com.juanfedevmaster.mdiparentprojectexample.entidades.Producto;
import com.juanfedevmaster.mdiparentprojectexample.logica.ProductoServicio;
import javax.swing.*;
import java.awt.*;

public class EditarProductoInternalFrame extends JInternalFrame {
    private ProductoServicio servicio;
    private ProductosInternalFrame productosFrame;
    private Producto producto;
    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtCantidad;

    public EditarProductoInternalFrame(Producto producto, ProductoServicio servicio, ProductosInternalFrame productosFrame) {
        super("Editar Producto — ID: " + producto.getId(), false, true, false, false);
        this.producto = producto;
        this.servicio = servicio;
        this.productosFrame = productosFrame;
        inicializarComponentes();
        setSize(420, 360);
        setLocation(220, 100);
    }

    private void inicializarComponentes() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 5, 7, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        panel.add(new JLabel("ID:"), gbc);
        JTextField txtId = new JTextField(String.valueOf(producto.getId()));
        txtId.setEditable(false);
        txtId.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1;
        panel.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panel.add(new JLabel("Nombre:"), gbc);
        txtNombre = new JTextField(producto.getNombre(), 20);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1;
        panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        panel.add(new JLabel("Descripción:"), gbc);
        txtDescripcion = new JTextArea(3, 20);
        txtDescripcion.setText(producto.getDescripcion());
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1;
        panel.add(new JScrollPane(txtDescripcion), gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        panel.add(new JLabel("Cantidad:"), gbc);
        txtCantidad = new JTextField(String.valueOf(producto.getCantidad()), 10);
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 1;
        panel.add(txtCantidad, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        btnGuardar.addActionListener(e -> guardar());
        btnCancelar.addActionListener(e -> dispose());
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.weightx = 0;
        panel.add(panelBotones, gbc);

        add(panel);
    }

    private void guardar() {
        String nombre = txtNombre.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String cantidadStr = txtCantidad.getText().trim();

        if (nombre.isEmpty() || descripcion.isEmpty() || cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!cantidadStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        servicio.actualizarProducto(producto.getId(), nombre, descripcion, Integer.parseInt(cantidadStr));
        productosFrame.cargarProductos();
        dispose();
    }
}
