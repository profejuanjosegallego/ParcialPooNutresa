package modelo;

public class Verdura extends Ingrediente {
    public Verdura(String codigo, String nombre, double gramos, double precioKilo, boolean fresco) {
        super(codigo, nombre, gramos, precioKilo, fresco);
    }

    @Override
    public int getTiempoCoccion() {
        return 30;
    }
}