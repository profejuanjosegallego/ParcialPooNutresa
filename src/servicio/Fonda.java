package servicio;

import java.util.ArrayList;
import modelo.Acompanamiento;
import modelo.Pedido;
import modelo.Sancocho;

public class Fonda {
    private String nombre;
    private ArrayList<Sancocho> menu;
    private ArrayList<Pedido> pedidos;

    public Fonda(String nombre) {
        this.nombre = nombre;
        this.menu = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void agregarAlMenu(Sancocho sancocho) {
        if (sancocho != null) {
            menu.add(sancocho);
        }
    }

    public Sancocho buscarSancocho(String codigo) {
        for (Sancocho s : menu) {
            if (s.getCodigo().equalsIgnoreCase(codigo)) {
                return s;
            }
        }
        return null;
    }

    public Pedido registrarPedido(int mesa, String codigoSancocho, int cantidad, ArrayList<Acompanamiento> acompanamientos) {
        Sancocho sancocho = buscarSancocho(codigoSancocho);
        if (sancocho == null) {
            System.out.println("Error mesa " + mesa + ": Sancocho " + codigoSancocho + " no está en el menú.");
            return null;
        }

        if (sancocho.getPorcionesDisponibles() < cantidad) {
            System.out.println("Error mesa " + mesa + ": Porciones insuficientes (" + sancocho.getPorcionesDisponibles() + " disponibles, solicitadas " + cantidad + ").");
            return null;
        }

        if (sancocho.servir(cantidad)) {
            Pedido pedido = new Pedido(mesa, sancocho, cantidad, acompanamientos);
            pedidos.add(pedido);
            return pedido;
        }

        return null;
    }

    public double calcularVentasDelDia() {
        double total = 0.0;
        for (Pedido p : pedidos) {
            total += p.calcularCosto();
        }
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Sancocho> getMenu() {
        return menu;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}