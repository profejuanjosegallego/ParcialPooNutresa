# Evidencias: Johann Felipe Hincapié Usuga

## 1. Errores de sintaxis corregidos

> Completa las filas 1 a 23 con tus anotaciones (archivo, línea y mensaje de `javac`). Las filas 24 y 25 ya están llenas.

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
| 24 | `Fonda.java` (`registrarPedido`) | ... | `constructor Pedido in class Pedido cannot be applied to given types` | El constructor de `Pedido` recibe 3 argumentos; se cambió `new Pedido(mesa, sancocho)` por `new Pedido(mesa, sancocho, cantidad)`. |
| 25 | `Fonda.java` (`mostrarMenu`) | ... | `package system does not exist` | Java distingue mayúsculas de minúsculas; se cambió `system.out.println` por `System.out.println`. |

## 2. Errores de lógica corregidos

| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
| 1 | `Ingrediente.calcularCosto` | `gramos / 1000` es una división entera (ambos operandos `int`), así que 1500 g daba 1 kg en vez de 1,5 kg. | Sección 1, costos de la olla de gallina: la gallina daba `$18000` en vez de `$27000`. | Se cambió a `gramos / 1000.0 * precioKilo` para forzar la división con decimales. |
| 2 | `Tuberculo.minutosCoccion` | Los tiempos estaban invertidos: `duro ? 25 : 40`. | Sección 1, minutos de la olla de gallina: la yuca (dura) daba 25 en vez de 40, y la papa daba 40 en vez de 25. | Se cambió a `duro ? 40 : 25`. |
| 3 | `Olla.agregarIngrediente` | Solo comparaba el peso actual con la capacidad, sin sumar el peso del ingrediente nuevo. | Sección 3, `¿Cupo la yuca en la olla pequeña?` daba `true` en vez de `false`. | Se cambió la condición a `calcularPesoTotal() + nuevo.getGramos() > capacidadGramos`. |
| 4 | `Olla.calcularCostoIngredientes` | El ciclo `for` empezaba en `i = 1` y se saltaba el primer ingrediente. | Sección 4, ficha del sancocho de gallina: el costo salía `$18200` menos de lo esperado (faltaba la gallina). | Se cambió el inicio del ciclo a `int i = 0`. |
| 5 | `Olla.calcularTiempoCoccion` | Usaba `<` en vez de `>`, así que `mayor` nunca se actualizaba y la olla siempre quedaba lista en 0 minutos. | Sección 4, fichas de los sancochos: el tiempo salía `0 min`. | Se cambió el operador a `i.minutosCoccion() > mayor`. |
| 6 | `Sancocho.estaCompleto` | Mezclaba `&&` y `\|\|`: bastaba tener un condimento para que dijera `true`. | Sección 4, `¿Está completo?` del caldo de papa daba `true` en vez de `false`. | Se unieron las tres condiciones (proteína, tubérculo y condimento) con `&&`. |
| 7 | `Sancocho.esTrifasico` | Contaba todos los ingredientes (`getCantidadIngredientes() >= 3`) en vez de contar proteínas. | Sección 4, `¿Es trifásico?` del sancocho de gallina daba `true` en vez de `false`. | Se cambió a `olla.contarPorCategoria("Proteína") >= 3`. |
| 8 | `Pedido.calcularCosto` | Los acompañamientos se sumaban una sola vez al total, pero cada plato lleva los suyos. | Sección 5, mesa 1 daba `$22580` en vez de `$27080` y mesa 2 `$41140` en vez de `$46140`. | Se cambió a `(sancocho.calcularPrecioPorcion() + sumaAcompanamientos) * cantidad`. |
| 9 | `Fonda.registrarPedido` | Creaba y guardaba el pedido en la lista antes de verificar si alcanzaban las porciones, así que los pedidos rechazados quedaban registrados y se cobraban. | Sección 5, `Pedidos registrados` daba `4` en vez de `3` y `Ventas del día` `$181240` en vez de `$127460`. | Se reordenó: primero se llama a `servir`, y si falla se hace `return null`; solo después se crea el `Pedido` y se hace `pedidos.add`. |

## 3. Salida final del programa

