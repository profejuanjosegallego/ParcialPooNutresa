package modelo;

public class Acompanamiento implements Costeable {
    private String nombre;
    private double precio;

    public Acompanamiento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public double calcularCosto() {
        return precio;
    }
}
