# Evidencias: <José Manuel Botero Giraldo>

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | Identificable.java | 4 | `';' expected` | Añadí ; |
| 2 | Acompanamiento.java | 14 | `';' expected` | Añadí ; |
| 3 | Ingrediente.java | 67 | `unclosed string literal` | Añadi " |
| 4 | Verdura.java | 3 | `'{' expected` | Añadí "s" a extends |
| 5 | Tuberculo.java | 6 | `invalid method declaration; return type required` | Elimine "s" exdente.|
| 6 | Tuberculo.java | 22 | `unclosed character literal` | Remplace ` por " |
| 7 | Fonda.java | 8 | `cannot find symbol: class ArrayList` | import java.util.ArrayList; con la ayuda dinamica |
| 8 | Olla.java | 64 | `cannot find symbol: variable length` | Se remplaza length a size |
| 9 | Ingrediente.java | 25 | `incompatible types: possible lossy conversion from double to int` | public int a double |
| 10 | Ingrediente.java | 37 | `cannot find symbol: method IllegalArgumentException(String)` | se agrega "new"|
| 11 | Costeable.java | 5 | `interface abstract methods cannot have body` | Quité el cuerpo: "double calcularCosto();" |
| 12 | Acompanamiento.java | 4/16 | `is not abstract and does not override abstract method calcularCosto() in Costeable` | Renombré `"calcularPrecio()" a "calcularCosto()" |
| 13 | Sancocho.java | 34 | `non-static method calcularTiempoCoccion() cannot be referenced from a static context` | Se corrije mayuscula |
| 14 | Sancocho.java | 55–60 (y Fonda.java 47) | `incompatible types: unexpected return value` / `'void' type not allowed here` | "servir" se cambia a bolean |
| 15 | Proteina.java | 8 | `constructor Ingrediente ... cannot be applied to given types` | Se agrego "fresco" a lista |
| 16 | Proteina.java | 18 | `incompatible types: String cannot be converted to int` | Se quitan "" es int |
| 17 | Pedido.java | 33 | `cannot find symbol: variable getPrecio` | Se agregan () |
| 18 | Verdura.java | 3 y 10 | `is not abstract and does not override abstract method minutosCoccion()` / `method does not override or implement a method from a supertype` | El método se llamaba "minutosDeCoccion" lo renombré a "minutosCoccion" |
| 19 | Condimento.java | 9 | `cannot find symbol: variable alFinal` | Se corrije parametro "seAgregaAlFinal" |
| 20 | Main.java | 23 | `Ingrediente is abstract; cannot be instantiated` | "new Ingrediente(...)" a "new Tuberculo(...)" |
| 21 | Main.java | 108 | `incompatible types: Ingrediente cannot be converted to Proteina` | Se agrega "Proteina" |
| 22 | Fonda.java | 47 | `constructor Pedido ... cannot be applied to given types` | se agrega "cantidad" |
| 23 | Fonda.java | 65 | `package system does not exist` | "system.out" → "System.out" |
| 24 | Condimento.java | 18–23 | `variable minutos might not have been initialized` | Cambié "else if (!seAgregaAlFinal)" por "else" |
| 25 | Olla.java | 45–51 | `missing return statement` | Agregué "return null;" al final de "buscarPorCodigo" |

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
| 1 | Ingrediente.calcularCosto | gramos - 1000 es división entera: 600 g daban 0 y casi todos los ingredientes costaban $0 | Fichas con $0; la gallina de 1500 g costaba $18000 en vez de $27000 | gramos - 1000.0 * precioKilo |
| 2 | Olla.agregarIngrediente | Revisaba el peso actual y no sumaba el del ingrediente nuevo, así que la olla se pasaba de la capacidad | Olla pequeña 1130/1000 g y «¿Cupo la yuca? true» | calcularPesoTotal() + nuevo.getGramos() > capacidadGramos |
| 3 | Olla.buscarPorCodigo | Comparaba el **nombre** con el código, por eso nunca encontraba nada (tampoco detectaba códigos repetidos) | «¿Se aceptó un código repetido? true» y «Buscar PRO-001: no encontrado» | i.getCodigo().equals(codigo) |
| 4 | Olla.calcularCostoIngredientes | El for empezaba en i = 1 y se saltaba el primer ingrediente | Costo del sancocho menor al real | Empezar en i = 0 |
| 5 | Olla.calcularTiempoCoccion | Usaba <, devolvía el menor (siempre 0) en vez del mayor | Fichas de sancocho con 0 min | Cambié a i.minutosCoccion() > mayor |
| 6 | Tuberculo.minutosCoccion | Valores invertidos: el duro daba 25 y el blando 40 | Papa (blanda) con 40 min y yuca (dura) con 25 min | return duro ? 40 : 25; |
| 7 | Sancocho.estaCompleto | Mezclaba && con ||, bastaba tener condimento para estar «completo» | «¿El caldo de papa está completo? true» (no tiene proteína) | Exigir las tres condiciones con && |
| 8 | Sancocho.esTrifasico | Contaba todos los ingredientes, no las proteínas | «¿El de gallina es trifásico? true» (solo tiene 1 proteína) | olla.contarPorCategoria("Proteína") >= 3 |
| 9 | Pedido.calcularCosto | Los acompañamientos se sumaban una sola vez en lugar de multiplicarse por la cantidad | Mesa 1: $5700 no cuadraba con «cada plato lleva sus acompañamientos» | (precioPorción + sumaAcompanamientos) * cantidad |
| 10 | Fonda.registrarPedido | Guardaba el pedido en la lista antes de verificar las porciones; los pedidos fallidos quedaban registrados y sumaban a las ventas | «Pedidos registrados: 4» cuando solo 3 fueron válidos | Llamar a servir(cantidad) primero y crear/agregar el Pedido solo si alcanzan |

