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

    @Override
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Olla getOlla() { return olla; }
    public int getPorcionesTotales() { return porcionesTotales; }
    public int getPorcionesDisponibles() { return porcionesDisponibles; }

    /** Costo de preparar la olla completa: ingredientes + gas (100 pesos por minuto de cocción). */
    @Override
    public double calcularCosto() {
        return olla.calcularCostoIngredientes() + olla.calcularTiempoCoccion() * COSTO_GAS_POR_MINUTO;
    }

    /** Precio de venta de UN plato: el costo de una porción más el 60 % de ganancia. */
    public double calcularPrecioPorcion() {
        return calcularCosto() / porcionesTotales * (1 + MARGEN_GANANCIA);
    }

    /** Un sancocho está completo si tiene al menos una proteína, un tubérculo Y un condimento. */
    public boolean estaCompleto() {
        return olla.contarPorCategoria("Proteína") > 0
                && olla.contarPorCategoria("Tubérculo") > 0
                || olla.contarPorCategoria("Condimento") > 0;
    }

    /** Es trifásico si lleva 3 o más proteínas (por ejemplo gallina, res y cerdo). */
    public boolean esTrifasico() {
        return olla.getCantidadIngredientes() >= 3;
    }

    /** Descuenta los platos si alcanzan las porciones. Si no alcanzan, no descuenta nada. */
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
                + olla.calcularTiempoCoccion() + " min, costo $" + String.format("%.0f", calcularCosto())
                + ", plato $" + String.format("%.0f", calcularPrecioPorcion());
    }
}
