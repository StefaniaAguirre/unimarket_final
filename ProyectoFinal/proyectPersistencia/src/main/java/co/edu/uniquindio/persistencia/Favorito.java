package co.edu.uniquindio.persistencia;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: favorito
 * Contiene los productos que los usuarios consideran favoritos
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Favorito.TODOS_FAVORITOS, query = "select f from Favorito f")
})
@Table(name = "Favoritos")
public class Favorito implements Serializable {
	
	public static final String TODOS_FAVORITOS = "TODOS FAVORITOS";
	@Id
	@Column(name = "ID_FAVORITO", nullable = false)
	private int idFavorito;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Producto producto;
	
	@ManyToOne
	private Usuario usuario;

	public Favorito() {
		super();
	}

	public int getIdFavorito() {
		return idFavorito;
	}

	public void setIdFavorito(int idFavorito) {
		this.idFavorito = idFavorito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Favorito [idFavorito=" + idFavorito + ", producto=" + producto + ", usuario=" + usuario + "]";
	}   
}
