package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Dueno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dueno {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_dueno")
	int  id_dueno;
	
	@Column(name = "nombre", nullable = false, length = 100)
	String nombre;
	
	@Column(name = "telefono", length = 20)
	String telefono;
	
	@Column(name = "direccion", length = 255)
	String direccion;
	
	@Column(name = "usuario", length = 50)
	String usuario;
	
	@Column(name = "password", length = 255)
	String password;
	
	public Dueno(String nombre, String telefono, String direccion, String usuario, String password) {
	    this.nombre = nombre;
	    this.telefono = telefono;
	    this.direccion = direccion;
	    this.usuario = usuario;
	    this.password = password;
	}


}
