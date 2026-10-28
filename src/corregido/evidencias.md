# Evidencias: Santiago Ocampo

## 1. Errores de sintaxis corregidos

| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | `modelo/Acompanamiento.java` | 4 | `cannot find symbol (symbol: class costeable)` | Se cambió `costeable` por `Costeable` con mayúscula inicial. |
| 2 | `modelo/Acompanamiento.java` | 16 | `is not abstract and does not override abstract method calcularCosto() in Costeable` | Se cambió el nombre del método `calcularPrecio()` por `calcularCosto()`. |
| 3 | `modelo/Costeable.java` | 5 | `interface abstract methods cannot have body` | Se eliminó el cuerpo `{ return 0; }` y se finalizó la firma del método con `;`. |
| 4 | `modelo/Ingrediente.java` | 12 | `cannot find symbol (symbol: method trin())` | Se corrigió el nombre del método `trin()` por `trim()`. |
| 5 | `modelo/Ingrediente.java` | 29 | `cannot find symbol (symbol: method trin())` | Se corrigió el nombre del método `trin()` por `trim()`. |
| 6 | `modelo/Ingrediente.java` | 37 | `cannot find symbol (symbol: method IllegalArgumentException)` | Se agregó la palabra clave `new` antes de `IllegalArgumentException(...)`. |
| 7 | `modelo/Olla.java` | 63 | `cannot find symbol (symbol: variable length)` | Se reemplazó `.length` por `.size()` para consultar el tamaño del `ArrayList`. |
| 8 | `modelo/Pedido.java` | 33 | `cannot find symbol (symbol: variable getPrecio)` | Se agregaron los paréntesis `()` al invocar la función `a.getPrecio()`. |
| 9 | `modelo/Proteina.java` | 8 | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | Se incluyó el argumento `fresco` faltante dentro del llamado a `super(...)`. |
| 10 | `modelo/Proteina.java` | 18 | `incompatible types: String cannot be converted to int` | Se reemplazó el texto `"60"` por el entero `60`. |
| 11 | `modelo/Sancocho.java` | 9 | `cannot find symbol (symbol: class olla)` | Se cambió el tipo `olla` por `Olla` con mayúscula inicial. |
| 12 | `modelo/Sancocho.java` | 34 | `non-static method calcularTiempoCoccion() cannot be referenced from a static context` | Se cambió la llamada estática `Olla.calcularTiempoCoccion()` por la llamada sobre la instancia `olla.calcularTiempoCoccion()`. |
| 13 | `modelo/Sancocho.java` | 55 | `incompatible types: unexpected return value` | Se cambió el tipo de retorno de `void` a `boolean` en la firma del método `servir`. |
| 14 | `modelo/Tuberculo.java` | 6 | `invalid method declaration; return type required` | Se renombró el constructor de `Tuberculos` a `Tuberculo` para que coincida con el nombre de la clase. |
| 15 | `modelo/Tuberculo.java` | 22 | `unclosed character literal` | Se reemplazaron las comillas simples `'Tubérculo'` por comillas dobles `"Tubérculo"`. |
| 16 | `modelo/Verdura.java` | 3 | `'{' expected` | Se corrigió la palabra clave `extend` por `extends`. |
| 17 | `modelo/Verdura.java` | 11 | `method does not override or implement a method from a supertype` | Se renombró el método `minutosDeCoccion()` a `minutosCoccion()`. |
| 18 | `servicio/Fonda.java` | 3 | `cannot find symbol (symbol: class ArrayList)` | Se agregó la importación `import java.util.ArrayList;`. |
| 19 | `servicio/Fonda.java` | 45 | `constructor Pedido in class Pedido cannot be applied to given types` | Se agregó el parámetro faltante `cantidad` al invocar `new Pedido(mesa, sancocho, cantidad)`. |
| 20 | `servicio/Fonda.java` | 65 | `package system does not exist` | Se cambió `system` en minúscula por `System` con mayúscula inicial. |
| 21 | `modelo/Condimento.java` | 23 | `variable minutos might not have been initialized` | Se reemplazó la estructura `if/else if` por retornos directos dentro del método `minutosCoccion()`. |
| 22 | `Main.java` | 24 | `Cannot instantiate the type Ingrediente` | Se cambió `new Ingrediente(...)` por la instanciación de la clase concreta `new Tuberculo(...)`. |
| 23 | `Main.java` | 108 | `Type mismatch: cannot convert from Ingrediente to Proteina` | Se agregó el casteo explícito `(Proteina)` al invocar `ollaGallina.buscarPorCodigo("PRO-001")`. |

