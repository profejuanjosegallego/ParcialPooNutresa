package modelo;

public class Condimento extends Ingrediente {
    private final boolean seAgregaAlFinal;

    public Condimento(String codigo, String nombre, int gramos, double precioKilo,
                      boolean fresco, boolean seAgregaAlFinal) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.seAgregaAlFinal = seAgregaAlFinal;
    }

    public boolean isSeAgregaAlFinal() { return seAgregaAlFinal; }

    @Override
    public int minutosCoccion() {
        if (seAgregaAlFinal) {
            return 5;
        } else {
            return 20;
        }
    }

    @Override
    public String getCategoria() {
        return "Condimento";
    }
}