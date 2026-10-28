package modelo;

import java.util.ArrayList;

public class Pedido implements Costeable {
    private int mesa;
    private Sancocho sancocho;
    private int cantidad;
    private ArrayList<Acompanamiento> acompanamientos;

    public Pedido(int mesa, Sancocho sancocho, int cantidad, ArrayList<Acompanamiento> acompanamientos) {
        this.mesa = mesa;
        this.sancocho = sancocho;
        this.cantidad = cantidad;
        this.acompanamientos = acompanamientos != null ? acompanamientos : new ArrayList<>();
    }

    @Override
    public double calcularCosto() {
        double costoAcomps = 0.0;
        for (Acompanamiento a : acompanamientos) {
            costoAcomps += a.calcularCosto();
        }
        return (sancocho.calcularPrecioPorcion() + costoAcomps) * cantidad;
    }

    public int getMesa() {
        return mesa;
    }

    public Sancocho getSancocho() {
        return sancocho;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<Acompanamiento> getAcompanamientos() {
        return acompanamientos;
    }
}