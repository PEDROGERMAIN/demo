package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import entities.EstadoCita;
import jakarta.validation.Valid;
import services.EstadoCitaService;

@Controller
@RequestMapping("/EstadoCita")
public class EstadoCitaController {


	@Autowired
	private EstadoCitaService estadoCitaService;
	
	
	@GetMapping("/buscarId/{id}")
	public String buscarById (@PathVariable Integer id,   Model model) {
		
		EstadoCita estadoCita = estadoCitaService.obtenerEstadoCita(id);
		
		model.addAttribute("estadoByID", estadoCita);
	
		return "Listar_estdo_cita";
	}
	
	@GetMapping("/buscarIdRest/{id}")
	public EstadoCita buscarById (@PathVariable Integer id) {
		
		return estadoCitaService.obtenerEstadoCita(id);
		
	}
	
	@PostMapping("/guardar")
	public String guardarEstadoCita (@Valid @ModelAttribute EstadoCita estadoCita, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formulario_estado_cita";
		} 

		estadoCitaService.guardarEstadoCita(estadoCita);
		return "formulario_estado_cita";
	}
			
	
	@PostMapping("/guardarRest1")
	public void guardarEstadoCitaRest (@Valid @RequestBody EstadoCita estadoCita ) {
		estadoCitaService.guardarEstadoCita(estadoCita);
	}
	
	
	
	
	@PostMapping("/guardarRest2")
	public ResponseEntity<?>  guardarEstadoCita1 (@Valid @RequestBody EstadoCita estadoCita, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			bindingResult.getFieldErrors().forEach(e -> errores.put(e.getField(), e.getDefaultMessage()));
			return ResponseEntity.badRequest().body(errores);
		} 
		
		estadoCitaService.guardarEstadoCita(estadoCita);
		return ResponseEntity.ok("OK");
		
	}


}
