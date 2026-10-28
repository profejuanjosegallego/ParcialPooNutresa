# Parcial práctico POO: La Fonda POO y su sancocho 🍲🇨🇴

| | |
|---|---|
| **Duración** | 2 horas (120 minutos) |
| **Lenguaje** | Java 17 o superior |
| **Puntaje** | 100 puntos |
| **Modalidad** | Individual |

---

## 📖 Historia

**La Fonda POO** vende el mejor sancocho de la ciudad. Doña Rosa arma cada olla con proteínas (gallina, res, cerdo), tubérculos (papa, yuca), verduras (mazorca, plátano) y condimentos (cilantro, guascas, ajo). Con eso calcula cuánto le cuesta la olla, cuánto se demora en estar lista, a cuánto vende cada plato y cuánto vendió en el día.

El sistema lo hizo un sobrino que "sabía programar"... y lo dejó **roto**. No compila y, cuando lo hagas compilar, vas a ver que **los números no cuadran**: platos gratis, ollas que se desbordan, sancochos que "están listos" en 0 minutos. Tu trabajo es dejarlo funcionando.

---

## ⚠️ Lee esto antes de empezar

Este parcial tiene **dos fases** y se hacen **en orden**:

```
        FASE 1                          FASE 2
  Errores de sintaxis      →      Errores de lógica
  (que compile)                   (que los resultados sean correctos)
  25 errores · ~55 min            10 errores · ~50 min
```

¿Por qué en este orden? Porque **no puedes probar la lógica de un programa que no compila**.

Te quedan ~15 minutos para `EVIDENCIAS.md` y la entrega. **Administra tu tiempo**: si un error te bloquea más de 5 minutos, anótalo y sigue con otro.

> 💡 **Haz commits mientras avanzas**, como mínimo: `Fase 1: el proyecto compila`, `Fase 2: corrige errores de lógica` y `Evidencias`. El historial de commits forma parte de la evaluación.

---

## 🗂️ Estructura del proyecto

```text
src/
  Main.java                  ← programa principal con los datos de prueba
  modelo/
    Identificable.java       ← interfaz: tiene código y ficha
    Costeable.java           ← interfaz: tiene costo en pesos
    Ingrediente.java         ← clase abstracta (padre de los 4 ingredientes)
    Proteina.java            ← hereda de Ingrediente
    Tuberculo.java           ← hereda de Ingrediente
    Verdura.java             ← hereda de Ingrediente
    Condimento.java          ← hereda de Ingrediente
    Acompanamiento.java      ← arroz, aguacate, ají (es Costeable, NO es ingrediente)
    Olla.java                ← contiene la lista de ingredientes
    Sancocho.java            ← una olla convertida en platos para vender
    Pedido.java              ← lo que pide una mesa
  servicio/
    Fonda.java               ← administra el menú y los pedidos
```

### Diagrama de clases

```text
   «interface»                    «interface»
  Identificable                    Costeable
 + getCodigo(): String          + calcularCosto(): double
 + obtenerFicha(): String              ▲
        ▲                              │ implements
        │        ┌─────────────────────┼──────────────────┬────────────────┐
        │        │                     │                  │                │
        ├── «abstract» Ingrediente     │            Acompanamiento       Pedido
        │   - codigo: String           │            - nombre             - mesa: int
        │   - nombre: String           │            - precio             - sancocho: Sancocho
        │   - gramos: int              │                                 - cantidad: int
        │   - precioKilo: double       │                                 - acompanamientos:
        │   - fresco: boolean          │                                   ArrayList<Acompanamiento>
        │   + calcularCosto(): double  │
        │   + minutosCoccion(): int        «abstract»
        │   + getCategoria(): String       «abstract»
        │          ▲                   │
        │   ┌──────┼─────────┬─────────┴──┐
        │ Proteina Tuberculo Verdura  Condimento
        │ - tipo   - duro             - seAgregaAlFinal
        │ 60/90min 40/25min  30min    5/20min
        │
        └── Sancocho ───────────► Olla
            - codigo, nombre        - capacidadGramos: int
            - porcionesTotales      - ingredientes: ArrayList<Ingrediente>
            - porcionesDisponibles  + agregarIngrediente(Ingrediente): boolean
            + calcularPrecioPorcion() + buscarPorCodigo(String): Ingrediente
            + estaCompleto()        + calcularPesoTotal(): int
            + esTrifasico()         + calcularCostoIngredientes(): double
            + servir(int): boolean  + calcularTiempoCoccion(): int
                                    + contarPorCategoria(String): int

 Fonda (servicio)
  - nombre: String
  - menu: ArrayList<Sancocho>
  - pedidos: ArrayList<Pedido>
  + agregarAlMenu(Sancocho)        + registrarPedido(int, String, int): Pedido
  + buscarSancocho(String)         + calcularVentasDelDia(): double
```

