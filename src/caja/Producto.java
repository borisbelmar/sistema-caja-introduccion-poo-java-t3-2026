package caja;

public class Producto {
    private String nombre;
    private int precio;
    private int stock;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
