package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.EstadoCita;
import repository.IEstadoCitaRepository;
import services.implementation.IEstadoCitaService;

@Service
public class EstadoCitaService implements IEstadoCitaService{

	
	@Autowired
	private IEstadoCitaRepository estadoCitaRepository;
	
	@Override
	public EstadoCita obtenerEstadoCita ( Integer id) {
		return estadoCitaRepository.findById(id).orElse(null);
	}
	
	@Override
	public void guardarEstadoCita (EstadoCita estadoCita) {
		
		estadoCitaRepository.save(estadoCita);
	}
}
