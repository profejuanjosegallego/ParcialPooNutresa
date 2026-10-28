# Evidencias: Estudiante de Programación Orientada a Objetos

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | Acompanamiento.java | 13 | `';' expected` | Se agregó el punto y coma faltante (`return precio;`). |
| 2 | Costeable.java | 4 | `abstract method in interface cannot have body` | Se eliminó el cuerpo por defecto y se dejó como método abstracto (`double calcularCosto();`). |
| 3 | Identificable.java | 4 | `';' expected` | Se añadió el punto y coma al final de la firma del método (`String obtenerCodigo();`). |
| 4 | Ingrediente.java | 33 | `cannot find symbol / constructor missing` | Se añadió el operador `new` al lanzar la excepción (`throw new IllegalArgumentException(...)`). |
| 5 | Ingrediente.java | 25 | `incompatible types: found double, required int` | Se ajustó el tipo de retorno del getter `getPrecioKilo()` a `double`. |
| 6 | Ingrediente.java | 65 | `unclosed string literal` | Se corrigió la concatenación y el cierre de comillas en el método `obtenerFicha()`. |
| 7 | Olla.java | 50 | `cannot find symbol: variable length` | Se reemplazó el acceso a `.length` por el método de listas `.size()`. |
| 8 | Olla.java | 51 | `IndexOutOfBoundsException potential / incorrect index` | Se corrigió el inicio del ciclo for a `0` (`int i = 0`). |
| 9 | Pedido.java | 31 | `cannot find symbol: variable getPrecio` | Se agregaron los paréntesis de invocación al método `a.getPrecio()`. |
| 10 | Proteina.java | 6 | `constructor Proteina in class Proteina cannot be applied to given types` | Se agregó el argumento booleano `fresco` faltante en la llamada a `super(...)`. |
| 11 | Proteina.java | 15 | `incompatible types: String cannot be converted to int` | Se retornó un valor entero en lugar de un texto (`return 60;`). |
| 12 | Fonda.java | 55 | `package system does not exist` | Se corrigió la minúscula inicial por mayúscula en `System.out.println`. |
| 13 | Fonda.java | 42 | `constructor Pedido in class Pedido cannot be applied to given types` | Se pasó el tercer argumento requerido `cantidad` (`new Pedido(mesa, sancocho, cantidad)`). |
| 14 | Main.java | 82 | `incompatible types: Ingrediente cannot be converted to Proteina` | Se añadió el casting explícito `(Proteina)`. |
| 15 | Main.java | 84 | `cannot find symbol: method getCodigo()` | Se actualizó al nombre correcto del método de la interfaz: `obtenerCodigo()`. |
| 16 | Olla.java | 42 | `missing return statement` | Se añadió `return null;` al final del método `buscarPorCodigo`. |
| 17 | Ingrediente.java | 38 | `incompatible types in setter validation` | Se corrigió la sintaxis de validación de excepciones en `setGramos`. |
| 18 | Acompanamiento.java | 3 | `Acompanamiento is not abstract and does not override abstract method` | Se implementó el método `@Override public double calcularCosto()`. |
| 19 | Condimento.java | 18 | `variable minutos might not have been initialized` | Se inicializó la variable local `int minutos = 0;`. |
| 20 | Identificable.java | 5 | `';' expected in interface method declaration` | Se cerró correctamente la firma del método `obtenerFicha()`. |
| 21 | Pedido.java | 11 | `constructor Pedido not applicable for 2 parameters` | Se estandarizó la firma del constructor para recibir los 3 parámetros necesarios. |
| 22 | Olla.java | 30 | `cannot find symbol: method getNombre() in check` | Se cambió a `nuevo.obtenerCodigo()` para validar la unicidad de códigos. |
| 23 | Olla.java | 35 | `logical mismatch in duplicate code check` | Se comparó utilizando `i.obtenerCodigo()` en lugar de utilizar el nombre. |
| 24 | Fonda.java | 28 | `cannot find symbol: method getCodigo()` | Se actualizó la llamada en la búsqueda a `s.obtenerCodigo()`. |
| 25 | Proteina.java | 5 | `constructor Ingrediente in class Ingrediente cannot be applied` | Se alinearon los parámetros del constructor hijo con los requeridos por la superclase. |

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
| 1 | `Olla.java` (`agregarIngrediente`) | Validaba el peso actual sin sumar el peso del ingrediente entrante al verificar capacidad. | Fila de capacidad | Se modificó la condición a `calcularPesoTotal() + nuevo.getGramos() > capacidadGramos`. |
| 2 | `Olla.java` (`calcularTiempoCoccion`) | Buscaba el menor tiempo (`< mayor`) en lugar del ingrediente más demorado. | Fila de tiempo | Se corrigió el operador de comparación a `> mayor`. |
| 3 | `Pedido.java` (`calcularCosto`) | Sumaba los acompañamientos una sola vez sin multiplicarlos por la cantidad de platos pedidos. | Fila de costos | Se agrupó la fórmula multiplicando la suma total por la cantidad: `(sancocho.calcularPrecioPorcion() + sumaAcompanamientos) * cantidad`. |
| 4 | `Fonda.java` (`registrarPedido`) | Agregaba el pedido a la lista antes de verificar si realmente alcanzaban las porciones en stock. | Fila de registro | Se movió la validación de porciones (`sancocho.servir(cantidad)`) antes de instanciar y agregar el pedido a la lista. |
| 5 | `Olla.java` (`buscarPorCodigo`) | Buscaba por nombre (`i.getNombre().equals(codigo)`) en lugar de por el código único del ingrediente. | Fila de búsqueda | Se cambió la comparación interna a `i.obtenerCodigo().equals(codigo)`. |
| 6 | `Olla.java` (`calcularCostoIngredientes`) | Omitía el primer ingrediente de la lista al iniciar el bucle en el índice `1` (`i = 1`). | Fila de inventario | Se corrigió el índice inicial del ciclo iterativo a `i = 0` para incluir todos los elementos. |
| 7 | `Acompanamiento.java` | No implementaba adecuadamente el cálculo de costos requerido por la interfaz `Costeable`. | Fila de interfaces | Se implementó el método `calcularCosto()` retornando directamente la propiedad `precio`. |
| 8 | `Condimento.java` (`minutosCoccion`) | Contenía bifurcaciones redundantes e incompletas para definir el tiempo de cocción. | Fila de tiempos | Se simplificó la asignación lógica de los minutos evaluando la bandera `seAgregaAlFinal`. |
| 9 | `Fonda.java` (`buscarSancocho`) | Consultaba el código del sancocho usando un método no sincronizado con la interfaz de identificación. | Fila de menú | Se reemplazó por la llamada correcta al método `s.obtenerCodigo()`. |
| 10 | `Main.java` (Pruebas de pedidos) | El flujo de validación de porciones generaba desajustes en las pruebas de mesas sin stock. | Fila de validación | Se aseguró que el inventario de porciones se descuente de forma segura y atómica al procesar el pedido. |

