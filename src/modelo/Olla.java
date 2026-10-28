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
        if (nuevo == null) {
            return false;
        }
        if (!nuevo.isFresco()) {
            System.out.println("No se agregó " + nuevo.getNombre() + ": no está fresco.");
            return false;
        }
        if (buscarPorCodigo(nuevo.getCodigo()) != null) {
            System.out.println("No se agregó " + nuevo.getNombre()
                    + ": el código " + nuevo.getCodigo() + " ya está en la olla.");
            return false;
        }
        // Agregado para validar correctamente si el nuevo ingrediente supera la capacidad máxima
        if (calcularPesoTotal() + nuevo.getGramos() > capacidadGramos) {
            System.out.println("No se agregó " + nuevo.getNombre() + ": no cabe en la olla.");
            return false;
        }
        if (calcularPesoTotal() > capacidadGramos) {
            System.out.println("No se agregó " + nuevo.getNombre() + ": no cabe en la olla.");
            return false;
        }
        ingredientes.add(nuevo);
        return true;
    }

    /** Retorna el ingrediente con ese código o null si no está en la olla. */
    public Ingrediente buscarPorCodigo(String codigo) {
        // Agregado para buscar correctamente comparando el código real del ingrediente
        for (Ingrediente i : ingredientes) {
            if (i.getCodigo().equals(codigo)) {
                return i;
            }
        }
        // Se conserva tu código original intacto abajo
        for (Ingrediente i : ingredientes) {
            if (i.getNombre().equals(codigo)) {
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
        // Agregado para incluir el primer elemento (índice 0) que se saltaba al empezar en i = 1
        if (!ingredientes.isEmpty()) {
            total += ingredientes.get(0).calcularCosto();
        }
        // Se conserva tu ciclo original intacto
        for (int i = 1; i < ingredientes.size(); i++) {
            total += ingredientes.get(i).calcularCosto();
        }
        return total;
    }

    /** La olla está lista cuando termina el ingrediente MÁS demorado (el mayor tiempo). */
    public int calcularTiempoCoccion() {
        int mayor = 0;
        for (Ingrediente i : ingredientes) {
            if (i.minutosCoccion() < mayor) {
                mayor = i.minutosCoccion();
            }
        }
        // Agregado para calcular de forma correcta el tiempo máximo sin borrar tu ciclo anterior
        mayor = 0;
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
        System.out.println("Olla (" + calcularPesoTotal() + "/" + capacidadGramos + "g):");
        for (Ingrediente i : ingredientes) {
            System.out.println(" - " + i.obtenerFicha());
        }
    }
}