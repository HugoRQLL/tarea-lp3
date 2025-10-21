package ejercicio_1;

import java.util.ArrayList;
import java.util.List;

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}

// Carrito.java
class Carrito {
    private List<Producto> productos;
    private List<Producto> historialCompras;

    public Carrito() {
        productos = new ArrayList<>();
        historialCompras = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(int indice) {
        if (indice >= 0 && indice < productos.size()) {
            productos.remove(indice);
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void vaciarCarrito() {
        historialCompras.addAll(productos);
        productos.clear();
    }

    public List<Producto> getHistorial() {
        return historialCompras;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }
}