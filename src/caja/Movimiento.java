package caja;

public class Movimiento {
    public enum Tipo {
        INGRESO,
        RETIRO
    }

    private Tipo tipo;
    private String fecha;
    private int productoIndex;
    private int cantidad;

    public Movimiento(Tipo tipo, String fecha, int productoIndex, int cantidad) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.productoIndex = productoIndex;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getProductoIndex() {
        return productoIndex;
    }

    public void setProductoIndex(int productoIndex) {
        this.productoIndex = productoIndex;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}