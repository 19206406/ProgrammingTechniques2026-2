package com.juanfedevmaster.mdiparentprojectexample.repositorios;

import com.juanfedevmaster.mdiparentprojectexample.entidades.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorio {
    private List<Producto> productos;
    private int nextId;

    public ProductoRepositorio() {
        productos = new ArrayList<>();
        nextId = 1;
        inicializarProductos();
    }

    private void inicializarProductos() {
        productos.add(new Producto(nextId++, "Arroz", "Arroz blanco premium 1kg", 50));
        productos.add(new Producto(nextId++, "Frijoles", "Frijoles negros secos 500g", 30));
        productos.add(new Producto(nextId++, "Aceite", "Aceite vegetal 1L", 25));
        productos.add(new Producto(nextId++, "Sal", "Sal refinada 1kg", 40));
        productos.add(new Producto(nextId++, "Azúcar", "Azúcar blanca 1kg", 35));
        productos.add(new Producto(nextId++, "Harina", "Harina de trigo 1kg", 20));
        productos.add(new Producto(nextId++, "Leche", "Leche entera pasteurizada 1L", 60));
        productos.add(new Producto(nextId++, "Huevos", "Huevos de gallina docena", 45));
        productos.add(new Producto(nextId++, "Jabón", "Jabón de barra multiusos", 55));
        productos.add(new Producto(nextId++, "Pasta", "Pasta de sémola 500g", 28));
    }

    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos);
    }

    public Producto obtenerPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void agregar(Producto producto) {
        producto.setId(nextId++);
        productos.add(producto);
    }

    public void actualizar(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == producto.getId()) {
                productos.set(i, producto);
                return;
            }
        }
    }

    public void eliminar(int id) {
        productos.removeIf(p -> p.getId() == id);
    }
}
