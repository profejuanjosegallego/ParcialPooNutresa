package modelo;

/** Lo que va en el plato aparte: arroz, aguacate, ají... */
public class Acompanamiento implements Costeable {
    private final String nombre;
    private final double precio;

    public Acompanamiento(String nombre, double precio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del acompañamiento no puede estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del acompañamiento no puede ser negativo.");
        }
    
    this.nombre = nombre;
    this.precio = precio;
}

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio;}

    @Override 
    public double calcularCosto() {
        return precio;
    }
}
