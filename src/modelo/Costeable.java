package modelo;

/** Todo lo que tiene un precio en pesos colombianos. */
public interface Costeable {
    double calcularCosto();

    /** La mazorca, el plátano y la cebolla se cocinan 30 minutos. */
    int minutosDeCoccion();
}
