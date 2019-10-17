package co.edu.uniquindio.prueba.test;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;

import co.edu.uniquindio.persistencia.Persona;
import co.edu.uniquindio.unimarket.ejb.NegocioEJB;

public class NegocioTest {
	@EJB
	private NegocioEJB negocioEJB;
	
	@Deployment
	public static Archive<?> createTestArchive() {
	return ShrinkWrap.create(WebArchive.class, "prueba.war").addPackage(NegocioEJB.class.getPackage())
	.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")
	.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	
//	@Test
//	@UsingDataSet({"Persona.json"})
//	public void probarAutenticacion()
//	{
//		Persona p = negocioEJB.autenticarPersonal("pruab@email.com", "clave");
//		Assert.assertNull(p);
//	}

}
