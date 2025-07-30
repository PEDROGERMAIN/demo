package entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Tipo_Especie")
public class TipoEspecie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_especie")
	private int id_especie;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

}