## 2. Errores de lógica corregidos

| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
| 1 | `Ingrediente.java` - `calcularCosto()` | Realizaba una división entera `gramos / 1000`, perdiendo la precisión decimal del peso. | Sección 1: Costos de la olla de gallina ($3750/3000 en vez de decimales exactos). | Se cambió `1000` por `1000.0` para forzar la división en coma flotante (`double`). |
| 2 | `Tuberculo.java` - `minutosCoccion()` | Tenía la condición ternaria invertida `duro ? 25 : 40`. | Sección 2: La yuca (dura) debe demorar 40 min y la papa (blanda) 25 min. | Se invirtieron las salidas a `duro ? 40 : 25`. |
| 3 | `Olla.java` - `buscarPorCodigo()` | Comparaba el parámetro `codigo` contra `i.getNombre()` en lugar del código. | Sección 1 y 6: Aceptaba códigos repetidos y `PRO-001` retornaba "no encontrada". | Se cambió `i.getNombre()` por `i.getCodigo()`. |
| 4 | `Olla.java` - `agregarIngrediente()` | Validaba `calcularPesoTotal() > capacidadGramos` sin sumar el peso del nuevo ingrediente, permitiendo desbordamientos. | Sección 3: Permitió ingresar la yuca excediendo la capacidad máxima (1130/1000 g). | Se actualizó la condición a `calcularPesoTotal() + nuevo.getGramos() > capacidadGramos`. |
| 5 | `Olla.java` - `calcularTiempoCoccion()` | Usaba el operador `<` (`i.minutosCoccion() < mayor`), lo que retornaba 0 min (mínimo) en lugar del tiempo máximo. | Sección 4: Los sancochos reportaban 0 min de cocción en sus fichas. | Se cambió el operador de comparación por `i.minutosCoccion() > mayor`. |
| 6 | `Sancocho.java` - `estaCompleto()` | Usaba el operador `||` antes de la categoría "Condimento", marcando completo un sancocho sin proteína. | Sección 4: El caldo de papa marcaba `estaCompleto() = true` sin tener proteína. | Se reemplazó el `||` por `&&` para exigir obligatoriamente las tres categorías. |
| 7 | `Sancocho.java` - `esTrifasico()` | Contaba el total de ingredientes de la olla con `getCantidadIngredientes()` en lugar de contar solo las proteínas. | Sección 4: El sancocho de gallina marcaba `esTrifasico() = true`. | Se cambió la llamada por `olla.contarPorCategoria("Proteína") >= 3`. |
| 8 | `Pedido.java` - `calcularCosto()` | Sumaba los acompañamientos al costo total del pedido una sola vez, en lugar de cobrarlos por cada plato. | Sección 5: Los totales de la mesa 1 ($31924) y mesa 2 ($40660) eran incorrectos. | Se ajustó la fórmula a `(sancocho.calcularPrecioPorcion() + sumaAcompanamientos) * cantidad`. |
| 9 | `Fonda.java` - `registrarPedido()` | Ejecutaba `pedidos.add(pedido)` antes de validar si había porciones disponibles con `sancocho.servir()`. | Sección 5: Registraba pedidos rechazados por falta de porciones e inflaba las ventas del día a $209704. | Se movió `pedidos.add(pedido)` para que solo se agregue si `sancocho.servir(cantidad)` retorna `true`. |
| 10 | `Sancocho.java` - `servir()` | No retenía la verificación estricta de porciones al descontar platos, permitiendo valores porciones inconsistentes al rechazar. | Sección 5: No devolvía `false` de forma consistente sin descontar porciones cuando la cantidad superaba las disponibles. | Se estructuró la validación previa `if (cantidad <= 0 || cantidad > porcionesDisponibles) return false;` antes de restar. |

## 3. Salida final del programa

