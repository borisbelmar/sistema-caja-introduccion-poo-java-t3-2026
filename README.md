# Sistema de Caja — Introducción a POO (Java)

Proyecto didáctico que simula una **caja registradora con inventario**: registrar productos, controlar su stock (ingresos y retiros) y generar ventas. Está pensado como ejercicio introductorio de **Programación Orientada a Objetos (POO)** en Java.

> 🎓 Si estás recién empezando con POO, este README te explica qué hace cada clase y qué conceptos representa, no solo "cómo correrlo".

## ¿Qué hace el programa?

`Main` simula un flujo típico de caja:

1. Crea un `Inventario` vacío.
2. Registra dos productos (`Producto A`, `Producto B`).
3. Hace **ingresos** de stock para esos productos.
4. Hace un **retiro** manual de stock.
5. Abre una `Venta`, le agrega productos y la cierra (lo que descuenta stock automáticamente).
6. Imprime en consola el inventario y el historial de movimientos en cada paso, para que puedas ver cómo cambia el estado.

## Conceptos de POO que vas a encontrar

| Concepto | Dónde se ve | Explicación rápida |
|---|---|---|
| **Clase / Objeto** | `Producto`, `Movimiento`, `Venta`... | Cada archivo `.java` define una clase: un "molde". Con `new Producto(...)` creas un objeto (una instancia) a partir de ese molde. |
| **Encapsulación** | Todas las clases en `caja/` | Los atributos son `private` (nadie accede directo desde afuera) y se exponen solo mediante métodos `getX()` / `setX()`. Esto protege el estado interno del objeto. |
| **Composición / Asociación** | `Inventario` ⟶ `Producto`, `Movimiento`<br>`Venta` ⟶ `Inventario`, `ItemVenta` | Un objeto "tiene" o "usa" a otros. `Inventario` contiene listas de `Producto` y `Movimiento`. `Venta` no duplica productos: le pregunta al `Inventario` cuando los necesita. |
| **Enumeraciones (`enum`)** | `Movimiento.Tipo` (`INGRESO`, `RETIRO`) | En vez de usar `String`s o números "mágicos" para representar el tipo de movimiento, se usa un `enum`: un conjunto fijo y seguro de valores posibles. |
| **Colecciones (`ArrayList`)** | `Inventario.productos`, `Inventario.movimientos`, `Venta.items` | Listas dinámicas de objetos (a diferencia de un arreglo de tamaño fijo). |
| **Validación de reglas de negocio** | `Inventario.registrarMovimiento`, `Venta.sumarProducto` | Antes de modificar el estado, se valida (stock suficiente, cantidad positiva, producto existente). Es buena práctica: el objeto se protege a sí mismo. |

## Estructura del proyecto

```
SistemaCaja/
├── src/
│   ├── Main.java              # Punto de entrada: arma el escenario de ejemplo
│   └── caja/
│       ├── Producto.java      # Un producto: nombre, precio, stock
│       ├── Movimiento.java    # Un ingreso o retiro de stock (con enum Tipo)
│       ├── Inventario.java    # Dueño de los productos y del historial de movimientos
│       ├── ItemVenta.java     # Una línea dentro de una venta (producto + cantidad)
│       └── Venta.java         # Una venta: junta ItemVenta y descuenta stock al cerrarse
└── README.md
```

**Tip de lectura:** empieza por `Producto` (la clase más simple), sigue con `Movimiento`, luego `Inventario` (que usa a ambas), y termina con `ItemVenta`/`Venta`. Al final lee `Main` para ver cómo se conecta todo.

## Cómo probarlo

Requisitos: JDK 21 (o compatible) instalado.

```bash
# Compilar
javac -d out src/Main.java src/caja/*.java

# Ejecutar
java -cp out Main
```

### ⚠️ Desafío para quien recién empieza

Si ejecutas lo anterior tal cual, vas a ver este error:

```
Error: no se ha encontrado el método principal en la clase Main
```

Esto pasa porque en `Main.java` el método está declarado como:

```java
public void main () { ... }
```

...pero Java solo reconoce como punto de entrada a un método con **esta firma exacta**:

```java
public static void main(String[] args) { ... }
```

**Ejercicio:** corrige la firma de `main` en `src/Main.java` y vuelve a compilar/ejecutar. Es un buen primer contacto con un error real de Java y con la palabra clave `static` (un método que pertenece a la clase y no a una instancia, por eso la JVM puede llamarlo sin crear un objeto `Main` primero).

## Abrir en IntelliJ IDEA

El proyecto ya trae `SistemaCaja.iml`. Simplemente abre la carpeta `SistemaCaja` con IntelliJ y el IDE reconocerá `src/` como carpeta fuente.
