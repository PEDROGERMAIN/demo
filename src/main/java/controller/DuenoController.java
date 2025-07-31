package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Dueno;
import services.DuenoService;

@Controller
@RequestMapping("/dueno")
public class DuenoController {
	
	@Autowired
	private DuenoService duenoService;
	
	@GetMapping
	public String listaDueno (Model model) {
	
		List<Dueno>  listaDueno = duenoService.obtenerDueno();
	
		model.addAttribute("duenoLista", listaDueno);
		
		return "Listar";
		
	}
	
	@GetMapping("/duenoById")
	public String duenoById (@RequestParam String usuario, @RequestParam String password, Model model) {
		Dueno dueno = duenoService.obtenerDueno(usuario, password);
		model.addAttribute("dueno", dueno);
		return "consulta_dueno";
	}
	
	@PostMapping("/guardar")
	public String guardarDueno(@ModelAttribute Dueno dueno) {
		duenoService.guardarDueno(dueno); // Llama al servicio para guardar el dueño
	    return "redirect:/Dueno"; // Redirige al listado después de guardar
	}

}
