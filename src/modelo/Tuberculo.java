package modelo;

public class Tuberculo extends Ingrediente {
    private boolean duro;

    public Tuberculo(String codigo, String nombre, double gramos, double precioKilo, boolean fresco, boolean duro) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.duro = duro;
    }

    public boolean isDuro() {
        return duro;
    }

    @Override
    public int getTiempoCoccion() {
        return duro ? 40 : 25;
    }
}