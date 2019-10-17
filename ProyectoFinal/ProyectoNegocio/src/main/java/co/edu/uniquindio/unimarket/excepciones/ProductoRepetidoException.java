package co.edu.uniquindio.unimarket.excepciones;

public class ProductoRepetidoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ProductoRepetidoException (String mensaje)
	{
		super(mensaje);
	}

}
