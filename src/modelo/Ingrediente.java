package modelo;

public abstract class Ingrediente implements Identificable, Costeable {
    private String codigo;
    private String nombre;
    private int gramos;
    private double precioKilo;
    private boolean fresco;

    public Ingrediente(String codigo, String nombre, int gramos, double precioKilo, boolean fresco) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        this.codigo = codigo;
        setNombre(nombre);
        setGramos(gramos);
        setPrecioKilo(precioKilo);
        setFresco(fresco);
    }

    @Override
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getGramos() { return gramos; }
    public double getPrecioKilo() { return precioKilo; }
    public boolean isFresco() { return fresco; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setGramos(int gramos) {
        if (gramos <= 0) {
            throw new IllegalArgumentException("Los gramos deben ser mayores que 0");
        }
        this.gramos = gramos;
    }

    public void setPrecioKilo(double precioKilo) {
        if (precioKilo <= 0) {
            throw new IllegalArgumentException("El precio por kilo debe ser mayor que 0");
        }
        this.precioKilo = precioKilo;
    }

    public void setFresco(boolean fresco) {
        this.fresco = fresco;
    }

    @Override
    public double calcularCosto() {
        return gramos / 1000.0 * precioKilo;
    }

    public abstract int minutosCoccion();
    public abstract String getCategoria();

    @Override
    public String obtenerFicha() {
        return getCategoria() + " [" + codigo + "] " + nombre + " - " + gramos + " g, $"
                + String.format("%.2f", calcularCosto()) + ", " + minutosCoccion() + " min";
    }
}