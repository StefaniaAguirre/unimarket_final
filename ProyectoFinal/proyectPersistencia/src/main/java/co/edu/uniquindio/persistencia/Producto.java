package co.edu.uniquindio.persistencia;

import java.awt.Window.Type;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: producto
 * Estos productos se pueden agregar y deoenden del tipo del producto
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Producto.TODAS_PRODUCTOS, query = "select p from Producto p"),
	@NamedQuery(name = Producto.TODOS_PRODUCTOS_DISPONIBLES, query = "select p from Producto p where p.disponibilidad = :disponibilidad")
})
@Table(name = "Productos")
public class Producto implements Serializable {

	public static final String TODAS_PRODUCTOS = "TODAS PRODUCTOS";
	public static final String TODOS_PRODUCTOS_DISPONIBLES = "TODOS PRODUCTOS DISPONIBLES";
	@Id
	@Column(name = "ID_PRODUCTO")
	private int idProducto;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;
	@Column(name = "PRECIO", nullable = false)
	private double precio;
	@Column(name = "DISPONIBILIDAD", nullable = false)
	private boolean disponibilidad;
	@Enumerated(EnumType.STRING)
	private TipoProducto tipoProducto;
	@Column(name = "IMAGEN")
	private String imagen;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaLimite;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "producto")
	private List<Compra> misCompras;
	
	@OneToMany(mappedBy = "producto")
	private List<Calificacion> misCalificaciones;
	
	@OneToMany(mappedBy = "producto")
	private List<Comentario> misComentarios;
	
	@OneToMany(mappedBy = "producto")
	private List<Favorito> misFavoritos;
	
	@OneToMany(mappedBy = "producto")
	private List<DetalleCompra> detallesCompra;
	
	public Producto() {
		super();
	}   
	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}   
	public boolean getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public Date getFechaLimite() {
		return fechaLimite;
	}
	
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Compra> getMisCompras() {
		return misCompras;
	}
	public void setMisCompras(List<Compra> misCompras) {
		this.misCompras = misCompras;
	}
	public List<Calificacion> getMisCalificaciones() {
		return misCalificaciones;
	}
	public void setMisCalificaciones(List<Calificacion> misCalificaciones) {
		this.misCalificaciones = misCalificaciones;
	}
	public List<Comentario> getMisComentarios() {
		return misComentarios;
	}
	public void setMisComentarios(List<Comentario> misComentarios) {
		this.misComentarios = misComentarios;
	}
	public List<Favorito> getMisFavoritos() {
		return misFavoritos;
	}
	public void setMisFavoritos(List<Favorito> misFavoritos) {
		this.misFavoritos = misFavoritos;
	}
	public List<DetalleCompra> getDetallesCompra() {
		return detallesCompra;
	}
	public void setDetallesCompra(List<DetalleCompra> detallesCompra) {
		this.detallesCompra = detallesCompra;
	}
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", disponibilidad=" + disponibilidad + ", tipoProducto=" + tipoProducto
				+ ", imagen=" + imagen + ", usuario=" + usuario + "]";
	}
}
