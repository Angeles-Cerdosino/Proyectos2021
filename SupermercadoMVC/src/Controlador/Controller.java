/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import DTO.DTOProducto;
import Modelo.Oferta;
import java.sql.Statement;
import Modelo.Producto;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author NotebookSFC
 */
public class Controller 
{
    public  String CONN = "jdbc:sqlserver://KEYROLI-DESKTOP:1433;databaseName=Supermercado";
    private String USER = "se";
    private String PASS = "123456";
    
    //open conection
    private Connection con;

    private void abrirConexion()
    {
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(CONN,USER,PASS);
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
    public void agregarProducto(Producto p)
    {
        try 
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Producto (nombre) VALUES (?)");
            ps.setString(1,p.getNombre());
            ps.executeUpdate();
            ps.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();//It tells you what happened and where in the code this happened.
        }
        finally
        {
            cerrarConexion();
        }
    }

    //obtener producto
    public ArrayList<Producto> obtenerProducto()
    {
    ArrayList<Producto> lista = new ArrayList<Producto>();
        try
        {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Producto ");
            while(rs.next())
            {
                int id = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                
                Producto p = new Producto(id, nombre);
                lista.add(p);
                
            }
            rs.close();
            con.close();
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
    
    //agregar Oferta
    public void agregarOferta (Oferta o)
    {
        try 
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Oferta (idProducto, precioNormal, precioOferta, stockDisponible, fechaInicioOferta, diasVigencia) VALUES (?,?,?,?,?,?)");
            ps.setInt(1, o.getProducto().getIdProducto()); //llama la composicion de oferta con producto y al codigo que contiene producto
            ps.setDouble(2, o.getPrecioNormal());
            ps.setDouble(3, o.getPrecioOferta());
            ps.setInt(4, o.getStockDisponible());
            ps.setString(5, o.getFechaInicioOferta());
            ps.setInt(6, o.getDiasVigencia());
            
            ps.executeUpdate();
            ps.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();//It tells you what happened and where in the code this happened.
        }
        finally
        {
            cerrarConexion();
        }
    }
    
    //devolver ofertas
    public ArrayList<Oferta> obtenerOfertas()
    {
        ArrayList<Oferta> oferta = new ArrayList<Oferta>();
        try 
        {
         abrirConexion();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT o.idOferta, o.precioNormal, o.precioOferta, o.diasVigencia FROM Oferta o JOIN Producto p on p.idProducto=o.idProducto");
         while(rs.next())
            {
             int idOferta = rs.getInt("idOferta");             
             double precioNormal = rs.getDouble("precioNormal");
             double precioOferta = rs.getDouble("precioOferta");
             int diasVigencia = rs.getInt("diasVigencia");
             
             
              
             Producto prod = new Producto();
             //prod.setNombre(nombre);
             
             Oferta o = new Oferta();
            
             

            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();//It tells you what happened and where in the code this happened.
        }
        finally
        {
            cerrarConexion();
        }
        return oferta;
    }
    
    //total no ganado por producto ofertado
     public double totalNoGanadoPorProdOfertado(int idProducto)
     {
        double total = 0;
        String sql = "SELECT SUM ((precioNormal - precioOferta) * stockDisponible) FROM Oferta WHERE idProducto = ?";
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            rs.next();
            total = rs.getDouble(1);
            
            rs.close();
            con.close();
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return total;    
     }
     
     //cantidad de articulos ofertados mas de 5 dias
     public int CantidadArticulosOfertadosMas5Dias()
     {
        int cantidad = 0;
        String sql = "SELECT SUM (stockDisponible) FROM Oferta WHERE diasVigencia > 5";
        try
        {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cantidad = rs.getInt(1);
            rs.close();
            con.close();
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();                    
        }
        return cantidad;    
     }
     
     //obtener producto dto
     public ArrayList<DTOProducto> obtenerProductoDTO()
     {
         ArrayList<DTOProducto> lista = new ArrayList<DTOProducto>();
         try 
         {
           abrirConexion();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("SELECT p.nombre, o.precioNormal, o.precioOferta, o.diasVigencia FROM Producto p JOIN Oferta o ON p.idProducto=o.idProducto");
           while(rs.next())
           {
               String nombre = rs.getString("nombre");
               int precioNormal = rs.getInt("precioNormal");
               int precioOferta = rs.getInt("precioOferta");
               int diasVigenticia = rs.getInt("diasVigencia");
               DTOProducto producto = new DTOProducto(nombre, precioNormal, precioOferta, diasVigenticia);
               lista.add(producto);
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
