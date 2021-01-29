using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Aeropuerto.Models
{
    public class Vuelos
    {
        public int IdVuelos { get; set; }
        public string Observaciones { get; set; }
        public int IdDestino { get; set; }
        public int Tipo { get; set; }
        public float Precio { get; set; }
        public DateTime Fecha { get; set; }
}
}