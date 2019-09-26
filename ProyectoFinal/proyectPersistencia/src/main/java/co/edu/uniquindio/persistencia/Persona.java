package co.edu.uniquindio.persistencia;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: persona
 * La persona que se registra puede ser de dos tipos administrador o usuario, teniendo en cuenta que solo se
 * se tiene un administrador
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Persona.TODAS_PERSONAS, query = "select p from Persona p")
})
@Table(name = "Personas")
public class Persona implements Serializable {

	public static final String TODAS_PERSONAS = "TODAS PERSONAS";
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "APELLIDO", nullable = false)
	private String apellido;
	@Column(name = "EMAIL",nullable = false)
	private String email;   
	@Id
	@Column(name = "ID", nullable = false, updatable = false)
	private String id;
	@Column(name = "TELEFONO", nullable = false, length = 10)
	private String telefono;
	@Column(name = "DIRECCION", nullable = false)
	private String direccion;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToOne
	private Administrador administrador;

	public Persona() {
		super();
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", id=" + id
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
}
