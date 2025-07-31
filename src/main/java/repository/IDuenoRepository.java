package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.Dueno;

@Repository
public interface IDuenoRepository extends JpaRepository<Dueno, Integer>{
	
	
	@Query("SELECT d FROM  Dueno d WHERE d.usuario =: usuario AND d.password =: password")
	public Optional<Dueno> findByUsuarioAndPassword(@Param("usuario") String  usuario,@Param("password") String password);
	
	
}