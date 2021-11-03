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

import pe.edu.upc.spring.model.Premio;
import pe.edu.upc.spring.service.IPremioService;

@Controller 	
@RequestMapping("/premio") //que atienda el controlador /race  (cuando hay muchos controladores), pero este no muestra nada, tiene q ir a bienvenido
public class PremioController {
	@Autowired
	private IPremioService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPremios(Map<String, Object> model) {
		model.put("listaPremios", pService.listar());
		return "listPremio"; // "listRace" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("premio", new Premio());
		return "premio"; // "race" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Premio objPremio, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "premio";
		else {
			boolean flag = pService.grabar(objPremio);
			if (flag)
				return "redirect:/premio/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un problema");
				return "redirect:/premio/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Premio> objPremio = pService.listarId(id);
		if (objPremio == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/premio/listar";
		}
		else {
			model.addAttribute("premio",objPremio);
			return "premio";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaPremios", pService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPremios", pService.listar());
		}
		return "listPremio";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaPremios", pService.listar());
		return "listPremio";
	}
	
}
