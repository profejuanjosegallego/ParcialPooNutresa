# Evidencias: Parcial POO - La Fonda POO y su sancocho 🍲🇨🇴

## 1. Errores de sintaxis corregidos

| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | `Identificable.java` | 4 | `interface abstract methods cannot have body` | Se eliminó el cuerpo del método finalizándolo con `;`[cite: 1, 6]. |
| 2 | `Costeable.java` | 5 | `interface abstract methods cannot have body` | Se quitó el cuerpo `{ return 0; }` dejando solo la firma terminada en `;`[cite: 1, 5]. |
| 3 | `Ingrediente.java` | 11 | `invalid method declaration; return type required` | Se corrigió el nombre del constructor para coincidir exactamente con la clase (`Ingrediente`). |
| 4 | `Ingrediente.java` | 3 | `is not abstract and does not override abstract method` | Se agregó la palabra clave `abstract` a la declaración de la clase[cite: 1]. |
| 5 | `Ingrediente.java` | 25 | `incompatible types: possible lossy conversion from double to int` | Se modificó el tipo de retorno de `getPrecioKilo()` de `int` a `double`[cite: 1, 7]. |
| 6 | `Ingrediente.java` | 67 | `unclosed string literal` | Se agregaron comillas dobles de cierre a la cadena `"g, $"`[cite: 1, 9]. |
| 7 | `Proteina.java` | 8 | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | Se agregó el parámetro `fresco` a la llamada `super(...)`[cite: 1, 14]. |
| 8 | `Proteina.java` | 18 | `incompatible types: String cannot be converted to int` | Se retornó el entero `60` en lugar de la cadena `"60"`[cite: 1, 14]. |
| 9 | `Tuberculo.java` | 6 | `invalid method declaration; return type required` | Se renombró el constructor de `Tuberculos` a `Tuberculo`[cite: 1, 18]. |
| 10 | `Tuberculo.java` | 22 | `unclosed character literal` | Se reemplazaron comillas simples `'` por dobles `"` en `"Tuberculo"`[cite: 1, 18]. |
| 11 | `Verdura.java` | 3 | `'{' expected` | Se corrigió la palabra clave `extend` por `extends`[cite: 1, 19]. |
| 12 | `Verdura.java` | 11 | `method does not override or implement a method from a supertype` | Se renombró `minutosDeCoccion()` a `minutosCoccion()` para coincidir con `Ingrediente`[cite: 1, 19]. |
| 13 | `Condimento.java` | 4 | `cannot find symbol: variable seAgregaAlFinal` | Se declaró el atributo `private boolean seAgregaAlFinal;`[cite: 1, 4]. |
| 14 | `Condimento.java` | 23 | `incompatible types: boolean cannot be converted to int` | Se modificó `minutosCoccion()` para retornar enteros `5` o `20` en lugar de un booleano[cite: 1, 4]. |
| 15 | `Acompanamiento.java` | 16 | `is not abstract and does not override abstract method calcularCosto()` | Se renombró el método `calcularPrecio()` por `calcularCosto()`[cite: 1, 2]. |
| 16 | `Olla.java` | 3 | `cannot find symbol: class ArrayList` | Se importó la clase `java.util.ArrayList`[cite: 1, 20]. |
| 17 | `Olla.java` | 64 | `cannot find symbol: variable length` | Se cambió `.length` por `.size()` para la lista `ArrayList`[cite: 1, 11]. |
| 18 | `Sancocho.java` | 34 | `non-static method cannot be referenced from a static context` | Se cambió la llamada estática `Olla.` por la referencia de la instancia `olla.`[cite: 1, 15]. |
| 19 | `Sancocho.java` | 55 | `incompatible types: unexpected return value` | Se cambió el tipo de retorno de `servir(int)` de `void` a `boolean`[cite: 1, 16]. |
| 20 | `Pedido.java` | 12 | `variable acompanamientos might not have been initialized` | Se inicializó la lista `this.acompanamientos = new ArrayList<>();` en el constructor[cite: 1]. |
| 21 | `Pedido.java` | 33 | `cannot find symbol: variable getPrecio` | Se agregaron paréntesis `()` a la llamada del método `a.getPrecio()`[cite: 1, 13]. |
| 22 | `Fonda.java` | 5 | `cannot find symbol: class ArrayList` | Se agregó `import java.util.ArrayList;` al inicio del archivo[cite: 1, 22]. |
| 23 | `Fonda.java` | 45 | `constructor Pedido in class Pedido cannot be applied to given types` | Se incluyó el argumento faltante `cantidad` en `new Pedido(mesa, sancocho, cantidad)`[cite: 1, 23]. |
| 24 | `Fonda.java` | 65 | `package system does not exist` | Se cambió `system.out.println` por `System.out.println`[cite: 1, 22, 23]. |
| 25 | `Main.java` | 23, 108 | `Ingrediente is abstract` / `incompatible types` | Se cambió `new Ingrediente` por `new Tuberculo` (L.23)[cite: 25] y se agregó el casteo explícito `(Proteina)` (L.108)[cite: 27]. |

