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

import pe.edu.upc.spring.model.TipoVia;
import pe.edu.upc.spring.service.ITipoViaService;

@Controller 	
@RequestMapping("/tipovia") //que atienda el controlador /race  (cuando hay muchos controladores), pero este no muestra nada, tiene q ir a bienvenido
public class TipoViaController {
	@Autowired
	private ITipoViaService tService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoTiposVias(Map<String, Object> model) {
		model.put("listaTiposVias", tService.listar());
		return "listTipoVia"; // "listRace" frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("tipovia", new TipoVia());
		return "tipovia"; // "race" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute TipoVia objTipoVia, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "tipovia";
		else {
			boolean flag = tService.grabar(objTipoVia);
			if (flag)
				return "redirect:/tipovia/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/tipovia/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<TipoVia> objTipoVia = tService.listarId(id);
		if (objTipoVia == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/tipovia/listar";
		}
		else {
			model.addAttribute("tipovia",objTipoVia);
			return "tipovia";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				tService.eliminar(id);
				model.put("listaTiposVias", tService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaTiposVias", tService.listar());
		}
		return "listTipoVia";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaTiposVias", tService.listar());
		return "listTipoVia";
	}
	
}
