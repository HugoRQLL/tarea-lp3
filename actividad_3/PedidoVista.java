package actividad_3;
    
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    public Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarPedidos(ArrayList<Pedido> pedidos) {
        System.out.println("Lista de Pedidos:");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos actualmente.");
        } else {
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println((i + 1) + ". " + pedidos.get(i));
            }
        }
    }

    public String solicitarDatosPedido() {
        System.out.print("Ingrese nombre del plato: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese tipo del plato: ");
        String tipo = scanner.nextLine();
        return nombre + "," + tipo;
    }

    public int solicitarEliminacionPedido() {
        System.out.print("Ingrese el número del pedido a eliminar: ");
        try {
            return Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String solicitarActualizacionPedido() {
        System.out.print("Ingrese el número del pedido a actualizar: ");
        String indiceStr = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre del plato: ");
        String nuevoNombre = scanner.nextLine();
        return indiceStr + "," + nuevoNombre;
    }

    public String[] solicitarBusquedaPedido() {
        System.out.println("¿Buscar por nombre o tipo?");
        System.out.println("1. Por nombre");
        System.out.println("2. Por tipo");
        System.out.print("Seleccione una opción: ");
        String opcion = scanner.nextLine();
        System.out.print("Ingrese el criterio de búsqueda: ");
        String criterio = scanner.nextLine();
        return new String[]{opcion, criterio};
    }

    public void mostrarResultadosBusqueda(List<Pedido> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron pedidos coincidentes.");
        } else {
            System.out.println("Pedidos encontrados:");
            for (Pedido p : resultados) {
                System.out.println(p);
            }
        }
    }

    public void mostrarConteoPedidos(HashMap<String, Integer> conteo) {
        System.out.println("Conteo de Pedidos:");
        for (String key : conteo.keySet()) {
            System.out.println(key + ": " + conteo.get(key));
        }
    }

    public String solicitarEstadoMostrar() {
        System.out.println("¿Mostrar pedidos pendientes o completos?");
        System.out.println("1. Pendientes");
        System.out.println("2. Completos");
        System.out.print("Seleccione una opción: ");
        String opcion = scanner.nextLine();
        return "1".equals(opcion) ? "pendiente" : "completado";
    }

    public void mostrarPedidosPorEstado(List<Pedido> pedidosFiltrados, String estado) {
        System.out.println("Pedidos " + estado + "s:");
        if (pedidosFiltrados.isEmpty()) {
            System.out.println("No hay pedidos " + estado + "s.");
        } else {
            for (Pedido p : pedidosFiltrados) {
                System.out.println(p);
            }
        }
    }

    public void mostrarContadorPendientes(int contador) {
        System.out.println("Número de pedidos pendientes: " + contador);
    }

    public void mostrarHistorial(ArrayList<Pedido> historial) {
        System.out.println("Historial de Pedidos (Completados/Eliminados):");
        if (historial.isEmpty()) {
            System.out.println("No hay pedidos en el historial.");
        } else {
            for (Pedido p : historial) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}