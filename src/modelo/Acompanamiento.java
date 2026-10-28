package modelo;


public class Acompanamiento implements Costeable {
    private final String nombre;
    private final double precio;

    public Acompanamiento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public double calcularCosto() {
        return precio;
    }
}
