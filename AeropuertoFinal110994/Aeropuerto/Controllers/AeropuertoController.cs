using Aeropuerto.AccessData;
using Aeropuerto.DTO;
using Aeropuerto.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Aeropuerto.Controllers
{
    public class AeropuertoController : Controller
    {
        // GET: Aeropuerto
        public ActionResult Index()
        {
            return View();
        }

        //GET: Alta Vuelos
        public ActionResult Alta()
        {
            Gestor gestor = new Gestor();
            VMVuelos vm = new VMVuelos();
            vm.Destinos = gestor.ObtenerDestinos();
            return View(vm);

        }

        //POST Vuelos
        [HttpPost]
        public ActionResult Alta(VMVuelos vmv)
        {
            Gestor gestor = new Gestor();
            //if (ModelState.IsValid)
            //{
                bool resultado = Gestor.InsertarNuevo(vmv.VuelosModel);
                if (resultado)
                {
                    return RedirectToAction("Lista", "Aeropuerto");
                }
                else
                {
                    return View(vmv);
                }
            //}
            //else
            //{
            //    vmv.Destinos = gestor.ObtenerDestinos(); //cuando la vista vuelve a cargar el dropdownlistfor, carga las id de destinos pero nos los values, para eso le vuelvo a mandar la lista
            //    return View(vmv);
            //}
        }

        //GET LISTA Vuelos
        public ActionResult Lista()
        {
            List<Vuelos> lista = Gestor.ListaVuelos();
            return View(lista);
        }

        //GET DE EDITAR
        //public ActionResult Editar(int id)
        //{
        //    Gestor gestor = new Gestor();
        //    var vuelos = gestor.BuscarVuelos(id);
        //    return View(vuelos);
        //}

        public ActionResult Editar(int id)
        {
            Gestor gestor = new Gestor();
            List<Destinos> itemsDestino = gestor.ObtenerDestinos();
            List<SelectListItem> itemsCombo = itemsDestino.ConvertAll(d =>
            {
                return new SelectListItem()
                {
                    Text = d.Nombre,
                    Value = d.IdDestino.ToString(),
                    Selected = false,
                };
            });

            Vuelos v = Gestor.BuscarVuelos(id); //ver aqui
            foreach (var item in itemsCombo)
            {
                if (item.Value.Equals(v.IdDestino.ToString()))
                {
                    item.Selected = true;
                    break; //para que corte la iteracion del for porque no tiene sentido q continue con los otros porque es un solo item que tengo que marcar en mi combo
                }
            }
            ViewBag.items = itemsCombo; //guarda la info

            ViewBag.Nombre = v.Observaciones;
            return View(v);
        }

        //editar
        [HttpPost]
        public ActionResult DatosPersona(Vuelos vm)
        {
            if (ModelState.IsValid)
            {
                bool resultado = Gestor.ActualizarVuelos(vm);
                if (resultado)
                {
                    return RedirectToAction("Lista", "Aeropuerto");
                }
                else
                {
                    return View(vm);
                }
            }
            return View();
        }

        ////GET de REPORTES
        public ActionResult Reportes()
        {
            List<ReportesDTO> reportes = AccessData.Gestor.ObtenerCantidadVuelosDestino();

            int CantidadVuelosCargados = AccessData.Gestor.ObtenerCantidadVuelosCargados();
           
            ReportesVM vmrepo = new ReportesVM();
            vmrepo.Reportes = reportes;
            vmrepo.CantidadVuelosCargados = CantidadVuelosCargados;

            return View(vmrepo);

        }

    }
}