## 3. Salida final del programa
```text
=== 1. Olla del sancocho de gallina ===
No se agregó Cebolla larga: no está fresco.
¿Se aceptó un ingrediente que no está fresco? false
No se agregó Ñame: el código TUB-002 ya está en la olla.
¿Se aceptó un código repetido? false
Olla (4020/6000 g):
  - Proteína [PRO-001] Gallina criolla - 1500 g, $27000, 60 min
  - Tubérculo [TUB-001] Papa pastusa - 1000 g, $3000, 20 min
  - Tubérculo [TUB-002] Yuca - 800 g, $2800, 40 min
  - Verdura [VER-001] Mazorca - 600 g, $2400, 30 min
  - Verdura [VER-002] Plátano verde - 500 g, $2000, 30 min
  - Condimento [CON-001] Cilantro - 50 g, $1000, 5 min
  - Condimento [CON-002] Guascas - 20 g, $1000, 5 min

=== 2. Olla del sancocho trifásico ===
Olla (5200/8000 g):
  - Proteína [PRO-101] Gallina - 1000 g, $18000, 60 min
  - Proteína [PRO-102] Costilla de res - 1000 g, $26000, 90 min
  - Proteína [PRO-103] Cerdo - 800 g, $17600, 90 min
  - Tubérculo [TUB-101] Papa pastusa - 1000 g, $3000, 20 min
  - Tubérculo [TUB-102] Yuca - 1000 g, $3500, 40 min
  - Verdura [VER-101] Mazorca - 600 g, $2400, 30 min
  - Condimento [CON-101] Cilantro - 50 g, $1000, 5 min

=== 3. Olla pequeña (caldo de papa) ===
No se agregó Yuca: no cabe en la olla.
¿Cupo la yuca en la olla pequeña? false
Olla (830/1000 g):
  - Tubérculo [TUB-201] Papa criolla - 800 g, $4800, 20 min
  - Condimento [CON-201] Ajo - 30 g, $600, 20 min

=== 4. Sancochos ===
Sancocho [SAN-001] Sancocho de gallina - 8 porciones, $4925, 60 min
Sancocho [SAN-002] Sancocho trifásico - 10 porciones, $9905, 90 min
Sancocho [SAN-003] Caldo de papa - 2 porciones, $3700, 20 min
¿El de gallina está completo? true
¿El caldo de papa está completo? false
¿El de gallina es trifásico? false
¿El trifásico es trifásico? true

=== 5. Pedidos en la fonda ===
Mesa 1: 2 x Sancocho de gallina + Arroz + Aguacate = $14350
Mesa 2: 3 x Sancocho trifásico + Arroz + Ají = $30415
¿Se registró el pedido de la mesa 3? false
¿Se registró el pedido de la mesa 4? false
Mesa 5: 6 x Sancocho de gallina = $29550
Pedidos registrados: 3
Porciones de gallina que quedan: 0
Ventas del día: $74315

=== 6. Polimorfismo ===
Buscar PRO-001: Gallina criolla (gallina)
Como Identificable: SAN-002
Papa pastusa cuesta $3000
Sancocho de gallina cuesta $4925
Arroz cuesta $2000
Pedido cuesta $14350
```

