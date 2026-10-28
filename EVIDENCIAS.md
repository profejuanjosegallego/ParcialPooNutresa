# Evidencias: <tu nombre completo>

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | `modelo/Acompanamiento.java` | 14 | `';' expected` | Faltaba el `;` después de `return precio` en `getPrecio()`. |
| 2 | `modelo/Identificable.java` | 4 | `'{' or ';' expected` | Faltaba el `;` al final de `String getCodigo()`. |
| 3 | `modelo/Ingrediente.java` | 67 | `unclosed string literal` | Faltaba cerrar la comilla en `" g, $"` dentro de `obtenerFicha()`. |
| 4 | `modelo/Tuberculo.java` | 6 | `invalid method declaration; return type required` | El constructor se llamaba `Tuberculos`; se renombró a `Tuberculo` (igual que la clase). |
| 5 | `modelo/Tuberculo.java` | 22 | `unclosed character literal` | `'Tubérculo'` usaba comillas simples; se cambió a `"Tubérculo"` (un `String` va con `"`). |
| 6 | `modelo/Verdura.java` | 3 | `'{' expected` | Decía `extend`; la palabra correcta es `extends`. |
| 7 | `modelo/Costeable.java` | 5 | `interface abstract methods cannot have body` | Se quitó el cuerpo `{ return 0; }`: queda `double calcularCosto();`. |
| 8 | `modelo/Acompanamiento.java` | 4 / 16 | `Acompanamiento is not abstract and does not override abstract method calcularCosto() in Costeable` | El método se llamaba `calcularPrecio()`; se renombró a `calcularCosto()` para implementar la interfaz `Costeable`. |
| 9 | `modelo/Condimento.java` | 9 | `cannot find symbol` (variable `alFinal`) | El parámetro se llama `seAgregaAlFinal`: `this.seAgregaAlFinal = seAgregaAlFinal;`. |
| 10 | `modelo/Condimento.java` | 23 | `variable minutos might not have been initialized` | El `else if (!seAgregaAlFinal)` se cambió por `else`, así `minutos` siempre recibe valor. |
| 11 | `modelo/Ingrediente.java` | 25 | `incompatible types: possible lossy conversion from double to int` | `getPrecioKilo()` devolvía `int` siendo `precioKilo` un `double`; el tipo de retorno pasa a `double` (sin tocar el atributo). |
| 12 | `modelo/Ingrediente.java` | 37 | `cannot find symbol` (method `IllegalArgumentException`) | Faltaba `new`: `throw new IllegalArgumentException(...)`. |
| 13 | `modelo/Olla.java` | 51 | `missing return statement` | `buscarPorCodigo()` no retornaba nada si no lo encontraba; se agregó `return null;` al final (como dice su comentario). |
| 14 | `modelo/Olla.java` | 64 | `cannot find symbol` (variable `length`) | Un `ArrayList` no tiene `length`; se usa `ingredientes.size()`. |
| 15 | `modelo/Pedido.java` | 33 | `cannot find symbol` (variable `getPrecio`) | Faltaban los paréntesis de la llamada: `a.getPrecio()`. |
| 16 | `modelo/Proteina.java` | 8 | `constructor Ingrediente in class Ingrediente cannot be applied to given types` | A `super(...)` le faltaba el argumento `fresco`. |
| 17 | `modelo/Proteina.java` | 18 | `incompatible types: String cannot be converted to int` | Retornaba `"60"` (texto); se cambió a `60` (número). |
| 18 | `modelo/Sancocho.java` | 34 | `non-static method calcularTiempoCoccion() cannot be referenced from a static context` | Se llamaba con la clase `Olla.`; se cambió al objeto `olla.calcularTiempoCoccion()`. |
| 19 | `modelo/Sancocho.java` | 55 (57, 60) | `incompatible types: unexpected return value` (y en `Fonda.java:47`: `'void' type not allowed here`) | `servir(int)` estaba declarado `void` pero retorna `true/false` y `Fonda` usa su resultado; se cambió a `public boolean servir(int cantidad)`. |
| 20 | `modelo/Verdura.java` | 10 / 11 | `method does not override or implement a method from a supertype` (y `Verdura is not abstract and does not override abstract method minutosCoccion()`) | El método se llamaba `minutosDeCoccion()`; se renombró a `minutosCoccion()`, como en `Ingrediente`. |
| 21 | `servicio/Fonda.java` | 8, 9, 13, 14 | `cannot find symbol` (class `ArrayList`) | Faltaba `import java.util.ArrayList;`. |
| 22 | `servicio/Fonda.java` | 45 | `constructor Pedido in class Pedido cannot be applied to given types` | A `new Pedido(mesa, sancocho)` le faltaba `cantidad`: `new Pedido(mesa, sancocho, cantidad)`. |
| 23 | `servicio/Fonda.java` | 65 | `package system does not exist` | Java distingue mayúsculas: `system.out` → `System.out`. |
| 24 | `Main.java` | 23 | `Ingrediente is abstract; cannot be instantiated` | No se puede hacer `new` de la clase abstracta; se usa la hija: `new Tuberculo(...)`. |
| 25 | `Main.java` | 108 | `incompatible types: Ingrediente cannot be converted to Proteina` | `buscarPorCodigo()` retorna `Ingrediente`; se hizo el cast `(Proteina) ollaGallina.buscarPorCodigo("PRO-001")`. |

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
| 1 | ... | ... | ... | ... |

## 3. Salida final del programa
(pega aquí la salida completa de `java -cp out Main`, o una captura)

## 4. Conceptos de POO en este proyecto
- **Encapsulamiento:**
- **Herencia:**
- **Abstracción (clase abstracta):**
- **Interfaz:**
- **Polimorfismo:**
