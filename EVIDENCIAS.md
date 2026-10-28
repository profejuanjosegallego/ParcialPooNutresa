# Evidencias: Diogenes Zambrano

## 1. Errores de sintaxis corregidos

> Nota: los archivos que entregué ya compilaban parcialmente (los `UnsupportedOperationException` los generó el IDE con "quick fix"). Aquí van los problemas de compilación que se resolvieron en esa fase; las líneas son las de los archivos tal como estaban antes de la corrección final.

| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | Costeable.java | 6 | `minutosDeCoccion()` no pertenece a la interfaz (el diagrama solo define `calcularCosto()`); obligaba a todas las clases a implementarlo | Eliminé el método agregado a la interfaz; queda solo `calcularCosto()` |
| 2 | Acompanamiento.java | 16 | `Acompanamiento is not abstract and does not override abstract method calcularCosto()` | Renombré `calcularPrecio()` a `calcularCosto()` con `@Override` y `return precio;` |
| 3 | Acompanamiento.java | 21-31 | Método `minutosDeCoccion()` con `UnsupportedOperationException` (stub del IDE) | Eliminé el stub y dejé `calcularCosto()` retornando el precio |
| 4 | Verdura.java | 11 | `method does not override or implement a method from a supertype` (`minutosDeCoccion` en vez de `minutosCoccion`) | Renombré el método a `minutosCoccion()` que sí es el abstracto de `Ingrediente` |
| 5 | Verdura.java | 22-26 | Stub del IDE para `minutosCoccion()` que lanzaba excepción | Eliminé el stub duplicado |
| 6 | Condimento.java | 36-40 | Stub `minutosDeCoccion()` con `@Override` sin padre | Eliminé el stub |
| 7 | Proteina.java | 28-32 | Stub `minutosDeCoccion()` con `@Override` sin padre | Eliminé el stub |
| 8 | Tuberculo.java | 25-29 | Stub `minutosDeCoccion()` con `@Override` sin padre | Eliminé el stub |
| 9 | Pedido.java | 52-56 | Stub `minutosDeCoccion()` con `@Override` sin padre | Eliminé el stub |
| 10 | Sancocho.java | 83-87 | Stub `minutosDeCoccion()` con `@Override` sin padre | Eliminé el stub |
| 11 | Condimento.java | 20-27 | Estructura `if / else if` innecesaria (variable local inicializada en 0) | Simplifiqué a `if (seAgregaAlFinal) return 5; return 20;` |
| 12 | Ingrediente.java | 63-69 | `@Override` mal indentado/llave final desordenada | Reformateé `obtenerFicha()` y la llave de cierre |
| 13-25 | (completar) | | | Completa aquí las demás filas con los errores de sintaxis que corregiste tú al compilar por primera vez (`;`, comillas, constructores, `cannot find symbol`, etc.), para llegar a las 25 |

## 2. Errores de lógica corregidos

| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
| 1 | Ingrediente.calcularCosto | `gramos / 1000` es división entera: 800 g daba 0 kg y la yuca costaba $0 | Sección 1, costos: `$27000, $3000, $2800...` | `gramos / 1000.0 * precioKilo` |
| 2 | Tuberculo.minutosCoccion | Estaba invertido: duro 25 y blando 40 | Sección 1, minutos: yuca `40`, papa `25` | `return duro ? 40 : 25;` |
| 3 | Olla.agregarIngrediente | Solo comparaba el peso actual con la capacidad, sin sumar el ingrediente nuevo | Sección 3: `¿Cupo la yuca?` = `false`, `830/1000 g` | `calcularPesoTotal() + nuevo.getGramos() > capacidadGramos` |
| 4 | Olla.buscarPorCodigo | Comparaba el **nombre** con el código, por eso nunca encontraba duplicados | Sección 1: código repetido `false`, `4470/6000 g` | `i.getCodigo().equals(codigo)` |
| 5 | Olla.calcularTiempoCoccion | Usaba `<`, así que devolvía 0 (el menor) en lugar del mayor | Sección 4: `60 min`, `90 min`, `25 min` | Cambié a `i.minutosCoccion() > mayor` |
| 6 | Sancocho.estaCompleto | Mezclaba `&&` con `||`: bastaba tener un condimento | Sección 4: caldo de papa `false` | Los tres conteos unidos con `&&` |
| 7 | Sancocho.esTrifasico | Contaba todos los ingredientes y no solo las proteínas | Sección 4: gallina `false` / trifásico `true` | `olla.contarPorCategoria("Proteína") >= 3` |
| 8 | Pedido.calcularCosto | Multiplicaba solo el plato por la cantidad; los acompañamientos se sumaban una vez | Sección 5: mesa 1 `$27080`, mesa 2 `$46140` | `(precioPlato + sumaAcompanamientos) * cantidad` |
| 9 | Fonda.registrarPedido | Guardaba el pedido **antes** de verificar las porciones, quedaba registrado aunque fallara | Sección 5: `Pedidos registrados: 3`, ventas `$127460` | Primero `servir(cantidad)`; solo si alcanza se crea y guarda el `Pedido` |
| 10 | (completar) | Revisé los 6 archivos indicados por el README y con las 9 correcciones anteriores toda la salida coincide con la tabla; si tu versión original tenía un décimo error, anótalo aquí | | |

