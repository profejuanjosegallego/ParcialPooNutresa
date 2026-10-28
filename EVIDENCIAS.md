# Evidencias: Miguel Angel Samudio Urán

## 1. Errores de sintaxis corregidos

| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | `Identificable.java` | 4 | `interface abstract methods cannot have body` | Se removieron los corchetes `{}` dejando solo la firma del método. |
| 2 | `Identificable.java` | 5 | `; expected` | Se agregó el punto y coma `;` al final de la declaración. |
| 3 | `Costeable.java` | 4 | `interface abstract methods cannot have body` | Se eliminó el cuerpo `{ return 0; }` y se dejó la interfaz limpia. |
| 4 | `Ingrediente.java` | 3 | `{ expected` | Se acomodó la sintaxis de declaración de la clase abstracta e `implements`. |
| 5 | `Ingrediente.java` | 11 | `invalid method declaration; return type required` | Se renombró el constructor para coincidir con la clase (`Ingrediente`). |
| 6 | `Ingrediente.java` | 18 | `unclosed string literal` | Se cerraron comillas en las cadenas del método. |
| 7 | `Proteina.java` | 8 | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | Se llamó a `super(codigo, nombre, gramos, precioKilo, fresco)`. |
| 8 | `Proteina.java` | 15 | `method does not override or implement a method from a supertype` | Se ajustó la firma del método `@Override public int minutosCoccion()`. |
| 9 | `Tuberculo.java` | 8 | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | Se agregó la llamada a `super(...)` con sus parámetros. |
| 10 | `Tuberculo.java` | 15 | `incompatible types: possible lossy conversion from double to int` | Se cambió el tipo de retorno para que devuelva un `int`. |
| 11 | `Verdura.java` | 8 | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | Se corrigió la llamada al constructor padre con `super(...)`. |
| 12 | `Verdura.java` | 14 | `is not abstract and does not override abstract method` | Se implementó el método `getCategoria()`. |
| 13 | `Condimento.java` | 8 | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | Se invocó el constructor `super(...)`. |
| 14 | `Condimento.java` | 15 | `incompatible types: String cannot be converted to boolean` | Se cambió la asignación de `seAgregaAlFinal` a tipo booleano. |
| 15 | `Acompanamiento.java` | 12 | `missing return statement` | Se colocó `return precio;` dentro de `calcularCosto()`. |
| 16 | `Olla.java` | 5 | `cannot find symbol: class ArrayList` | Se agregó `import java.util.ArrayList;`. |
| 17 | `Olla.java` | 22 | `non-static method cannot be referenced from a static context` | Se arregló la invocación del método sobre el objeto correspondiente. |
| 18 | `Olla.java` | 35 | `variable total might not have been initialized` | Se inicializó la variable `double costoTotal = 0.0;`. |
| 19 | `Sancocho.java` | 3 | `package system does not exist` | Se cambió `system` por `System` con mayúscula. |
| 20 | `Sancocho.java` | 15 | `is not abstract and does not override abstract method` | Se implementaron los métodos de las interfaces `Identificable` y `Costeable`. |
| 21 | `Pedido.java` | 5 | `cannot find symbol: class ArrayList` | Se agregó `import java.util.ArrayList;`. |
| 22 | `Pedido.java` | 18 | `incompatible types: void cannot be converted to double` | Se ajustó para que `calcularCosto()` devuelva `double`. |
| 23 | `Fonda.java` | 5 | `cannot find symbol: class Sancocho` | Se importaron los modelos con `import modelo.*;`. |
| 24 | `Fonda.java` | 28 | `incompatible types: Ingrediente cannot be converted to Proteina` | Se aplicó casteo explícito `(Proteina) buscado`. |
| 25 | `Main.java` | 45 | `; expected` | Se cerraron sentencias con `;` en `Main.java`. |

## 2. Errores de lógica corregidos

| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
| 1 | `Ingrediente.calcularCosto()` | Multiplicaba `gramos * precioKilo` directamente. | Sec. 1: Costos olla de gallina | Se convirtió a kilos dividiendo entre 1000.0: `(gramos / 1000.0) * precioKilo`. |
| 2 | `Tuberculo.minutosCoccion()` | Invertía tiempos (25 min para duros y 40 para blandos). | Sec. 2: Yuca demora 40 min | Se usó el operador ternario `duro ? 40 : 25`. |
| 3 | `Olla.agregarIngrediente()` | Aceptaba no frescos, códigos repetidos y exceso de peso. | Sec. 1 y Sec. 3 | Se validó fresco, repetidos con `buscarPorCodigo` y límite de capacidad. |
| 4 | `Olla.calcularTiempoCoccion()` | Sumaba los minutos en lugar de buscar el mayor. | Sec. 1: Minutos olla de gallina | Se buscó el tiempo máximo iterando los ingredientes. |
| 5 | `Sancocho.calcularCosto()` | No sumaba el costo del gas por minuto. | Sec. 4: Ficha Sancocho Gallina | Se agregó `+(olla.calcularTiempoCoccion() * 100)`. |
| 6 | `Sancocho.calcularPrecioPorcion()` | Omitía el 60% de ganancia en el cálculo. | Sec. 4: Plato gallina $9040 | Se multiplicó el costo por porción por `1.6`. |
| 7 | `Sancocho.estaCompleto()` | No validaba que tuviera proteína, tubérculo y condimento al tiempo. | Sec. 4: ¿Está completo? | Se exigió `contarPorCategoria >= 1` para las 3 categorías. |
| 8 | `Sancocho.esTrifasico()` | Contaba menos de 3 proteínas. | Sec. 4: ¿Es trifásico? | Se puso como condición `contarPorCategoria("Proteina") >= 3`. |
| 9 | `Pedido.calcularCosto()` | No multiplicaba los acompañamientos por la cantidad de platos. | Sec. 5: Pedido mesa 1 y 5 | Se sumó el plato con acompañamientos y se multiplicó por `cantidad`. |
| 10 | `Fonda.registrarPedido()` | No reducía las porciones ni validaba disponibilidad suficiente. | Sec. 5: Porciones que quedan | Se validó disponible y se llamó a `sancocho.servir(cantidad)`. |

## 3. Salida final del programa

```text
=== PARCIAL PRÁCTICO POO: LA FONDA POO Y SU SANCOCHO ===

--- SECCIÓN 1: Olla de Gallina ---
Costos de la olla de gallina:
 - Gallina criolla: $27000
 - Papa sabanera: $3000
 - Mazorca dulce: $2800
 - Plátano verde: $2400
 - Yuca Rionegro: $2000
 - Cilantro fresco: $1000
 - Guascas de la huerta: $1000
Minutos de cocción:
 - Gallina criolla: 60 min
 - Papa sabanera: 25 min
 - Mazorca dulce: 30 min
 - Plátano verde: 30 min
 - Yuca Rionegro: 40 min
 - Cilantro fresco: 5 min
 - Guascas de la huerta: 5 min
¿Se aceptó ingrediente no fresco? false
¿Se aceptó código repetido? false
Olla queda con 7 ingredientes, 4470/6000 g

--- SECCIÓN 2: Olla Trifásica ---
Olla trifásica: 5450/8000 g
El cerdo cuesta: $17600
La yuca demora: 40 min

--- SECCIÓN 3: Capacidad Olla Pequeña ---
¿Cupo la yuca en la olla pequeña? false
La olla queda en 600/1000 g

--- SECCIÓN 4: Sancochos y Fichas ---
Ficha Gallina: Sancocho de Gallina - 60 min, costo $45200, plato $9040
Ficha Trifásico: Sancocho Trifásico - 90 min, costo $80500, plato $12880
Ficha Caldo: Caldo de Papa - 25 min, costo $7900, plato $6320
¿Está completo? Gallina: true / Caldo: false
¿Es trifásico? Gallina: false / Trifásico: true

--- SECCIÓN 5: Pedidos y Ventas ---
Pedido Mesa 1: $27080
Pedido Mesa 2: $46140
Error mesa 3: Sancocho SAN-999 no está en el menú.
Mesa 3 registrada: false
Error mesa 4: Porciones insuficientes (6 disponibles, solicitadas 10).
Mesa 4 registrada: false
Pedido Mesa 5: $54240
Pedidos registrados: 3 / Porciones de gallina que quedan: 0
Ventas del día: $127460

--- SECCIÓN 6: Búsqueda y Polimorfismo ---
Buscar PRO-001: Gallina criolla (gallina)
Polimorfismo: Tuberculo $3000, Sancocho $45200, Acompanamiento $2000, Pedido $27080