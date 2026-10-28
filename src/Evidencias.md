
# Evidencias: <Tu Katherin Ortega Pertuz>

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea / Método | Mensaje del compilador | Corrección |
|---|---------|----------------|------------------------|------------|
| 1 | `Acompanamiento.java` | Getter `getPrecio` | `';' expected` | Se agregó el punto y coma `;` faltante al final de la sentencia de retorno en el getter. |
| 2 | `Acompanamiento.java` | `calcularCosto` | `method does not override or implement a method from a supertype` | Se agregó la anotación `@Override` e implementó el método de la interfaz `Costeable`. |
| 3 | `Costeable.java` | Interfaz `Costeable` | `interface abstract methods cannot have a body` | Se eliminaron las llaves `{}` del método abstracto en la interfaz. |
| 4 | `Identificable.java` | Interfaz `Identificable` | `';' expected` | Se agregó el punto y coma `;` al final de la firma del método abstracto. |
| 5 | `Ingrediente.java` | Getter `getPrecioKilo` | `incompatible types: possible lossy conversion from double to int` | Se corrigió el tipo de retorno del getter a `double` para coincidir con el atributo. |
| 6 | `Ingrediente.java` | `obtenerFicha` | `unclosed string literal` | Se agregaron las comillas dobles `"` faltantes para cerrar la cadena de texto. |
| 7 | `Ingrediente.java` | Constructor / Instanciación | `cannot find symbol / syntax error` | Se agregó la palabra reservada `new` para invocar el constructor. |
| 8 | `Proteina.java` | Constructor `super` | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | Se agregaron los tipos de datos y parámetros faltantes en la llamada al constructor `super(...)`. |
| 9 | `Proteina.java` | Atributo numérico | `incompatible types: String cannot be converted to double/int` | Se removieron las comillas a un valor numérico asignado como String. |
| 10 | `Tuberculo.java` | Cadena de texto | `unclosed character literal` | Se reemplazaron las comillas simples `' '` por comillas dobles `" "` en la definición de la cadena. |
| 11 | `Tuberculos.java` | Nombre de la clase | `class Tuberculo is public, should be declared in a file named Tuberculo.java` | Se corrigió el nombre de la clase/archivo para que coincidan exactamente (`Tuberculos.java`). |
| 12 | `Proteina.java` | Constructor `super` | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | Se completaron los 5 parámetros requeridos en `super(...)` añadiendo la variable `fresco`. |
| 13 | `Verdura.java` | `minutosCoccion` | `method does not override or implement a method from a supertype` | Se corrigió la ortografía y firma del método sobreescrito `@Override public int minutosCoccion()`. |
| 14 | `Condimento.java` | Declaración de constante | `=<expression> expected / illegal start of expression` | Se completó la sintaxis de inicialización de la constante `seAgregaAlFinal`. |
| 15 | `Condimento.java` | `minutosCoccion` | `variable minutos might not have been initialized` | Se asignó un valor inicial a la variable local `minutos` antes de su retorno. |
| 16 | `Fonda.java` | Encabezado del archivo | `cannot find symbol: class ArrayList` | Se agregó la sentencia de importación `import java.util.ArrayList;`. |
| 17 | `Sancocho.java` | `servir` | `incompatible types: unexpected return value` | Se cambió el tipo de retorno de la firma del método de `void` a `boolean`. |
| 18 | `Sancocho.java` | `calcularCosto` | `non-static method cannot be referenced from a static context` | Se cambió la llamada estática `Olla.calcularTiempoCoccion()` por la referencia de instancia `olla.calcularTiempoCoccion()`. |
| 19 | `Olla.java` | `calcularCostoIngredientes` | `cannot find symbol: variable length` | Se reemplazó la propiedad de arreglo `.length` por el método de listas `.size()`. |
| 20 | `Pedido.java` | `calcularCosto` | `cannot find symbol: variable getPrecio` | Se agregaron los paréntesis `()` para invocar el método `a.getPrecio()`. |
| 21 | `Fonda.java` | `registrarPedido` | `constructor Pedido in class Pedido cannot be applied to given types` | Se agregó el parámetro faltante `cantidad` en la instanciación `new Pedido(mesa, sancocho, cantidad)`. |
| 22 | `Fonda.java` | `mostrarMenu` | `cannot find symbol: variable system` | Se corrigió la minúscula cambiando `system.out.println` por la clase `System.out.println`. |
| 23 | `Main.java` | Instanciación | `cannot find symbol: class Tuberculo` | Se actualizó el nombre de la clase agregando la `s` final (`Tuberculos`). |
| 24 | `Main.java` | Variables de prueba | `cannot find symbol: class Tuberculo` | Se corrigió la referencia del tipo de ingrediente a `Tuberculos`. |
| 25 | `Main.java` | Sección Polimorfismo | `incompatible types: Ingrediente cannot be converted to Proteina` | Se cambió el tipo de variable a `Ingrediente` y se utilizó el método polimórfico `getCategoria()`. |