```text
=== 1. Olla del sancocho de gallina ===
No se agregó Cebolla larga: no está fresco.
¿Se aceptó un ingrediente que no está fresco? false
No se agregó Ñame: el código TUB-002 ya está en la olla.
¿Se aceptó un código repetido? false
Olla (4470/6000 g):
  - Proteína [PRO-001] Gallina criolla - 1500 g, $27000, 60 min
  - Tubérculo [TUB-001] Papa pastusa - 1000 g, $3000, 25 min
  - Tubérculo [TUB-002] Yuca - 800 g, $2800, 40 min
  - Verdura [VER-001] Mazorca - 600 g, $2400, 30 min
  - Verdura [VER-002] Plátano verde - 500 g, $2000, 30 min
  - Condimento [CON-001] Cilantro - 50 g, $1000, 5 min
  - Condimento [CON-002] Guascas - 20 g, $1000, 5 min

=== 2. Olla del sancocho trifásico ===
Olla (5450/8000 g):
  - Proteína [PRO-101] Gallina - 1000 g, $18000, 60 min
  - Proteína [PRO-102] Costilla de res - 1000 g, $26000, 90 min
  - Proteína [PRO-103] Cerdo - 800 g, $17600, 90 min
  - Tubérculo [TUB-101] Papa pastusa - 1000 g, $3000, 25 min
  - Tubérculo [TUB-102] Yuca - 1000 g, $3500, 40 min
  - Verdura [VER-101] Mazorca - 600 g, $2400, 30 min
  - Condimento [CON-101] Cilantro - 50 g, $1000, 5 min

=== 3. Olla pequeña (caldo de papa) ===
No se agregó Yuca: no cabe en la olla.
¿Cupo la yuca en la olla pequeña? false
Olla (830/1000 g):
  - Tubérculo [TUB-201] Papa criolla - 800 g, $4800, 25 min
  - Condimento [CON-201] Ajo - 30 g, $600, 20 min

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
```

## 4. Conceptos de POO en este proyecto

- **Encapsulamiento:** Los atributos de las clases son `private` (por ejemplo `gramos` y `precioKilo` en `Ingrediente`, o `porcionesDisponibles` en `Sancocho`) y solo se accede a ellos mediante getters y setters. Los setters validan los datos (`gramos` y `precioKilo` deben ser mayores que 0, `nombre` no puede estar vacío), y `Olla.getIngredientes()` devuelve una copia de la lista para que nadie la modifique desde afuera.
- **Herencia:** `Proteina`, `Tuberculo`, `Verdura` y `Condimento` heredan de `Ingrediente` con `extends`. Reutilizan sus atributos y métodos (código, nombre, gramos, `calcularCosto`, `obtenerFicha`) y llaman al constructor del padre con `super(...)`, añadiendo solo lo propio: `tipo`, `duro` o `seAgregaAlFinal`.
- **Abstracción (clase abstracta):** `Ingrediente` es abstracta porque no existe un "ingrediente genérico" que se pueda cocinar. Declara `minutosCoccion()` y `getCategoria()` como métodos abstractos, y cada hija está obligada a implementarlos a su manera. Por eso `new Ingrediente(...)` no compila.
- **Interfaz:** Hay dos. `Identificable` (`getCodigo`, `obtenerFicha`) la implementan `Ingrediente` (y por herencia sus cuatro hijas) y `Sancocho`. `Costeable` (`calcularCosto`) la implementan `Ingrediente`, `Sancocho`, `Acompanamiento` y `Pedido`. Son contratos que clases sin relación de herencia pueden cumplir.
- **Polimorfismo:** En la sección 6 de `Main` se crea un `ArrayList<Costeable>` con una `Tuberculo`, un `Sancocho`, un `Acompanamiento` y un `Pedido`. El ciclo llama a `c.calcularCosto()` sin saber el tipo real de cada objeto, y Java ejecuta la versión correcta en cada caso (por eso imprime `$3000`, `$45200`, `$2000` y `$27080`). Lo mismo ocurre dentro de `Olla`, que recorre `Ingrediente` y llama a `minutosCoccion()` sin importar si es proteína, tubérculo, verdura o condimento.







