import java.util.ArrayList;
import modelo.Acompanamiento;
import modelo.Condimento;
import modelo.Costeable;
import modelo.Identificable;
import modelo.Ingrediente;
import modelo.Olla;
import modelo.Pedido;
import modelo.Proteina;
import modelo.Sancocho;
import modelo.Tuberculo;
import modelo.Verdura;
import servicio.Fonda;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Olla del sancocho de gallina ===");
        Olla ollaGallina = new Olla(6000);
        //                              código     nombre             gramos  $/kg   fresco  tipo
        Proteina gallina = new Proteina("PRO-001", "Gallina criolla", 1500, 18000, true, "gallina");
        //                              código     nombre          gramos  $/kg  fresco  duro
        Tuberculo papa = new Tuberculo("TUB-001", "Papa pastusa", 1000, 3000, true, false);
        Ingrediente yuca = new Tuberculo("TUB-002", "Yuca", 800, 3500, true, true);
        //                            código     nombre           gramos  $/kg  fresco
        Verdura mazorca = new Verdura("VER-001", "Mazorca", 600, 4000, true);
        Verdura platano = new Verdura("VER-002", "Plátano verde", 500, 4000, true);
        //                                   código     nombre      gramos  $/kg   fresco  alFinal
        Condimento cilantro = new Condimento("CON-001", "Cilantro", 50, 20000, true, true);
        Condimento guascas = new Condimento("CON-002", "Guascas", 20, 50000, true, true);
        ollaGallina.agregarIngrediente(gallina);
        ollaGallina.agregarIngrediente(papa);
        ollaGallina.agregarIngrediente(yuca);
        ollaGallina.agregarIngrediente(mazorca);
        ollaGallina.agregarIngrediente(platano);
        ollaGallina.agregarIngrediente(cilantro);
        ollaGallina.agregarIngrediente(guascas);
        Verdura cebolla = new Verdura("VER-003", "Cebolla larga", 100, 5000, false);
        System.out.println("¿Se aceptó un ingrediente que no está fresco? " + ollaGallina.agregarIngrediente(cebolla));
        Tuberculo name = new Tuberculo("TUB-002", "Ñame", 700, 4000, true, true);
        System.out.println("¿Se aceptó un código repetido? " + ollaGallina.agregarIngrediente(name));
        ollaGallina.mostrarIngredientes();

        System.out.println("\n=== 2. Olla del sancocho trifásico ===");
        Olla ollaTrifasica = new Olla(8000);
        ollaTrifasica.agregarIngrediente(new Proteina("PRO-101", "Gallina", 1000, 18000, true, "gallina"));
        ollaTrifasica.agregarIngrediente(new Proteina("PRO-102", "Costilla de res", 1000, 26000, true, "res"));
        ollaTrifasica.agregarIngrediente(new Proteina("PRO-103", "Cerdo", 800, 22000, true, "cerdo"));
        ollaTrifasica.agregarIngrediente(new Tuberculo("TUB-101", "Papa pastusa", 1000, 3000, true, false));
        ollaTrifasica.agregarIngrediente(new Tuberculo("TUB-102", "Yuca", 1000, 3500, true, true));
        ollaTrifasica.agregarIngrediente(new Verdura("VER-101", "Mazorca", 600, 4000, true));
        ollaTrifasica.agregarIngrediente(new Condimento("CON-101", "Cilantro", 50, 20000, true, true));
        ollaTrifasica.mostrarIngredientes();

        System.out.println("\n=== 3. Olla pequeña (caldo de papa) ===");
        Olla ollaPequena = new Olla(1000);
        ollaPequena.agregarIngrediente(new Tuberculo("TUB-201", "Papa criolla", 800, 6000, true, false));
        ollaPequena.agregarIngrediente(new Condimento("CON-201", "Ajo", 30, 20000, true, false));
        Tuberculo yucaExtra = new Tuberculo("TUB-202", "Yuca", 300, 3500, true, true);
        System.out.println("¿Cupo la yuca en la olla pequeña? " + ollaPequena.agregarIngrediente(yucaExtra));
        ollaPequena.mostrarIngredientes();

        System.out.println("\n=== 4. Sancochos ===");
        Sancocho deGallina = new Sancocho("SAN-001", "Sancocho de gallina", ollaGallina, 8);
        Sancocho trifasico = new Sancocho("SAN-002", "Sancocho trifásico", ollaTrifasica, 10);
        Sancocho caldo = new Sancocho("SAN-003", "Caldo de papa", ollaPequena, 2);
        System.out.println(deGallina.obtenerFicha());
        System.out.println(trifasico.obtenerFicha());
        System.out.println(caldo.obtenerFicha());
        System.out.println("¿El de gallina está completo? " + deGallina.estaCompleto());
        System.out.println("¿El caldo de papa está completo? " + caldo.estaCompleto());
        System.out.println("¿El de gallina es trifásico? " + deGallina.esTrifasico());
        System.out.println("¿El trifásico es trifásico? " + trifasico.esTrifasico());

        System.out.println("\n=== 5. Pedidos en la fonda ===");
        Fonda fonda = new Fonda("La Fonda POO");
        fonda.agregarAlMenu(deGallina);
        fonda.agregarAlMenu(trifasico);
        fonda.agregarAlMenu(caldo);
        Acompanamiento arroz = new Acompanamiento("Arroz", 2000);
        Acompanamiento aguacate = new Acompanamiento("Aguacate", 2500);
        Acompanamiento aji = new Acompanamiento("Ají", 500);

        Pedido mesa1 = fonda.registrarPedido(1, "SAN-001", 2);
        if (mesa1 != null) {
            mesa1.agregarAcompanamiento(arroz);
            mesa1.agregarAcompanamiento(aguacate);
            System.out.println(mesa1.obtenerResumen());
        }
        Pedido mesa2 = fonda.registrarPedido(2, "SAN-002", 3);
        if (mesa2 != null) {
            mesa2.agregarAcompanamiento(arroz);
            mesa2.agregarAcompanamiento(aji);
            System.out.println(mesa2.obtenerResumen());
        }
        Pedido mesa3 = fonda.registrarPedido(3, "SAN-001", 7);
        System.out.println("¿Se registró el pedido de la mesa 3? " + (mesa3 != null));
        Pedido mesa4 = fonda.registrarPedido(4, "SAN-999", 1);
        System.out.println("¿Se registró el pedido de la mesa 4? " + (mesa4 != null));
        Pedido mesa5 = fonda.registrarPedido(5, "SAN-001", 6);
        if (mesa5 != null) {
            System.out.println(mesa5.obtenerResumen());
        }
        System.out.println("Pedidos registrados: " + fonda.getCantidadPedidos());
        System.out.println("Porciones de gallina que quedan: " + deGallina.getPorcionesDisponibles());
        System.out.printf("Ventas del día: $%.0f%n", fonda.calcularVentasDelDia());

        System.out.println("\n=== 6. Polimorfismo ===");
        Proteina buscada = ollaGallina.buscarPorCodigo("PRO-001");
        System.out.println("Buscar PRO-001: " + (buscada != null ? buscada.getNombre() + " (" + buscada.getTipo() + ")" : "no encontrado"));
        Identificable conCodigo = trifasico;
        System.out.println("Como Identificable: " + conCodigo.getCodigo());
        ArrayList<Costeable> cosasConPrecio = new ArrayList<>();
        cosasConPrecio.add(papa);
        cosasConPrecio.add(deGallina);
        cosasConPrecio.add(arroz);
        cosasConPrecio.add(mesa1);
        for (Costeable c : cosasConPrecio) {
            System.out.printf("%s cuesta $%.0f%n", c.getClass().getSimpleName(), c.calcularCosto());
        }
    }
}
