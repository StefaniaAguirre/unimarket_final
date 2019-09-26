package co.edu.uniquindio.persistencia;

import java.awt.color.CMMException;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compra
 * Contiene las compras hechas por los usuarios
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Compra.TODAS_COMPRAS, query = "select c from Compra c")
})
@Table(name = "Compras")
public class Compra implements Serializable {

	public static final String TODAS_COMPRAS = "TODAS_COMPRAS";
	@Id
	@Column(name = "ID_COMPRA")
	private int idCompra;
	@Column(name = "FECHA_COMPRA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCompra;
	@Column(name = "METODO_PAGO")
	@Enumerated(EnumType.STRING)
	private MetodoPago metodoPago;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Producto producto;
	
	@OneToMany(mappedBy = "compra")
	private List<DetalleCompra> detallesCompra;

	public Compra() {
		super();
	}   
//	public String getIdUsuario() {
//		return this.idUsuario;
//	}
//
//	public void setIdUsuario(String idUsuario) {
//		this.idUsuario = idUsuario;
//	}   
//	public String getIdProducto() {
//		return this.idProducto;
//	}
//
//	public void setIdProducto(String idProducto) {
//		this.idProducto = idProducto;
//	}   
	public int getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	
	public Date getFecha() {
		return fechaCompra;
	}
	
	public void setFecha(Date fecha) {
		this.fechaCompra = fecha;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public MetodoPago getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", fechaCompra=" + fechaCompra + ", metodoPago=" + metodoPago
				+ ", producto=" + producto + "]";
	}
}
