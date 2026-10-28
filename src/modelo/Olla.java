package modelo;

import java.util.ArrayList;

public class Olla {
    private final int capacidadGramos;
    private final ArrayList<Ingrediente> ingredientes;

    public Olla(int capacidadGramos) {
        this.capacidadGramos = capacidadGramos;
        this.ingredientes = new ArrayList<>();
    }

    public int getCapacidadGramos() { return capacidadGramos; }
    public int getCantidadIngredientes() { return ingredientes.size(); }

    public ArrayList<Ingrediente> getIngredientes() {
        return new ArrayList<>(ingredientes);
    }

    public boolean agregarIngrediente(Ingrediente nuevo) {
        if (nuevo == null) {
            return false;
        }
        if (!nuevo.isFresco()) {
            System.out.println("No se agregó " + nuevo.getNombre() + ": no está fresco.");
            return false;
        }
        if (buscarPorCodigo(nuevo.getCodigo()) != null) {
            System.out.println("No se agregó " + nuevo.getNombre() + ": el código " + nuevo.getCodigo() + " ya está en la olla.");
            return false;
        }
        if (calcularPesoTotal() + nuevo.getGramos() > capacidadGramos) {
            System.out.println("No se agregó " + nuevo.getNombre() + ": no cabe en la olla.");
            return false;
        }
        ingredientes.add(nuevo);
        return true;
    }

    public Ingrediente buscarPorCodigo(String codigo) {
        for (Ingrediente i : ingredientes) {
            if (i.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return null;
    }

    public int calcularPesoTotal() {
        int total = 0;
        for (Ingrediente i : ingredientes) {
            total += i.getGramos();
        }
        return total;
    }

    public double calcularCostoIngredientes() {
        double total = 0;
        for (Ingrediente i : ingredientes) {
            total += i.calcularCosto();
        }
        return total;
    }

    public int calcularTiempoCoccion() {
        int mayor = 0;
        for (Ingrediente i : ingredientes) {
            if (i.minutosCoccion() > mayor) {
                mayor = i.minutosCoccion();
            }
        }
        return mayor;
    }

    public int contarPorCategoria(String categoria) {
        int contador = 0;
        for (Ingrediente i : ingredientes) {
            if (i.getCategoria().equalsIgnoreCase(categoria)) {
                contador++;
            }
        }
        return contador;
    }

    public void mostrarIngredientes() {
        System.out.println("Olla (" + calcularPesoTotal() + "/" + capacidadGramos + " g):");
        for (Ingrediente i : ingredientes) {
            System.out.println(" - " + i.obtenerFicha());
        }
    }
}