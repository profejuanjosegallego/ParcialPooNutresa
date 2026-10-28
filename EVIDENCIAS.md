# Evidencias: Catalina Lombana Osorio

## 1. Errores de sintaxis corregidos

| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | Acompanamiento.java | 14 | error: ';' expected | Agregué ';' después de la palabra precio |
| 2 | Identificable.java | 4 | error: ';' expected | Agregué ';' después de los paréntesis de getCodigo() |
| 3 | Ingrediente.java | 67 | error: unclosed string literal | Cerré las comillas del texto |
| 4 | Tuberculo.java | 6 | invalid method declaration; return type required | Renombré el constructor para que se llame igual que la clase |
| 5 | Tuberculo.java | 22 | error: unclosed character literal | Cambié las comillas simples por dobles |
| 6 | Verdura.java | 3 | error: '{' expected | Cambié extend por extends en la declaración de la clase |
| 7 | Fonda.java | 8 | cannot find symbol (class ArrayList) | Agregué import java.util.ArrayList debajo de package |
| 8 | Costeable.java | 5 | interface abstract methods cannot have body | Quité el cuerpo del método calcularCosto() y lo terminé con ; |
| 9 | Acompanamiento.java | 4 | is not abstract and does not override abstract method | Renombré el método calcularPrecio() a calcularCosto() para implementar la interfaz |
| 10 | Ingrediente.java | 25 | incompatible types: possible lossy conversion from double to int | Cambié el tipo de retorno de getPrecioKilo() de int a double |
| 11 | Ingrediente.java | 37 | cannot find symbol (method IllegalArgumentException) | Agregué new antes de IllegalArgumentException |
| 12 | Condimento.java | 9 | cannot find symbol (variable alFinal) | Cambié alFinal por seAgregaAlFinal, el nombre real del parámetro del constructor |
| 13 | Olla.java | 64 | cannot find symbol (variable length) | Cambié ingredientes.length por ingredientes.size(), porque es un ArrayList |
| 14 | Pedido.java | 33 | cannot find symbol (variable getPrecio) | Agregué los paréntesis para llamar al método: a.getPrecio() |
| 15 | Sancocho.java | 34 | non-static method calcularTiempoCoccion() cannot be referenced from a static context | Cambié Olla.calcularTiempoCoccion() por olla.calcularTiempoCoccion(), llamándolo sobre el objeto |
| 16 | Condimento.java | 23 | variable minutos might not have been initialized | Cambié else if (!seAgregaAlFinal) por else, para que minutos siempre reciba un valor |
| 17 | Sancocho.java | 57 | incompatible types: unexpected return value | Cambié el tipo de retorno de servir() de void a boolean |
| 18 | Proteina.java | 8 | constructor Ingrediente cannot be applied to given types | Agregué el parámetro fresco en la llamada a super(...) |
| 19 | Proteina.java | 18 | incompatible types: String cannot be converted to int | Cambié return "60"; por return 60; |
| 20 | Verdura.java | 10 | method does not override or implement a method from a supertype | Renombré minutosDeCoccion() a minutosCoccion() |
| 21 | Olla.java | 38 | missing return statement | Agregué return null; al final de buscarPorCodigo() |
| 22 | Fonda.java | 45 | constructor Pedido cannot be applied to given types | Agregué el argumento cantidad en new Pedido(mesa, sancocho, cantidad) |
| 23 | Fonda.java | 65 | package system does not exist | Cambié system por System (con mayúscula) |
| 24 | Main.java | 23 | Ingrediente is abstract; cannot be instantiated | Cambié new Ingrediente por new Tuberculo |
| 25 | Main.java | 108 | incompatible types: Ingrediente cannot be converted to Proteina | Agregué el cast (Proteina) |

## 2. Errores de lógica corregidos

