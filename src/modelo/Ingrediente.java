package modelo;

public abstract class Ingrediente implements Identificable, Costeable {
    protected String codigo;
    protected String nombre;
    protected double gramos;
    protected double precioKilo;
    protected boolean fresco;

    public Ingrediente(String codigo, String nombre, double gramos, double precioKilo, boolean fresco) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.gramos = gramos;
        this.precioKilo = precioKilo;
        this.fresco = fresco;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getGramos() {
        return gramos;
    }

    public double getPrecioKilo() {
        return precioKilo;
    }

    public boolean isFresco() {
        return fresco;
    }

    @Override
    public double calcularCosto() {
        return (this.gramos / 1000.0) * this.precioKilo;
    }

    public abstract int getTiempoCoccion();
}