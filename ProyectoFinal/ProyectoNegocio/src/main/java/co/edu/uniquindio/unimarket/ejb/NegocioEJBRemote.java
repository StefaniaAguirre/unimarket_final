package co.edu.uniquindio.unimarket.ejb;



import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.persistencia.Comentario;
import co.edu.uniquindio.persistencia.Persona;
import co.edu.uniquindio.persistencia.Producto;
import co.edu.uniquindio.persistencia.Usuario;
import co.edu.uniquindio.unimarket.excepciones.CedulaRepetidaException;
import co.edu.uniquindio.unimarket.excepciones.EmailRepetidoException;
import co.edu.uniquindio.unimarket.excepciones.ProductoRepetidoException;

@Remote
public interface NegocioEJBRemote {

	
	//lista mis propias compras
	//
	String JDNI = "java:global/ProyectoEAR/ProyectoNegocio/NegocioEJB!co.edu.uniquindio.unimarket.ejb.NegocioEJBRemote";
	
	Persona autenticarPersona(String email, String clave);
	List<Producto> listarProductosDisponibles();
	List<Comentario> listarComentarios(int codigoProducto);
	
	void crearProduto(Producto  p) throws ProductoRepetidoException;
	void registrarUsuario(Usuario u) throws CedulaRepetidaException, EmailRepetidoException;
	Producto editarProducto(Producto p);
}