```text
===
=== 1. Olla del sancocho de gallina ===
No se agregó Cebolla larga: no está fresco.
¿Se aceptó un ingrediente que no está fresco? false
No se agregó Papa pastusa: el código TUB-001 ya está en la olla.
¿Se aceptó un código repetido? false
Olla (4480/6000 g):
  - Proteína [PRO-001] Gallina criolla - 1500 g, $27000, 60 min
  - Tubérculo [TUB-001] Papa pastusa - 1000 g, $3000, 25 min
  - Tubérculo [TUB-002] Yuca - 800 g, $2800, 40 min
  - Verdura [VER-001] Mazorca - 600 g, $2400, 30 min
  - Verdura [VER-002] Plátano verde - 500 g, $2000, 30 min
  - Condimento [CON-001] Cilantro - 50 g, $1000, 5 min
  - Condimento [CON-002] Guascas - 30 g, $900, 5 min

=== 2. Olla del sancocho trifásico ===
Olla (5450/8000 g):
  - Proteína [PRO-001] Gallina - 1500 g, $27000, 60 min
  - Proteína [PRO-002] Costilla de res - 1000 g, $26000, 90 min
  - Proteína [PRO-003] Cerdo - 800 g, $17600, 90 min
  - Tubérculo [TUB-001] Papa pastusa - 1000 g, $3000, 25 min
  - Tubérculo [TUB-002] Yuca - 500 g, $1250, 40 min
  - Verdura [VER-001] Mazorca - 600 g, $2400, 30 min
  - Condimento [CON-001] Cilantro - 50 g, $1000, 5 min

=== 3. Olla pequeña (caldo de papa) ===
No se agregó Yuca: no cabe en la olla.
¿Cupo la yuca en la olla pequeña? false
Olla (830/1000 g):
  - Tubérculo [TUB-301] Papa criolla - 800 g, $4800, 25 min
  - Condimento [CON-301] Ajo - 30 g, $600, 20 min

=== 4. Sancochos ===
Sancocho [SAN-001] Sancocho de gallina - 8 porciones, 60 min, costo $45100, plato $9020
Sancocho [SAN-002] Sancocho trifásico - 10 porciones, 90 min, costo $87250, plato $13960
Sancocho [SAN-003] Caldo de papa - 2 porciones, 25 min, costo $7900, plato $6320
¿El de gallina está completo? true
¿El caldo de papa está completo? false
¿El de gallina es trifásico? false
¿El trifásico es trifásico? true

=== 5. Pedidos en la fonda ===
Mesa 1: 2 x Sancocho de gallina + Arroz + Aguacate = $27040
Mesa 2: 3 x Sancocho trifásico + Arroz + Ají = $49380
Mesa 3: no alcanzan las porciones de Sancocho de gallina (quedan 6).
¿Se registró el pedido de la mesa 3? false
Mesa 4: el sancocho SAN-999 no está en el menú.
¿Se registró el pedido de la mesa 4? false
Mesa 5: 6 x Sancocho de gallina = $54120
Pedidos registrados: 3
Porciones de gallina que quedan: 0
Ventas del día: $130540

=== 6. Polimorfismo ===
Buscar PRO-001: Gallina criolla (gallina)
Como Identificable: SAN-002
Tuberculo cuesta $3000
Sancocho cuesta $45100
Acompanamiento cuesta $2000
Pedido cuesta $27040

##4. Conceptos de POO en este proyecto
Encapsulamiento: Se aplica ocultando los atributos con modificadores private y final en clases como Ingrediente, Sancocho y Pedido, exponiendo únicamente métodos de acceso (getters) y validaciones en los modificadores (setters) como setGramos() y setPrecioKilo().

Herencia: Se utiliza mediante la relación de jerarquía donde las clases Proteina, Tuberculo, Verdura y Condimento extienden (extends) de la clase base común Ingrediente, heredando sus atributos y comportamientos compartidos.

Abstracción (clase abstracta): Se implementa en la clase abstracta Ingrediente, la cual define la estructura básica de cualquier ingrediente y declara los métodos abstractos minutosCoccion() y getCategoria(), obligando a sus clases hijas concretas a proveer la implementación específica.

Interfaz: Se usan dos interfaces: Identificable (implementada por Ingrediente y Sancocho para gestionar códigos únicos) y Costeable (implementada por Ingrediente, Acompanamiento, Sancocho y Pedido para estandarizar el cálculo del costo financiero en pesos).

Polimorfismo: Se evidencia en la Sección 6 al almacenar objetos de diferentes tipos (Tuberculo, Sancocho, Acompanamiento, Pedido) dentro de una lista genérica de tipo ArrayList<Costeable>, invocando el método calcularCosto() en cada objeto en tiempo de ejecución de forma transparente.