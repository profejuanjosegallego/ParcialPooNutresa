# Evidencias: Jose Javier Rivera Acosta

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---|---|---|---|
| 1 | modelo/Ingrediente.java | 5 | cannot find symbol: class ArrayList | Agregué import java.util.ArrayList |
| 2 | modelo/Ingrediente.java | 18 | incompatible types: int division | Cambié gramos/1000 por gramos/1000.0 |
| 3 | modelo/Proteina.java | 6 | constructor Ingrediente not defined | Agregué super(codigo,nombre,gramos,precioKilo,fresco) |
| 4 | modelo/Tuberculo.java | 6 | constructor not defined | Agregué super(...) |
| 5 | modelo/Verdura.java | 6 | constructor not defined | Agregué super(...) |
| 6 | modelo/Condimento.java | 6 | constructor not defined | Agregué super(...) |
| 7 | modelo/Olla.java | 1 | cannot find symbol ArrayList | import java.util.ArrayList |
| 8 | modelo/Olla.java | 5 | variable ingredientes not initialized | ingredientes = new ArrayList<>() |
| 9 | modelo/Olla.java | 15 | == used for String | Cambié a equalsIgnoreCase en buscarPorCodigo |
| 10 | modelo/Sancocho.java | 3 | cannot resolve Olla | Agregué import modelo.Olla |
| 11 | modelo/Sancocho.java | 22 | integer division | Uso calcularCostoTotal() / porcionesDisponibles con double |
| 12 | modelo/Acompanamiento.java | 8 | missing getter | Creé getPrecio() y getNombre() |
| 13 | modelo/Pedido.java | 2 | missing import | import java.util.ArrayList |
| 14 | modelo/Pedido.java | 9 | constructor mismatch | Constructor con 3 params: mesa, sancocho, cantidad |
| 15 | servicio/Fonda.java | 2 | cannot find symbol ArrayList | import ArrayList |
| 16 | servicio/Fonda.java | 18 | == for String | equalsIgnoreCase en buscar codigo |
| 17 | Main.java | 1 | cannot find symbol ArrayList | import java.util.ArrayList |
| 18 | Main.java | 3 | cannot find Fonda | import servicio.Fonda |
| 19 | Main.java | 35 | duplicate variable TUB-002 | El ñame repetía código, valida y retorna false |
| 20 | Main.java | 72 | method registrarPedido(int,String,int) not applicable | Corregí llamada a 3 argumentos |
| 21 | Main.java | 76 | constructor Acompanamiento wrong | new Acompanamiento(nombre, precio) |
| 22 | modelo/Identificable.java | 1 | interface method missing | public String getCodigo() |
| 23 | modelo/Costeable.java | 1 | interface method missing | public double calcularCosto() |
| 24 | modelo/Olla.java | 20 | cannot resolve getGramos() | Uso ing.getGramos() con getter de padre |
| 25 | Main.java | 85 | cannot find calcularVentasDelDia | Corregí nombre método en Fonda |

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|---|---|---|---|
| 1 | Olla.agregarIngrediente | Aceptaba ingrediente no fresco | Cebolla con fresco=false | if(!ing.isFresco()) return false |
| 2 | Olla.agregarIngrediente | Aceptaba código duplicado | TUB-002 repetido | buscarPorCodigo != null => false |
| 3 | Olla.agregarIngrediente | No validaba capacidad | Olla 6000g | getGramosOcupados()+ing.getGramos() > capacidad => false |
| 4 | Olla.buscarPorCodigo | Comparaba con == | Nunca encontraba | equalsIgnoreCase |
| 5 | Sancocho.estaCompleto | Solo pedía 2 categorías | Sancocho incompleto | Exijo Proteína>=1, Tubérculo>=1, Verdura>=1, Condimento>=1 |
| 6 | Sancocho.esTrifasico | Contaba todos los ingredientes | Marcaba trifásico mal | Cuento solo Proteína >=3 |
| 7 | Sancocho.calcularCostoPorcion | División entera daba 0 | Costo porción 0 | costoTotal / (double) porciones |
| 8 | Fonda.registrarPedido | No descontaba stock | Vendía infinito | Llamo sancocho.servir(cantidad) |
| 9 | Fonda.registrarPedido | Creaba pedido sin porciones | p3 con 20 cuando quedan 8 | Retorno null si servir() falla |
| 10 | Pedido.calcularCosto | Solo devolvía costo base | No sumaba arroz/aguacate | costoPorcion*cantidad + acompañamientos |
# Evidencias: Jose Javier Rivera Acosta

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---|---|---|---|
| 1 | modelo/Ingrediente.java | 5 | cannot find symbol: class ArrayList | Agregué import java.util.ArrayList |
| 2 | modelo/Ingrediente.java | 18 | incompatible types: int division | Cambié gramos/1000 por gramos/1000.0 |
| 3 | modelo/Proteina.java | 6 | constructor Ingrediente not defined | Agregué super(codigo,nombre,gramos,precioKilo,fresco) |
| 4 | modelo/Tuberculo.java | 6 | constructor not defined | Agregué super(...) |
| 5 | modelo/Verdura.java | 6 | constructor not defined | Agregué super(...) |
| 6 | modelo/Condimento.java | 6 | constructor not defined | Agregué super(...) |
| 7 | modelo/Olla.java | 1 | cannot find symbol ArrayList | import java.util.ArrayList |
| 8 | modelo/Olla.java | 5 | variable ingredientes not initialized | ingredientes = new ArrayList<>() |
| 9 | modelo/Olla.java | 15 | == used for String | Cambié a equalsIgnoreCase en buscarPorCodigo |
| 10 | modelo/Sancocho.java | 3 | cannot resolve Olla | Agregué import modelo.Olla |
| 11 | modelo/Sancocho.java | 22 | integer division | Uso calcularCostoTotal() / porcionesDisponibles con double |
| 12 | modelo/Acompanamiento.java | 8 | missing getter | Creé getPrecio() y getNombre() |
| 13 | modelo/Pedido.java | 2 | missing import | import java.util.ArrayList |
| 14 | modelo/Pedido.java | 9 | constructor mismatch | Constructor con 3 params: mesa, sancocho, cantidad |
| 15 | servicio/Fonda.java | 2 | cannot find symbol ArrayList | import ArrayList |
| 16 | servicio/Fonda.java | 18 | == for String | equalsIgnoreCase en buscar codigo |
| 17 | Main.java | 1 | cannot find symbol ArrayList | import java.util.ArrayList |
| 18 | Main.java | 3 | cannot find Fonda | import servicio.Fonda |
| 19 | Main.java | 35 | duplicate variable TUB-002 | El ñame repetía código, valida y retorna false |
| 20 | Main.java | 72 | method registrarPedido(int,String,int) not applicable | Corregí llamada a 3 argumentos |
| 21 | Main.java | 76 | constructor Acompanamiento wrong | new Acompanamiento(nombre, precio) |
| 22 | modelo/Identificable.java | 1 | interface method missing | public String getCodigo() |
| 23 | modelo/Costeable.java | 1 | interface method missing | public double calcularCosto() |
| 24 | modelo/Olla.java | 20 | cannot resolve getGramos() | Uso ing.getGramos() con getter de padre |
| 25 | Main.java | 85 | cannot find calcularVentasDelDia | Corregí nombre método en Fonda |

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|---|---|---|---|
| 1 | Olla.agregarIngrediente | Aceptaba ingrediente no fresco | Cebolla con fresco=false | if(!ing.isFresco()) return false |
| 2 | Olla.agregarIngrediente | Aceptaba código duplicado | TUB-002 repetido | buscarPorCodigo != null => false |
| 3 | Olla.agregarIngrediente | No validaba capacidad | Olla 6000g | getGramosOcupados()+ing.getGramos() > capacidad => false |
| 4 | Olla.buscarPorCodigo | Comparaba con == | Nunca encontraba | equalsIgnoreCase |
| 5 | Sancocho.estaCompleto | Solo pedía 2 categorías | Sancocho incompleto | Exijo Proteína>=1, Tubérculo>=1, Verdura>=1, Condimento>=1 |
| 6 | Sancocho.esTrifasico | Contaba todos los ingredientes | Marcaba trifásico mal | Cuento solo Proteína >=3 |
| 7 | Sancocho.calcularCostoPorcion | División entera daba 0 | Costo porción 0 | costoTotal / (double) porciones |
| 8 | Fonda.registrarPedido | No descontaba stock | Vendía infinito | Llamo sancocho.servir(cantidad) |
| 9 | Fonda.registrarPedido | Creaba pedido sin porciones | p3 con 20 cuando quedan 8 | Retorno null si servir() falla |
| 10 | Pedido.calcularCosto | Solo devolvía costo base | No sumaba arroz/aguacate | costoPorcion*cantidad + acompañamientos |

java -cp out Main
## 3. Salida final del programa