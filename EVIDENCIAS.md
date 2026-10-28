# Evidencias: Andrés David

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---|---|---|---|
| 1 | Main.java | 16 | System.out mal escrito | Se ajustó la S mayúscula en System.out |
| 2 | Main.java | 23 | Ingrediente is abstract; cannot be instantiated | Se cambió la instanciación directa por Tuberculo |
| 3 | Main.java | 108 | cannot find symbol: class proteina | Se corrigió la minúscula en el casting por Proteina |
| 4 | Main.java | 108 | incompatible types: Ingrediente cannot be converted to Proteina | Se aplicó el casting explícito (Proteina) |
| 5 | Olla.java | 51 | missing return statement | Se añadió el return null al final del método |
| 6 | Fonda.java | 66 | cannot find symbol: system | Se corrigió system por System.out.println |
| 7 | Proteina.java | - | constructor Proteina cannot be applied | Se ajustó la llamada al super(...) |
| 8 | Tuberculo.java | - | constructor Tuberculo cannot be applied | Se alinearon los parámetros del constructor |
| 9 | Condimento.java | - | constructor Condimento cannot be applied | Se corrigió la firma llamando a super(...) |
| 10 | Verdura.java | - | constructor Verdura cannot be applied | Se ajustaron los argumentos al invocar super |
| 11 | Sancocho.java | - | does not override abstract method | Se implementaron los métodos abstractos |
| 12 | Olla.java | - | cannot find symbol: variable ingredientes | Se inicializó la lista con new ArrayList<>() |
| 13 | Pedido.java | - | cannot find symbol | Se corrigieron las referencias de importación |
| 14 | Costeable.java | - | interface expected here | Se ajustó la implementación de la interfaz |
| 15 | Identificable.java | - | interface expected here | Se ajustaron las cláusulas implements |
| 16 | Acompanamiento.java | - | cannot find symbol | Se agregaron los atributos y getters faltantes |
| 17 | Main.java | 1-14 | cannot find symbol: imports | Se importaron los paquetes de modelo y servicio |
| 18 | Main.java | 38 | cannot find symbol: variable cebolla | Se declaró la variable Verdura antes de usarla |
| 19 | Main.java | 39 | cannot find symbol: variable name | Se declaró correctamente la variable |
| 20 | Ingrediente.java | - | abstract class instantiation error | Se marcó la clase como abstract |
| 21 | Olla.java | 47 | cannot find symbol: equals | Se usó .equals() para comparar cadenas |
| 22 | Olla.java | 58 | missing return statement | Se retornó el total acumulado |
| 23 | Fonda.java | - | cannot find symbol | Se importó el modelo en el servicio |
| 24 | Main.java | - | class Main is public | Se verificó el nombre correcto del archivo |
| 25 | Main.java | - | reached end of file while parsing | Se cerraron las llaves de cierre pendientes |

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|---|---|---|---|
| 1 | Olla.agregarIngrediente | Dejaba meter ingredientes dañados | Validar frescura | Puse un condicional para verificar si es fresco |
| 2 | Olla.agregarIngrediente | Repetía ingredientes con el mismo código | Validar duplicados | Usé el método buscarPorCodigo para controlarlo |
| 3 | Olla.agregarIngrediente | Se pasaba del límite de peso de la olla | Validar capacidad | Controlé que no supere la capacidad en gramos |
| 4 | Olla.buscarPorCodigo | Comparaba mal el texto del código | Buscar por código | Cambié la comparación por .equals() |
| 5 | Olla.calcularCostoTotal | No sumaba los precios de cada cosa | Suma de precios | Recorrí la lista acumulando los costos |
| 6 | Sancocho.calcularCosto | Faltaba sumar la olla y el acompañamiento | Costo del plato | Sumé todos los componentes al total |
| 7 | Main.main | Tenía los datos al revés en las pruebas | Datos de prueba | Ordené bien los parámetros al instanciar |
| 8 | Fonda.atenderPedido | No hacía nada con los ingredientes de la orden | Procesar pedido | organicé la lógica para procesar el pedido |
| 9 | Olla.calcularPesoTotal | Devolvía cero siempre | Peso acumulado | Sumé los gramos de los ingredientes en un ciclo |
| 10 | Pedido.imprimirFactura | Mostraba mal los datos en consola | Impresión | Ajusté la salida para que imprima bien |

## 3. Salida final del programa
Al ejecutar la clase Main en la terminal, el programa compila correctamente y muestra en consola la validación de la olla del sancocho de gallina, confirmando que no se aceptan ingredientes no frescos ni códigos repetidos (arrojando false en ambos casos de control).

## 4. Conceptos de POO en este proyecto
- Encapsulamiento: Se usa en los atributos privados de las clases del modelo como Ingrediente y Olla, exponiendo su acceso seguro mediante métodos getters y setters.
- Herencia: Se aplica en clases como Proteina, Tuberculo, Verdura y Condimento, las cuales extienden de la clase base Ingrediente para compartir atributos comunes.
- Abstracción: La clase Ingrediente se define como abstract para servir de base genérica e impedir que se instancie directamente por fuera.
- Interfaz: Las interfaces Costeable e Identificable se implementan en las clases correspondientes para asegurar contratos obligatorios de comportamiento.
- Polimorfismo: En la clase Olla se maneja una lista de tipo List<Ingrediente> que permite almacenar y procesar distintos tipos de ingredientes de forma uniforme.