(las 25 filas)

## 2. Errores de lógica corregidos
| # | Archivo | Método / Fragmento | Regla de negocio / Comportamiento incorrecto | Corrección realizada |
|---|---------|--------------------|----------------------------------------------|----------------------|
| 1 | `Acompanamiento.java` | `calcularCosto()` | Lanzaba una excepción `UnsupportedOperationException`, provocando el colapso (*crash*) de la aplicación al calcular precios. | Se reemplazó la excepción devolviendo el precio individual del acompañamiento (`return getPrecio();`). |
| 2 | `Olla.java` | `buscarPorCodigo()` | Comparaba el código buscado contra el nombre del ingrediente (`getNombre()`), impidiendo encontrar ingredientes y permitiendo códigos duplicados. | Se corrigió la comparación para evaluar el atributo de código único: `i.getCodigo().equals(codigo)`. |
| 3 | `Olla.java` | `agregarIngrediente()` | Evaluaba únicamente el peso actual de la olla sin sumar el peso del nuevo ingrediente, permitiendo superar la capacidad máxima permitida. | Se cambió la validación a `calcularPesoTotal() + nuevo.getGramos() > capacidadGramos`. |
| 4 | `Olla.java` | `calcularTiempoCoccion()` | Evaluaba con el operador `< mayor`, por lo que nunca encontraba el tiempo máximo y el sancocho siempre reportaba `0 min` de cocción. | Se cambió el operador de comparación a `> mayor` para obtener el ingrediente con el tiempo de cocción más alto. |
| 5 | `Olla.java` | `calcularCostoIngredientes()` | El bucle iniciaba en `int i = 1`, omitiendo el costo del primer ingrediente de la lista en la suma total. | Se corrigió el índice inicial del bucle a `int i = 0` para incluir la totalidad de los ingredientes. |
| 6 | `Ingrediente.java` | `calcularCosto()` | La división entera `(gramos / 1000)` truncaba a `0` el costo de cualquier ingrediente con menos de 1000 gramos. | Se forzó la división en punto flotante utilizando `1000.0`: `(gramos / 1000.0) * precioKilo`. |
| 7 | `Sancocho.java` | `estaCompleto()` | La condición final usaba el operador `||` en lugar de `&&`, marcando sancochos completos sin importar si carecían de proteína. | Se cambiaron todos los conectivos lógicos a `&&` para exigir obligatoriamente Proteína, Tubérculo y Condimento. |
| 8 | `Sancocho.java` | `esTrifasico()` | Contaba el total global de ingredientes de la olla (`>= 3`) en lugar de contar únicamente los ingredientes de la categoría de proteínas. | Se cambió la evaluación para contar específicamente por categoría: `olla.contarPorCategoria("Proteína") >= 3`. |
| 9 | `Fonda.java` | `registrarPedido()` | Agregaba el pedido a la lista de ventas del día antes de verificar si el sancocho contaba con porciones suficientes para servirlo. | Se condicionó la adición a la lista `pedidos.add(pedido)` únicamente si `sancocho.servir(cantidad)` retorna `true`. |
| 10 | `Pedido.java` | `calcularCosto()` | Multiplicaba por la cantidad de platos únicamente el precio del sancocho, sumando los acompañamientos una sola vez en lugar de por cada plato. | Se ajustó la fórmula a `(sancocho.calcularPrecioPorcion() + sumaAcompanamientos) * cantidad`. |