package co.edu.uniquindio.persistencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 * Esta clase vamos a definir un solo administrador
 */
@Entity

public class Administrador extends Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}
}
