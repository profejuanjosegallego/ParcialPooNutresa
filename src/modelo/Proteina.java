package modelo;

public class Proteina extends Ingrediente {
    private String tipo;

    public Proteina(String codigo, String nombre, int gramos, double precioKilo, boolean fresco, String tipo) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.tipo = tipo;
    }

    @Override
    public int minutosCoccion() {
        if (tipo != null && tipo.equalsIgnoreCase("gallina")) {
            return 60;
        }
        return 90;
    }

    @Override
    public String getCategoria() {
        return "Proteina";
    }

    public String getTipo() {
        return tipo;
    }
}