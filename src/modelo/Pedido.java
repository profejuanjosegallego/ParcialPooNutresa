package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Costeable {
    private int numeroMesa;
    private Sancocho sancocho;
    private int cantidadPorciones;
    private List<Acompanamiento> acompanamientos;

    public Pedido(int numeroMesa, Sancocho sancocho, int cantidadPorciones) {
        this.numeroMesa = numeroMesa;
        this.sancocho = sancocho;
        this.cantidadPorciones = cantidadPorciones;
        this.acompanamientos = new ArrayList<>();
    }

    public void agregarAcompanamiento(Acompanamiento acomp) {
        if (acomp != null) {
            acompanamientos.add(acomp);
        }
    }

    @Override
    public double calcularCosto() {
        double precioBasePlato = sancocho.getPrecioVentaPlato();
        double costoAcompanamientos = 0;
        for (Acompanamiento a : acompanamientos) {
            costoAcompanamientos += a.calcularCosto();
        }
        return (precioBasePlato + costoAcompanamientos) * cantidadPorciones;
    }

    public String obtenerResumen() {
        return String.format("Pedido Mesa %d: %d platos de %s - Total: $%.0f",
                numeroMesa, cantidadPorciones, sancocho.getNombre(), calcularCosto());
    }
}