package modelo;

public class Condimento extends Ingrediente {
    private boolean seAgregaAlFinal;

    public Condimento(String codigo, String nombre, int gramos, double precioKilo, boolean fresco, boolean seAgregaAlFinal) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.seAgregaAlFinal = seAgregaAlFinal;
    }

    @Override
    public int minutosCoccion() {
        return seAgregaAlFinal ? 5 : 20;
    }

    @Override
    public String getCategoria() {
        return "Condimento";
    }

    public boolean isSeAgregaAlFinal() {
        return seAgregaAlFinal;
    }
}