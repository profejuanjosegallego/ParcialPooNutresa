package modelo;

public class Sancocho implements Costeable {
    private final String codigo;
    private final String nombre;
    private final Olla olla;
    private final int porciones;

    public Sancocho(String codigo, String nombre, Olla olla, int porciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.olla = olla;
        this.porciones = porciones;
    }

    public boolean estaCompleto() {
        boolean tieneProteina = false;
        boolean tieneTuberculo = false;
        boolean tieneVerdura = false;
        boolean tieneCondimento = false;

        for (Ingrediente i : olla.getIngredientes()) {
            if (i instanceof Proteina) tieneProteina = true;
            if (i instanceof Tuberculo) tieneTuberculo = true;
            if (i instanceof Verdura) tieneVerdura = true;
            if (i instanceof Condimento) tieneCondimento = true;
        }
        return tieneProteina && tieneTuberculo && tieneVerdura && tieneCondimento;
    }

    public boolean esTrifasico() {
        int carnes = 0;
        for (Ingrediente i : olla.getIngredientes()) {
            if (i instanceof Proteina) carnes++;
        }
        return carnes >= 3;
    }

    public String obtenerFicha() {
        String estado = estaCompleto() ? "✅ Completo" : "❌ Incompleto";
        return nombre + " (" + codigo + ") — " + porciones + " porciones — " + estado;
    }

    public int getPorcionesDisponibles() {
        return porciones;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public double calcularCosto() {
        return porciones * 15000;
    }

    public boolean servir(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}