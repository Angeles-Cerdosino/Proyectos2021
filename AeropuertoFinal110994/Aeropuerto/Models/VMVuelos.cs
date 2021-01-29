using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Aeropuerto.Models
{
    public class VMVuelos
    {
        public Vuelos VuelosModel { get; set; }
        public List<Destinos> Destinos { get; set; }
    }
}