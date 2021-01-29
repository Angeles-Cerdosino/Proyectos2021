
using Aeropuerto.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Aeropuerto.Models
{
    public class ReportesVM
    {
        public List<ReportesDTO> Reportes { get; set; }
        public int CantidadVuelosCargados { get; set; }
    }
}