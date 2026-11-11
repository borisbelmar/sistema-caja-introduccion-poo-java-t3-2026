package caja;

public class ItemVenta {
    private int productIndex;
    private int cantidad;

    public ItemVenta(int productIndex, int cantidad) {
        this.productIndex = productIndex;
        this.cantidad = cantidad;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(int productIndex) {
        this.productIndex = productIndex;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
