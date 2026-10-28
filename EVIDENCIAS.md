# Evidencias: Julian Obando

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea aproximada | Mensaje del compilador | Corrección |
|---|---------|------------------|------------------------|------------|
| 1 | modelo/Acompanamiento.java | 14 | `';' expected` | Se cerró correctamente el getter con punto y coma. |
| 2 | modelo/Costeable.java | 3 | Interface abstract methods cannot have body | Se dejó el método de la interfaz sin implementación. |
| 3 | modelo/Acompanamiento.java | 17 | Method does not override | Se implementó `calcularCosto()`. |
| 4 | modelo/Identificable.java | 4 | `';' expected` | Se agregó el punto y coma al método abstracto. |
| 5 | modelo/Ingrediente.java | 67 | Unclosed string literal | Se cerró correctamente la cadena de `obtenerFicha()`. |
| 6 | modelo/Ingrediente.java | 23 | Possible lossy conversion | El getter de `precioKilo` pasó a `double`. |
| 7 | modelo/Ingrediente.java | 37 | Cannot find symbol | Se agregó `new` al lanzar `IllegalArgumentException`. |
| 8 | modelo/Proteina.java | 8 | Constructor cannot be applied | Se envió `fresco` al constructor padre. |
| 9 | modelo/Proteina.java | 18 | String cannot be converted to int | Se retornó el entero `60`. |
| 10 | modelo/Tuberculo.java | 6 | Invalid method declaration | El constructor pasó a llamarse `Tuberculo`. |
| 11 | modelo/Tuberculo.java | 22 | Unclosed character literal | Se usaron comillas dobles para el texto. |
| 12 | modelo/Verdura.java | 3 | `{` expected | Se cambió `extend` por `extends`. |
| 13 | modelo/Verdura.java | 10 | Method does not override | Se usó el nombre correcto `minutosCoccion()`. |
| 14 | modelo/Condimento.java | 9 | Cannot find symbol | Se asignó el parámetro `seAgregaAlFinal`. |
| 15 | modelo/Condimento.java | 17 | Variable might not have been initialized | Se retornó directamente un operador ternario. |
| 16 | modelo/Olla.java | 44 | Missing return statement | Se agregó `return null`. |
| 17 | modelo/Olla.java | 64 | Cannot find symbol length | Se reemplazó por `size()`. |
| 18 | modelo/Sancocho.java | 34 | Non-static method in static context | Se llamó a `olla.calcularTiempoCoccion()`. |
| 19 | modelo/Sancocho.java | 57 | Unexpected return value | `servir()` pasó a retornar `boolean`. |
| 20 | modelo/Pedido.java | 33 | Cannot find symbol | Se llamó correctamente a `getPrecio()`. |
| 21 | servicio/Fonda.java | 3 | Cannot find symbol ArrayList | Se agregó la importación correspondiente. |
| 22 | servicio/Fonda.java | 45 | Constructor cannot be applied | Se creó `Pedido` con sus tres parámetros. |
| 23 | servicio/Fonda.java | 65 | Package system does not exist | Se corrigió `system` por `System`. |
| 24 | Main.java | 23 | Ingrediente is abstract | Se instanció `Tuberculo`. |
| 25 | modelo/Olla.java | 44 | Incompatible types | Se tipó la búsqueda como un ingrediente genérico compatible. |

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista | Cómo se corrigió |
|---|------------------|---------------|-------|------------------|
| 1 | Ingrediente.calcularCosto() | Dividía como enteros. | Costo de gallina distinto de $27000. | Se dividió por `1000.0`. |
| 2 | Tuberculo.minutosCoccion() | Invertía los tiempos. | Papa debía tardar 25 y yuca 40 minutos. | Duro retorna 40, blando retorna 25. |
| 3 | Olla.agregarIngrediente() | Revisaba solo el peso actual. | La yuca extra no debía caber. | Se sumó el peso nuevo antes de comparar la capacidad. |
| 4 | Olla.buscarPorCodigo() | Buscaba por nombre. | El código repetido debía rechazarse. | Se comparó contra `getCodigo()`. |
| 5 | Olla.calcularCostoIngredientes() | No sumaba el primer elemento. | Costos de ingredientes incompletos. | Se recorrió desde el índice 0 con `size()`. |
| 6 | Olla.calcularTiempoCoccion() | Seleccionaba el mínimo. | Los tiempos esperados eran máximos. | Se conservó el mayor tiempo encontrado. |
| 7 | Sancocho.calcularCosto() | Llamaba estáticamente al tiempo. | El costo gas era incorrecto. | Se llamó mediante la instancia `olla`. |
| 8 | Sancocho.estaCompleto() y esTrifasico() | Usaba OR y contaba el total de ingredientes. | Caldo debía estar incompleto y trifásico solo con tres proteínas. | Se usaron tres categorías para completo y conteo de proteína para trifásico. |
| 9 | Sancocho.servir() | El tipo no permitía informar el resultado. | Los pedidos excedidos debían rechazarse. | Se implementó `boolean` y se descontó solo cuando alcanza el cupo. |
| 10 | Pedido.calcularCosto() y Fonda.registrarPedido() | Los acompañamientos y la validación se calculaban incorrectamente. | Ventas y pedidos esperados eran distintos. | Se multiplicó plato más acompañamientos por cantidad; registro validado antes de agregarlo. |

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
- **Encapsulamiento:** los atributos se mantienen privados y se exponen mediante getters o métodos que controlan cambios, como `servir()`, `agregarIngrediente()` y `agregarAcompanamiento()`.
- **Herencia:** Proteina, Tuberculo, Verdura y Condimento heredan de la clase abstracta Ingrediente.
- **Abstracción:** Ingrediente define el comportamiento común y declara `minutosCoccion()` y `getCategoria()` para que cada tipo los implemente según su cocción.
- **Interfaces:** Identificable la implementan Ingrediente y Sancocho; Costeable la implementan Ingrediente, Acompanamiento, Sancocho y Pedido.
- **Polimorfismo:** `ArrayList<Costeable>` almacena objetos de clases distintas y cada llamada a `calcularCosto()` ejecuta su implementación específica.
