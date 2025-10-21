package ejercicio_1;

// Vista.java
import java.util.List;
import java.util.Scanner;

public class Vista {
    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n--- Sistema de Carrito de Compras ---");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Listar Productos");
        System.out.println("3. Agregar Producto al Carrito");
        System.out.println("4. Ver Carrito");
        System.out.println("5. Eliminar Producto del Carrito");
        System.out.println("6. Aplicar Descuento");
        System.out.println("7. Calcular Envío");
        System.out.println("8. Ver Historial de Compras");
        System.out.println("9. Realizar Compra");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public String solicitarEntrada(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Productos:");
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i));
            }
        }
    }

    public void mostrarCarrito(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i));
            }
        }
    }

    public void mostrarHistorial(List<Producto> historial) {
        if (historial.isEmpty()) {
            System.out.println("No hay historial de compras.");
        } else {
            System.out.println("Historial de compras:");
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}