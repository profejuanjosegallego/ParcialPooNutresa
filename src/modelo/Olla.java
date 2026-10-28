package modelo;

import java.util.ArrayList;

public class Olla {
    private int capacidadGramos;
    private ArrayList<Ingrediente> ingredientes;

    public Olla(int capacidadGramos) {
        this.capacidadGramos = capacidadGramos;
        this.ingredientes = new ArrayList<>();
    }

    public boolean agregarIngrediente(Ingrediente ing) {
        if (ing == null || !ing.isFresco()) {
            return false;
        }
        if (buscarPorCodigo(ing.getCodigo()) != null) {
            return false;
        }
        if (calcularPesoTotal() + ing.getGramos() > capacidadGramos) {
            return false;
        }
        return ingredientes.add(ing);
    }

    public Ingrediente buscarPorCodigo(String codigo) {
        for (Ingrediente ing : ingredientes) {
            if (ing.getCodigo().equalsIgnoreCase(codigo)) {
                return ing;
            }
        }
        return null;
    }

    public int calcularPesoTotal() {
        int peso = 0;
        for (Ingrediente ing : ingredientes) {
            peso += ing.getGramos();
        }
        return peso;
    }

    public double calcularCostoIngredientes() {
        double costoTotal = 0.0;
        for (Ingrediente ing : ingredientes) {
            costoTotal += ing.calcularCosto();
        }
        return costoTotal;
    }

    public int calcularTiempoCoccion() {
        if (ingredientes.isEmpty()) {
            return 0;
        }
        int maxTiempo = 0;
        for (Ingrediente ing : ingredientes) {
            if (ing.minutosCoccion() > maxTiempo) {
                maxTiempo = ing.minutosCoccion();
            }
        }
        return maxTiempo;
    }

    public int contarPorCategoria(String categoria) {
        int contador = 0;
        for (Ingrediente ing : ingredientes) {
            if (ing.getCategoria().equalsIgnoreCase(categoria)) {
                contador++;
            }
        }
        return contador;
    }

    public int getCapacidadGramos() {
        return capacidadGramos;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}