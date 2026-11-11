package caja;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;
    private ArrayList<Movimiento> movimientos;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.movimientos = new ArrayList<>();
    }

    public void registrarMovimiento(Movimiento.Tipo tipo, String fecha, int productoIndex, int cantidad) {
        Producto currentProduct = this.productos.get(productoIndex);

        if (currentProduct == null) {
            System.out.println("El producto no existe.");
            return;
        }
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a cero.");
            return;
        }

        if (tipo == Movimiento.Tipo.RETIRO && currentProduct.getStock() < cantidad) {
            System.out.println("No hay suficiente stock para retirar.");
            return;
        }

        this.movimientos.add(new Movimiento(tipo, fecha, productoIndex, cantidad));

        if (tipo == Movimiento.Tipo.INGRESO) {
            currentProduct.setStock(currentProduct.getStock() + cantidad);
        } else if (tipo == Movimiento.Tipo.RETIRO) {
            currentProduct.setStock(currentProduct.getStock() - cantidad);
        }
    }

    public void registrarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Producto getProducto(int index) {
        return this.productos.get(index);
    }

    public void imprimirMovimientos() {
        System.out.println("Movimientos registrados:");
        for (Movimiento movimiento : movimientos) {
            String tipo = movimiento.getTipo() == Movimiento.Tipo.INGRESO ? "Ingreso" : "Retiro";
            System.out.println("Tipo: " + tipo + ", Fecha: " + movimiento.getFecha() + ", Producto: " + this.productos.get(movimiento.getProductoIndex()).getNombre() + ", Cantidad: " + movimiento.getCantidad());
        }
    }

    public void imprimirInventario() {
        System.out.println("Inventario actual:");
        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Stock: " + producto.getStock());
        }
    }
}