### 📐 Reglas del negocio (las fórmulas)

| Concepto | Regla |
|---|---|
| Costo de un ingrediente | `gramos / 1000 × precioKilo` (los gramos se pasan a **kilos**). Ej.: 1500 g de gallina a $18.000/kg = **$27.000** |
| Minutos de cocción | Proteína: gallina **60**, res o cerdo **90**. Tubérculo: duro (yuca) **40**, blando (papa) **25**. Verdura: **30**. Condimento: si se echa al final **5**, si no **20** |
| Tiempo de la olla | El del ingrediente **más demorado** (el mayor) |
| Agregar a la olla | Solo si está **fresco**, su **código** no está repetido y **cabe**: peso actual + peso del nuevo ≤ capacidad |
| Costo del sancocho | Costo de **todos** los ingredientes + **$100 por minuto** de gas |
| Precio de un plato | `costo / porcionesTotales × 1.6` (60 % de ganancia) |
| Sancocho completo | Tiene al menos una proteína, un tubérculo **y** un condimento |
| Sancocho trifásico | Tiene **3 o más proteínas** |
| Costo de un pedido | `(precio del plato + acompañamientos) × cantidad` (cada plato lleva sus acompañamientos) |
| Registrar pedido | Solo si el sancocho está en el menú **y** alcanzan las porciones. Si no, **no se registra nada** |

---

## ▶️ Compilar y ejecutar

Desde la **raíz del proyecto** (la carpeta que contiene `src/`):

```bash
javac -encoding UTF-8 -d out src/modelo/*.java src/servicio/*.java src/Main.java
java -cp out Main
```

> Si usas un IDE (IntelliJ, VS Code, NetBeans, Eclipse) también puedes ejecutar `Main` directamente, pero **comprueba al menos una vez con los comandos de arriba**.

---

## 🔧 FASE 1: Errores de sintaxis (40 pts) · ⏱ ~55 min

El proyecto tiene **exactamente 25 errores de compilación** repartidos en los 13 archivos. Corrígelos hasta que `javac` termine **sin ningún mensaje**.

**Cómo trabajar:**

1. Compila y lee el **primer** error: archivo, número de línea y mensaje.
2. Ve a esa línea, entiende qué dice el mensaje y corrige.
3. Vuelve a compilar. Repite.

> 🧠 **Los errores aparecen por oleadas.** Java primero revisa que el código esté bien *escrito* (`;`, comillas, llaves...). Solo cuando eso está bien revisa tipos, herencia e interfaces. Y al final revisa que las variables tengan valor y que los métodos siempre retornen algo. Así que es normal corregir unos pocos errores y que aparezcan más de 20 nuevos (un mismo error puede producir varios mensajes). **No te asustes: vas avanzando.** Las últimas oleadas pueden traer **un solo error a la vez**.

**Pistas de los mensajes que vas a encontrar:**

