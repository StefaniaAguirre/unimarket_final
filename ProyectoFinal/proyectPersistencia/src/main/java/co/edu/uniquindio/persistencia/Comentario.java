package co.edu.uniquindio.persistencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comentario
 * Contiene todos los comentario de hechos a los productos
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Comentario.TODOS_COMENTARIOS, query = "select c from Comentario c")
})
@Table(name = "Comentarios")
public class Comentario implements Serializable {

	public static final String TODOS_COMENTARIOS = "TODOS COMENTARIOS";
	@Id
	@Column(name = "ID_COMENTARIO")
	private int idComentario;
	@Column(name = "COMENTARIO", nullable = false, length = 250)
	private String comentario;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Producto producto;

	public Comentario() {
		super();
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", comentario=" + comentario + ", producto=" + producto
				+ "]";
	}
}
