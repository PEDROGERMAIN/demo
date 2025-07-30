package entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_paciente")
	private int id_paciente;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="id_dueno", nullable = false)
	private Dueno dueno;
	 
	@ManyToOne
	@JoinColumn(name="id_especie", nullable = false)
	private TipoEspecie tipoEspecie;
	
	@Column(name="fecha_nacimiento")
	private LocalDateTime fecha_nacimiento;

	
	@Lob
	@Column(name = "foto")
	private byte[] foto;

}
