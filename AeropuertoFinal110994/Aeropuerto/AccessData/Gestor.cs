using Aeropuerto.DTO;
using Aeropuerto.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Aeropuerto.AccessData
{
    public class Gestor
    {
        //INSERTAR NUEVO
        public static bool InsertarNuevo(Vuelos v)
        {
            bool resultado = false;
            SqlConnection conex = new SqlConnection("Data Source=138.99.7.66;Initial Catalog=TUP_VUELOS;User ID=tup_final;Password=@tup_prog3");
            try
            {
                SqlCommand comando = new SqlCommand();
                string SQL = "INSERT INTO Vuelos VALUES (@Observaciones, @IdDestino, @Tipo, @Precio, @Fecha)";
                comando.Parameters.Clear();
                //comando.Parameters.AddWithValue("@Id", v.IdVuelos);
                comando.Parameters.AddWithValue("@Observaciones", v.Observaciones);
                comando.Parameters.AddWithValue("@IdDestino", v.IdDestino);
                comando.Parameters.AddWithValue("@Tipo", v.Tipo);
                comando.Parameters.AddWithValue("@Precio", v.Precio);
                comando.Parameters.AddWithValue("@Fecha", v.Fecha);


                comando.CommandType = System.Data.CommandType.Text;
                comando.CommandText = SQL;
                conex.Open();
                comando.Connection = conex;
                comando.ExecuteNonQuery();
                resultado = true;
            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                conex.Close();
            }
            return resultado;

        }

        //Select para destinos, combo
        public List<Destinos> ObtenerDestinos()
        {
            List<Destinos> lista = new List<Destinos>();
            SqlConnection conex = new SqlConnection("Data Source=138.99.7.66;Initial Catalog=TUP_VUELOS;User ID=tup_final;Password=@tup_prog3");

            try
            {
                SqlCommand comand = new SqlCommand();
                string SQL = "SELECT * FROM Destinos ";
                comand.Parameters.Clear();
                comand.CommandType = System.Data.CommandType.Text;
                comand.CommandText = SQL;

                conex.Open();
                comand.Connection = conex;

                SqlDataReader dr = comand.ExecuteReader();
                if (dr != null)
                {
                    while (dr.Read())
                    {
                        Destinos d = new Destinos();
                        d.IdDestino = int.Parse(dr["Id"].ToString());
                        d.Nombre = dr["Nombre"].ToString();
                        lista.Add(d);
                    }
                }
            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                conex.Close();
            }
            return lista;
        }

        //lista Vuelos
        public static List<Vuelos> ListaVuelos()
        {
            List<Vuelos> lista = new List<Vuelos>();
            SqlConnection conex = new SqlConnection("Data Source=138.99.7.66;Initial Catalog=TUP_VUELOS;User ID=tup_final;Password=@tup_prog3");

            try
            {
                SqlCommand comando = new SqlCommand();
                string SQL = "SELECT * FROM Vuelos ";
                comando.Parameters.Clear();
                comando.CommandType = System.Data.CommandType.Text;
                comando.CommandText = SQL;

                conex.Open();
                comando.Connection = conex;

                SqlDataReader dr = comando.ExecuteReader();
                if (dr != null)
                {
                    while (dr.Read())
                    {
                        Vuelos v = new Vuelos();
                        v.IdVuelos = int.Parse(dr["Id"].ToString());
                        v.Observaciones = dr["Observaciones"].ToString();
                        v.IdDestino = int.Parse(dr["IdDestino"].ToString());
                        v.Tipo = int.Parse(dr["Tipo"].ToString());
                        v.Precio = float.Parse(dr["Precio"].ToString());
                        v.Fecha = DateTime.Parse(dr["Fecha"].ToString());

                        lista.Add(v);
                    }
                }
            }
            catch (Exception)
            {

            }
            finally
            {
                conex.Close();
            }
            return lista;
        }

        //para editar
        public static Vuelos BuscarVuelos(int id)
        {

            Vuelos v = new Vuelos();
            SqlConnection conex = new SqlConnection("Data Source=138.99.7.66;Initial Catalog=TUP_VUELOS;User ID=tup_final;Password=@tup_prog3");
            try
            {
                SqlCommand comando = new SqlCommand();
                var sql = "SELECT * FROM Vuelos WHERE Id = @Id ";

                comando.Parameters.Clear();
                comando.Parameters.AddWithValue("@Id", id);

                comando.CommandType = System.Data.CommandType.Text;
                comando.CommandText = sql;

                conex.Open();
                comando.Connection = conex;

                SqlDataReader dr = comando.ExecuteReader();

                if (dr != null)
                {
                    while (dr.Read())
                    {
                        v.IdVuelos = int.Parse(dr["Id"].ToString());
                        v.Observaciones = dr["Observaciones"].ToString();
                        v.IdDestino = int.Parse(dr["IdDestino"].ToString());
                        v.Tipo = int.Parse(dr["Tipo"].ToString());
                        v.Precio = float.Parse(dr["Precio"].ToString());
                        v.Fecha = DateTime.Parse(dr["Fecha"].ToString());
                    }
                }
            }

            catch (Exception)
            {
                throw;
            }
            finally
            {
                conex.Close();
            }
            return v;
        }

        //UPDATE
        public static bool ActualizarVuelos(Vuelos v)
        {
            bool resultado = false;
            SqlConnection conex = new SqlConnection("Data Source=138.99.7.66;Initial Catalog=TUP_VUELOS;User ID=tup_final;Password=@tup_prog3");

            try
            {
                SqlCommand comando = new SqlCommand();
                string consulta = "UPDATE Vuelos SET Observaciones= @observaciones, IdDestino= @idDestino, Tipo= @tipo, Precio= @precio, Fecha= @fecha WHERE Id = @id"; /*parameter*/
                comando.Parameters.Clear();
                comando.Parameters.AddWithValue("@observaciones", v.Observaciones);
                comando.Parameters.AddWithValue("@idDestino", v.IdDestino);
                comando.Parameters.AddWithValue("@tipo", v.Tipo);
                comando.Parameters.AddWithValue("@precio", v.Precio);
                comando.Parameters.AddWithValue("@fecha", v.Fecha);
                comando.Parameters.AddWithValue("@id", v.IdVuelos);


                comando.CommandType = System.Data.CommandType.Text;
                comando.CommandText = consulta;

                conex.Open();
                comando.Connection = conex;
                comando.ExecuteNonQuery();
                resultado = true;
            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                conex.Close();
            }
            return resultado;
        }


        //report CantidadVuelosCargados
        public static int ObtenerCantidadVuelosCargados()
        {
            int resultado = 0;
            SqlConnection conex = new SqlConnection("Data Source=138.99.7.66;Initial Catalog=TUP_VUELOS;User ID=tup_final;Password=@tup_prog3");

            try
            {
                SqlCommand comando = new SqlCommand();
                string consulta = @"SELECT COUNT(*) 'CantidadVuelosCargados' FROM Vuelos";

                comando.Parameters.Clear();
                comando.CommandType = System.Data.CommandType.Text;
                comando.CommandText = consulta;

                conex.Open();
                comando.Connection = conex;
                SqlDataReader dr = comando.ExecuteReader();

                if (dr != null)
                {
                    while (dr.Read())
                    {
                        resultado = int.Parse(dr["CantidadVuelosCargados"].ToString());
                    }
                }
            }
            catch (Exception)
            {
                //throw;
            }
            finally
            {
                conex.Close();
            }
            return resultado;
        }

        //reporte cant CantidadVuelosDestino
        public static List<ReportesDTO> ObtenerCantidadVuelosDestino()
        {
            List<ReportesDTO> resultados = new List<ReportesDTO>();

            SqlConnection conex = new SqlConnection("Data Source=138.99.7.66;Initial Catalog=TUP_VUELOS;User ID=tup_final;Password=@tup_prog3");

            try
            {
                SqlCommand comando = new SqlCommand();
                string consulta = @"Select D.Nombre, COUNT(V.Id) 'CantidadVuelosDestino' 
                                     FROM Vuelos V join Destinos D on V.IdDestino = D.Id GROUP BY D.Nombre ";

                comando.Parameters.Clear();
                comando.CommandType = System.Data.CommandType.Text;
                comando.CommandText = consulta;

                conex.Open();
                comando.Connection = conex;
                SqlDataReader dr = comando.ExecuteReader();

                if (dr != null)
                {
                    while (dr.Read())
                    {
                        ReportesDTO reporte = new ReportesDTO();
                        reporte.Nombre = dr["Nombre"].ToString();
                        reporte.CantidadVuelosDestino = int.Parse(dr["CantidadVuelosDestino"].ToString());
                        resultados.Add(reporte);
                    }
                }
            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                conex.Close();
            }
            return resultados;

        }
    }
}