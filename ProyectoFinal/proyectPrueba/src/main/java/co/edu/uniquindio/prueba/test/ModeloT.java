package co.edu.uniquindio.prueba.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.persistencia.Administrador;
import co.edu.uniquindio.persistencia.Calificacion;
import co.edu.uniquindio.persistencia.Comentario;
import co.edu.uniquindio.persistencia.Compra;
import co.edu.uniquindio.persistencia.DetalleCompra;
import co.edu.uniquindio.persistencia.Favorito;
import co.edu.uniquindio.persistencia.MetodoPago;
import co.edu.uniquindio.persistencia.Persona;
import co.edu.uniquindio.persistencia.Producto;
import co.edu.uniquindio.persistencia.TipoProducto;
import co.edu.uniquindio.persistencia.Usuario;
import junit.framework.Assert;

/**
 * Clase la cual contiene todas las pruebas de cada uno de los .json
 * @author Angelica Arroyave y Stefania Aguirre
 *
 */
@RunWith (Arquillian. class)
public class ModeloT {

	@PersistenceContext
	private EntityManager entityManager;

	@Deployment
	public static Archive<?> createTestArchive() {
	return ShrinkWrap.create(WebArchive.class, "prueba.war").addPackage(Persona.class.getPackage())
	.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")
	.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	// --------------------------- PRUEBAS CON ADMINISTRADOR ---------------------------
	
	/**
	 * Método el cual agrega un administrador se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarAdministrador() {
		
		Administrador admin = new Administrador();
		admin.setNombre("Andrés");
		admin.setApellido("López");
		admin.setDireccion("Isabela");
		admin.setId("7843");
		admin.setEmail("andresL@gamil.com");
		admin.setTelefono("7472354");
		admin.setPassword("7843");
		
		entityManager.persist(admin);
		
		Administrador adminRegistrado = entityManager.find(Administrador.class, "7843");
	}
	
	/**
	 * Método el cual modifica algún atributo de un administrador se usa el entityManager.persist(), entityManager.find() y entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarAdministrador() {
		
		Administrador admin = new Administrador();
		admin.setNombre("Andres");
		admin.setApellido("Gutierrez");
		admin.setDireccion("Calle #6");
		admin.setId("9823");
		admin.setEmail("andreaG@gamil.com");
		admin.setTelefono("7434354");
		admin.setPassword("9823");
		
		entityManager.persist(admin);
		
		Administrador adminB = entityManager.find(Administrador.class, "9823");
		
		admin.setDireccion("Arrayanes");
		
		entityManager.merge(adminB);
		
		Administrador adminRegistrado = entityManager.find(Administrador.class, "9823");
		Assert.assertEquals("Arrayanes", adminRegistrado.getDireccion());
	}
	
	/**
	 * Método el cual elimina un administrador se usa el entityManager.persist(), entityManager.find() y entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarAdministrador() {
		
		Administrador admin = new Administrador();
		admin.setNombre("Andrés");
		admin.setApellido("López");
		admin.setDireccion("Isabela");
		admin.setId("7843");
		admin.setEmail("andresL@gamil.com");
		admin.setTelefono("7472354");
		admin.setPassword("7843");
		
		entityManager.persist(admin);
		
		Administrador adminRegistrado = entityManager.find(Administrador.class, "7843");
		entityManager.remove(adminRegistrado);
		
		Administrador adminEliminado = entityManager.find(Administrador.class, "7843");
		Assert.assertNull(adminEliminado);
	}
	
	// --------------------------- PRUEBAS CON USUARIO ---------------------------
	
	/**
	 * Método el cual agrega un usuario se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Stefania");
		usuario.setApellido("Aguirre");
		usuario.setEmail("stefaniaA@gmail.com");
		usuario.setDireccion("Torre Laureles");
		usuario.setTelefono("7374254");
		usuario.setId("111");
		usuario.setPassword("111");
		
		entityManager.persist(usuario);
		
		Usuario usuarioRegistrado = entityManager.find(Usuario.class, "111");
	}
	
	/**
	 * Método el cual modifica algún atributo de un usuario se usa el entityManager.persist(), entityManager.find() y entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarUsuario() {

		Usuario usuario = new Usuario();
		usuario.setNombre("Stefania");
		usuario.setApellido("Aguirre");
		usuario.setEmail("stefaniaA@gmail.com");
		usuario.setDireccion("Torre Laureles");
		usuario.setTelefono("7374254");
		usuario.setId("111");
		usuario.setPassword("111");
		
		entityManager.persist(usuario);
		
		Usuario us = entityManager.find(Usuario.class, "111");
		
		us.setTelefono("7478730");
		
		entityManager.merge(us);
		
		Usuario usuarioModificar = entityManager.find(Usuario.class, "111");
		Assert.assertEquals("7478730", usuarioModificar.getTelefono());
	}
	
	/**
	 * Método el cual elimina un usuario se usa el entityManager.persist(), entityManager.find() y entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Stefania");
		usuario.setApellido("Aguirre");
		usuario.setEmail("stefaniaA@gmail.com");
		usuario.setDireccion("Torre Laureles");
		usuario.setTelefono("7374254");
		usuario.setId("111");
		usuario.setPassword("111");
		
		entityManager.persist(usuario);
		
		Usuario us = entityManager.find(Usuario.class, "111");
		entityManager.remove(us);
		
		Usuario usEliminado = entityManager.find(Usuario.class, "111");
		Assert.assertNull(usEliminado);
	}
	
	// --------------------------- PRUEBAS CON PERSONA.JSON ---------------------------
	
	/**
	 * Método el cual agrega una persona se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@UsingDataSet({"Persona.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarPersona() {

		Persona p = new Persona();
		p.setNombre("Juliana");
		p.setApellido("Castañeda");
		p.setEmail("julianaC@gmail.com");
		p.setDireccion("Calle 3");
		p.setId("7623");
		p.setPassword("7623");
		
		entityManager.persist(p);
			
		Persona personaRegistrada = entityManager.find(Persona.class, "213");
	}
	
	/**
	 * Método el cual elimina una persona se usa el entityManager.find() y entityManager.remove()
	 */
	@Test
	@UsingDataSet({"Persona.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarPersona() {
		
		Persona p = entityManager.find(Persona.class, "321");
		entityManager.remove(p);
		
		Persona personaRegistrada = entityManager.find(Persona.class, "321");
		Assert.assertNull(personaRegistrada);
	}
	
	/**
	 * Método el cual modifica algún atributo de una persona se usa el entityManager.find() y entityManager.merge()
	 */
	@Test
	@UsingDataSet({"Persona.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarDatoPersona() {
		
		Persona p = entityManager.find(Persona.class, "987");
		
		p.setDireccion("Calle #23");
		
		entityManager.merge(p);
		
		Persona personaRegistrada = entityManager.find(Persona.class, "987");
		Assert.assertEquals("Calle #23", personaRegistrada.getDireccion());
	}
	
	/**
	 * Método el cual lista todas las personas que están registradas en la base de datos se usa entityManager.createNamedQuery) y .getResultList()
	 */
	@Test
	@UsingDataSet({"Persona.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void listarPersonas() {
		
		TypedQuery<Persona> q = entityManager.createNamedQuery(Persona.TODAS_PERSONAS, Persona.class);
		List l = q.getResultList();
		
		System.out.println("LISTA DE TODAS LAS PERSONAS: " + l.toString());
	}
	
	// --------------------------- PRUEBAS CON PRODUCTO.JSON ---------------------------
	
	/**
	 * Método el cual agrega un producto se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@UsingDataSet({"Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarProducto() {
		
		Usuario usuario = entityManager.find(Usuario.class, "987");
		Assert.assertNotNull(usuario);
		
		Producto produc = new Producto();
		produc.setDescripcion("Portatil");
		produc.setDisponibilidad(true);
		produc.setIdProducto(4);
		produc.setImagen("IMAGEN");
		produc.setNombre("Computador HP");
		produc.setPrecio(1500000);
		produc.setTipoProducto(TipoProducto.TECNOLOGIA);
		produc.setUsuario(usuario);
		
		entityManager.persist(produc);
		
		Producto producto = entityManager.find(Producto.class, 4);
		
		Assert.assertNotNull(producto);
	}
	
	/**
	 * Método el cual elimina un producto se usa el entityManager.find() y entityManager.remove()
	 */
	@Test
	@UsingDataSet({"Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarProducto() {
		
		Producto prod = entityManager.find(Producto.class, 1);
		
		entityManager.remove(prod);
		
		Producto productoRegistrado = entityManager.find(Producto.class, 1);
		Assert.assertNull(productoRegistrado);
	}
	
	/**
	 * Método el cual modifica algún atributo de un producto se usa el entityManager.find() y entityManager.merge()
	 */
	@Test
	@UsingDataSet({"Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarProducto() {

		Producto prod = entityManager.find(Producto.class, 2);
		
		prod.setPrecio(2000000.0);
		
		entityManager.merge(prod);
		
		Producto productoRegistrado = entityManager.find(Producto.class, 2);
		Assert.assertEquals(2000000.0, productoRegistrado.getPrecio());
	}
	
	/**
	 * Método el cual lista todas los productos que están registradas en la base de datos se usa entityManager.createNamedQuery) y .getResultList()
	 */
	@Test
	@UsingDataSet({"Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void listarProductos() {
		
		TypedQuery<Producto> q = entityManager.createNamedQuery(Producto.TODAS_PRODUCTOS, Producto.class);
		List l = q.getResultList();
		
		System.out.println("LISTA DE TODOS LOS PRODUCTOS: " + l.toString());
	}
	
	/**
	 * Método el cual lista todas los productos que están registrados como disponibles == true en la base de datos se usa entityManager.createNamedQuery) y .getResultList()
	 */
	@Test
	@UsingDataSet({"Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void listarProductosDisponibles() {
		
		TypedQuery<Producto> q = entityManager.createNamedQuery(Producto.TODOS_PRODUCTOS_DISPONIBLES, Producto.class);
		q.setParameter("disponibilidad", true);
		List<Producto> l = q.getResultList();
		
		System.out.println("LISTA DE TODOS LOS PRODUCTOS DISPONIBLES: " + l.toString());
	}
	
	// --------------------------- PRUEBAS CON COMPRA.JSON ---------------------------
	
	/**
	 * Método el cual agrega una compra se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@UsingDataSet({"Producto.json", "Compra.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarCompra() {
		
		Producto prod = entityManager.find(Producto.class, 2);
		
		Assert.assertNotNull(prod);
		
		Compra compra = new Compra();
		compra.setFechaCompra(new Date());
		compra.setIdCompra(100);
		compra.setMetodoPago(MetodoPago.EFECTIVO);
		compra.setProducto(prod);
		
		entityManager.persist(compra);
		
		Compra com = entityManager.find(Compra.class, 100);
		
		Assert.assertNotNull(com);
	}
	
	/**
	 * Método el cual elimina una compra se usa el entityManager.find() y entityManager.remove()
	 */
	@Test
	@UsingDataSet({"Producto.json", "Compra.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarCompra() {
		
		Compra com = entityManager.find(Compra.class, 103);
		
		entityManager.remove(com);
		
		Compra compraRegis = entityManager.find(Compra.class, 103);
		Assert.assertNull(compraRegis);
	}
	
	/**
	 * Método el cual modifica algún atributo de una compra se usa el entityManager.find() y entityManager.merge()
	 */
	@Test
	@UsingDataSet({"Producto.json", "Compra.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarCompra() {
		
		Compra com = entityManager.find(Compra.class, 101);
		
		com.setMetodoPago(MetodoPago.TARJETA_CREDITO);
		
		entityManager.merge(com);
		
		Compra compra = entityManager.find(Compra.class, 101);
		Assert.assertEquals(MetodoPago.TARJETA_CREDITO, compra.getMetodoPago());
	}
	
	/**
	 * Método el cual lista todas las compras que están registradas en la base de datos se usa entityManager.createNamedQuery) y .getResultList()
	 */
	@Test
	@UsingDataSet({"Producto.json", "Compra.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void listarCompras() {
		
		TypedQuery<Compra> q = entityManager.createNamedQuery(Compra.TODAS_COMPRAS, Compra.class);
		List l = q.getResultList();
		
		System.out.println("LISTA DE TODAS LAS COMPRAS: " + l.toString());
	}
	
	// --------------------------- PRUEBAS CON CALIFICACIONES.JSON ---------------------------
	
	/**
	 * Método el cual agrega una calificación se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@UsingDataSet({"Calificaciones.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarCalificacion() {
		
		Producto prod = entityManager.find(Producto.class, 3);
		Assert.assertNotNull(prod);
		
		Usuario usuario = entityManager.find(Usuario.class, "321");
		Assert.assertNotNull(usuario);
		
		Calificacion cal = new Calificacion();
		cal.setCalificacion(3);
		cal.setIdCalificacion(984);
		cal.setProducto(prod);
		cal.setUsuario(usuario);
		
		entityManager.persist(cal);
		
		Calificacion calRegistrada = entityManager.find(Calificacion.class, 984);
	}
	
	/**
	 * Método el cual modifica algún atributo de una calificación se usa el entityManager.find() y entityManager.merge()
	 */
	@Test
	@UsingDataSet({"Calificaciones.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarCalificacion() {
		
		Calificacion cal = entityManager.find(Calificacion.class, 986);
		
		cal.setCalificacion(2);
		
		entityManager.merge(cal);
		
		Calificacion calModificada = entityManager.find(Calificacion.class, 986);
		Assert.assertEquals(2, calModificada.getCalificacion());
	}
	
	/**
	 * Método el cual elimina una calificación se usa el entityManager.find() y entityManager.remove()
	 */
	@Test
	@UsingDataSet({"Calificaciones.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarCalificacion() {
		
		Calificacion cal = entityManager.find(Calificacion.class, 987);
		
		entityManager.remove(cal);
		
		Calificacion calificacion = entityManager.find(Calificacion.class, 987);
		Assert.assertNull(calificacion);
	}
	
	/**
	 * Método el cual lista todas las calificacions que están registradas en la base de datos se usa entityManager.createNamedQuery) y .getResultList()
	 */
	@Test
	@UsingDataSet({"Calificaciones.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void listarCalificaciones() {
		
		TypedQuery<Calificacion> q = entityManager.createNamedQuery(Calificacion.TODAS_CALIFICACIONES, Calificacion.class);
		List l = q.getResultList();
		
		System.out.println("LISTA DE TODAS LAS CALIFICACIONES: " + l.toString());
	}
	
	// --------------------------- PRUEBAS CON COMENTARIO.JSON ---------------------------
	
	/**
	 * Método el cual agrega un comentario se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@UsingDataSet({"Comentario.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarComentario() {
		
		Producto prod = entityManager.find(Producto.class, 3);
		Assert.assertNotNull(prod);

		Comentario comentario = new Comentario();
		comentario.setComentario("Bueno");
		comentario.setIdComentario(4);
		comentario.setProducto(prod);
		
		entityManager.persist(comentario);
		
		Comentario comRegistrado = entityManager.find(Comentario.class, 4);
	}
	
	/**
	 * Método el cual modifica algún atributo de un comentario se usa el entityManager.find() y entityManager.merge()
	 */
	@Test
	@UsingDataSet({"Comentario.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarComentario() {
		
		Comentario com = entityManager.find(Comentario.class, 1);
		
		com.setComentario("Regular");
		
		entityManager.merge(com);
		
		Comentario comRegistrado = entityManager.find(Comentario.class, 1);
		Assert.assertEquals("Regular", comRegistrado.getComentario());
	}
	
	/**
	 * Método el cual elimina un comentario se usa el entityManager.find() y entityManager.remove()
	 */
	@Test
	@UsingDataSet({"Comentario.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarComentario() {
		
		Comentario com = entityManager.find(Comentario.class, 2);
		
		entityManager.remove(com);
		
		Comentario comEliminar = entityManager.find(Comentario.class, 2);
		Assert.assertNull(comEliminar);
	}
	
	/**
	 * Método el cual lista todas los comentarios que están registradas en la base de datos se usa entityManager.createNamedQuery) y .getResultList()
	 */
	@Test
	@UsingDataSet({"Comentario.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void listarComentarios() {
	
		TypedQuery<Comentario> q = entityManager.createNamedQuery(Comentario.TODOS_COMENTARIOS, Comentario.class);
		List l = q.getResultList();
		
		System.out.println("LISTA DE TODOS LOS COMENTARIOS: " + l.toString());
	}
	
	// --------------------------- PRUEBAS CON FAVORITOS.JSON ---------------------------
	
	/**
	 * Método el cual agrega favoritos se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@UsingDataSet({"Favoritos.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarFavoritos() {
		
		Usuario usuario = entityManager.find(Usuario.class, "213");
		Assert.assertNotNull(usuario);
		
		Producto prod = entityManager.find(Producto.class, 1);
		Assert.assertNotNull(prod);
		
		Favorito fav = new Favorito();
		fav.setIdFavorito(4);
		fav.setProducto(prod);
		fav.setUsuario(usuario);
		
		entityManager.persist(fav);
		
		Favorito favRegistrado = entityManager.find(Favorito.class, 4);
	}
	
	/**
	 * Método el cual modifica algún atributo de favoritos se usa el entityManager.find() y entityManager.merge()
	 */
	@Test
	@UsingDataSet({"Favoritos.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarFavoritos() {
	
		Producto prod = entityManager.find(Producto.class, 1);
		Assert.assertNotNull(prod);
		
		Favorito fav = entityManager.find(Favorito.class, 2);
		
		fav.setProducto(prod);
		
		entityManager.merge(fav);
		
		Favorito favModificado = entityManager.find(Favorito.class, 2);
		Assert.assertEquals(prod, favModificado.getProducto());
	}
	
	/**
	 * Método el cual elimina favoritos se usa el entityManager.find() y entityManager.remove()
	 */
	@Test
	@UsingDataSet({"Favoritos.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarFavoritos() {
	
		Favorito fav = entityManager.find(Favorito.class, 3);
		
		entityManager.remove(fav);
		
		Favorito favEliminado = entityManager.find(Favorito.class, 3);
		Assert.assertNull(favEliminado);
	}
	
	/**
	 * Método el cual lista todas los productos favoritos que están registrados en la base de datos se usa entityManager.createNamedQuery) y .getResultList()
	 */
	@Test
	@UsingDataSet({"Favoritos.json", "Persona.json", "Producto.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void listarFavoritos() {
		
		TypedQuery<Favorito> q = entityManager.createNamedQuery(Favorito.TODOS_FAVORITOS, Favorito.class);
		List l = q.getResultList();
		
		System.out.println("LISTA DE TODOS LOS FAVORITOS: " + l.toString());
	}
	
	// --------------------------- PRUEBAS CON DETALLESCOMPRAS.JSON ---------------------------
	
	/**
	 * Método el cual agrega detalles de compra se usa el entityManager.persist() y entityManager.find()
	 */
	@Test
	@UsingDataSet({"DetallesCompras.json", "Producto.json", "Compra.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void agregarDetallesCompras() {
		
		Producto prod = entityManager.find(Producto.class, 1);
		Assert.assertNotNull(prod);
		
		Compra comp = entityManager.find(Compra.class, 101);
		Assert.assertNotNull(comp);
		
		DetalleCompra detalleCom = new DetalleCompra();
		detalleCom.setCantidad(5);
		detalleCom.setIdDetalleCompra(4);
		detalleCom.setPrecioProducto(1350000);
		detalleCom.setValorCompra(2000000);
		detalleCom.setCompra(comp);
		detalleCom.setProducto(prod);
		
		entityManager.persist(detalleCom);
		
		DetalleCompra detComp = entityManager.find(DetalleCompra.class, 4);
	}
	
	/**
	 * Método el cual modifica algún atributo del detalle de una compra se usa el entityManager.find() y entityManager.merge()
	 */
	@Test
	@UsingDataSet({"DetallesCompras.json", "Producto.json", "Compra.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void modificarDetallesCompras() {
		
		DetalleCompra detCom = entityManager.find(DetalleCompra.class, 2);
		
		detCom.setCantidad(7);
		
		entityManager.merge(detCom);
		
		DetalleCompra detModificado = entityManager.find(DetalleCompra.class, 2);
		Assert.assertEquals(7, detCom.getCantidad());
	}
	
	/**
	 * Método el cual elimina el detalle de una compra se usa el entityManager.find() y entityManager.remove()
	 */
	@Test
	@UsingDataSet({"DetallesCompras.json", "Producto.json", "Compra.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void eliminarDetallesCompras() {
	
		DetalleCompra detCom = entityManager.find(DetalleCompra.class, 1);
		
		entityManager.remove(detCom);
		
		DetalleCompra detComEliminado = entityManager.find(DetalleCompra.class, 1);
		Assert.assertNull(detComEliminado);
	}
	
	/**
	 * Método el cual lista todos los detalles de las compras que están registradas en la base de datos se usa entityManager.createNamedQuery) y .getResultList()
	 */
	@Test
	@UsingDataSet({"DetallesCompras.json", "Producto.json", "Compra.json"})
	@Transactional(value = TransactionMode.ROLLBACK)
	public void listarDetallesCompras() {
		
		TypedQuery<DetalleCompra> q = entityManager.createNamedQuery(DetalleCompra.TODOS_DETALLES_COMPRAS, DetalleCompra.class);
		List l = q.getResultList();
		
		System.out.println("LISTA DE TODOS LOS DETALLES DE COMPRAS: " + l.toString());
	}
}
