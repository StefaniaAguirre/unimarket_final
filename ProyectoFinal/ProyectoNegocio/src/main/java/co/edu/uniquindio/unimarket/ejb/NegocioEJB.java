package co.edu.uniquindio.unimarket.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.persistencia.Comentario;
import co.edu.uniquindio.persistencia.Persona;
import co.edu.uniquindio.persistencia.Producto;
import co.edu.uniquindio.persistencia.Usuario;
import co.edu.uniquindio.unimarket.excepciones.CedulaRepetidaException;
import co.edu.uniquindio.unimarket.excepciones.EmailRepetidoException;
import co.edu.uniquindio.unimarket.excepciones.ProductoRepetidoException;

/**
 * Session Bean implementation class NegocioEJB
 */
@Stateless
@LocalBean
public class NegocioEJB implements NegocioEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public NegocioEJB() {
        // TODO Auto-generated constructor stub
    }
 //Aquí se va programar toda la logica 
	
	@Override
	public List<Producto> listarProductosDisponibles() {
		// TODO Auto-generated method stub
		
		TypedQuery<Producto> q = entityManager.createNamedQuery(Producto.PRODUCTO_DISPONIBLES, Producto.class );
		q.setParameter("fechaActual", new Date());//new SImpleDateFormat("yyyy-MM-dd").parse("2019-10-10"); para buscar una fechaEnEspecial
		
		
		return q.getResultList();
	}
	
	@Override
	public Persona autenticarPersona(String email, String clave) {
		TypedQuery<Persona> q = entityManager.createNamedQuery(Persona.VERIFICAR_LOGIN, Persona.class);
		q.setParameter("email", email);
		q.setParameter("password", clave);
		List<Persona> p = q.getResultList();		
		if(p != null){
			return p.get(0);
		}		
		return null;
	}

	@Override
	public List<Comentario> listarComentarios(int codigoProducto) {
		// TODO Auto-generated method stub
		

		TypedQuery<Comentario> q = entityManager.createNamedQuery(Comentario.COMENTARIOS_PRODUCTOS, Comentario.class );
		q.setParameter("CodigoProducto",codigoProducto);
		return null;
	}

	@Override
	public void crearProduto(Producto p) throws ProductoRepetidoException  {
		// TODO Auto-generated method stub
		if (entityManager.find(Producto.class, p.getIdProducto())!= null)
		{
			throw new ProductoRepetidoException("El producto ya existe");
		}
		entityManager.persist(p);
		
	}

	@Override
	public  void registrarUsuario(Usuario u) throws CedulaRepetidaException, EmailRepetidoException {
		// TODO Auto-generated method stub
		
		if (entityManager.find(Usuario.class, u.getId())!= null)
		{
			throw new CedulaRepetidaException("La cedula del ususario ya existe");
		}
		if (buscarUsuario( u.getEmail())!= null)
		{
			throw new EmailRepetidoException("El email ya se encuentra en uso");
		}
		entityManager.persist(u);
		
	}
	
	public Usuario buscarUsuario(String email)
	{
		TypedQuery<Usuario> q = entityManager.createNamedQuery(Usuario.BUSCAR_POR_EMAIL, Usuario.class);
		List<Usuario> lista = q.getResultList();
		
		if(lista.isEmpty())
		{
			return null;
		}
		return lista.get(0);
	}

	@Override
	public Producto editarProducto(Producto p) {
		// TODO Auto-generated method stub
		entityManager.merge(p);
		return p;
	}

//	@Override
//	public Persona autenticarUsuario(String email, String clave) {
//		// TODO Auto-generated method stub
//
//	 TypedQuery<Persona> q = entityManager.createNamedQuery(Persona.VERIFICAR_LOGIN, Persona.class); //Debe estar implementado el query en la entidad
//	 q.setParameter("email", email);
//	 q.setParameter("pasword ", clave);
//		
//		List<Persona> u = q.getResultList();
//		
//		if(u!= null)
//		{
//			return u.get(0);
//		}
//		return null;
//		
//	}
}