| Mensaje del compilador | Qué suele significar |
|---|---|
| `';' expected` | Falta un punto y coma (fíjate también en la línea anterior) |
| `'{' expected` | Algo mal escrito en la declaración de la clase |
| `unclosed string literal` | Un texto entre comillas `"` al que le falta cerrar la comilla |
| `unclosed character literal` | Usaste comillas simples `'...'` para un texto. En Java los `String` van con `"` |
| `invalid method declaration; return type required` | El constructor no se llama **exactamente** igual que la clase |
| `cannot find symbol` | Un nombre mal escrito, una variable que no existe, faltan `()` en una llamada, o falta un `import` |
| `package system does not exist` | Java distingue mayúsculas de minúsculas |
| `interface abstract methods cannot have body` | Un método de una interfaz no lleva `{ }` |
| `incompatible types: possible lossy conversion` | Intentas devolver un `double` donde se declaró `int` |
| `incompatible types: String cannot be converted to int` | `"60"` es un texto, `60` es un número |
| `incompatible types: unexpected return value` | El método está declarado `void` pero retorna un valor |
| `'void' type not allowed here` | Usas el resultado de un método `void` como si retornara algo |
| `non-static method ... cannot be referenced from a static context` | Llamaste un método con el nombre de la **clase** en vez de un **objeto** |
| `constructor X in class X cannot be applied to given types` | Llamas a un constructor (o a `super`) con argumentos de más o de menos |
| `X is abstract; cannot be instantiated` | No se puede hacer `new` de una clase abstracta: usa la clase hija |
| `incompatible types: Ingrediente cannot be converted to Proteina` | Un padre no se guarda en una variable de un hijo sin hacer *cast* `(Proteina)` |
| `method does not override or implement a method from a supertype` | El `@Override` no coincide con el nombre/firma del método del padre |
| `is not abstract and does not override abstract method` | Una clase concreta no implementó un método abstracto o de la interfaz |
| `variable X might not have been initialized` | Hay un camino en el que la variable se usa sin haber recibido valor |
| `missing return statement` | Hay un camino en el que el método termina sin retornar nada |

**Reglas de la fase 1:**

- ❌ No borres clases, métodos, atributos ni interfaces para "hacer que compile".
- ❌ No cambies `abstract`, `extends` ni `implements`, y no uses `default` en las interfaces.
- ❌ No "silencies" errores con *casts* como `(int)` o cambiando el tipo de un **atributo**.
- ✅ Corrige el error **respetando la intención** del código: lee los comentarios `/** ... */` y la tabla de reglas del negocio, te dicen qué debe hacer cada método.

✔️ **Terminaste la fase 1 cuando:** `javac` no muestra errores y `java -cp out Main` ejecuta las 6 secciones.

---

## 🐞 FASE 2: Errores de lógica (45 pts) · ⏱ ~50 min

Ahora el programa compila... pero **miente**. Hay **exactamente 10 errores de lógica**: código que Java acepta, pero que no cumple las reglas del negocio. Están en `Ingrediente`, `Tuberculo`, `Olla`, `Sancocho`, `Pedido` y `Fonda`. **`Main.java` no tiene errores de lógica.**

Ejecuta el programa y compara **cada sección** con esta tabla. Cada fila que no coincida es una pista.

| Sección | Qué se prueba | Resultado esperado |
|---|---|---|
| 1 | Costos de la olla de gallina (en orden) | `$27000`, `$3000`, `$2800`, `$2400`, `$2000`, `$1000`, `$1000` |
| 1 | Minutos de la olla de gallina (en orden) | `60`, `25`, `40`, `30`, `30`, `5`, `5` |
| 1 | `¿Se aceptó un ingrediente que no está fresco?` | `false` |
| 1 | `¿Se aceptó un código repetido?` | `false` (la olla queda con **7** ingredientes, `4470/6000 g`) |
| 2 | Olla trifásica | `5450/8000 g`; el cerdo cuesta `$17600`; la yuca, `40 min` |
| 3 | `¿Cupo la yuca en la olla pequeña?` | `false` (la olla queda en `830/1000 g`) |
| 4 | Ficha del sancocho de gallina | `60 min, costo $45200, plato $9040` |
| 4 | Ficha del sancocho trifásico | `90 min, costo $80500, plato $12880` |
| 4 | Ficha del caldo de papa | `25 min, costo $7900, plato $6320` |
| 4 | `¿Está completo?` gallina / caldo | `true` / `false` |
| 4 | `¿Es trifásico?` gallina / trifásico | `false` / `true` |
| 5 | Pedido mesa 1 y mesa 2 | `$27080` y `$46140` |
| 5 | Mesas 3 y 4 | rechazadas, cada una con su mensaje (`false`, `false`) |
| 5 | Pedido mesa 5 | `$54240` |
| 5 | `Pedidos registrados` / `Porciones de gallina que quedan` | `3` / `0` |
| 5 | `Ventas del día` | `$127460` |
| 6 | `Buscar PRO-001` | `Gallina criolla (gallina)` |
| 6 | Polimorfismo | `Tuberculo $3000`, `Sancocho $45200`, `Acompanamiento $2000`, `Pedido $27080` |

