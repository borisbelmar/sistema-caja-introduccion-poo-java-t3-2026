import caja.Inventario;
import caja.Movimiento;
import caja.Producto;
import caja.Venta;

public class Main {
    private void imprimirSeparador() {
        System.out.println("--------------------------------------------------");
    }
    public void main () {
        System.out.println("=============== Sistema de caja =============");
        Inventario inventario = new Inventario();

        inventario.imprimirInventario();
        inventario.imprimirMovimientos();

        imprimirSeparador();

        inventario.registrarProducto(new Producto("Producto A", 100));
        inventario.registrarProducto(new Producto("Producto B", 200));
        inventario.imprimirInventario();
        imprimirSeparador();
        inventario.registrarMovimiento(Movimiento.Tipo.INGRESO, "2024-06-01", 0, 10);
        inventario.registrarMovimiento(Movimiento.Tipo.INGRESO, "2024-06-01", 1, 5);
        inventario.imprimirInventario();
        imprimirSeparador();
        inventario.registrarMovimiento(Movimiento.Tipo.RETIRO, "2024-06-02", 0, 3);
        inventario.imprimirMovimientos();
        inventario.imprimirInventario();
        imprimirSeparador();
        Venta venta1 = new Venta("2024-06-02", inventario);
        venta1.sumarProducto(0, 2);
        venta1.sumarProducto(1, 1);
        venta1.imprimirDetalle();
        venta1.cerrarVenta();
        imprimirSeparador();
        inventario.imprimirInventario();
        inventario.imprimirMovimientos();
    }
}
