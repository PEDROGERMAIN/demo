package services.implementation;

import entities.EstadoCita;

public interface IEstadoCitaService {

	
	public EstadoCita obtenerEstadoCita ( Integer id);
	
	public void guardarEstadoCita (EstadoCita estadoCita);

}
