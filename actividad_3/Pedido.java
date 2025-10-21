package actividad_3;


public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    private String estado;

    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
        this.estado = "pendiente";
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public String getEstado() {
        return estado;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Plato: " + nombrePlato + " | Tipo: " + tipoPlato + " | Estado: " + estado;
    }
}