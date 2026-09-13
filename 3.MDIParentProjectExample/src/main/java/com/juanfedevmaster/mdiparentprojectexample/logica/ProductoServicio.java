package com.juanfedevmaster.mdiparentprojectexample.logica;

import com.juanfedevmaster.mdiparentprojectexample.entidades.Producto;
import com.juanfedevmaster.mdiparentprojectexample.repositorios.ProductoRepositorio;
import java.util.List;

public class ProductoServicio {
    private ProductoRepositorio repositorio;

    public ProductoServicio() {
        repositorio = new ProductoRepositorio();
    }

    public List<Producto> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public Producto obtenerPorId(int id) {
        return repositorio.obtenerPorId(id);
    }

    public void crearProducto(String nombre, String descripcion, int cantidad) {
        Producto producto = new Producto(0, nombre, descripcion, cantidad);
        repositorio.agregar(producto);
    }

    public void actualizarProducto(int id, String nombre, String descripcion, int cantidad) {
        Producto producto = new Producto(id, nombre, descripcion, cantidad);
        repositorio.actualizar(producto);
    }

    public void eliminarProducto(int id) {
        repositorio.eliminar(id);
    }
}
