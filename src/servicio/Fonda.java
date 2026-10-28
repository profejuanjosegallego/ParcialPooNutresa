package servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Pedido;
import modelo.Sancocho;

public class Fonda {
    private String nombre;
    private Map<String, Sancocho> menu;
    private List<Pedido> pedidos;

    public Fonda(String nombre) {
        this.nombre = nombre;
        this.menu = new HashMap<>();
        this.pedidos = new ArrayList<>();
    }

    public void agregarAlMenu(Sancocho sancocho) {
        if (sancocho != null) {
            menu.put(sancocho.getCodigo(), sancocho);
        }
    }

    public Pedido registrarPedido(int mesa, String codigoSancocho, int porciones) {
        Sancocho sancocho = menu.get(codigoSancocho);
        if (sancocho == null) {
            return null;
        }
        if (!sancocho.reducirPorciones(porciones)) {
            return null;
        }
        Pedido nuevoPedido = new Pedido(mesa, sancocho, porciones);
        pedidos.add(nuevoPedido);
        return nuevoPedido;
    }

    public int getCantidadPedidos() {
        return pedidos.size();
    }

    public double calcularVentasDelDia() {
        double totalVentas = 0;
        for (Pedido p : pedidos) {
            totalVentas += p.calcularCosto();
        }
        return totalVentas;
    }
}