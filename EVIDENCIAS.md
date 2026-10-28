# Tabla de Evidencias - Proyecto Sancocho

## 1. Tabla de evidencias: sintaxis (25)

| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---|---|---|---|
| 1 | Acompanamiento.java | 14 | ';' expected | Faltaba `;` en `return precio`. |
| 2 | Acompanamiento.java | ~16 | is not abstract and does not override abstract method calcularCosto() | El método se llamaba `calcularPrecio()`. Se renombró a `calcularCosto()` con `@Override`. |
| 3 | Condimento.java | ~9 | cannot find symbol: alFinal | La variable no existía. Se usó el parámetro `seAgregaAlFinal`. |
| 4 | Condimento.java | ~19 | variable minutos might not have been initialized | El `else if` dejaba un camino sin valor. Se cambió por un `else`. |
| 5 | Costeable.java | 5 | interface abstract methods cannot have body | Se quitó el cuerpo: `double calcularCosto();`. |
| 6 | Identificable.java | 4 | ';' expected | Faltaba `;` en `String getCodigo()`. |
| 7 | Ingrediente.java | ~25 | incompatible types: possible lossy conversion from double to int | `getPrecioKilo()` devolvía `int`. Se cambió a `double`. |
| 8 | Ingrediente.java | ~37 | cannot find symbol: method IllegalArgumentException | Faltaba `new` en el `throw`. |
| 9 | Ingrediente.java | 67 | unclosed string literal | Faltaba cerrar la comilla en `" g, $"`. |
| 10 | Olla.java | ~58 | missing return statement | `buscarPorCodigo` no retornaba nada si no encontraba. Se agregó `return null;`. |
| 11 | Olla.java | ~75 | cannot find symbol: variable length | `ArrayList` usa `.size()`, no `.length`. |
| 12 | Pedido.java | ~34 | cannot find symbol: variable getPrecio | Faltaban los paréntesis: `a.getPrecio()`. |
| 13 | Proteina.java | 7 | constructor Ingrediente cannot be applied to given types | Faltaba el argumento `fresco` en `super(...)`. |
| 14 | Proteina.java | ~16 | incompatible types: String cannot be converted to int | `return "60"` pasó a `return 60`. |
| 15 | Sancocho.java | ~33 | non-static method calcularTiempoCoccion() cannot be referenced from a static context | Se llamaba con la clase `Olla`; se usó el objeto `olla`. |
| 16 | Sancocho.java | ~54 | incompatible types: unexpected return value | `servir` era `void` pero retornaba `boolean`. Se cambió a `boolean`. |
| 17 | Tuberculo.java | 6 | invalid method declaration; return type required | El constructor `Tuberculos` pasó a `Tuberculo`. |
| 18 | Tuberculo.java | 22 | unclosed character literal | Comillas simples en un String; quedó `"Tubérculo"`. |
| 19 | Verdura.java | 3 | '{' expected | `extend` pasó a `extends`. |
| 20 | Verdura.java | ~9 | method does not override or implement a method from a supertype | `minutosDeCoccion` pasó a `minutosCoccion`. |
| 21 | Fonda.java | 5 | cannot find symbol: class ArrayList | Faltaba `import java.util.ArrayList;`. |
| 22 | Fonda.java | ~35 | constructor Pedido cannot be applied to given types | Se llamaba con 2 argumentos; se agregó `cantidad`. |
| 23 | Fonda.java | ~60 | package system does not exist | `system.out` pasó a `System.out`. |
| 24 | Main.java | 23 | Ingrediente is abstract; cannot be instantiated | `new Ingrediente(...)` pasó a `new Tuberculo(...)`. |
| 25 | Main.java | ~108 | incompatible types: Ingrediente cannot be converted to Proteina | Se agregó el cast `(Proteina)`. |

---

## 2. Tabla de evidencias: lógica (10)

| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|---|---|---|---|
| 1 | Ingrediente.calcularCosto() | `gramos / 1000` es división entera: 1500 g daba 1, no 1,5 | S1: costos ($27000, $2800...) | `gramos / 1000.0 * precioKilo` |
| 2 | Tuberculo.minutosCoccion() | Duro y blando estaban invertidos | S1/S2: minutos (papa 25, yuca 40) | `duro ? 40 : 25` |
| 3 | Olla.buscarPorCodigo() | Comparaba el código contra el nombre | S1: código repetido y S6: buscar PRO-001 | `i.getCodigo().equals(codigo)` |
| 4 | Olla.agregarIngrediente() | No sumaba el peso del nuevo al verificar capacidad | S3: yuca no debe caber (830/1000) | `calcularPesoTotal() + nuevo.getGramos() > capacidadGramos` |
| 5 | Olla.calcularCostoIngredientes() | El ciclo empezaba en 1 y se saltaba el primer ingrediente | S4: costo $45200 | `for (int i = 0; ...)` |
| 6 | Olla.calcularTiempoCoccion() | Usaba `<`, devolvía 0 (nunca el mayor) | S4: “0 min” | Se cambió a `>` |
| 7 | Sancocho.estaCompleto() | `&&` ... `||` dejaba pasar sancochos sin proteína o tubérculo si tenían condimento | S4: completo true/false | Las tres condiciones unidas con `&&` |
| 8 | Sancocho.esTrifasico() | Contaba todos los ingredientes, no las proteínas | S4: trifásico false/true | `contarPorCategoria("Proteína") >= 3` |
| 9 | Pedido.calcularCosto() | Los acompañamientos se sumaban una sola vez, no por plato | S5: mesa 1 $27080, mesa 2 $46140 | `(precioPlato + acompañamientos) * cantidad` |
| 10 | Fonda.registrarPedido() | Guardaba el pedido antes de validar las porciones, así quedaban pedidos rechazados | S5: pedidos registrados 3, ventas $127460 | Se llama a `servir()` primero y se agrega a pedidos solo si tuvo éxito |
## 3. Salida final del programa
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
## 4. Conceptos de POO en este proyecto

- **Encapsulamiento:** Se aplica en los atributos privados (`private`) de clases como `Ingrediente` y `Olla`, protegiendo los datos y accediendo a ellos mediante métodos `get` y `set`.
- **Herencia:** Se observa en las clases `Proteina`, `Tuberculo`, `Verdura` y `Condimento`, las cuales extienden (`extends`) de la clase padre abstracta `Ingrediente`.
- **Abstracción (clase abstracta):** La clase `Ingrediente` agrupa atributos y métodos comunes para todos los ingredientes sin permitir que se creen objetos directamente de ella.
- **Interfaz:** Se utiliza con `Identificable` y `Costeable`, obligando a las clases que las implementan a definir comportamientos específicos como el cálculo de costos o la identificación.
- **Polimorfismo:** Se evidencia en colecciones como las de la `Olla` o en la sección 6 del `Main`, donde se procesan diferentes tipos de ingredientes o elementos costeables de manera genérica ejecutando su lógica propia.


