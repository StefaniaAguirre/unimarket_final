package co.edu.uniquindio.gui.modelo;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.persistencia.Comentario;
import co.edu.uniquindio.persistencia.Persona;
import co.edu.uniquindio.persistencia.Producto;
import co.edu.uniquindio.persistencia.Usuario;
import co.edu.uniquindio.unimarket.ejb.NegocioEJBRemote;
import co.edu.uniquindio.unimarket.excepciones.CedulaRepetidaException;
import co.edu.uniquindio.unimarket.excepciones.EmailRepetidoException;
import co.edu.uniquindio.unimarket.excepciones.ProductoRepetidoException;

public class PruebaDelegado {
	
	private NegocioEJBRemote negocioRemoto;
	
	public  static PruebaDelegado pruebaDelegado= instancia(); 
	
	public static PruebaDelegado instancia()
	{
		if(pruebaDelegado == null)
		{
			pruebaDelegado = new PruebaDelegado();
			return pruebaDelegado;
		}
		return pruebaDelegado;
	}
	

	private PruebaDelegado() {
		try {
		negocioRemoto = (NegocioEJBRemote) new InitialContext().lookup( NegocioEJBRemote.JDNI );
		}catch (NamingException e)
		{
			e.printStackTrace();
		}
	}

	public Persona autenticarPersona(String email, String clave) {
		return negocioRemoto.autenticarPersona(email, clave);
	}

	public List<Producto> listarProductosDisponibles() {
		return negocioRemoto.listarProductosDisponibles();
	}

	public List<Comentario> listarComentarios(int codigoProducto) {
		return negocioRemoto.listarComentarios(codigoProducto);
	}

	public void crearProduto(Producto p) throws ProductoRepetidoException {
		negocioRemoto.crearProduto(p);
	}

	public void registrarUsuario(Usuario u) throws CedulaRepetidaException, EmailRepetidoException {
		negocioRemoto.registrarUsuario(u);
	}

	public Producto editarProducto(Producto p) {
		return negocioRemoto.editarProducto(p);
	}
	

}
