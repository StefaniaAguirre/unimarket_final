package co.edu.uniquindio.persistencia;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: usuario
 * Pueden haber varios usuarios y cada uno depende de ser vendedor o comprador
 */
@Entity
@Table(name = "Usuarios")
public class Usuario extends Persona implements Serializable {
	
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	@OneToMany(mappedBy = "usuario")
	private List<Favorito> misFavoritos;
	
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	} 
   
}