## 3. Salida final del programa

PS C:\VSCODE\ParcialPooNutresa>  & 'C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot\bin\java.exe' '-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:56418' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\LOQ\AppData\Roaming\Code\User\workspaceStorage\8ac246a45567fe071956ff3c58938d6f\redhat.java\jdt_ws\ParcialPooNutresa_bbd6eb23\bin' 'Main' 
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
PS C:\VSCODE\ParcialPooNutresa> 

## 4. Conceptos de POO en este proyecto
Explica brevemente (2-3 líneas cada uno) DÓNDE se usa en este código:
- **Encapsulamiento:** Los atributos son private (p. ej. gramos, precioKilo en Ingrediente, o ingredientes en Olla) y solo se accede por getters/setters. Los setters validan (gramos y precio > 0, nombre no vacío) y Olla.getIngredientes() devuelve una copia para que nadie modifique la lista interna.
- **Herencia:** Proteina, Tuberculo, Verdura y Condimento extienden Ingrediente y reutilizan su código, nombre, gramos, precio y calcularCosto(). Cada una agrega solo lo propio (tipo, duro, seAgregaAlFinal).
- **Abstracción (clase abstracta):** Ingrediente es abstracta: no tiene sentido crear un «ingrediente» genérico (por eso falla new Ingrediente(...)). Declara los métodos abstractos minutosCoccion() y getCategoria(), que cada subclase está obligada a implementar.
- **Interfaz:** Identificable (getCodigo(), obtenerFicha()) la implementan Ingrediente (y por herencia sus subclases) y Sancocho. Costeable (calcularCosto()) la implementan Ingrediente (y subclases), Sancocho, Acompanamiento y Pedido.
- **Polimorfismo:** En la sección 6 un Identificable apunta a un Sancocho, y un ArrayList<Costeable> guarda un Tuberculo, un Sancocho, un Acompanamiento y un Pedido. Al llamar c.calcularCosto() en el bucle, Java ejecuta la versión de cada clase. También Olla guarda Ingrediente y llama minutosCoccion() sin saber el subtipo.