## 2. Errores de lógica corregidos

| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
| 1 | `Ingrediente.calcularCosto()` | Hacía división entera `gramos / 1000` truncando los decimales[cite: 8]. | Sección 1 (Costos olla de gallina) | Se cambió a `(gramos / 1000.0) * precioKilo` para forzar la división flotante `double`[cite: 8]. |
| 2 | `Tuberculo.minutosCoccion()` | Tenía los tiempos invertidos devolviendo 25 min para duros y 40 para blandos[cite: 18]. | Sección 2 (Tiempo yuca = 40 min) | Se cambió la condición a `duro ? 40 : 25`[cite: 18]. |
| 3 | `Olla.agregarIngrediente()` | Evaluaba la capacidad de la olla sin sumar los gramos del nuevo ingrediente[cite: 10]. | Sección 3 (Cupo la yuca = false) | Se cambió a `calcularPesoTotal() + nuevo.getGramos() <= capacidadGramos`[cite: 10]. |
| 4 | `Olla.buscarPorCodigo()` | Comparaba el nombre del ingrediente (`getNombre()`) en lugar de su código[cite: 11]. | Sección 1 (Código repetido = false) | Se cambió la comparación a `i.getCodigo().equalsIgnoreCase(codigo)`[cite: 11]. |
| 5 | `Olla.calcularCostoIngredientes()` | El bucle iniciaba en `i = 1`, ignorando el costo del primer ingrediente[cite: 11]. | Sección 1 (Costos olla de gallina) | Se reemplazó por un bucle for-each que recorre todos los elementos desde el índice 0[cite: 11]. |
| 6 | `Olla.calcularTiempoCoccion()` | Usaba el operador `<` en vez de `>`, devolviendo siempre 0 min[cite: 11, 12]. | Sección 1 (Minutos olla de gallina = 60) | Se actualizó la condición a `if (i.minutosCoccion() > mayor)` para obtener el tiempo máximo[cite: 11, 12]. |
| 7 | `Sancocho.calcularCosto()` | No sumaba el costo del gas ($100 por cada minuto de cocción de la olla)[cite: 15]. | Sección 4 (Costo sancocho de gallina = $45.200) | Se calculó como `olla.calcularCostoIngredientes() + (olla.calcularTiempoCoccion() * COSTO_GAS_POR_MINUTO)`[cite: 15]. |
| 8 | `Sancocho.calcularPrecioPorcion()` | Dividía por porciones disponibles o no aplicaba el factor de ganancia del 60% (1.6)[cite: 15]. | Sección 4 (Plato gallina = $9.040) | Se actualizó la fórmula a `(calcularCosto() / porcionesTotales) * 1.6`[cite: 15]. |
| 9 | `Sancocho.estaCompleto()` y `esTrifasico()` | `estaCompleto()` usaba `||`[cite: 15]. `esTrifasico()` contaba todos los ingredientes en vez de solo proteínas[cite: 16]. | Sección 4 (`estaCompleto` / `esTrifasico`) | `estaCompleto()` usó `&&` para exigir las 3 categorías[cite: 15]. `esTrifasico()` se cambió a `olla.contarPorCategoria("Proteina") >= 3`[cite: 16]. |
| 10 | `Fonda.registrarPedido()` y `Pedido.calcularCosto()` | `registrarPedido()` guardaba el pedido antes de verificar porciones[cite: 23]. `Pedido` no agrupaba acompañamientos por plato[cite: 13]. | Sección 5 (Mesas 3 y 4 rechazadas / Mesa 1 = $27.080) | `registrarPedido()` solo registra si `sancocho.servir(cantidad)` retorna `true`[cite: 23]. `Pedido` calcula `(precioPlato + costoAcoms) * cantidad`[cite: 13]. |

## 3. Salida final del programa