> 📝 **Algunos errores esconden a otros**: cuando arregles uno, vuelve a ejecutar y revisa **toda** la tabla de nuevo. Por ejemplo, mientras los costos estén mal no vas a poder saber si el precio de los pedidos está bien.
>
> 🧮 Usa la tabla de **reglas del negocio** y haz las cuentas a mano (o con calculadora) para entender de dónde sale cada número.
>
> 💡 Si en tu consola las tildes se ven raras (`Prote�na`), no es un error del programa: es la configuración de la consola.

**Para cada error lógico encontrado**, escribe en `EVIDENCIAS.md`: el archivo y método, qué hacía mal, qué fila de la tabla te dio la pista y cómo lo corregiste.

✔️ **Terminaste la fase 2 cuando:** toda la salida coincide con la tabla.

---

## 📄 Entregable: `EVIDENCIAS.md` (15 pts, junto con los commits)

Crea un archivo `EVIDENCIAS.md` en la raíz del proyecto con esta estructura:

```markdown
# Evidencias: <tu nombre completo>

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | ...     | ...   | ...                    | ...        |
(las 25 filas)

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|
(las 10 filas)

## 3. Salida final del programa
(pega aquí la salida completa de `java -cp out Main`, o una captura)

## 4. Conceptos de POO en este proyecto
Explica brevemente (2-3 líneas cada uno) DÓNDE se usa en este código:
- **Encapsulamiento:**
- **Herencia:**
- **Abstracción (clase abstracta):**
- **Interfaz:** (hay dos, ¿qué clases implementa cada una?)
- **Polimorfismo:** (mira la sección 6 de Main)
```

---

## 📊 Rúbrica

| Fase | Criterio | Pts |
|---|---|---|
| 1 | El proyecto compila; los 25 errores están corregidos **respetando la intención** del código (1.6 pts c/u) | 40 |
| 2 | Los 10 errores lógicos están corregidos y la salida coincide con la tabla (4.5 pts c/u) | 45 |
| — | `EVIDENCIAS.md` completo (tablas, salida final y conceptos) y commits por fase | 15 |
| | **Total** | **100** |

**Penalizaciones:**

- Eliminar clases, métodos, interfaces o relaciones de herencia: **−10 por cada caso**.
- Cambiar los datos de prueba de `Main` para que "coincida" la tabla: **la fase 2 vale 0**.
- Reemplazar un cálculo por el número esperado (ej. `return 45200;`): **ese error vale 0** y **−5** adicionales.

---

## 📏 Reglas generales

- ✅ Puedes agregar métodos auxiliares (`private`) y pruebas propias **al final** de `Main`.
- ✅ Puedes consultar tus apuntes y la documentación oficial de Java.
- ❌ No cambies las **firmas públicas** de los métodos (nombre, parámetros y tipo de retorno), salvo cuando eso sea justamente el error de sintaxis.
- ❌ No uses bibliotecas externas, asistentes de IA, herramientas de reparación automática ni código de otra persona.
- ❌ No modifiques los datos de prueba que ya vienen en `Main`.

---

## 🚀 Entrega

1. Sube tu proyecto a tu repositorio con **commits por fase** (mínimo 3 commits).
2. Verifica que el repositorio tenga `src/` corregido y `EVIDENCIAS.md`.
3. Entrega el enlace del repositorio al docente antes de que termine el tiempo.

**¡Éxitos, y que no se le queme el sancocho! 🍲**
