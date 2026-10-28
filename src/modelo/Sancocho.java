package modelo;

import java.util.HashSet;
import java.util.Set;

public class Sancocho implements Identificable, Costeable {
    private String codigo;
    private String nombre;
    private Olla olla;
    private int porcionesTotales;
    private int porcionesDisponibles;

    public Sancocho(String codigo, String nombre, Olla olla, int porcionesTotales) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.olla = olla;
        this.porcionesTotales = porcionesTotales;
        this.porcionesDisponibles = porcionesTotales;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPorcionesDisponibles() {
        return porcionesDisponibles;
    }

    public boolean reducirPorciones(int cantidad) {
        if (cantidad <= porcionesDisponibles) {
            porcionesDisponibles -= cantidad;
            return true;
        }
        return false;
    }

    public int getTiempoCoccion() {
        return olla.calcularTiempoCoccion();
    }

    @Override
    public double calcularCosto() {
        return olla.calcularCostoTotal();
    }

    public double getPrecioVentaPlato() {
        return (calcularCosto() / porcionesTotales) * 1.6;
    }

    public String obtenerFicha() {
        return String.format("Sancocho [%s] %s - %d porciones, %d min, costo $%.0f, plato $%.0f",
                codigo, nombre, porcionesTotales, getTiempoCoccion(), calcularCosto(), getPrecioVentaPlato());
    }

    public boolean estaCompleto() {
        boolean tieneProteina = false;
        boolean tieneTuberculo = false;
        boolean tieneVerdura = false;

        for (Ingrediente ing : olla.getIngredientes()) {
            if (ing instanceof Proteina) {
                tieneProteina = true;
            } else if (ing instanceof Tuberculo) {
                tieneTuberculo = true;
            } else if (ing instanceof Verdura) {
                tieneVerdura = true;
            }
        }
        return tieneProteina && tieneTuberculo && tieneVerdura;
    }

    public boolean esTrifasico() {
        Set<String> proteinas = new HashSet<>();
        for (Ingrediente ing : olla.getIngredientes()) {
            if (ing instanceof Proteina) {
                proteinas.add(((Proteina) ing).getTipo());
            }
        }
        return proteinas.size() >= 3;
    }
}