```text
=== 1. Olla del sancocho de gallina ===
¿Se aceptó un ingrediente que no está fresco? false
¿Se aceptó un código repetido? false
Olla (4470/6000 g):
 - Proteina [PRO-001] Gallina criolla - 1500g, $27000, 60 min
 - Tuberculo [TUB-001] Papa pastusa - 1000g, $3000, 25 min
 - Tuberculo [TUB-002] Yuca - 800g, $2800, 40 min
 - Verdura [VER-001] Mazorca - 600g, $2400, 30 min
 - Verdura [VER-002] Plátano verde - 500g, $2000, 30 min
 - Condimento [CON-001] Cilantro - 50g, $1000, 5 min
 - Condimento [CON-002] Guascas - 20g, $1000, 5 min

=== 2. Olla del sancocho trifásico ===
Olla (5450/8000 g):
 - Proteina [PRO-101] Gallina - 1000g, $18000, 60 min
 - Proteina [PRO-102] Costilla de res - 1000g, $20000, 90 min
 - Proteina [PRO-103] Cerdo - 800g, $17600, 90 min
 - Tuberculo [TUB-101] Papa pastusa - 1000g, $3000, 25 min
 - Tuberculo [TUB-102] Yuca - 1000g, $3500, 40 min
 - Verdura [VER-101] Mazorca - 600g, $2400, 30 min
 - Condimento [CON-101] Cilantro - 50g, $1000, 5 min

=== 3. Olla pequeña (caldo de papa) ===
¿Cupo la yuca en la olla pequeña? false
Olla (830/1000 g):
 - Tuberculo [TUB-201] Papa criolla - 800g, $4000, 25 min
 - Condimento [CON-201] Ajo - 30g, $900, 20 min

=== 4. Sancochos ===
Sancocho [SAN-001] Sancocho de gallina - 8 porciones, 60 min, costo $45200, plato $9040
Sancocho [SAN-002] Sancocho trifásico - 10 porciones, 90 min, costo $80500, plato $12880
Sancocho [SAN-003] Caldo de papa - 2 porciones, 25 min, costo $7900, plato $6320
¿El de gallina está completo? true
¿El caldo de papa está completo? false
¿El de gallina es trifásico? false
¿El trifásico es trifásico? true

=== 5. Pedidos en la fonda ===
Mesa 1: 2 x Sancocho de gallina + Arroz + Aguacate = $27080
Mesa 2: 3 x Sancocho trifásico + Arroz + Ají = $46140
Mesa 3: no alcanzan las porciones de Sancocho de gallina (quedan 6).
¿Se registró el pedido de la mesa 3? false
Mesa 4: el sancocho SAN-999 no está en el menú.
¿Se registró el pedido de la mesa 4? false
Mesa 5: 6 x Sancocho de gallina = $54240
Pedidos registrados: 3
Porciones de gallina que quedan: 0
Ventas del día: $127460

=== 6. Polimorfismo ===
Buscar PRO-001: Gallina criolla (gallina)
Como Identificable: SAN-002
Tuberculo cuesta $3000
Sancocho cuesta $45200
Acompanamiento cuesta $2000
Pedido cuesta $27080

## 4. Conceptos de POO en este proyecto

Encapsulamiento: Se aplica ocultando los atributos con modificadores private y final en clases como Ingrediente, Sancocho y Pedido, exponiendo únicamente métodos de acceso (getters) y validaciones en los modificadores (setters) como setGramos() y setPrecioKilo().

Herencia: Se utiliza mediante la relación de jerarquía donde las clases Proteina, Tuberculo, Verdura y Condimento extienden (extends) de la clase base común Ingrediente, heredando sus atributos y comportamientos compartidos.

Abstracción (clase abstracta): Se implementa en la clase abstracta Ingrediente, la cual define la estructura básica de cualquier ingrediente y declara los métodos abstractos minutosCoccion() y getCategoria(), obligando a sus clases hijas concretas a proveer la implementación específica.

Interfaz: Se usan dos interfaces: Identificable (implementada por Ingrediente y Sancocho para gestionar códigos únicos) y Costeable (implementada por Ingrediente, Acompanamiento, Sancocho y Pedido para estandarizar el cálculo del costo financiero en pesos).

Polimorfismo: Se evidencia en la Sección 6 al almacenar objetos de diferentes tipos (Tuberculo, Sancocho, Acompanamiento, Pedido) dentro de una lista genérica de tipo ArrayList<Costeable>, invocando el método calcularCosto() en cada objeto en tiempo de ejecución de forma transparente.