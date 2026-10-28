package modelo;

public class Verdura extends Ingrediente {

    public Verdura(String codigo, String nombre, int gramos, double precioKilo, boolean fresco) {
        super(codigo, nombre, gramos, precioKilo, fresco);
    }

    @Override
    public int minutosCoccion() {
        return 30;
    }

    @Override
    public String getCategoria() {
        return "Verdura";
    }
}