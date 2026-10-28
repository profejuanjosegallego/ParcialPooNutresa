package servicio;

import java.util.ArrayList;
import modelo.Pedido;
import modelo.Sancocho;

public class Fonda {
    private final String nombre;
    private final ArrayList<Sancocho> menu;
    private final ArrayList<Pedido> pedidos;

    public Fonda(String nombre) {
        this.nombre = nombre;
        this.menu = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public int getCantidadPedidos() { return pedidos.size(); }

    public void agregarAlMenu(Sancocho sancocho) {
        if (sancocho != null) {
            menu.add(sancocho);
        }
    }

    public Sancocho buscarSancocho(String codigo) {
        for (Sancocho s : menu) {
            if (s.getCodigo().equals(codigo)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Registra el pedido SOLO si el sancocho está en el menú y alcanzan las porciones.
     * Retorna el pedido creado, o null si no se pudo registrar.
     */
    public Pedido registrarPedido(int mesa, String codigoSancocho, int cantidad) {
        Sancocho sancocho = buscarSancocho(codigoSancocho);
        if (sancocho == null) {
            System.out.println("Mesa " + mesa + ": el sancocho " + codigoSancocho + " no está en el menú.");
            return null;
        }
        if (cantidad <= 0 || cantidad > sancocho.getPorcionesDisponibles()) {
            System.out.println("Mesa " + mesa + ": no alcanzan las porciones de " + sancocho.getNombre()
                    + " (quedan " + sancocho.getPorcionesDisponibles() + ").");
            return null;
        }
        Pedido pedido = new Pedido(mesa, sancocho, cantidad);
        sancocho.servir(cantidad);
        pedidos.add(pedido);
        return pedido;
    }

    /** Suma lo que pagan TODOS los pedidos registrados. */
    public double calcularVentasDelDia() {
        double total = 0;
        for (Pedido p : pedidos) {
            total += p.calcularCosto();
        }
        return total;
    }

    public void mostrarMenu() {
        System.out.println("Menú de " + nombre + ":");
        for (Sancocho s : menu) {
            System.out.println("  - " + s.obtenerFicha());
        }
    }
}
