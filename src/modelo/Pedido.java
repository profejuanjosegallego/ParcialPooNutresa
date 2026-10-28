package modelo;

import java.util.ArrayList;

public class Pedido implements Costeable {
    private final int mesa;
    private final Sancocho sancocho;
    private final int cantidad;
    private final ArrayList<Acompanamiento> acompanamientos;

    public Pedido(int mesa, Sancocho sancocho, int cantidad) {
        this.mesa = mesa;
        this.sancocho = sancocho;
        this.cantidad = cantidad;
        this.acompanamientos = new ArrayList<>();
    }

    public int getMesa() { return mesa; }
    public Sancocho getSancocho() { return sancocho; }
    public int getCantidad() { return cantidad; }

    public void agregarAcompanamiento(Acompanamiento acompanamiento) {
        if (acompanamiento != null) {
            acompanamientos.add(acompanamiento);
        }
    }

    /** CADA plato lleva sus acompañamientos: (precio del plato + acompañamientos) × cantidad. */
    @Override
    public double calcularCosto() {
        double sumaAcompanamientos = 0;
        for (Acompanamiento a : acompanamientos) {
            sumaAcompanamientos += a.getPrecio();
        }
        return (sancocho.calcularPrecioPorcion() + sumaAcompanamientos) * cantidad;
    }

    public String obtenerResumen() {
        String texto = "Mesa " + mesa + ": " + cantidad + " x " + sancocho.getNombre();
        for (Acompanamiento a : acompanamientos) {
            texto += " + " + a.getNombre();
        }
        return texto + " = $" + String.format("%.0f", calcularCosto());
    }
}
