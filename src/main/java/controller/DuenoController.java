package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entities.Dueno;
import services.DuenoService;

@Controller
@RequestMapping("/Dueno")
public class DuenoController {
	
	@Autowired
	private DuenoService duenoServicre;
	
	@GetMapping
	public String listaDueno (Model model) {
	
		List<Dueno>  listaDueno = duenoServicre.obtenerDueno();
	
		model.addAttribute("duenoLista", listaDueno);
		
		return "Listar";
		
	}
	
	@PostMapping("/guardar")
	public String guardarDueno(@ModelAttribute Dueno dueno) {
	    duenoServicre.guardarDueno(dueno); // Llama al servicio para guardar el dueño
	    return "redirect:/Dueno"; // Redirige al listado después de guardar
	}

}
