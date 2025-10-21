package actividad_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Pedido> historial;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void eliminarPedido(int index) {
        if (index >= 0 && index < pedidos.size()) {
            Pedido pedido = pedidos.get(index);
            pedido.setEstado("eliminado");
            historial.add(pedido);
            pedidos.remove(index);
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public ArrayList<Pedido> getHistorial() {
        return historial;
    }

    public boolean actualizarPedido(int index, String nuevoNombre) {
        if (index >= 0 && index < pedidos.size()) {
            pedidos.get(index).setNombrePlato(nuevoNombre);
            return true;
        }
        return false;
    }

    public List<Pedido> buscarPedidos(String criterio, boolean porNombre) {
        return pedidos.stream()
                .filter(p -> porNombre ? p.getNombrePlato().toLowerCase().contains(criterio.toLowerCase())
                                       : p.getTipoPlato().toLowerCase().contains(criterio.toLowerCase()))
                .collect(Collectors.toList());
    }

    public HashMap<String, Integer> contarPedidos() {
        HashMap<String, Integer> conteo = new HashMap<>();
        conteo.put("Total", pedidos.size());
        for (Pedido p : pedidos) {
            String tipo = p.getTipoPlato();
            conteo.put(tipo, conteo.getOrDefault(tipo, 0) + 1);
        }
        return conteo;
    }

    public boolean marcarComoCompleto(int index) {
        if (index >= 0 && index < pedidos.size()) {
            Pedido pedido = pedidos.get(index);
            pedido.setEstado("completado");
            historial.add(pedido);
            pedidos.remove(index);
            return true;
        }
        return false;
    }

    public List<Pedido> filtrarPorEstado(String estado) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equals(estado))
                .collect(Collectors.toList());
    }

    public int contarPendientes() {
        return (int) pedidos.stream()
                .filter(p -> "pendiente".equals(p.getEstado()))
                .count();
    }
}