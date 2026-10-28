package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final int mesa;
    private final Sancocho sancocho;
    private final int porcionesSolicitadas;
    private final List<Acompanamiento> acompanamientos;

    public Pedido(int mesa, Sancocho sancocho, int porciones) {
        this.mesa = mesa;
        this.sancocho = sancocho;
        this.porcionesSolicitadas = porciones;
        this.acompanamientos = new ArrayList<>();
    }

    public void agregarAcompanamiento(Acompanamiento a) {
        if (a != null) {
            acompanamientos.add(a);
        }
    }

    public String obtenerResumen() {
        return "Mesa " + mesa + " — " + sancocho.obtenerFicha() +
               " — Extras: " + acompanamientos.size();
    }

    public double calcularTotal() {
        double total = sancocho.calcularCosto() * porcionesSolicitadas / sancocho.getPorcionesDisponibles();
        for (Acompanamiento a : acompanamientos) {
            total += a.calcularCosto();
        }
        return total;
    }

    public double calcularCosto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularCosto'");
    }
}