package co.edu.uniquindio.unimarket.excepciones;

public class CedulaRepetidaException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public CedulaRepetidaException (String mensaje)
	{
		super(mensaje);
	}
}
