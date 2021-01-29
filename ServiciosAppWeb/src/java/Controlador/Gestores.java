
package Controlador;
import Modelo.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NotebookSFC
 */
public class Gestores {
    private Connection con;
    private String CONN="jdbc:sqlserver://localhost:1433;databaseName=PROYECTOPRUEBALABO";
    private String USER="sa";
    private String PASS="Oliver88$";
 
    
    //abrir conexion
    public void abrirConexion()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN,USER,PASS);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }    
    //cerrar conexion    
    public void cerrarConexion()
    {
        try 
        {
            if(con!=null && !con.isClosed())
                con.close();
        } 
        catch (SQLException exc) 
        {
        exc.printStackTrace();
        }
    }
    
    public Connection getConexion()
    {return con;}
    
    //obtener servicio
    public ArrayList<Servicio> obtenerServicio()
    {
        ArrayList<Servicio> lista = new ArrayList<>();
        try 
        {
        abrirConexion();
        Statement st = con.createStatement();
        String sql = "SELECT * FROM SERVICIOS ";
        PreparedStatement ps = con.prepareStatement(sql);           
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next())
        {
            int id = rs.getInt("idServicio");
            int idtipo = rs.getInt("idTipo");
            String descripcion = rs.getString("Descripcion");
            double costo = rs.getDouble("Costo");
            
            Tipo tipo = new Tipo(idtipo, descripcion);
            tipo.setIdTipo(id);
            
            lista.add(new Servicio(id,tipo,descripcion,costo));
        }
        rs.close();
        st.close();
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
       
    //obtener para el combo
  public ArrayList<Tipo> obtenerTipos(){
        ArrayList<Tipo> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            
            Statement st = con.createStatement();
            String query = "SELECT * FROM TIPO ";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("idTipo");
                String descripcion = rs.getString("Descripcion");
                Tipo v = new Tipo(id, descripcion);
                lista.add(v);
            }
            
            rs.close();
            st.close();
            con.close();
        
        } catch(SQLException exc) {
            Logger.getLogger(Gestores.class.getName()).log(Level.SEVERE, null, exc);
        } finally {
            cerrarConexion();
        }
        return lista;
    }



    
    
       //inserta servicio booleano
    public boolean insertarServicio (Servicio s)
    {
        boolean insert = false;
        try 
        {
        abrirConexion();
        String sql = "INSERT INTO SERVICIOS (idTipo, Descripcion, Costo) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, s.getTipo().getIdTipo());
        ps.setString(2,s.getDescripcion());
        ps.setDouble(3,s.getCosto());
        ps.execute();
        insert = true;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        finally
        {
        cerrarConexion();
        }
       return insert;
    }   
    
    
}
