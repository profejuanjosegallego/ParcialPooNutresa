package modelo;

public class Proteina extends Ingrediente {
    private final String tipo;

    public Proteina(String codigo, String nombre, int gramos, double precioKilo,
                    boolean fresco, String tipo) {
        super(codigo, nombre, gramos, precioKilo,fresco);
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }

    /** La gallina se ablanda en 60 minutos; la res y el cerdo necesitan 90. */
    @Override
    public int minutosCoccion() {
        if (tipo.equalsIgnoreCase("gallina")) {
            return 60;
        }
        return 90;
    }

    @Override
    public String getCategoria() {
        return "Proteína";
    }
}
