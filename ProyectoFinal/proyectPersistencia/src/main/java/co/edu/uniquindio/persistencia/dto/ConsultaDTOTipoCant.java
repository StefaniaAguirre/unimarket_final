package co.edu.uniquindio.persistencia.dto;

import co.edu.uniquindio.persistencia.TipoProducto;

public class ConsultaDTOTipoCant {

	private Long cantidadProductos;
	private TipoProducto tipoProducto;
	
	public ConsultaDTOTipoCant(Long cantidadProductos, TipoProducto tipoProducto) {
		super();
		this.cantidadProductos = cantidadProductos;
		this.tipoProducto = tipoProducto;
	}

	public Long getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(Long cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
}
