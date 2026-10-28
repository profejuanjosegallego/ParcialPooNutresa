package modelo;

public class Proteina extends Ingrediente {
    private String tipo;

    public Proteina(String codigo, String nombre, double gramos, double precioKilo, boolean fresco, String tipo) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.tipo = tipo.toLowerCase();
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public int getTiempoCoccion() {
        switch (tipo) {
            case "res":
                return 90;
            case "gallina":
                return 60;
            case "cerdo":
                return 45;
            default:
                return 50;
        }
    }
}