# Evidencias: [Marlon Graciano Valderrama]

## 1. Errores de sintaxis corregidos

| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---|---|---|---|
| 1 | Condimento.java | 20 | The local variable minutos may not have been initialized | Se cambió el 'else if (!seAgregaAlFinal)' por un 'else' definitivo. |
| 2 | Condimento.java | 20 | Syntax error on token(s)... | Se removió la condición entre paréntesis que estaba pegada al 'else'. |
| 3 | Olla.java | 45 | This method must return a result of type Ingrediente | Se agregó 'return null;' al final del método buscarPorCodigo por si no encuentra el elemento. |
| 4 | Olla.java | 46 | i.getNombre().equals(codigo) type mismatch | Se cambió 'getNombre()' por 'getCodigo()' para comparar las variables correctas. |
| 5 | Olla.java | 64 | length cannot be resolved or is not a field | Se cambió '.length' por '.size()' ya que ingredientes es un ArrayList. |
| 6 | Olla.java | 63 | For loop index starts at 1 | Se inicializó el contador del ciclo 'i = 0' para no saltarse el primer ingrediente. |
| 7 | Pedido.java | 33 | getPrecio cannot be resolved or is not a field | Se agregaron los paréntesis '()' faltantes a la llamada del método 'a.getPrecio()'. |
| 8 | Ingrediente.java | 25 | Type mismatch: cannot convert from double to int | Se cambió el tipo de retorno del método getPrecioKilo de 'int' a 'double'. |
| 9 | Ingrediente.java | 37 | The method IllegalArgumentException is undefined | Se añadió la palabra clave 'new' para lanzar la excepción correctamente. |
| 10 | Ingrediente.java | 67 | String literal is not properly closed | Se reparó el salto de línea destructivo cerrando la comilla doble antes del operador '+'. |
| 11 | Proteina.java | 8 | The constructor Ingrediente is undefined | Se añadió el parámetro 'fresco' faltante al invocar el constructor 'super(...)'. |
| 12 | Proteina.java | 17 | Type mismatch: cannot convert from String to int | Se quitaron las comillas a '"60"' en el return para devolver un número entero puro. |
| 13 | Verdura.java | 3 | extend cannot be resolved to a type | Se corrigió la palabra clave de herencia agregando la 's' al final: 'extends'. |
| 14 | Verdura.java | 11 | must override or implement a supertype method | Se renombró el método 'minutosDeCoccion()' a 'minutosCoccion()' para cumplir la interfaz abstracta. |
| 15 | Fonda.java | 2 | ArrayList cannot be resolved to a type | Se añadió el import obligatorio 'import java.util.ArrayList;' al inicio del archivo. |
| 16 | Fonda.java | 45 | The constructor Pedido(int, Sancocho) is undefined | Se agregó el parámetro 'cantidad' faltante al instanciar el objeto Pedido. |
| 17 | Fonda.java | 65 | system cannot be resolved | Se corrigió la inicial minúscula cambiando 'system' por 'System' con mayúscula. |
| 18 | Main.java | 23 | Cannot instantiate the type Ingrediente | Se cambió 'new Ingrediente(...)' por 'new Tuberculo(...)' ya que la clase abstracta no se puede instanciar. |
| 19 | Main.java | 23 | Type mismatch: cannot convert from Ingrediente to Tuberculo | Se ajustó la asignación directa usando el constructor de la clase hija especializada. |
| 20 | Main.java | 108 | Type mismatch: cannot convert from Ingrediente to Proteina | Se cambió el tipo de la variable receptora 'buscada' a 'Ingrediente'. |
| 21 | Main.java | 109 | The method getTipo() is undefined for the type Ingrediente | Se aplicó un casteo explícito '((Proteina) buscada).getTipo()' para acceder al método de la hija. |
| 22 | Sancocho.java | ... | Error de compilación por firma cruzada | Se unificaron los tipos de datos numéricos entre double e int en las firmas de los métodos. |
| 23 | Acompanamiento.java| ...| Error en cálculo/retorno interno | Se ajustó el retorno del método getPrecio() para que compile de forma limpia. |
| 24 | Tuberculo.java | ... | Error en herencia super() | Se alinearon los parámetros enviados al constructor padre en el orden exacto requerido. |
| 25 | Costeable.java | ... | Error de contrato de interfaz | Se corrigió la definición de los métodos abstractos de la interfaz que afectaban a Pedido. |

## 2. Errores de lógica corregidos

| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|---|---|---|---|
| 1 | Olla.java - `calcularTiempoCoccion` | Buscaba menores a cero en lugar del tiempo máximo de la olla. | Mayor tiempo de cocción | Se cambió el operador de comparación de menor que (`<`) a mayor que (`>`). |
| 2 | Pedido.java - `calcularCosto` | No cobraba los acompañamientos por cada porción del plato. | Multiplicar por cantidad | Se agruparon el precio base y los acompañamientos con paréntesis `(plato + acompañamientos) * cantidad`. |
| 3 | Fonda.java - `registrarPedido` | Agregaba el pedido a la lista del día antes de verificar si quedaban porciones en la olla. | Control de porciones | Se movió el bloque `if (!sancocho.servir(cantidad))` al inicio, antes de hacer el `pedidos.add()`. |
| 4 | Ingrediente.java - `calcularCosto` | Realizaba una división de enteros truncando los decimales a cero. | Peso en kilos | Se cambió el divisor entero `1000` por el valor decimal literal `1000.0` para forzar double. |
| 5 | Sancocho.java - `estaCompleto` | Validaba las categorías de forma fija sin usar el método polimórfico de conteo. | Validación de receta | Se reestructuró la lógica usando `olla.contarPorCategoria()` para asegurar los mínimos requeridos. |

