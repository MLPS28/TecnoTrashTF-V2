package pe.edu.upc.spring.controller;

import java.util.List;
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

import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.model.TipoVia;
import pe.edu.upc.spring.model.Direccion;

import pe.edu.upc.spring.service.IDistritoService;
import pe.edu.upc.spring.service.ITipoViaService;
import pe.edu.upc.spring.service.IDireccionService;

@Controller

@RequestMapping("/direccion")

public class DireccionController {
	@Autowired
	private IDistritoService dService;

	@Autowired
	private ITipoViaService tService;

	@Autowired
	private IDireccionService diService;	

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}

	@RequestMapping("/")
	public String irPaginaListadoDirecciones(Map<String, Object> model) {
		model.put("listaDirecciones", diService.listar());
		return "listDireccion"; // "listPet" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaDistritos", dService.listar());
		model.addAttribute("listaTiposVias", tService.listar());
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("distrito", new Distrito());
		model.addAttribute("tipovia", new TipoVia());
		return "direccion"; // "pet" es una pagina del frontEnd para insertar y/o modificar
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Direccion objDireccion, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			{
				model.addAttribute("listaDistritos", dService.listar());
				model.addAttribute("listaTiposVias", tService.listar());			
				return "direccion";
			}
		else {
			boolean flag = diService.grabar(objDireccion);
			if (flag)
				return "redirect:/direccion/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un problema");
				return "redirect:/direccion/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Direccion> objDireccion = diService.listarId(id);
		if (objDireccion == null) 
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/direccion/listar";
		}
		else 
		{
			model.addAttribute("listaDistritos", dService.listar());
			model.addAttribute("listaTiposVias", tService.listar());						
			if (objDireccion.isPresent())
				objDireccion.ifPresent(o -> model.addAttribute("direccion", o)); //o: es el objpet
			return "direccion";
		}
	}	

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {

			if (id!=null && id>0) {
				diService.eliminar(id);
				model.put("listaDirecciones", diService.listar());
			}
		}

		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDirecciones", diService.listar());
		}
		return "listDireccion";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaDirecciones", diService.listar());
		return "listDireccion";
	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Direccion direccion ) 
	throws ParseException
	{
		diService.listarId(direccion.getCDireccion());
		return "listDireccion";
	}	

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("direccion", new Direccion());
		return "buscar";
	}	

	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Direccion direccion ) 
	throws ParseException
	{
		List<Direccion> listaDirecciones;
		
		direccion.setNDireccion(direccion.getNDireccion()); //capturo lo que dijite en la cajita de texto
		
		listaDirecciones = diService.buscarDistrito(direccion.getNDireccion());
		
		/*if (listaMascotas.isEmpty()) {
			listaMascotas = pService.buscarPropietario(pet.getNamePet());
		}
		
		if (listaMascotas.isEmpty()) {
			listaMascotas = pService.buscarRaza(pet.getNamePet());
		} */
		
		if (listaDirecciones.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaDirecciones", listaDirecciones);
		
		return "buscar";
	}	
	
	
}