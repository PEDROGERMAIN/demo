package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Dueno;

@Repository
public interface IDuenoRepository extends JpaRepository<Dueno, Integer>{

	
}