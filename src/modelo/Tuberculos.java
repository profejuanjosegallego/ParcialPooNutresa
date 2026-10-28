package modelo;

public class Tuberculos extends Ingrediente {
    private final boolean duro;

    public Tuberculos(String codigo, String nombre, int gramos, double precioKilo,
                     boolean fresco, boolean duro) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.duro = duro;
    }

    public boolean isDuro() { return duro; }

    /** Los tubérculos duros (yuca, ñame) necesitan 40 minutos; los blandos (papa), 25. */
    @Override
    public int minutosCoccion() {
        return duro ? 25 : 40;
    }

    @Override
    public String getCategoria() {
        return "Tubérculo";
    }
}
