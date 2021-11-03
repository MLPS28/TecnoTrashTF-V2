package pe.edu.upc.spring.controller;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.model.Direccion;
import pe.edu.upc.spring.model.Reporte;

import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.IDireccionService;
import pe.edu.upc.spring.service.IReporteService;

@Controller

@RequestMapping("/reporte")

public class ReporteController {
	@Autowired
	private IUsuarioService uService;

	@Autowired
	private IDireccionService dService;

	@Autowired
	private IReporteService rService;	

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}

	@RequestMapping("/")
	public String irPaginaListadoReportes(Map<String, Object> model) {
		model.put("listaReportes", rService.listar());
		return "listReporte"; // "listPet" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("listaDirecciones", dService.listar());
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("reporte", new Reporte());
		return "reporte"; // "pet" es una pagina del frontEnd para insertar y/o modificar
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Reporte objReporte, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			{
				model.addAttribute("listaUsuarios", uService.listar());
				model.addAttribute("listaDirecciones", dService.listar());			
				return "reporte";
			}
		else {
			boolean flag = rService.grabar(objReporte);
			if (flag)
				return "redirect:/reporte/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un problema");
				return "redirect:/reporte/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Reporte> objReporte = rService.listarId(id);
		if (objReporte == null) 
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/reporte/listar";
		}
		else 
		{
			model.addAttribute("listaUsuarios", uService.listar());
			model.addAttribute("listaDirecciones", dService.listar());						
			if (objReporte.isPresent())
				objReporte.ifPresent(o -> model.addAttribute("reporte", o)); //o: es el objpet
			return "reporte";
		}
	}	

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {

			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaReportes", rService.listar());
			}
		}

		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaReportes", rService.listar());
		}
		return "listReporte";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaReportes", rService.listar());
		return "listReporte";
	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Reporte reporte ) 
	throws ParseException
	{
		rService.listarId(reporte.getCReporte());
		return "listReporte";
	}	

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("reporte", new Reporte());
		return "buscar";
	}	

	/*@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Reporte reporte ) 
	throws ParseException
	{
		List<Reporte> listaReportes;
		
		reporte.setTDescripcion(reporte.getTDescripcion()); //capturo lo que dijite en la cajita de texto
		
		listaReportes = rService.buscarDistrito(reporte.getTDescripcion());
		
		/*if (listaMascotas.isEmpty()) {
			listaMascotas = pService.buscarPropietario(pet.getNamePet());
		}
		
		if (listaMascotas.isEmpty()) {
			listaMascotas = pService.buscarRaza(pet.getNamePet());
		} 
		
		if (listaReportes.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaReportes", listaReportes);
		
		return "buscar";
	}	*/
	
	
}