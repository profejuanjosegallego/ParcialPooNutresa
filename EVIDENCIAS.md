# Evidencias: José David Valencia Martínez

## 1. Errores de sintaxis y compilación corregidos

Las correcciones se agrupan por archivo y comportamiento relacionado. No se asignan números de línea ni se transcriben mensajes originales del compilador.

| # | Archivo | Problema identificado | Corrección aplicada |
|---|---|---|---|
| 1 | `src/modelo/Acompanamiento.java` | Faltaba el punto y coma al devolver el precio; además, el método de costo no coincidía con `Costeable`. | Se completó la instrucción y se implementó `calcularCosto()`. |
| 2 | `src/modelo/Costeable.java` | El método abstracto de la interfaz tenía cuerpo. | Se dejó la declaración `double calcularCosto();`. |
| 3 | `src/modelo/Identificable.java` | La declaración de `getCodigo()` no terminaba en punto y coma. | Se completó la declaración de la interfaz. |
| 4 | `src/modelo/Ingrediente.java` | El getter de `precioKilo` declaraba `int` aunque el atributo es `double`; faltaba construir la excepción; la ficha tenía una cadena sin cerrar. | Se alineó el retorno con `double`, se agregó `new IllegalArgumentException(...)` y se cerró la cadena de la ficha. |
| 5 | `src/modelo/Condimento.java` | El constructor refería un nombre de variable inexistente y el compilador no podía garantizar la inicialización de `minutos`. | Se asignó el parámetro `seAgregaAlFinal` y se hizo exhaustiva la rama alternativa. |
| 6 | `src/modelo/Olla.java` | El recorrido usaba `length` sobre un `ArrayList`; la búsqueda no tenía retorno cuando no encontraba elemento. | Se usó `size()` en el recorrido y se agregó `return null` al final de la búsqueda. |
| 7 | `src/modelo/Pedido.java` | `getPrecio` se usaba como campo en vez de llamarse como método. | Se cambió a `getPrecio()`. |
| 8 | `src/modelo/Proteina.java` | La llamada a `super` omitía el parámetro `fresco`; el método de minutos devolvía texto en vez de un entero. | Se pasó `fresco` al constructor padre y se devolvió `60` como `int`. |
| 9 | `src/modelo/Sancocho.java` | El cálculo invocaba como estático un método de instancia de `Olla`; `servir` devolvía valores aunque estaba declarado `void`. | Se llamó al método sobre `olla` y se declaró `servir` con retorno `boolean`, acorde con sus resultados y uso. |
| 10 | `src/modelo/Tuberculo.java` | El constructor no tenía el mismo nombre que la clase y la categoría usaba comillas de carácter para un texto. | Se corrigió el nombre del constructor y se devolvió la categoría como `String`. |
| 11 | `src/modelo/Verdura.java` | La declaración de herencia estaba mal escrita y el método de cocción no coincidía con el abstracto de `Ingrediente`. | Se corrigió `extends` y se implementó `minutosCoccion()`. |
| 12 | `src/servicio/Fonda.java` | Faltaba importar `ArrayList`, la creación de `Pedido` omitía `cantidad` y `System` estaba escrito con minúscula. | Se agregó el import, se pasó la cantidad y se corrigió la mayúscula. |
| 13 | `src/Main.java` | La yuca se creaba como instancia de la clase abstracta `Ingrediente`; la búsqueda devolvía `Ingrediente` y se asignaba a `Proteina`. | Se creó la yuca como `Tuberculo` y se convirtió explícitamente el resultado de búsqueda a `Proteina`. Se conservaron los valores de los datos de prueba. |

## 2. Errores de lógica corregidos

