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

    /** Retorna una copia para que nadie modifique la lista interna desde afuera. */
    public ArrayList<Ingrediente> getIngredientes() {
        return new ArrayList<>(ingredientes);
    }

    /** Agrega el ingrediente solo si está fresco, su código no está repetido y CABE en la olla. */
    public boolean agregarIngrediente(Ingrediente nuevo) {
        if (nuevo == null || !nuevo.isFresco()) return false;
        if (buscarPorCodigo(nuevo.getCodigo()) != null) return false;
        if (calcularPesoTotal() + nuevo.getGramos() > capacidadGramos) return false;
    
        ingredientes.add(nuevo);
        return true;
    }

    /** Retorna el ingrediente con ese código o null si no está en la olla. */
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

    /** Suma el costo de TODOS los ingredientes de la olla. */
    public double calcularCostoIngredientes() {
        double total = 0;
        for (Ingrediente i : ingredientes) {
            total += i.calcularCosto();
        }
        return total;
    }

    /** La olla está lista cuando termina el ingrediente MÁS demorado (el mayor tiempo). */
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
            if (i.getCategoria().equals(categoria)) {
                contador++;
            }
        }
        return contador;
    }

    public void mostrarIngredientes() {
        System.out.println("Olla (" + calcularPesoTotal() + "/" + capacidadGramos + " g):");
        for (Ingrediente i : ingredientes) {
            System.out.println("  - " + i.obtenerFicha());
        }
    }
}