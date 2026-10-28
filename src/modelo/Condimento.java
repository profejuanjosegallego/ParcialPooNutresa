package modelo;

public class Condimento extends Ingrediente {
    private boolean alFinal;

    public Condimento(String codigo, String nombre, double gramos, double precioKilo, boolean fresco, boolean alFinal) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.alFinal = alFinal;
    }

    public boolean isAlFinal() {
        return alFinal;
    }

    @Override
    public int getTiempoCoccion() {
        return alFinal ? 5 : 15;
    }
}
