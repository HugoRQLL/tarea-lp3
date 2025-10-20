import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public boolean eliminarPedido(String nombrePlato) {
        return pedidos.removeIf(p -> p.getNombrePlato().equalsIgnoreCase(nombrePlato));
    }

    public boolean actualizarPedido(String nombrePlato, String nuevoNombre, String nuevoTipo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlato)) {
                pedido.setNombrePlato(nuevoNombre);
                pedido.setTipoPlato(nuevoTipo);
                return true;
            }
        }
        return false;
    }

    public List<Pedido> buscarPedido(String criterio) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(criterio) ||
                pedido.getTipoPlato().equalsIgnoreCase(criterio)) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }

    public int contarPedidos() {
        return pedidos.size();
    }

    public long contarPedidosPorTipo(String tipo) {
        return pedidos.stream()
                      .filter(p -> p.getTipoPlato().equalsIgnoreCase(tipo))
                      .count();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
