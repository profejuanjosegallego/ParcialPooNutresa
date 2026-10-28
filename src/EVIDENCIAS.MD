# Evidencias: Jorge Alexander Chaves Rivero

## 1. Errores de sintaxis corregidos
| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | Acompanamiento.java | 14 | ';' expected | public double getPrecio() { return precio; } |
| 2 | Acompanamiento.java | 16 | Acompanamiento is not abstract and does not override abstract method calcularCosto() in Costeable | @Override
    public double calcularCosto() {
        return precio;
    } |
| 3 | Costeable.java | 5 | interface abstract methods cannot have body | double calcularCosto(); |
| 4 | Identificable.java | 4 | '{' or ';' expected | String getCodigo(); |
| 5 | Pedido.java |  | cannot find symbol
  symbol:   variable getPrecio
  location: variable a of type Acompanamiento | sumaAcompanamientos += a.getPrecio(); |
| 6 | Verdura.java | 3 | '{' expected | public class Verdura extends Ingrediente { |
| 7 | Verdura.java | 10 | minutosDeCoccion() in Verdura does not override or implement a method from a supertype | public int minutosCoccion() { |
| 8 | Condimento.java | 9 | cannot find symbol
  symbol:   variable alFinal
  location: class Condimento | this.seAgregaAlFinal = seAgregaAlFinal; |
| 9 | Condimento.java | 17 | variable minutos might not have been initialized | int minutos = 0; |
| 10 | Proteina.java | 18 | incompatible types: String cannot be converted to int | return 60; |
| 11 | Proteina.java | 8 | constructor Ingrediente in class Ingrediente cannot be applied to given types;
  required: String,String,int,double,boolean
  found:    String,String,int,double
  reason: actual and formal argument lists differ in length | super(codigo, nombre, gramos, precioKilo, fresco); |
| 12 | Olla.java | 45-52 | missing return statement | return null; |
| 13 | Olla.java |  | cannot find symbol
  symbol:   variable length
  location: variable ingredientes of type ArrayList<Ingrediente> | for (int i = 1; i < ingredientes.size(); i++) { |
| 14 | Tuberculo.java | 6 | invalid method declaration; return type required | public Tuberculo(String codigo, String nombre, int gramos, double precioKilo, boolean fresco, boolean duro) { |
| 15 | Tuberculo.java | 22 | not a statement | return "Tubérculo"; |
| 16 |      |    |                     |         |
| 17 |      |    |                     |         |
| 18 |      |    |                     |         |
| 19 |      |    |                     |         |
| 20 |      |    |                     |         |
| 21 |      |    |                     |         |
| 23 |      |    |                     |         |
| 24 |      |    |                     |         |
| 25 |      |    |                     |         |
(las 25 filas)

## 2. Errores de lógica corregidos
| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
| 1 |                       |                           |                           |                           |
| 2 |                       |                           |                           |                           |
| 3 |                       |                           |                           |                           |
| 4 |                       |                           |                           |                           |
| 5 |                       |                           |                           |                           |
| 6 |                       |                           |                           |                           |
| 7 |                       |                           |                           |                           |
| 8 |                       |                           |                           |                           |
| 9 |                       |                           |                           |                           |
| 10 |                      |                           |                           |                           |
(las 10 filas)

## 3. Salida final del programa
(pega aquí la salida completa de `java cp out Main`, o una captura)

## 4. Conceptos de POO en este proyecto
Explica brevemente (23 líneas cada uno) DÓNDE se usa en este código:
 **Encapsulamiento:**
 **Herencia:**
 **Abstracción (clase abstracta):**
 **Interfaz:** (hay dos, ¿qué clases implementa cada una?)
 **Polimorfismo:** (mira la sección 6 de Main)