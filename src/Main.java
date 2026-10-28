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

        Proteina gallina = new Proteina("PRO-001", "Gallina criolla", 1500, 18000, true, "gallina");
        Tuberculo papa = new Tuberculo("TUB-001", "Papa pastusa", 1000, 3000, true, true);
        Tuberculo yuca = new Tuberculo("TUB-002", "Yuca", 800, 3500, true, true);
        Verdura mazorca = new Verdura("VER-001", "Mazorca", 600, 4000, true, false);
        Verdura platano = new Verdura("VER-002", "Plátano verde", 500, 3000, true, true);
        Condimento cilantro = new Condimento("CON-001", "Cilantro", 50, 20000, true, true);
        Condimento guascas = new Condimento("CON-002", "Guascas", 20, 50000, true, true);

        ollaGallina.agregarIngrediente(gallina);
        ollaGallina.agregarIngrediente(papa);
        ollaGallina.agregarIngrediente(yuca);
        ollaGallina.agregarIngrediente(mazorca);
        ollaGallina.agregarIngrediente(platano);
        ollaGallina.agregarIngrediente(cilantro);
        ollaGallina.agregarIngrediente(guascas);

        Verdura cebolla = new Verdura("VER-003", "Cebolla larga", 100, 3500, false, false);
        System.out.println("¿Se aceptó un ingrediente que no está fresco? " + ollaGallina.agregarIngrediente(cebolla));

        Tuberculo name = new Tuberculo("TUB-002", "Ñame", 700, 4000, true, true);
        System.out.println("¿Se aceptó un código repetido? " + ollaGallina.agregarIngrediente(name));

        ollaGallina.mostrarIngredientes();

        System.out.println("\n=== 2. Sancocho ===");
        Sancocho deGallina = new Sancocho("SAN-001", "Sancocho de gallina", ollaGallina, 10);
        System.out.println(deGallina.obtenerFicha());
        System.out.println("¿Está completo? " + deGallina.estaCompleto());
        System.out.println("Costo porción: " + deGallina.calcularCostoPorcion());

        Olla ollaTrifasico = new Olla(10000);
        ollaTrifasico.agregarIngrediente(new Proteina("PRO-002", "Costilla", 1000, 22000, true, "res"));
        ollaTrifasico.agregarIngrediente(new Proteina("PRO-003", "Cerdo", 1000, 20000, true, "cerdo"));
        ollaTrifasico.agregarIngrediente(new Proteina("PRO-004", "Pollo", 1000, 16000, true, "pollo"));
        ollaTrifasico.agregarIngrediente(new Tuberculo("TUB-003", "Papa", 1000, 3000, true, true));
        new Verdura("VER-004", "Mazorca", 500, 4000, true)
        ollaTrifasico.agregarIngrediente(new Condimento("CON-003", "Cilantro", 50, 20000, true, true));

        Sancocho trifasico = new Sancocho("SAN-002", "Sancocho trifásico", ollaTrifasico, 12);
        Sancocho caldo = new Sancocho("SAN-003", "Caldo", ollaTrifasico, 1);

        System.out.println(trifasico.obtenerFicha());
        System.out.println("¿Es trifásico? " + trifasico.esTrifasico());
        System.out.println("¿Gallina es trifásico? " + deGallina.esTrifasico());

        System.out.println("\n=== 3. Fonda ===");
        Fonda fonda = new Fonda("La Fonda de la 70");
        fonda.agregarAlMenu(deGallina);
        fonda.agregarAlMenu(trifasico);
        fonda.mostrarMenu();

        System.out.println("\n=== 4. Pedidos ===");
        Pedido p1 = fonda.registrarPedido(1, "SAN-001", 2);
        Pedido p2 = fonda.registrarPedido(2, "SAN-002", 3);
        Pedido p3 = fonda.registrarPedido(3, "SAN-001", 20);

        if (p1 != null) {
            p1.agregarAcompanamiento(new Acompanamiento("Arroz", 3000));
            p1.agregarAcompanamiento(new Acompanamiento("Aguacate", 2500));
            System.out.println(p1.obtenerResumen());
        }
        if (p2 != null) System.out.println(p2.obtenerResumen());
        if (p3 != null) System.out.println(p3.obtenerResumen());

        System.out.println("Ventas del día: " + fonda.calcularVentasDelDia());
        System.out.println("Pedidos registrados: " + fonda.getCantidadPedidos());

        System.out.println("\n=== 5. Polimorfismo ===");
        Ingrediente buscada = ollaGallina.buscarPorCodigo("PRO-001");
        if (buscada != null) {
            System.out.println("Encontrado: " + buscada.getNombre() + " - Costo: " + buscada.calcularCosto());
        }

        Identificable conCodigo = trifasico;
        System.out.println("Identificable: " + conCodigo.getCodigo());

        Costeable costeable = p1;
        if (costeable != null) System.out.println("Costeable pedido: " + costeable.calcularCosto());

        System.out.println("\n=== FIN PRUEBAS ===");
    }
}