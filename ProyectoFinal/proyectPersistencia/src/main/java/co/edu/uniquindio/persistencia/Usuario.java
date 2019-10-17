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

@NamedQueries({ @NamedQuery(name = Usuario.BUSCAR_POR_EMAIL, query = "select u from Usuario u where u.email = :email")
	            })

public class Usuario extends Persona implements Serializable {
	
	
	public static final String BUSCAR_POR_EMAIL = "BUSCAR_POR_EMAIL";
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	@OneToMany(mappedBy = "usuario")
	private List<Favorito> misFavoritos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Calificacion> misCalificaciones;
	
	@OneToMany(mappedBy = "usuario")
	private List<Comentario> misComentarios;
	
	@OneToMany(mappedBy = "usuario")
	private List<Compra> compras;
	
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	} 
   
}
