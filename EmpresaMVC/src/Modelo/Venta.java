
package Modelo;


public class Venta {
    private int id;
    private String cliente;
    private int cantidad;
    private ProductoModel Producto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoModel getProducto() {
        return Producto;
    }

    public void setProducto(ProductoModel Producto) {
        this.Producto = Producto;
    }

    public Venta(int id, String cliente, int cantidad, ProductoModel Producto) {
        this.id = id;
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.Producto = Producto;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", cliente=" + cliente + ", cantidad=" + cantidad + ", Producto=" + Producto + '}';
    }
    
    
    
}
