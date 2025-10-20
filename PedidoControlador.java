import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarPedidos(modelo.getPedidos());
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar pedido");
            System.out.println("2. Eliminar pedido");
            System.out.println("3. Mostrar pedidos");
            System.out.println("4. Actualizar pedido");
            System.out.println("5. Buscar pedido");
            System.out.println("6. Contar pedidos");
            System.out.println("7. Salir");
            String opcion = vista.scanner.nextLine();

            switch (opcion) {
                case "1":
                    String datos = vista.solicitarDatosPedido();
                    String[] parts = datos.split(",");
                    if (parts.length == 2) {
                        Pedido nuevoPedido = new Pedido(parts[0].trim(), parts[1].trim());
                        modelo.agregarPedido(nuevoPedido);
                        vista.mostrarMensaje("Pedido agregado exitosamente.");
                    } else {
                        vista.mostrarMensaje("Datos inválidos. Use el formato: nombre,tipo");
                    }
                    break;
                case "2":
                    int indice = vista.solicitarEliminacionPedido();
                    if (indice >= 0 && indice < modelo.getPedidos().size()) {
                        modelo.eliminarPedido(indice);
                        vista.mostrarMensaje("Pedido eliminado exitosamente.");
                    } else {
                        vista.mostrarMensaje("Índice inválido.");
                    }
                    break;
                case "3":
                    vista.mostrarMensaje("Lista actualizada arriba.");
                    break;
                case "4": // actualizar pedido
                    String[] actualizacion = vista.solicitarActualizacionPedido().split(",");
                    if (actualizacion.length == 2) {
                        try {
                            int idx = Integer.parseInt(actualizacion[0]) - 1;
                            if (modelo.actualizarPedido(idx, actualizacion[1].trim())) {
                                vista.mostrarMensaje("Pedido actualizado exitosamente.");
                            } else {
                                vista.mostrarMensaje("Índice inválido.");
                            }
                        } catch (NumberFormatException e) {
                            vista.mostrarMensaje("Número inválido.");
                        }
                    } else {
                        vista.mostrarMensaje("Datos inválidos.");
                    }
                    break;
                case "5": // buscar pedido
                    String[] busqueda = vista.solicitarBusquedaPedido();
                    if (busqueda.length == 2) {
                        boolean porNombre = "1".equals(busqueda[0]);
                        List<Pedido> resultados = modelo.buscarPedidos(busqueda[1], porNombre);
                        vista.mostrarResultadosBusqueda(resultados);
                    } else {
                        vista.mostrarMensaje("Opción inválida.");
                    }
                    break;
                case "6": // contar pedidos
                    vista.mostrarConteoPedidos(modelo.contarPedidos());
                    break;
                case "7":
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
        vista.cerrarScanner();
    }
}