package caja;

import java.util.ArrayList;

public class Venta {
    private String fecha;
    private Inventario inventario;
    private ArrayList<ItemVenta> items;
    private boolean cerrado;

    public Venta(String fecha, Inventario inventario) {
        this.fecha = fecha;
        this.items = new ArrayList<>();
        this.inventario = inventario;
        this.cerrado = false;
    }

    public void sumarProducto(int productIndex, int cantidad) {
        Producto producto = this.inventario.getProducto(productIndex);

        if (producto == null) {
            System.out.println("El producto no existe.");
            return;
        }

        if (producto.getStock() < cantidad) {
            System.out.println("No hay suficiente stock para la venta.");
            return;
        }
        this.items.add(new ItemVenta(productIndex, cantidad));
    }

    private int calcularTotal() {
        int total =0;
        for (ItemVenta item : items) {
            Producto producto = this.inventario.getProducto(item.getProductIndex());
            total += producto.getPrecio() * item.getCantidad();
        }
        return total;
    }

    public void imprimirDetalle() {
        System.out.println("Detalle de la venta:");
        for (ItemVenta item : items) {
            Producto producto = this.inventario.getProducto(item.getProductIndex());
            System.out.println("Producto: " + producto.getNombre() + ", Cantidad: " + item.getCantidad() + ", Precio unitario: " + producto.getPrecio() + ", Total: " + (producto.getPrecio() * item.getCantidad()));
        }
        System.out.println("======");
        System.out.println("Total de la venta: " + calcularTotal());
    }

    public void cerrarVenta() {
        if (this.cerrado) {
            System.out.println("La venta ya está cerrada.");
            return;
        }
        for (ItemVenta item : items) {
            inventario.registrarMovimiento(Movimiento.Tipo.RETIRO, fecha, item.getProductIndex(), item.getCantidad());
        }
        this.cerrado = true;
    }
}
