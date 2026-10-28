package modelo;

/** Todo lo que tiene un precio en pesos colombianos. */
public interface Costeable {
    default double calcularCosto() {
        return 0;
    }
}
