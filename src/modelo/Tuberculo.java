package modelo;

public class Tuberculo extends Ingrediente {
    private boolean duro;

    public Tuberculo(String codigo, String nombre, int gramos, double precioKilo, boolean fresco, boolean duro) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.duro = duro;
    }

    @Override
    public int minutosCoccion() {
        return duro ? 40 : 25;
    }

    @Override
    public String getCategoria() {
        return "Tuberculo";
    }

    public boolean isDuro() {
        return duro;
    }
}