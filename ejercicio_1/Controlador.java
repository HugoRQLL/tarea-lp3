package ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private List<Producto> productosDisponibles;
    private Carrito carrito;
    private Vista vista;

    public Controlador() {
        productosDisponibles = new ArrayList<>();
        carrito = new Carrito();
        vista = new Vista();

        // Agregar algunos productos iniciales
        productosDisponibles.add(new Producto("Manzana", 0.5));
        productosDisponibles.add(new Producto("Pan", 1.0));
        productosDisponibles.add(new Producto("Leche", 1.5));
        productosDisponibles.add(new Producto("Huevos", 2.0));
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            String opcion = vista.solicitarEntrada("");

            switch (opcion) {
                case "1":
                    agregarProducto();
                    break;
                case "2":
                    listarProductos();
                    break;
                case "3":
                    agregarProductoAlCarrito();
                    break;
                case "4":
                    verCarrito();
                    break;
                case "5":
                    eliminarProductoDelCarrito();
                    break;
                case "6":
                    aplicarDescuento();
                    break;
                case "7":
                    calcularEnvio();
                    break;
                case "8":
                    verHistorial();
                    break;
                case "9":
                    realizarCompra();
                    break;
                case "0":
                    salir = true;
                    vista.mostrarMensaje("Saliendo...");
                    vista.cerrar();
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        }
    }

    private void agregarProducto() {
        String nombre = vista.solicitarEntrada("Ingrese nombre del producto: ");
        String precioStr = vista.solicitarEntrada("Ingrese precio del producto: ");
        try {
            double precio = Double.parseDouble(precioStr);
            productosDisponibles.add(new Producto(nombre, precio));
            vista.mostrarMensaje("Producto agregado exitosamente.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Precio inválido.");
        }
    }

    private void listarProductos() {
        vista.mostrarProductos(productosDisponibles);
    }

    private void agregarProductoAlCarrito() {
        listarProductos();
        String seleccionStr = vista.solicitarEntrada("Seleccione el número del producto a agregar: ");
        try {
            int seleccion = Integer.parseInt(seleccionStr) - 1;
            if (seleccion >= 0 && seleccion < productosDisponibles.size()) {
                Producto seleccionado = productosDisponibles.get(seleccion);
                carrito.agregarProducto(seleccionado);
                vista.mostrarMensaje("Producto agregado al carrito.");
            } else {
                vista.mostrarMensaje("Selección inválida.");
            }
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Entrada inválida.");
        }
    }

    private void verCarrito() {
        vista.mostrarCarrito(carrito.getProductos());
        double total = carrito.calcularTotal();
        System.out.println("Total: $" + total);
    }

    private void eliminarProductoDelCarrito() {
        verCarrito();
        String seleccionStr = vista.solicitarEntrada("Seleccione el número del producto a eliminar: ");
        try {
            int indice = Integer.parseInt(seleccionStr) - 1;
            carrito.eliminarProducto(indice);
            vista.mostrarMensaje("Producto eliminado.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Entrada inválida.");
        }
    }

    private void aplicarDescuento() {
        String porcentajeStr = vista.solicitarEntrada("Ingrese porcentaje de descuento (ej: 10 para 10%): ");
        try {
            double porcentaje = Double.parseDouble(porcentajeStr);
            double total = carrito.calcularTotal();
            double descuento = total * (porcentaje / 100);
            double totalConDescuento = total - descuento;
            System.out.println("Total con descuento: $" + totalConDescuento);
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Porcentaje inválido.");
        }
    }

    private void calcularEnvio() {
        double envioFijo = 5.0;
        double total = carrito.calcularTotal();
        System.out.println("Envío: $" + envioFijo);
        System.out.println("Total con envío: $" + (total + envioFijo));
    }

    private void verHistorial() {
        vista.mostrarHistorial(carrito.getHistorial());
    }

    private void realizarCompra() {
        if (carrito.getProductos().isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío.");
            return;
        }
        double total = carrito.calcularTotal();
        carrito.vaciarCarrito();
        vista.mostrarMensaje("Compra realizada por $" + total);
    }
}