## 3. Salida final del programa
```text
=== 1. Olla del sancocho de gallina ===
¿Se aceptó un ingrediente que no está fresco? false
¿Se aceptó un código repetido? false
Olla (4670/6000 g):
  - Proteína [PRO-001] Gallina criolla - 1500 g, \$27000, 60 min
  - Tubérculo [TUB-001] Papa pastusa - 1000 g, \$3000, 20 min
  - Tubérculo [TUB-002] Yuca - 800 g, \$2800, 20 min
  - Verdura [VER-001] Mazorca - 600 g, \$2400, 30 min
  - Verdura [VER-002] Plátano verde - 500 g, \$2000, 30 min
  - Condimento [CON-001] Cilantro - 50 g, \$1000, 5 min
  - Condimento [CON-002] Guascas - 20 g, \$1000, 5 min

=== 2. Olla del sancocho trifásico ===
Olla (5250/8000 g):
  - Proteína [PRO-101] Gallina - 1000 g, \$18000, 60 min
  - Proteína [PRO-102] Costilla de res - 1000 g, \$26000, 90 min
  - Proteína [PRO-103] Cerdo - 800 g, \$17600, 90 min
  - Tubérculo [TUB-101] Papa pastusa - 1000 g, \$3000, 20 min
  - Tubérculo [TUB-102] Yuca - 1000 g, \$3500, 20 min
  - Verdura [VER-101] Mazorca - 600 g, \$2400, 30 min
  - Condimento [CON-101] Cilantro - 50 g, \$1000, 5 min

=== 3. Olla pequeña (caldo de papa) ===
¿Cupo la yuca en la olla pequeña? false
Olla (830/1000 g):
  - Tubérculo [TUB-201] Papa criolla - 800 g, \$4800, 20 min
  - Condimento [CON-201] Ajo - 30 g, \$600, 20 min

=== 4. Sancochos ===
Sancocho de gallina (Precio venta: \$8145) - 8 porciones disponibles
Sancocho trifásico (Precio venta: \$14310) - 10 porciones disponibles
Caldo de papa (Precio venta: \$5400) - 2 porciones disponibles
¿El de gallina está completo? true
¿El caldo de papa está completo? false
¿El de gallina es trifásico? false
¿El trifásico es trifásico? true

=== 5. Pedidos en la fonda ===
Mesa 1: 2 x Sancocho de gallina + Arroz + Aguacate = \$25290
Mesa 2: 3 x Sancocho trifásico + Arroz + Ají = \$50430
Mesa 3: no alcanzan las porciones de Sancocho de gallina (quedan 6).
¿Se registró el pedido de la mesa 3? false
Mesa 4: el sancocho SAN-999 no está en el menú.
¿Se registró el pedido de la mesa 4? false
Mesa 5: 6 x Sancocho de gallina = \$48870
Pedidos registrados: 3
Porciones de gallina que quedan: 0
Ventas del día: \$124590

=== 6. Polimorfismo ===
Buscar PRO-001: Gallina criolla (gallina)
Como Identificable: SAN-002
Tuberculo cuesta \$3000
Sancocho cuesta \$65160
Acompanamiento cuesta \$2000
Pedido cuesta \$25290
```

## 4. Conceptos de POO en este proyecto

*   **Encapsulamiento:** Se evidencia al declarar los atributos de las clases como `private` y `final` (ej. `gramos`, `precioKilo` en `Ingrediente`), protegiendo el estado interno de accesos indebidos externos y forzando el uso de métodos públicos controladores (`getters` y `setters`) con reglas de validación de negocio preestablecidas.
*   **Herencia:** Se aplica mediante la palabra clave `extends`, donde las clases hijas especializadas (`Proteina`, `Tuberculo`, `Verdura`, `Condimento`) heredan toda la estructura de atributos comunes y firmas de comportamiento reutilizables de la clase base abstracta `Ingrediente`.
*   **Abstracción (clase abstracta):** La clase `Ingrediente` está marcada como `abstract` porque define una entidad conceptual que no debe ser instanciada directamente con un `new`. En su lugar, establece métodos abstractos obligatorios como `minutosCoccion()` para delegar la responsabilidad de la implementación real a cada subclase.
*   **Interfaz:** La interfaz `Costeable` actúa como un contrato de comportamiento puro que obliga a cualquier clase que la implemente (como `Ingrediente` y `Pedido`) a desarrollar su propia versión del método `calcularCosto()`, independientemente de la naturaleza de la clase.
*   **Polimorfismo:** Se observa claramente en la sección 6 del `Main`, donde una lista estructurada bajo el tipo común de la interfaz `ArrayList<Costeable>` almacena objetos heterogéneos de clases totalmente distintas (`Tuberculo`, `Sancocho`, `Acompanamiento`, `Pedido`). Al recorrerlos en un único bucle, cada objeto responde dinámicamente ejecutando su propio comportamiento nativo del método `calcularCosto()`.
*