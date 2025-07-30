package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Dueno;
import repository.IDuenoRepository;
import services.implementation.IDuenoService;

@Service
public class DuenoService implements IDuenoService{

	@Autowired
	private IDuenoRepository duenoRepository;
	
	@Override
	public List<Dueno> obtenerDueno() {
		return duenoRepository.findAll();
	}

	@Override
	public Dueno obtenerDueno(Integer id) {
		return duenoRepository.findById(id).orElse(null);
	}

	public void guardarDueno(Dueno dueno) {
		duenoRepository.save(dueno);	
	}

}
