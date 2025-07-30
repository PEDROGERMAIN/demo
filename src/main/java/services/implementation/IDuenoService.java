package services.implementation;

import java.util.List;

import entities.Dueno;

public interface IDuenoService  {
	
	List<Dueno> obtenerDueno();
	
	Dueno obtenerDueno(Integer id);
	

}
