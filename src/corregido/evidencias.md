# Evidencias: Santiago Ocampo

## 1. Errores de sintaxis corregidos

| # | Archivo | Línea | Mensaje del compilador | Corrección |
|---|---------|-------|------------------------|------------|
| 1 | `modelo/Acompanamiento.java` | 4 | `cannot find symbol (symbol: class costeable)` | Se cambió `costeable` por `Costeable` con mayúscula inicial. |
| 2 | `modelo/Acompanamiento.java` | 16 | `is not abstract and does not override abstract method calcularCosto() in Costeable` | Se cambió el nombre del método `calcularPrecio()` por `calcularCosto()`. |
| 3 | `modelo/Costeable.java` | 5 | `interface abstract methods cannot have body` | Se eliminó el cuerpo `{ return 0; }` y se finalizó la firma del método con `;`. |

## 2. Errores de lógica corregidos

| # | Archivo y método | Qué hacía mal | Pista (fila de la tabla) | Cómo lo corregí |
|---|------------------|---------------|--------------------------|-----------------|

## 3. Salida final del programa

```text
(Aquí pegarás la salida completa de la consola cuando termine el programa)