| # | Archivo y método | Comportamiento incorrecto | Regla del negocio relacionada | Corrección aplicada |
|---|---|---|---|---|
| 1 | `Ingrediente.calcularCosto()` | La división entera truncaba los gramos antes de multiplicar el precio por kilo. | Costo = gramos / 1000 × precio por kilo. | Se usa `1000.0` para que la división conserve decimales. |
| 2 | `Tuberculo.minutosCoccion()` | Asignaba 25 minutos a tubérculos duros y 40 a blandos. | Duros: 40 min; blandos: 25 min. | Se invirtieron los resultados del operador condicional. |
| 3 | `Olla.agregarIngrediente()` | Solo comparaba el peso actual con la capacidad y no sumaba el nuevo ingrediente. | El ingrediente cabe si peso actual + peso nuevo ≤ capacidad. | La validación incluye `nuevo.getGramos()`. |
| 4 | `Olla.buscarPorCodigo()` | Comparaba el nombre del ingrediente con el código buscado. | La búsqueda se hace por código. | Se compara `getCodigo()` con el código recibido. |
| 5 | `Olla.calcularCostoIngredientes()` | Empezaba en el índice 1 y omitía el primer ingrediente. | El costo de la olla incluye todos los ingredientes. | El recorrido empieza en 0 y llega hasta `ingredientes.size()`. |
| 6 | `Olla.calcularTiempoCoccion()` | Conservaba tiempos menores, no el mayor. | El tiempo de cocción de la olla es el máximo entre sus ingredientes. | Se actualiza el máximo cuando el tiempo del ingrediente es mayor. |
| 7 | `Sancocho.estaCompleto()` | La condición permitía que bastara con tener condimento, aunque faltaran proteína o tubérculo. | Debe haber proteína, tubérculo y condimento. | Se requieren las tres categorías con condiciones unidas por `&&`. |
| 8 | `Sancocho.esTrifasico()` | Contaba todos los ingredientes, sin verificar cuántos eran proteínas. | Un sancocho trifásico tiene al menos tres proteínas. | Se cuenta la categoría `Proteína`. |
| 9 | `Pedido.calcularCosto()` | Sumaba acompañamientos una sola vez, sin multiplicarlos por la cantidad de platos. | (precio del plato + acompañamientos) × cantidad. | Se agrupan plato y acompañamientos antes de multiplicar por `cantidad`. |
| 10 | `Fonda.registrarPedido()` | Añadía el pedido a la lista antes de comprobar si había porciones suficientes. | Si no alcanzan las porciones, no se registra el pedido. | Se agrega a la lista únicamente después de que `servir(cantidad)` tenga éxito. |

## 3. Salida final del programa

La compilación de verificación se realizó en una carpeta nueva bajo `out/`, para no sobrescribir la salida compilada que ya existía.

Comandos equivalentes ejecutados:

```powershell
javac -encoding UTF-8 -d out/verification-56e57ffe209544d2a3d28e055c2cd149 src/modelo/*.java src/servicio/*.java src/Main.java
java -cp out/verification-56e57ffe209544d2a3d28e055c2cd149 Main
```

La compilación terminó sin errores y la ejecución terminó con código 0. La consola confirmó los costos y tiempos de ingredientes, las validaciones de las ollas, las fichas de los tres sancochos, los pedidos, las ventas y el polimorfismo. La salida completa observada fue:

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

## 4. Conceptos de programación orientada a objetos

- **Encapsulamiento:** `Ingrediente`, `Olla`, `Sancocho`, `Pedido` y `Fonda` guardan sus datos en atributos privados. Los getters, setters y métodos de negocio controlan el acceso; por ejemplo, `Olla.getIngredientes()` devuelve una copia de la lista.
- **Herencia:** `Proteina`, `Tuberculo`, `Verdura` y `Condimento` extienden `Ingrediente` y especializan su categoría y tiempo de cocción.
- **Abstracción mediante clases abstractas:** `Ingrediente` concentra los datos comunes y declara `minutosCoccion()` y `getCategoria()` como métodos abstractos que implementan sus subclases.
- **Interfaces:** `Identificable` declara código y ficha; la implementan `Ingrediente` y `Sancocho` (las subclases de `Ingrediente` heredan esa implementación). `Costeable` declara el cálculo de costo; la implementan `Ingrediente`, `Sancocho`, `Acompanamiento` y `Pedido`.
- **Polimorfismo:** en la sección 6 de `Main`, una lista `ArrayList<Costeable>` contiene un `Tuberculo`, un `Sancocho`, un `Acompanamiento` y un `Pedido`; el mismo llamado `calcularCosto()` ejecuta la implementación correspondiente a cada objeto.
