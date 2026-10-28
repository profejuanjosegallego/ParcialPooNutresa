import java.util.ArrayList;
import modelo.*;
import servicio.Fonda;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PARCIAL PRÁCTICO POO: LA FONDA POO Y SU SANCOCHO ===\n");

        // SECCIÓN 1: Creación de Olla Gallina e Ingredientes
        System.out.println("--- SECCIÓN 1: Olla de Gallina ---");
        Olla ollaGallina = new Olla(6000);

        Proteina gallina = new Proteina("PRO-001", "Gallina criolla", 1500, 18000, true, "gallina");
        Tuberculo papa = new Tuberculo("TUB-001", "Papa sabanera", 1000, 3000, true, false);
        Verdura mazorca = new Verdura("VER-001", "Mazorca dulce", 700, 4000, true);
        Verdura platano = new Verdura("VER-002", "Plátano verde", 600, 4000, true);
        Tuberculo yuca = new Tuberculo("TUB-002", "Yuca Rionegro", 500, 4000, true, true);
        Condimento cilantro = new Condimento("CON-001", "Cilantro fresco", 100, 10000, true, true);
        Condimento guascas = new Condimento("CON-002", "Guascas de la huerta", 70, 14285.714285714286, true, true);

        Proteina pescadoPodrido = new Proteina("PRO-999", "Pescado vencido", 1000, 15000, false, "pescado");
        Proteina gallinaRepetida = new Proteina("PRO-001", "Gallina extra", 1000, 18000, true, "gallina");

        ollaGallina.agregarIngrediente(gallina);
        ollaGallina.agregarIngrediente(papa);
        ollaGallina.agregarIngrediente(mazorca);
        ollaGallina.agregarIngrediente(platano);
        ollaGallina.agregarIngrediente(yuca);
        ollaGallina.agregarIngrediente(cilantro);
        ollaGallina.agregarIngrediente(guascas);

        boolean agPodrido = ollaGallina.agregarIngrediente(pescadoPodrido);
        boolean agRepetido = ollaGallina.agregarIngrediente(gallinaRepetida);

        System.out.println("Costos de la olla de gallina:");
        for (Ingrediente ing : ollaGallina.getIngredientes()) {
            System.out.printf(" - %s: $%.0f\n", ing.getNombre(), ing.calcularCosto());
        }

        System.out.println("Minutos de cocción:");
        for (Ingrediente ing : ollaGallina.getIngredientes()) {
            System.out.printf(" - %s: %d min\n", ing.getNombre(), ing.minutosCoccion());
        }

        System.out.println("¿Se aceptó ingrediente no fresco? " + agPodrido);
        System.out.println("¿Se aceptó código repetido? " + agRepetido);
        System.out.printf("Olla queda con %d ingredientes, %d/%d g\n\n",
                ollaGallina.getIngredientes().size(),
                ollaGallina.calcularPesoTotal(),
                ollaGallina.getCapacidadGramos());

        // SECCIÓN 2: Olla Trifásica
        System.out.println("--- SECCIÓN 2: Olla Trifásica ---");
        Olla ollaTrifasica = new Olla(8000);

        Proteina res = new Proteina("PRO-002", "Murillo de res", 1200, 22000, true, "res");
        Proteina cerdo = new Proteina("PRO-003", "Costilla de cerdo", 1100, 16000, true, "cerdo");

        ollaTrifasica.agregarIngrediente(gallina);
        ollaTrifasica.agregarIngrediente(res);
        ollaTrifasica.agregarIngrediente(cerdo);
        ollaTrifasica.agregarIngrediente(papa);
        ollaTrifasica.agregarIngrediente(yuca);

        System.out.printf("Olla trifásica: %d/%d g\n", ollaTrifasica.calcularPesoTotal(), ollaTrifasica.getCapacidadGramos());
        System.out.printf("El cerdo cuesta: $%.0f\n", cerdo.calcularCosto());
        System.out.printf("La yuca demora: %d min\n\n", yuca.minutosCoccion());

        // SECCIÓN 3: Capacidad Olla Pequeña
        System.out.println("--- SECCIÓN 3: Capacidad Olla Pequeña ---");
        Olla ollaPequena = new Olla(1000);
        ollaPequena.agregarIngrediente(platano);
        boolean cupoYuca = ollaPequena.agregarIngrediente(yuca);

        System.out.println("¿Cupo la yuca en la olla pequeña? " + cupoYuca);
        System.out.printf("La olla queda en %d/%d g\n\n", ollaPequena.calcularPesoTotal(), ollaPequena.getCapacidadGramos());

        // SECCIÓN 4: Sancochos y Fichas
        System.out.println("--- SECCIÓN 4: Sancochos y Fichas ---");
        Sancocho sancochoGallina = new Sancocho("SAN-001", "Sancocho de Gallina", 8, ollaGallina);
        Sancocho sancochoTrifasico = new Sancocho("SAN-002", "Sancocho Trifásico", 10, ollaTrifasica);

        Olla ollaCaldo = new Olla(3000);
        ollaCaldo.agregarIngrediente(papa);
        Sancocho caldoPapa = new Sancocho("SAN-003", "Caldo de Papa", 2, ollaCaldo);

        System.out.println("Ficha Gallina: " + sancochoGallina.obtenerFicha());
        System.out.println("Ficha Trifásico: " + sancochoTrifasico.obtenerFicha());
        System.out.println("Ficha Caldo: " + caldoPapa.obtenerFicha());

        System.out.printf("¿Está completo? Gallina: %b / Caldo: %b\n", sancochoGallina.estaCompleto(), caldoPapa.estaCompleto());
        System.out.printf("¿Es trifásico? Gallina: %b / Trifásico: %b\n\n", sancochoGallina.esTrifasico(), sancochoTrifasico.esTrifasico());

        // SECCIÓN 5: Menú, Pedidos y Ventas
        System.out.println("--- SECCIÓN 5: Pedidos y Ventas ---");
        Fonda fonda = new Fonda("La Fonda POO");
        fonda.agregarAlMenu(sancochoGallina);
        fonda.agregarAlMenu(sancochoTrifasico);

        Acompanamiento arroz = new Acompanamiento("Arroz", 2000);
        Acompanamiento aguacate = new Acompanamiento("Aguacate", 2500);

        ArrayList<Acompanamiento> acompMesa1 = new ArrayList<>();
        acompMesa1.add(arroz);
        acompMesa1.add(aguacate);

        ArrayList<Acompanamiento> acompMesa2 = new ArrayList<>();
        acompMesa2.add(aguacate);

        Pedido p1 = fonda.registrarPedido(1, "SAN-001", 2, acompMesa1);
        if (p1 != null) {
            System.out.printf("Pedido Mesa 1: $%.0f\n", p1.calcularCosto());
        }

        Pedido p2 = fonda.registrarPedido(2, "SAN-002", 3, acompMesa2);
        if (p2 != null) {
            System.out.printf("Pedido Mesa 2: $%.0f\n", p2.calcularCosto());
        }

        Pedido p3 = fonda.registrarPedido(3, "SAN-999", 1, null);
        System.out.println("Mesa 3 registrada: " + (p3 != null));

        Pedido p4 = fonda.registrarPedido(4, "SAN-001", 10, null);
        System.out.println("Mesa 4 registrada: " + (p4 != null));

        Acompanamiento aji = new Acompanamiento("Ají", 680);
        ArrayList<Acompanamiento> acompMesa5 = new ArrayList<>();
        acompMesa5.add(aji);
        Pedido p5 = fonda.registrarPedido(5, "SAN-002", 4, acompMesa5);
        if (p5 != null) {
            System.out.printf("Pedido Mesa 5: $%.0f\n", p5.calcularCosto());
        }

        System.out.printf("Pedidos registrados: %d / Porciones de gallina que quedan: %d\n",
                fonda.getPedidos().size(), sancochoGallina.getPorcionesDisponibles());
        System.out.printf("Ventas del día: $%.0f\n\n", fonda.calcularVentasDelDia());

        // SECCIÓN 6: Búsqueda y Polimorfismo
        System.out.println("--- SECCIÓN 6: Búsqueda y Polimorfismo ---");
        Ingrediente buscado = ollaGallina.buscarPorCodigo("PRO-001");
        if (buscado != null) {
            System.out.printf("Buscar PRO-001: %s (%s)\n", buscado.getNombre(), ((Proteina) buscado).getTipo());
        }

        Costeable item1 = papa;
        Costeable item2 = sancochoGallina;
        Costeable item3 = arroz;
        Costeable item4 = p1;

        System.out.printf("Polimorfismo: Tuberculo $%.0f, Sancocho $%.0f, Acompanamiento $%.0f, Pedido $%.0f\n",                item1.calcularCosto(),
                item2.calcularCosto(),
                item3.calcularCosto(),
                item4.calcularCosto());
    }
}