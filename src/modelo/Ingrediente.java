package modelo;

public abstract class Ingrediente implements Identificable, Costeable {
    protected String codigo;
    protected String nombre;
    protected int gramos;
    protected double precioKilo;
    protected boolean fresco;

    public Ingrediente(String codigo, String nombre, int gramos, double precioKilo, boolean fresco) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.gramos = gramos;
        this.precioKilo = precioKilo;
        this.fresco = fresco;
    }

    @Override
    public double calcularCosto() {
        return (this.gramos / 1000.0) * this.precioKilo;
    }

    public abstract int minutosCoccion();
    public abstract String getCategoria();

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGramos() {
        return gramos;
    }

    public double getPrecioKilo() {
        return precioKilo;
    }

    public boolean isFresco() {
        return fresco;
    }

    @Override
    public String obtenerFicha() {
        return nombre + " (" + getCategoria().toLowerCase() + ")";
    }
}