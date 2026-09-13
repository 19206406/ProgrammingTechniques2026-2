package com.juanfedevmaster.mdiparentprojectexample.ui;

import com.juanfedevmaster.mdiparentprojectexample.logica.ProductoServicio;
import javax.swing.*;

public class MainFrame extends JFrame {
    private JDesktopPane desktopPane;
    private ProductoServicio servicio;

    public MainFrame(ProductoServicio servicio) {
        this.servicio = servicio;
        inicializarComponentes();
        abrirProductos();
    }

    private void inicializarComponentes() {
        setTitle("Sistema de Abarrotes - Panel Principal");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuVista = new JMenu("Vista");
        JMenuItem itemProductos = new JMenuItem("Productos");
        itemProductos.addActionListener(e -> abrirProductos());
        menuVista.add(itemProductos);
        menuBar.add(menuVista);

        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> System.exit(0));
        menuArchivo.add(itemSalir);
        menuBar.add(menuArchivo);

        setJMenuBar(menuBar);
    }

    private void abrirProductos() {
        ProductosInternalFrame productosFrame = new ProductosInternalFrame(servicio, this);
        desktopPane.add(productosFrame);
        productosFrame.setVisible(true);
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }
}
