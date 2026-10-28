# Evidencias: Jorge Alexander Chaves Rivero

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | Acompanamiento.java | 14 | ';' expected | public double getPrecio() { return precio; } |
| 2 | Acompanamiento.java | 16 | Acompanamiento is not abstract and does not override abstract method calcularCosto() in Costeable | @Override
    public double calcularCosto() {
        return precio;
    } |
| 3 | Costeable.java | 5 | interface abstract methods cannot have body | double calcularCosto(); |
| 4 | Identificable.java | 4 | '{' or ';' expected | String getCodigo(); |
| 5 | Pedido.java |  | cannot find symbol
  symbol:   variable getPrecio
  location: variable a of type Acompanamiento | sumaAcompanamientos += a.getPrecio(); |
| 6 | Verdura.java | 3 | '{' expected | public class Verdura extends Ingrediente { |
| 7 | Verdura.java | 10 | minutosDeCoccion() in Verdura does not override or implement a method from a supertype | public int minutosCoccion() { |
| 8 | Condimento.java | 9 | cannot find symbol
  symbol:   variable alFinal
  location: class Condimento | this.seAgregaAlFinal = seAgregaAlFinal; |
| 9 | Condimento.java | 17 | variable minutos might not have been initialized | int minutos = 0; |
| 10 | Proteina.java | 18 | incompatible types: String cannot be converted to int | return 60; |
| 11 | Proteina.java | 8 | constructor Ingrediente in class Ingrediente cannot be applied to given types;
  required: String,String,int,double,boolean
  found:    String,String,int,double
  reason: actual and formal argument lists differ in length | super(codigo, nombre, gramos, precioKilo, fresco); |
| 12 | Olla.java | 45-52 | missing return statement | return null; |
| 13 | Olla.java |  | cannot find symbol
  symbol:   variable length
  location: variable ingredientes of type ArrayList<Ingrediente> | for (int i = 1; i < ingredientes.size(); i++) { |
| 14 | Tuberculo.java | 6 | invalid method declaration; return type required | public Tuberculo(String codigo, String nombre, int gramos, double precioKilo, boolean fresco, boolean duro) { |
| 15 | Tuberculo.java | 22 | not a statement | return "Tubérculo"; |
| 16 | Sancocho.java | 34 | non-static method calcularTiempoCoccion() cannot be referenced from a static context | return olla.calcularCostoIngredientes() + olla.calcularTiempoCoccion() * COSTO_GAS_POR_MINUTO; |
| 17 | Sancocho.java | 55 | Void methods cannot return a value | public boolean servir(int cantidad) { |
| 18 | Ingrediente.java | 25 | incompatible types: possible lossy conversion from double to int | public double getPrecioKilo() { return precioKilo; } |
| 19 | Ingrediente.java | 67 | unclosed string literal | return getCategoria() + " [" + codigo + "] " + nombre + " - " + gramos + " g, $" |
| 20 | Ingrediente.java | 37 | unreported exception IllegalArgumentException; must be caught or declared to be thrown | throw new IllegalArgumentException("Los gramos deben ser mayores que 0"); |
| 21 | Fonda.java | 9-10 | cannot find symbol
  symbol:   class ArrayList
  location: class Fonda | private final ArrayList<Sancocho> menu;
    private final ArrayList<Pedido> pedidos; |
| 22 | Fonda.java | 46 | constructor Pedido in class Pedido cannot be applied to given types;
  required: int,Sancocho,int
  found:    int,Sancocho
  reason: actual and formal argument lists differ in length | Pedido pedido = new Pedido(mesa, sancocho, cantidad); |
| 23 | Fonda.java | 66 | package system does not exist | System.out.println("Menú de " + nombre + ":"); |
| 24 | Main.java | 108 | incompatible types: Ingrediente cannot be converted to Proteina | Proteina buscada = (Proteina) ollaGallina.buscarPorCodigo("PRO-001"); |
| 25 | Main.java | 23 | Ingrediente is abstract; cannot be instantiated | Tuberculo yuca = new Tuberculo("TUB-002", "Yuca", 800, 3500, true, true); |
(las 25 filas)

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
| 1 | Ingrediente.java calcularCosto() | Realizaba una división entera (int / int) descartando los decimales y dejando el precio de muchos ingredientes en $0. | Secciones 1 y 2:
Precios en $0 de yuca, mazorca, etc. | Se cambió el divisor entero 1000 por el decimal 1000.0 para forzar una operación de tipo double. |
| 2 | Tuberculo.java minutosCoccion() | Tenía la lógica del operador ternario invertida; le asignaba 25 minutos a la yuca y 40 minutos a la papa. | Sección 1:
Minutos de la olla de gallina en orden. | Se invirtieron los valores de retorno en el operador ternario para que devuelva duro ? 40 : 25;. |
| 3 | Olla.java buscarPorCodigo() | Comparaba el código del parámetro contra el nombre del ingrediente (getNombre()), impidiendo encontrar coincidencias. | Sección 1: ¿Se aceptó un código repetido? true | Se corrigió la condición del ciclo utilizando i.getCodigo().equals(codigo) para comparar los atributos correctos. |
| 4 | Olla.java agregarIngrediente() | Evaluaba únicamente el peso actual antes de ingresar el ingrediente, permitiendo desbordar la capacidad de la olla. | Sección 3:
¿Cupo la yuca en la olla pequeña? true | Se cambió la condición para sumar el peso actual y el del nuevo ingrediente: calcularPesoTotal() + nuevo.getGramos() > capacidadGramos. |
| 5 | Olla.java calcularCostoIngredientes() | Iniciaba el ciclo for en el índice 1 en lugar de 0, ignorando el costo del primer ingrediente de la lista. | Sección 4:
Ficha del sancocho de gallina (costo muy bajo). | Se modificó el valor inicial del contador del ciclo a int i = 0 para incluir la totalidad de los elementos. |
| 6 | Olla.java calcularTiempoCoccion() | Tenía el operador relacional invertido (< en vez de >), haciendo que el método retornara siempre 0 minutos. | Sección 4:
Fichas de sancochos con 0 min de cocción. | Se corrigió el signo de comparación dentro del condicional del ciclo for a if (i.minutosCoccion() > mayor). |
| 7 | Sancocho.java estaCompleto() | La precedencia de operadores (&& antes que ||) | ¿Está completo? gallina / caldo → true / false [o simplemente ¿Está completo? caldo] | hacía que se validara como completo si solo incluía un condimento.|
| 8 | Sancocho.java esTrifasico() | Contaba el tamaño total de la lista de ingredientes de la olla en lugar de filtrar específicamente por categorías de carne. | Sección 4: ¿Es trifásico? gallina true | Se corrigió el método llamando a olla.contarPorCategoria("Proteína") >= 3 para evaluar únicamente las proteínas. |
| 9 | Pedido.java calcularCosto() | Sumaba el valor de los acompañamientos suelto al final una sola vez, sin multiplicarlos por la cantidad de platos pedidos. | Sección 5: Pedido mesa 1 y 2 ($22580 y $41140). | Se agruparon el precio base y la suma de acompañamientos entre paréntesis antes de multiplicarlos por la variable cantidad. |
| 10 | Fonda.java registrarPedido() | Agregaba el objeto pedido al historial (pedidos.add) antes de verificar si la cocina tenía porciones para servirlo. | Sección 5: Pedidos registrados / Ventas del día altas. | Se reestructuró el método para ejecutar primero el condicional sancocho.servir(cantidad) antes de añadirlo a la lista. |
(las 10 filas)

## 3. Salida final del programa
(pega aquí la salida completa de `java cp out Main`, o una captura)
=== 1. Olla del sancocho de gallina ===
No se agreg� Cebolla larga: no est� fresco.
�Se acept� un ingrediente que no est� fresco? false
No se agreg� �ame: el c�digo TUB-002 ya est� en la olla.
�Se acept� un c�digo repetido? false
Olla (4470/6000 g):
  - Prote�na [PRO-001] Gallina criolla - 1500 g, $27000, 60 min
  - Tub�rculo [TUB-001] Papa pastusa - 1000 g, $3000, 25 min
  - Tub�rculo [TUB-002] Yuca - 800 g, $2800, 40 min
  - Verdura [VER-001] Mazorca - 600 g, $2400, 30 min
  - Verdura [VER-002] Pl�tano verde - 500 g, $2000, 30 min
  - Condimento [CON-001] Cilantro - 50 g, $1000, 5 min
  - Condimento [CON-002] Guascas - 20 g, $1000, 5 min

=== 2. Olla del sancocho trif�sico ===
Olla (5450/8000 g):
  - Prote�na [PRO-101] Gallina - 1000 g, $18000, 60 min
  - Prote�na [PRO-102] Costilla de res - 1000 g, $26000, 90 min
  - Prote�na [PRO-103] Cerdo - 800 g, $17600, 90 min
  - Tub�rculo [TUB-101] Papa pastusa - 1000 g, $3000, 25 min
  - Tub�rculo [TUB-102] Yuca - 1000 g, $3500, 40 min
  - Verdura [VER-101] Mazorca - 600 g, $2400, 30 min
  - Condimento [CON-101] Cilantro - 50 g, $1000, 5 min

=== 3. Olla peque�a (caldo de papa) ===
No se agreg� Yuca: no cabe en la olla.
�Cupo la yuca en la olla peque�a? false
Olla (830/1000 g):
  - Tub�rculo [TUB-201] Papa criolla - 800 g, $4800, 25 min
  - Condimento [CON-201] Ajo - 30 g, $600, 20 min

=== 4. Sancochos ===
Sancocho [SAN-001] Sancocho de gallina - 8 porciones, 60 min, costo $45200, plato $9040
Sancocho [SAN-002] Sancocho trif�sico - 10 porciones, 90 min, costo $80500, plato $12880
Sancocho [SAN-003] Caldo de papa - 2 porciones, 25 min, costo $7900, plato $6320
�El de gallina est� completo? true
�El caldo de papa est� completo? false
�El de gallina es trif�sico? false
�El trif�sico es trif�sico? true

=== 5. Pedidos en la fonda ===
Mesa 1: 2 x Sancocho de gallina + Arroz + Aguacate = $27080
Mesa 2: 3 x Sancocho trif�sico + Arroz + Aj� = $46140
Mesa 3: no alcanzan las porciones de Sancocho de gallina (quedan 6).
�Se registr� el pedido de la mesa 3? false
Mesa 4: el sancocho SAN-999 no est� en el men�.
�Se registr� el pedido de la mesa 4? false
Mesa 5: 6 x Sancocho de gallina = $54240
Pedidos registrados: 3
Porciones de gallina que quedan: 0
Ventas del d�a: $127460

=== 6. Polimorfismo ===
Buscar PRO-001: Gallina criolla (gallina)
Como Identificable: SAN-002
Tuberculo cuesta $3000
Sancocho cuesta $45200
Acompanamiento cuesta $2000
Pedido cuesta $27080

## 4. Conceptos de POO en este proyecto
Explica brevemente (23 líneas cada uno) DÓNDE se usa en este código:
 **Encapsulamiento:**
 **Herencia:**
 **Abstracción (clase abstracta):**
 **Interfaz:** (hay dos, ¿qué clases implementa cada una?)
 **Polimorfismo:** (mira la sección 6 de Main)

 • Encapsulamiento: Se aplica en clases como Ingrediente, Sancocho y Pedido al declarar sus variables de estado como privadas (ej. private int gramos;), restringiendo su manipulación directa externa y controlando su lectura y modificación estrictamente mediante métodos accesores públicos como getGramos() y setGramos().
• Herencia: Se utiliza en la jerarquía de componentes de la receta, donde las clases hijas Proteina, Tuberculo, Verdura y Condimento extienden de manera directa utilizando la palabra clave extends a la superclase común Ingrediente, reutilizando así todos sus atributos y comportamientos base.
• Abstracción (clase abstracta): Se evidencia en la superclase Ingrediente, la cual está marcada como abstract para actuar como un molde conceptual no instanciable. Esta clase obliga a todas sus subclases derivadas a implementar obligatoriamente su propia lógica para los métodos abstractos minutosCoccion() y getCategoria().
• Interfaz: El proyecto cuenta con dos interfaces: Costeable (que obliga a definir calcularCosto() y es implementada por las clases Ingrediente, Sancocho, Pedido y Acompanamiento) e Identificable (que obliga a definir getCódigo() y obtenerFicha(), siendo implementada por las clases Ingrediente y Sancocho).
• Polimorfismo: Se evidencia en la Sección 6 de Main al almacenar objetos de tipos distintos (Tuberculo, Sancocho, Acompanamiento y Pedido) en una lista unificada de tipo ArrayList<Costeable>. Al recorrerlos en el ciclo for, cada objeto responde llamando de forma dinámica a su propia versión del método calcularCosto().