## 3. Salida final del programa

```text
=== 1. Olla del sancocho de gallina ===
No se agregó Cebolla larga: no está fresco.
¿Se aceptó un ingrediente que no está fresco? false
No se agregó Ñame: el código TUB-002 ya está en la olla.
¿Se aceptó un código repetido? false
Olla (4470/6000 g):
  - Proteína [PRO-001] Gallina criolla - 1500 g, $ 27000, 60 min
  - Tubérculo [TUB-001] Papa pastusa - 1000 g, $ 3000, 25 min
  - Tubérculo [TUB-002] Yuca - 800 g, $ 2800, 40 min
  - Verdura [VER-001] Mazorca - 600 g, $ 2400, 30 min
  - Verdura [VER-002] Plátano verde - 500 g, $ 2000, 30 min
  - Condimento [CON-001] Cilantro - 50 g, $ 1000, 5 min
  - Condimento [CON-002] Guascas - 20 g, $ 1000, 5 min

=== 2. Olla del sancocho trifásico ===
Olla (5450/8000 g):
  - Proteína [PRO-101] Gallina - 1000 g, $ 18000, 60 min
  - Proteína [PRO-102] Costilla de res - 1000 g, $ 26000, 90 min
  - Proteína [PRO-103] Cerdo - 800 g, $ 17600, 90 min
  - Tubérculo [TUB-101] Papa pastusa - 1000 g, $ 3000, 25 min
  - Tubérculo [TUB-102] Yuca - 1000 g, $ 3500, 40 min
  - Verdura [VER-101] Mazorca - 600 g, $ 2400, 30 min
  - Condimento [CON-101] Cilantro - 50 g, $ 1000, 5 min

=== 3. Olla pequeña (caldo de papa) ===
No se agregó Yuca: no cabe en la olla.
¿Cupo la yuca en la olla pequeña? false
Olla (830/1000 g):
  - Tubérculo [TUB-201] Papa criolla - 800 g, $ 4800, 25 min
  - Condimento [CON-201] Ajo - 30 g, $ 600, 20 min

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
Buscar PRO-001: Gallina criolla (Proteína)
Como Identificable: SAN-002
Tuberculo cuesta $3000
Sancocho cuesta $45200
Acompanamiento cuesta $2000
Pedido cuesta $27080
```

> Observación: la tabla del README espera `Buscar PRO-001: Gallina criolla (gallina)`, pero `Main` imprime `getCategoria()`, que según las reglas es `"Proteína"` (y `contarPorCategoria` depende de ese valor). Como `Main` no se puede modificar, dejé `getCategoria()` sin cambios.

## 4. Conceptos de POO en este proyecto

- **Encapsulamiento:** Los atributos son `private` (por ejemplo `codigo`, `gramos`, `precioKilo` en `Ingrediente`) y se acceden con getters/setters. Los setters validan los datos (gramos > 0, nombre no vacío). `Olla.getIngredientes()` retorna una copia para proteger la lista interna.
- **Herencia:** `Proteina`, `Tuberculo`, `Verdura` y `Condimento` extienden `Ingrediente` y reutilizan código, nombre, gramos, precio y fresco mediante `super(...)`, agregando solo lo propio (`tipo`, `duro`, `seAgregaAlFinal`).
- **Abstracción (clase abstracta):** `Ingrediente` es abstracta y declara `minutosCoccion()` y `getCategoria()` sin implementación; cada hijo define su propia regla. No se puede hacer `new Ingrediente(...)`.
- **Interfaz:** `Identificable` (`getCodigo`, `obtenerFicha`) la implementan `Ingrediente` (y por herencia sus 4 hijos) y `Sancocho`. `Costeable` (`calcularCosto`) la implementan `Ingrediente` (y sus hijos), `Acompanamiento`, `Sancocho` y `Pedido`.
- **Polimorfismo:** En la sección 6 de `Main`, un `ArrayList<Costeable>` guarda un `Tuberculo`, un `Sancocho`, un `Acompanamiento` y un `Pedido`; al llamar `c.calcularCosto()` cada objeto ejecuta su propia versión. También `Ingrediente buscada` y `Identificable conCodigo = trifasico` usan referencias del tipo padre/interfaz.