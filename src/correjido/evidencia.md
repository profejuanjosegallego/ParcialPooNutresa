# Evidencias: [Carlos Duvan Tique Marin]

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---|---|---|---|
| 1 | Ingrediente.java | ~25 | Incompatible types: int cannot be converted to double | Se cambió el tipo de retorno de `getPrecioKilo()` de `int` a `double`. |
| 2 | Ingrediente.java | ~38 | ';' expected / non-static method cannot be referenced | Se agregó la palabra clave `new` antes de instanciar `IllegalArgumentException`. |
| 3 | Ingrediente.java | ~78 | Unclosed string literal | Se cerraron correctamente las comillas dobles antes del salto de línea en `obtenerFicha()`. |
| 4 | Olla.java | ~52 | Missing return statement | Se añadió un `return null;` al final del método `buscarPorCodigo()`. |
| 5 | Olla.java | ~67 | Cannot find symbol (variable length for ArrayList) | Se reemplazó `.length` por `.size()` para recorrer el `ArrayList`. |
| 6 | Pedido.java | ~31 | Operator '+' cannot be applied to method | Se agregaron los paréntesis faltantes en la llamada `a.getPrecio()`. |
| 7 | Proteina.java | ~7 | constructor Ingrediente in class Ingrediente cannot be applied to given types | Se añadió el argumento `fresco` faltante al invocar `super(...)`. |
| 8 | Proteina.java | ~15 | Incompatible types: String cannot be converted to int | Se retornó el entero `60` en lugar de la cadena `"60"` en `minutosCoccion()`. |
| 9 | Sancocho.java | ~28 | Non-static method cannot be referenced from a static context | Se cambió la llamada estática `Olla.calcularTiempoCoccion()` por la instancia `olla.calcularTiempoCoccion()`. |
| 10 | Sancocho.java | ~47 | Invalid method return type | Se cambió el tipo de retorno de `servir()` de `void` a `boolean`. |
| 11 | Tuberculo.java | ~6 | Invalid constructor declaration | Se corrigió el nombre del constructor de `Tuberculos` a `Tuberculo`. |
| 12 | Verdura.java | ~3 | Extends keyword spelling / syntax error | Se corrigió `extend` por `extends` y el método `minutosDeCoccion()` a `minutosCoccion()`. |
| 13 | Fonda.java | ~2 | Package/import missing | Se añadió `import java.util.ArrayList;`. |
| 14 | Fonda.java | ~42 | Constructor Pedido in class Pedido cannot be applied | Se agregaron los 3 argumentos requeridos (`mesa`, `sancocho`, `cantidad`) al instanciar `Pedido`. |
| 15 | Fonda.java | ~60 | Cannot find symbol (system.out) | Se corrigió la minúscula de `system` a `System`. |
| 16 | Main.java | ~18 | Abstract class cannot be instantiated | Se cambió `new Ingrediente(...)` por `new Tuberculo(...)` para la yuca. |
| 17 | Main.java | ~24 | Incompatible types: Ingrediente cannot be converted to Proteina | Se añadió el cast explícito `(Proteina)` al recibir el resultado de `buscarPorCodigo()`. |

# Evidencias: [Carlos Duvan Tique Marin]

## 2. Lógica y Reglas de Negocio corregidas
| # | Archivo | Regla / Validación | Ajuste Lógico Implementado |
|---|---|---|---|
| 1 | Acompanamiento.java | Integridad de datos | Se añadieron validaciones en el constructor para impedir nombres vacíos y precios negativos (`precio < 0`). |
| 2 | Condimento.java | Tiempos de cocción y herencia | Se consolidó la herencia de `Ingrediente` y la lógica de tiempos de cocción diferenciados (5 o 20 minutos). |
| 3 | Costeable.java | Contrato de interfaz | Se verificó el contrato base para unificar el cálculo de costos en el sistema. |
| 4 | Identificable.java | Contrato de interfaz | Se validó la interfaz para la identificación unívoca y la generación de fichas técnicas. |
| 5 | Ingrediente.java | Corrección matemática | Se corrigió la división entera en `calcularCosto()` usando `1000.0` y se blindaron las restricciones de gramos y precios. |
| 6 | Olla.java | Algoritmos de control e inventario | Se ajustó `buscarPorCodigo` para comparar el atributo único, se corrigió el ciclo de costos (desde índice 0) y se ajustó el tiempo máximo de cocción junto con la validación de capacidad. |