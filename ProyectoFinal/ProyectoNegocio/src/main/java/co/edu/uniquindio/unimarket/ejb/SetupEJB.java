package co.edu.uniquindio.unimarket.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.persistencia.Administrador;
import co.edu.uniquindio.persistencia.Persona;
import co.edu.uniquindio.persistencia.Usuario;

/**
 * Session Bean implementation class SetupEJB
 */
@Singleton
@LocalBean
@Startup
public class SetupEJB {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public SetupEJB() {
        // TODO Auto-generated constructor stu
    }
    
    @PostConstruct
    public void config()
    {
    	TypedQuery<Persona> q = entityManager.createNamedQuery(Persona.OBTENER_ADMINISTRADOR, Persona.class);
    	
    	if(q.getResultList().isEmpty())
    	{
    		Administrador a = new Administrador();
            a.setId("12367");
    		a.setNombre("Admin");
    		a.setTelefono("8712382126");
    		a.setDireccion("calle 123");
    		a.setPassword("1234");
    		a.setEmail("admiin@gmail.com");
    		a.setApellido("apellido");
    		
    		entityManager.persist(a);
    	}
    }

}
