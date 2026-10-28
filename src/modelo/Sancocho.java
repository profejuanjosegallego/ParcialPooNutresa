package modelo;

public class Sancocho implements Identificable, Costeable {
    private String codigo;
    private String nombre;
    private int porcionesTotales;
    private int porcionesDisponibles;
    private Olla olla;

    public Sancocho(String codigo, String nombre, int porcionesTotales, Olla olla) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.porcionesTotales = porcionesTotales;
        this.porcionesDisponibles = porcionesTotales;
        this.olla = olla;
    }

    @Override
    public double calcularCosto() {
        return olla.calcularCostoIngredientes() + (olla.calcularTiempoCoccion() * 100);
    }

    public double calcularPrecioPorcion() {
        return (calcularCosto() / porcionesTotales) * 1.6;
    }

    public boolean estaCompleto() {
        return olla.contarPorCategoria("Proteina") >= 1 &&
               olla.contarPorCategoria("Tuberculo") >= 1 &&
               olla.contarPorCategoria("Condimento") >= 1;
    }

    public boolean esTrifasico() {
        return olla.contarPorCategoria("Proteina") >= 3;
    }

    public boolean servir(int cantidad) {
        if (porcionesDisponibles >= cantidad) {
            porcionesDisponibles -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPorcionesTotales() {
        return porcionesTotales;
    }

    public int getPorcionesDisponibles() {
        return porcionesDisponibles;
    }

    public Olla getOlla() {
        return olla;
    }

    @Override
    public String obtenerFicha() {
return String.format("%s - %d min, costo $%.0f, plato $%.0f",                nombre, olla.calcularTiempoCoccion(), calcularCosto(), calcularPrecioPorcion());
    }
}