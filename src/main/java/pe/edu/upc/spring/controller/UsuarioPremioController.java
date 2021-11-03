package pe.edu.upc.spring.controller;

//import java.util.List;
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

import pe.edu.upc.spring.model.Premio;
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.model.UsuarioPremio;

import pe.edu.upc.spring.service.IPremioService;
import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.IUsuarioPremioService;

@Controller

@RequestMapping("/usuariopremio")

public class UsuarioPremioController {
	@Autowired
	private IPremioService pService;

	@Autowired
	private IUsuarioService uService;

	@Autowired
	private IUsuarioPremioService upService;	

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}

	@RequestMapping("/")
	public String irPaginaListadoUsuariosPremios(Map<String, Object> model) {
		model.put("listaUsuariosPremios", upService.listar());
		return "listUsuarioPremio"; // "listPet" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaPremios", pService.listar());
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("usuariopremio", new UsuarioPremio());
		model.addAttribute("premio", new Premio());
		model.addAttribute("usuario", new Usuario());
		return "usuariopremio"; // "pet" es una pagina del frontEnd para insertar y/o modificar
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute UsuarioPremio objUsuarioPremio, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			{
				model.addAttribute("listaPremios", pService.listar());
				model.addAttribute("listaUsuarios", uService.listar());			
				return "usuariopremio";
			}
		else {
			boolean flag = upService.grabar(objUsuarioPremio);
			if (flag)
				return "redirect:/usuariopremio/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un problema");
				return "redirect:/usuariopremio/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<UsuarioPremio> objUsuarioPremio = upService.listarId(id);
		if (objUsuarioPremio == null) 
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/usuariopremio/listar";
		}
		else 
		{
			model.addAttribute("listaPremios", pService.listar());
			model.addAttribute("listaUsuarios", uService.listar());						
			if (objUsuarioPremio.isPresent())
				objUsuarioPremio.ifPresent(o -> model.addAttribute("usuariopremio", o)); //o: es el objpet
			return "usuariopremio";
		}
	}	

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {

			if (id!=null && id>0) {
				upService.eliminar(id);
				model.put("listaUsuariosPremios", upService.listar());
			}
		}

		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaUsuariosPremios", upService.listar());
		}
		return "listUsuarioPremio";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaUsuariosPremios", upService.listar());
		return "listUsuarioPremio";
	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute UsuarioPremio usuariopremio ) 
	throws ParseException
	{
		upService.listarId(usuariopremio.getCUsuarioPremio());
		return "listUsuarioPremio";
	}	

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("usuariopremio", new UsuarioPremio());
		return "buscar";
	}	

	/*@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute UsuarioPremio usuariopremio ) 
	throws ParseException
	{
		List<UsuarioPremio> listaUsuariosPremios;
		
		//usuariopremio.setUsuario(usuariopremio.getUsuario()); //capturo lo que dijite en la cajita de texto
		
		//listaUsuariosPremios = upService.buscarUsuario(usuariopremio.getUsuario());
		
		/*if (listaMascotas.isEmpty()) {
			listaMascotas = pService.buscarPropietario(pet.getNamePet());
		}
		
		if (listaMascotas.isEmpty()) {
			listaMascotas = pService.buscarRaza(pet.getNamePet());
		} */
		
		/*if (listaUsuariosPremios.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaUsuariosPremios", listaUsuariosPremios);
		
		return "buscar";
	}	*/
	
}