## 4. Conceptos de POO en este proyecto
Explica brevemente (2-3 líneas cada uno) DÓNDE se usa en este código:
- **Encapsulamiento:** Se implementa en las clases del modelo (`Ingrediente`, `Olla`, `Pedido`, etc.) manteniendo sus atributos como privados (`private`) y controlando el acceso mediante métodos de lectura/escritura (`getters` y `setters`) que incluyen reglas de validación.
- **Herencia:** Se utiliza en la relación entre `Ingrediente` (superclase) y sus clases hijas (`Proteina`, `Tuberculo`, `Verdura`, `Condimento`), las cuales heredan atributos comunes como `codigo`, `nombre`, `gramos` y `precioKilo`.
- **Abstracción (clase abstracta):** Presente en la clase `Ingrediente`, que define los métodos abstractos `minutosCoccion()` y `getCategoria()` para obligar a que cada tipo de ingrediente especifique su propia implementación concreta.
- **Interfaz:** Se definen `Costeable` (implementada por `Ingrediente`, `Sancocho`, `Acompanamiento` y `Pedido` para unificar el método `calcularCosto()`) e `Identificable` (implementada por `Ingrediente` y `Sancocho` para estandarizar `obtenerCodigo()` y `obtenerFicha()`).
- **Polimorfismo:** Se evidencia en la sección 6 de `Main`, donde una lista de tipo `Costeable` almacena instancias de distintas clases (`Tuberculo`, `Sancocho`, `Acompanamiento`, `Pedido`) y ejecuta `calcularCosto()` obteniendo el comportamiento específico de cada objeto.