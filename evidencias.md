# EVIDENCIAS DEL PROYECTO — SISTEMA DE FONDA Y SANCOCHOS
**Estudiante:** Cristian Camilo Cruz Osorio
**Fecha:** 28/10/2026
**Rama:** feature/recetario/G2-EDT-F01-crear

---

## 1. Estructura del Proyecto
proyecto/
├── src/
│ ├── modelo/
│ │ ├── Ingrediente.java (clase abstracta base)
│ │ ├── Proteina.java
│ │ ├── Tuberculo.java
│ │ ├── Verdura.java
│ │ ├── Condimento.java
│ │ ├── Acompanamiento.java (implementa Costeable)
│ │ ├── Olla.java (gestión de ingredientes y capacidad)
│ │ ├── Sancocho.java (lógica: estaCompleto / esTrifasico)
│ │ ├── Pedido.java (asignación de porciones y acompañamientos)
│ │ ├── Identificable.java (interfaz)
│ │ └── Costeable.java (interfaz para cálculo de precios)
│ ├── servicio/
│ │ └── Fonda.java (menú, registro de pedidos, ventas)
│ └── Main.java (ejecución y pruebas del sistema)
├── bin/ (archivos compilados)
└── EVIDENCIAS.md
plaintext

---

## 2. Funcionalidades Implementadas

### ✅ Gestión de Ingredientes
- Validación de código único en la olla
- Control de capacidad máxima en gramos
- Verificación de frescura al agregar

### ✅ Lógica de Sancocho
- `estaCompleto()` → valida presencia de: Proteína + Tubérculo + Verdura + Condimento
- `esTrifasico()` → detecta 3 o más tipos de proteína
- `obtenerFicha()` → resumen formateado con estado

### ✅ Pedidos y Costos
- Restricción de porciones disponibles
- Acompañamientos adicionales con precio propio
- Cálculo de venta total del día

### ✅ Polimorfismo
- Uso de interfaces `Identificable` y `Costeable`
- Tratamiento uniforme de objetos con comportamiento común

---

## 3. Comandos de Compilación y Ejecución
```bash
# Compilar todo
javac -d bin src/modelo/*.java src/servicio/*.java src/Main.java

# Ejecutar
java -cp bin Main
4. Resultados Esperados
✅ Olla pequeña rechaza ingrediente que excede capacidad
✅ Código duplicado no se agrega
✅ Ingrediente no fresco es rechazado
✅ Sancocho trifásico detecta 3 proteínas
✅ Pedidos sin stock o código inválido son rechazados
✅ Costos calculados por polimorfismo
5. Estado del Repositorio
✅ Código compilando sin errores
✅ Rama activa: feature/recetario/G2-EDT-F01-crear
✅ Archivos organizados por paquete (modelo, servicio)
✅ Interfaces aplicadas correctamente