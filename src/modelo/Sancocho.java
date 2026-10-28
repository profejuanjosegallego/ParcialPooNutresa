package modelo;

public class Sancocho implements Identificable, Costeable {
    public static final double COSTO_GAS_POR_MINUTO = 100;
    public static final double MARGEN_GANANCIA = 0.60;

    private final String codigo;
    private final String nombre;
    private final Olla olla;
    private final int porcionesTotales;
    private int porcionesDisponibles;

    public Sancocho(String codigo, String nombre, Olla olla, int porciones) {
        if (porciones <= 0) {
            throw new IllegalArgumentException("Las porciones deben ser mayores que 0");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.olla = olla;
        this.porcionesTotales = porciones;
        this.porcionesDisponibles = porciones;
    }

    @Override public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Olla getOlla() { return olla; }
    public int getPorcionesTotales() { return porcionesTotales; }
    public int getPorcionesDisponibles() { return porcionesDisponibles; }

    @Override
    public double calcularCosto() {
        return olla.calcularCostoIngredientes() + olla.calcularTiempoCoccion() * COSTO_GAS_POR_MINUTO;
    }

    public double calcularPrecioPorcion() {
        return calcularCosto() / porcionesTotales * (1 + MARGEN_GANANCIA);
    }

    public boolean estaCompleto() {
        return olla.contarPorCategoria("Proteína") > 0
            && olla.contarPorCategoria("Tubérculo") > 0
            && olla.contarPorCategoria("Condimento") > 0;
    }

    public boolean esTrifasico() {
        return olla.contarPorCategoria("Proteína") >= 3;
    }

    public boolean servir(int cantidad) {
        if (cantidad <= 0 || cantidad > porcionesDisponibles) {
            return false;
        }
        porcionesDisponibles -= cantidad;
        return true;
    }

    @Override
    public String obtenerFicha() {
        return "Sancocho [" + codigo + "] " + nombre + " - " + porcionesTotales + " porciones, "
                + olla.calcularTiempoCoccion() + " min, costo $" + String.format("%.2f", calcularCosto())
                + ", plato $" + String.format("%.2f", calcularPrecioPorcion());
    }
}