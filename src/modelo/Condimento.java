package modelo;

public class Condimento extends Ingrediente {
    private final  boolean seAgregaAlFinal;

    public Condimento(String codigo, String nombre, Integer gramos, Double precioKilo,
                      Boolean fresco, Boolean seAgregaAlFinal) {
        super(codigo, nombre, gramos, precioKilo, fresco);
        this.seAgregaAlFinal = seAgregaAlFinal;
    }

    public Boolean isSeAgregaAlFinal() { return seAgregaAlFinal; }

    /** Las hierbas que se echan al final (cilantro, guascas) necesitan 5 minutos; las demás, 20. */
    @Override
    public int minutosCoccion() {
        int minutos = 0;
        if (seAgregaAlFinal) {
            minutos = 5;
        } else if (!seAgregaAlFinal) {b
            minutos = 20;
        }
        return minutos;
    }

    @Override
    public String getCategoria() {
        return "Condimento";
    }
}
