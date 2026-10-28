package modelo;

/** Lo que va en el plato aparte: arroz, aguacate, ají... */
public class Aconpanamiento implements Costeable {
    private final String nombre;
    private final double precio;

    public Aconpanamiento() {
    }

    public Acompanamiento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio }

    public double calcularPrecio() {
        return precio;
    }

    @Override
    public double calcularCosto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularCosto'");
    }
}
