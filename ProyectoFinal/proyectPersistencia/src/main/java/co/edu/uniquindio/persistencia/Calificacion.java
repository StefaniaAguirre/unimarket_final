package co.edu.uniquindio.persistencia;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Entity implementation class for Entity: Calificacion
 * Contiene todas las calificaciones de los productos
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Calificacion.TODAS_CALIFICACIONES, query = "select c from Calificacion c")
})
@Table(name = "Calificaciones")
public class Calificacion implements Serializable {
   
	public static final String TODAS_CALIFICACIONES = "TODAS CALIFICACIONES";
	@Id
	@Column(name = "ID_CALIFICACION")
	private int idCalificacion;
	@Column(name = "CALIFICACION", nullable = false)
	//La calificación dada por el usuario debe ser obligatoria y tendrá un valor de 1 a 5
	@Min(1)
	@Max(5)
	private int calificacion;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Producto producto;
	
	@ManyToOne
	private Usuario usuario;

	public Calificacion() {
		super();
	} 
	public int getIdCalificacion() {
		return this.idCalificacion;
	}

	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
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
		return "Calificacion [idCalificacion=" + idCalificacion + ", calificacion=" + calificacion + ", producto="
				+ producto + ", usuario=" + usuario + "]";
	}
}