| # | Archivo y método | Qué estaba mal | Dónde se notó en la salida | Cómo lo corregí |
|---|------------------|----------------|----------------------------|-----------------|
| 1 | Ingrediente.java, calcularCosto() | Dividía gramos / 1000 con enteros y se perdían los decimales (800 g daba 0 kg) | Sección 1: costos de la olla de gallina ($27000, $3000, $2800...) | Cambié 1000 por 1000.0 para que la división sea con decimales |
| 2 | Tuberculo.java, minutosCoccion() | Los valores estaban invertidos: el tubérculo duro daba 25 min y el blando 40 | Sección 1: minutos de la olla de gallina (papa 25, yuca 40) y sección 2 (yuca 40 min) | Cambié duro ? 25 : 40 por duro ? 40 : 25 |
| 3 | Olla.java, buscarPorCodigo() | Comparaba el código recibido con getNombre() en vez de getCodigo(), por lo que nunca encontraba el ingrediente | Sección 1: aceptó un código repetido (true) y sección 6: Buscar PRO-001 no encontrado | Cambié getNombre() por getCodigo() en la comparación |
| 4 | Olla.java, agregarIngrediente() | Validaba la capacidad solo con el peso actual y no sumaba el peso del ingrediente nuevo, por lo que aceptaba ingredientes que desbordaban la olla | Sección 3: la yuca cupo (true) y la olla quedó en 1130/1000 g | Cambié la condición a calcularPesoTotal() + nuevo.getGramos() > capacidadGramos |
| 5 | Olla.java, calcularCostoIngredientes() | El ciclo empezaba en i = 1 y se saltaba el primer ingrediente de la lista | Sección 4: costo del sancocho de gallina ($12200 en vez de $45200) | Cambié el inicio del ciclo a i = 0 para sumar todos los ingredientes |
| 6 | Olla.java, calcularTiempoCoccion() | La condición usaba < en vez de > al buscar el mayor tiempo, por lo que siempre devolvía 0 | Sección 4: las fichas de los sancochos mostraban 0 min (debían ser 60, 90 y 25) | Cambié < por > para quedarme con el mayor tiempo de cocción |
| 7 | Sancocho.java, estaCompleto() | Usaba \|\| antes de la condición del condimento, así que bastaba con tener un condimento para quedar completo | Sección 4: el caldo de papa salía completo (true) sin tener proteína | Cambié \|\| por && para exigir proteína, tubérculo y condimento a la vez |
| 8 | Sancocho.java, esTrifasico() | Contaba todos los ingredientes de la olla en vez de contar solo las proteínas | Sección 4: el sancocho de gallina salía trifásico (true) teniendo una sola proteína | Cambié getCantidadIngredientes() por contarPorCategoria("Proteína") >= 3 |
| 9 | Pedido.java, calcularCosto() | Multiplicaba solo el sancocho por la cantidad y sumaba los acompañamientos una sola vez, sin multiplicarlos por los platos | Sección 5: la mesa 1 daba $9380 en vez de $27080 | Agrupé con paréntesis: (precioPorcion + acompañamientos) * cantidad |
| 10 | Fonda.java, registrarPedido() | Agregaba el pedido a la lista antes de verificar que había porciones, así que guardaba pedidos rechazados | Sección 5: Pedidos registrados daba 4 (debían ser 3) y las ventas del día estaban infladas | Moví pedidos.add(pedido) para después de servir(), solo cuando el pedido es exitoso |

## 3. Salida final del programa

```
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
Buscar PRO-001: Gallina criolla (gallina)
Como Identificable: SAN-002
Tuberculo cuesta $3000
Sancocho cuesta $45200
Acompanamiento cuesta $2000
Pedido cuesta $27080
```

## 4. Conceptos de POO aplicados

- **Encapsulamiento:** los atributos son `private` y se accede a ellos con getters. En `Olla`, la lista `ingredientes` es privada y `getIngredientes()` devuelve una copia para que nadie la modifique desde afuera.
- **Herencia:** `Proteina`, `Tuberculo`, `Verdura` y `Condimento` extienden de `Ingrediente` y reutilizan sus atributos y métodos.
- **Abstracción:** `Ingrediente` es abstracta y declara `minutosCoccion()` sin implementarlo; cada clase hija lo define a su manera (proteína 60, tubérculo 25 o 40, etc.).
- **Interfaces:** `Identificable` (getCodigo) y `Costeable` (calcularCosto) definen contratos. `Sancocho` implementa las dos; `Pedido` y `Acompanamiento` implementan `Costeable`.
- **Polimorfismo:** en la sección 6 del Main, una lista de `Costeable` guarda un tubérculo, un sancocho, un acompañamiento y un pedido, y cada uno responde con su propio `calcularCosto()`.
