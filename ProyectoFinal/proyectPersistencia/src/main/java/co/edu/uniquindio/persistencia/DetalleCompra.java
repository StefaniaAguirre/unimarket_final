package co.edu.uniquindio.persistencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DetalleCompra
 * Contiene todos los detalles de las compras de los productos
 */
@Entity
@NamedQueries({
	@NamedQuery(name = DetalleCompra.TODOS_DETALLES_COMPRAS, query = "select dc from DetalleCompra dc")
})
@Table(name = "DetallesCompras")
public class DetalleCompra implements Serializable {

	public static final String TODOS_DETALLES_COMPRAS = "TODOS DETALLES COMPRAS";
	@Id
	@Column(name = "ID_DETALLE_COMPRA")
	private int idDetalleCompra;
	@Column(name = "VALOR_COMPRA", nullable = false)
	private int ValorCompra;
	@Column(name = "PRECIO_PRODUCTO", nullable = false)
	private int precioProducto;
	@Column(name = "CANTIDAD", nullable = false)
	private int cantidad;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Compra compra;
	
	@ManyToOne
	private Producto producto;
	
	public DetalleCompra() {
		super();
	}   
	public int getIdDetalleCompra() {
		return this.idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}   
	public int getValorCompra() {
		return this.ValorCompra;
	}

	public void setValorCompra(int ValorCompra) {
		this.ValorCompra = ValorCompra;
	}   
	public int getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}   
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "DetalleCompra [idDetalleCompra=" + idDetalleCompra + ", ValorCompra=" + ValorCompra
				+ ", precioProducto=" + precioProducto + ", cantidad=" + cantidad + ", compra=" + compra + ", producto="
				+ producto + "]";
	}
}
