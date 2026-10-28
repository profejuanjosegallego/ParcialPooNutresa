# Evidencias: <tu Hernan Dario Perez Higuita>

## 1. Errores de sintaxis corregidos
| #  | Archivo       | Línea | Mensaje del compilador | Corrección                                                                                                                                         |
|----|---------------|-------|----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| 1  | Tuberculo     | 6     |The constructor Tuberculo(String, String, int, int, boolean, boolean) is undefined                        |Se cambia nombre de Tuberculos a Tuberculo                        |
| 2  | Main          | 23    |Type mismatch: cannot convert from Ingrediente to Tuberculo                                               |Se cambia el tipo de instancia de new Ingrediente a new Tuberculo
| 3  | Verdura       | 33    |The method agregarIngrediente(Ingrediente) in the type Olla is not applicable for the arguments (Verdura) |Se agrega 's' a 'extend', para heredar correctamente
| 4  | Acompañamiento| 14    |Syntax error, insert ";" to complete BlockStatements                                                      |Se agrega ';' a return precio;
| 5  | Acompañamiento| 14    |Syntax error, insert ";" to complete MethodDeclaration                                                    |Se agrega ';' a getCodigo();
| 6  | Ingrediente   | 25    |Type mismatch: cannot convert from double to int                                                          |Se cambia el tipo de dato de int a double
| 7  | Costeable     | 5     |Abstract methods do not specify a body                                                                    |Se elimina cuerpo del método abstracto
| 8  | Acompañamiento| 4     |The type Acompanamiento must implement the inherited abstract method Costeable.calcularCosto()            |Se implementa la clase abstracta calcularCosto()
| 9  | Condimiento   | 9     |alFinal cannot be resolved to a variable                                                                  |Se implementa el nombre correcto del parametro
| 10 | Condimiento   | 23    |The local variable minutos may not have been initialized                                                  |Se elimina el parametro del else if y se modifca por un else
| 11 | Ingrediente   | 51    |The method IllegalArgumentException(String) is undefined for the type Ingrediente                         |Se agrega operador new para instanciar correctamente 
| 12 | Ingrediente   | 84    |String literal is not properly closed by a double-quote                                                   |Se agrega comillas que faltaban de cierre " g, $"
| 13 | Olla          | 45    |This method must return a result of type Ingrediente                                                      |Se agrega returno null linea 51
| 14 | Olla          | 108   |length cannot be resolved or is not a field                                                               |Se cambia lenght por size() por ser un lista dinamica
| 15 | Pedido        | 33    |getPrecio cannot be resolved or is not a field                                                            |Se agrega parentisis a getPrecio()
| 16 | Proteina      | 8     |The constructor Ingrediente(String, String, int, double) is undefined                                     |Se agrega fresco en los atributos super del padre
| 17 | Proteina      | 18    |Type mismatch: cannot convert from String to int                                                          |Se cambia string "60" por int 60
| 18 | Sancocho      | 54    |Cannot make a static reference to the non-static method calcularTiempoCoccion() from the type Olla        |Se cambia Olla por olla
| 19 | Sancocho      | 57    |Void methods cannot return a value                                                                        |Se cambia el retorno de void a boolean
| 20 | Sancocho      | 60    |Void methods cannot return a value                                                                        |Se cambia el retorno de void a boolean
| 21 | Tuberculo     | 27    |Invalid character constant                                                                                |Se cambia 'Tubérculo' por "Tubérculo"
| 22 | Sancocho      | 3     |The type Verdura must implement the inherited abstract method Ingrediente.minutosCoccion()                |Se cambia minutosDeCoccion por minutosCoccion
| 23 | Fonda         | 8     |ArrayList cannot be resolved to a type                                                                    |Se hace importacion de java.util.ArrayList;
| 24 | Fonda         | 47    |The constructor Pedido(int, Sancocho) is undefined                                                        |Se agrega cantidad a los parametros de la funcion
| 25 | Fonda         | 67    |system cannot be resolved                                                                                 |Se corrige system por System
| 26 | Main          | 108   |Type mismatch: cannot convert from Ingrediente to Proteina                                                |Se cambia el tipo de Proteina a Ingrediente


(las 25 filas)

## 2. Errores de lógica corregidos
| # | Archivo y método           | Qué hacía mal                 | Pista (fila de la tabla) | Cómo lo corregí       |
| 1 | Ingrediente.calcularCosto  | gramos / 1000                 | Seccion 1                | gramos / 1000.0       |
| 2 | Tuberculos.minutosCoccion  | return duro ? 25 : 40         | Seccion 1                | return duro ? 40 : 25 |
| 3 | Olla.agregarIngrediente    | No suma el ingrediente nuevo  | Seccion 3                | calcularPesoTotal() + nuevo.getGramos() > capacidadGramos|
| 4 | Olla.buscarPorCodigo       | Comparaba nombre con codigo   | Seccion 1                | i.getCodigo().equals(codigo)|
| 5 | Olla.calcularTiempoCoccion | Usaba <, así que devolvía 0   | Seccion 4                | i.minutosCoccion() > mayor|
| 6 | Sancocho.estaCompleto      | Mezclaba `&&` con `||`        | Seccion 4                | && olla.contarPorCategoria("Condimento") > 0|
| 7 | Sancocho.esTrifasico       | Contaba todos los ingrediente | Seccion 4                | return olla.contarPorCategoria("Proteína") >= 3|             |
| 8 |                  |               |                          |                 |
| 9 |                  |               |                          |                 |
| 10 |------------------|---------------|-------------------------|-----------------|

(las 10 filas)

## 3. Salida final del programa
(pega aquí la salida completa de `java -cp out Main`, o una captura)

##4. Conceptos de POO en este proyecto
Encapsulamiento: Se aplica ocultando los atributos con modificadores private y final en clases como Ingrediente, Sancocho y Pedido, exponiendo únicamente métodos de acceso (getters) y validaciones en los modificadores (setters) como setGramos() y setPrecioKilo().

Herencia: Se utiliza mediante la relación de jerarquía donde las clases Proteina, Tuberculo, Verdura y Condimento extienden (extends) de la clase base común Ingrediente, heredando sus atributos y comportamientos compartidos.

Abstracción (clase abstracta): Se implementa en la clase abstracta Ingrediente, la cual define la estructura básica de cualquier ingrediente y declara los métodos abstractos minutosCoccion() y getCategoria(), obligando a sus clases hijas concretas a proveer la implementación específica.

Interfaz: Se usan dos interfaces: Identificable (implementada por Ingrediente y Sancocho para gestionar códigos únicos) y Costeable (implementada por Ingrediente, Acompanamiento, Sancocho y Pedido para estandarizar el cálculo del costo financiero en pesos).

Polimorfismo: Se evidencia en la Sección 6 al almacenar objetos de diferentes tipos (Tuberculo, Sancocho, Acompanamiento, Pedido) dentro de una lista genérica de tipo ArrayList<Costeable>, invocando el método calcularCosto() en cada objeto en tiempo de ejecución de forma transparente.