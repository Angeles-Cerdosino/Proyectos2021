 
package Controlador;
import java.sql.*;
import java.sql.Statement;
import Modelo.ProductoModel;
import Modelo.Venta;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import DTO.DTOReporte;
import DTO.DTOVenta;
import DTO.DTOVentaFiltro;



public class ProductoController {
    public  String CONN = "jdbc:sqlserver://DESKTOP:1433;databaseName=EMPRESA";
    private String USER = "se";
    private String PASS = "123456";
    
    //open conection
    private Connection con;
    
    //abrir conexion
    private void abrirConexion()
    {
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(CONN, USER, PASS);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
    
    //cerrar conexion    
    private void cerrarConexion()
    {
        try 
        {
            if(con!=null && !con.isClosed())
                con.close();
        } 
        catch (Exception exc) 
        {
        exc.printStackTrace();
        }
    }
    
        //agregar producto
    public void agregarProducto(ProductoModel p){
  
        try {
            
            abrirConexion();            
            PreparedStatement st = con.prepareStatement("INSERT INTO Productos (nombre, precio) VALUES (?,?)");
            st.setString(1,p.getNombre());
            st.setDouble(2,p.getPrecio());
            
            st.executeUpdate();
            st.close();                     
            
            } 
        catch (Exception ex)     
            {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE,null,ex);

            }
            finally
            {
                cerrarConexion();
            }
        
    }

    //obtener producto
    public ArrayList<ProductoModel> obtenerProducto ()
    {
        ArrayList<ProductoModel> lista = new ArrayList<ProductoModel>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Productos");
            while (rs.next())
            {
                int id = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                
                ProductoModel prod = new ProductoModel();
                prod.setCodigo(id);
                prod.setNombre(nombre);
                prod.setPrecio(precio);
                lista.add(prod);
            }
            
            rs.close();          
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();;
        } 
        finally
        {
            cerrarConexion();
        }
        return lista;
    }
    
    
    //agregar la venta
    public void agregarVenta(Venta v){
  
        try {            
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO Ventas (cliente, cantidad, idProducto) VALUES (?,?,?)");
            st.setString(1,v.getCliente());
            st.setInt(2,v.getCantidad());
            st.setInt(3,v.getProducto().getCodigo());
            
            st.executeUpdate();
            st.close();
                      
            
        } catch (Exception e) 
        {
            e.printStackTrace();
         
        }
        finally
        {
            cerrarConexion();
        }
        
    }
    
    //metodo para devolver ventas
    public ArrayList<Venta> obtenerVentas ()
    {
        ArrayList<Venta> lista = new ArrayList<Venta>();        
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT v.idVenta, v.cliente, v.cantidad, p.nombre, p.precio * FROM Ventas v JOIN Productos p on v.idProducto=p.idProducto");
            while (rs.next())
            {
                int idVenta = rs.getInt("idVenta"); //por cada uno de los items que me trae la consulta
                String nombreProducto = rs.getString("nombre");
                double precioProducto = rs.getDouble("precio");
                String cliente = rs.getString("cliente");
                int cantidad = rs.getInt("cantidad");
                
                ProductoModel prod = new ProductoModel();
                prod.setNombre(nombreProducto);
                prod.setPrecio(precioProducto);
                
                Venta v = new Venta(idVenta, cliente, cantidad, prod);
                lista.add(v);
            }           
            rs.close();            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();;
        } 
        finally
        {
            cerrarConexion();
        }    
        return lista;
    }
    
    //obtener venta de reporte DTO
    public ArrayList<DTOVenta> obtenerVentasDTO()
    {
        ArrayList<DTOVenta> lista = new ArrayList<DTOVenta>();
        try 
            {
                abrirConexion();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery ("SELECT v.idVenta, v.cliente, v.cantidad, p.nombre, p.precio FROM Ventas v JOIN Productos p ON v.idProducto = p.idProducto"); 
                while (rs.next())
                {
                    int idVenta = rs.getInt("idVenta");
                    String nombreProducto = rs.getString("nombre");
                    double precioProducto = rs.getDouble("precio");
                    String cliente = rs.getString("cliente");
                    int cantidad = rs.getInt("cantidad");
                    DTOVenta venta = new DTOVenta(cliente, cantidad, nombreProducto, precioProducto);
                    lista.add(venta);
                }
                rs.close();

            } 
        catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
        finally
            {
            cerrarConexion();
            }
        return lista;
    }
    
    //cantidad de ventas por producto, con DTO reportes
    public ArrayList<DTOReporte> cantidadVtasPorProducto()
    {
        ArrayList<DTOReporte> lista = new ArrayList<DTOReporte>();
        try 
        {
         abrirConexion();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT COUNT (*) 'Cantidad', nombre 'Producto' \n" + 
                                        "FROM Ventas V JOIN Productos P ON V.idProducto = p.idProducto \n" + 
                                        "GROUP BY nombre");
         while(rs.next())
         {
             int cantidad = rs.getInt("Cantidad");
             String nombre = rs.getString("Producto");
             
             DTOReporte reporte = new DTOReporte(nombre, cantidad);
             lista.add(reporte);
         }
         rs.close();
        } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        finally
        {
            cerrarConexion();
        }
        return lista;
    }
    
    //facturacion total
    public double facturacionTotal()
    {
        double facturacion =0;
        try 
        {
         abrirConexion();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT SUM (V.cantidad * P.precio)\n" + 
                                        "FROM Ventas V JOIN Productos P ON P.idProducto = p.idProducto");
        rs.next();
        facturacion = rs.getDouble(1);
        rs.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return facturacion;
    }
    
    //venta de mayor cantidad de productos
    public DTOVenta ventaMayorCantidadDeProductos()
    {
        DTOVenta venta = null;
        try 
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT TOP 1 V.cliente, V.cantidad, P.nombre, P.precio \n" + 
                                            "FROM Ventas V JOIN Productos P ON V.idProducto = P.idProducto \n" + 
                                            "ORDER BY cantidad DESC");
        rs.next();
        
        String cliente = rs.getString("cliente");
        int cantidad = rs.getInt("cantidad");
        String producto = rs.getString("nombre");
        double precio = rs.getDouble("precio");
        
        venta = new DTOVenta(cliente, cantidad, producto, precio);
        rs.close();
        
        
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        
        return venta;
    }

    //obtener ventas por filtro
    public ArrayList<DTOVentaFiltro> VentasPorFiltroImporteTotal (double importe)
    {
        ArrayList<DTOVentaFiltro> lista = new ArrayList<DTOVentaFiltro>();
        try 
        {
           abrirConexion();
           String sql = "select v.cliente, p.nombre, v.cantidad * p.precio 'importe'\n" +
                                            "FROM Ventas v JOIN Productos p ON v.codProducto = p.codigo\n" +
                                            "WHERE v.cantidad * p.precio > ? \n" +
                                            "order by 3 desc";
           PreparedStatement st = con.prepareStatement(sql);
           st.setDouble(1, importe);
           ResultSet rs = st.executeQuery();
           while(rs.next())
           {
               String nombreProducto = rs.getString("nombre");
               double importeVenta = rs.getDouble("importe");
               String cliente = rs.getString("cliente");
               DTOVentaFiltro filtro = new DTOVentaFiltro(cliente, nombreProducto, importeVenta);
               lista.add(filtro);
           }
           rs.close();
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return lista;
    }
    
    
    
    
    
}
