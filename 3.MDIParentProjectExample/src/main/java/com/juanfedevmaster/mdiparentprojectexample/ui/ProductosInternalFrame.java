package com.juanfedevmaster.mdiparentprojectexample.ui;

import com.juanfedevmaster.mdiparentprojectexample.entidades.Producto;
import com.juanfedevmaster.mdiparentprojectexample.logica.ProductoServicio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductosInternalFrame extends JInternalFrame {
    private ProductoServicio servicio;
    private MainFrame mainFrame;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public ProductosInternalFrame(ProductoServicio servicio, MainFrame mainFrame) {
        super("Productos", true, true, true, true);
        this.servicio = servicio;
        this.mainFrame = mainFrame;
        inicializarComponentes();
        cargarProductos();
        setSize(800, 480);
        setLocation(30, 30);
    }

    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnCrear = new JButton("Crear Producto");
        JButton btnEditar = new JButton("Editar Producto");
        JButton btnEliminar = new JButton("Eliminar Producto");

        btnCrear.addActionListener(e -> abrirCrear());
        btnEditar.addActionListener(e -> abrirEditar());
        btnEliminar.addActionListener(e -> eliminarSeleccionado());

        panelBotones.add(btnCrear);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelPrincipal.add(panelBotones, BorderLayout.NORTH);

        String[] columnas = {"ID", "Nombre", "Descripción", "Cantidad"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowHeight(24);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(380);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(90);

        panelPrincipal.add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelPrincipal);
    }

    public void cargarProductos() {
        modeloTabla.setRowCount(0);
        List<Producto> productos = servicio.obtenerTodos();
        for (Producto p : productos) {
            modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getDescripcion(), p.getCantidad()});
        }
    }

    private void abrirCrear() {
        CrearProductoInternalFrame crearFrame = new CrearProductoInternalFrame(servicio, this);
        mainFrame.getDesktopPane().add(crearFrame);
        crearFrame.setVisible(true);
    }

    private void abrirEditar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) modeloTabla.getValueAt(fila, 0);
        Producto producto = servicio.obtenerPorId(id);
        EditarProductoInternalFrame editarFrame = new EditarProductoInternalFrame(producto, servicio, this);
        mainFrame.getDesktopPane().add(editarFrame);
        editarFrame.setVisible(true);
    }

    private void eliminarSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) modeloTabla.getValueAt(fila, 0);
        String nombre = (String) modeloTabla.getValueAt(fila, 1);
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Desea eliminar el producto \"" + nombre + "\"?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            servicio.eliminarProducto(id);
            cargarProductos();
        }
    }
}
