package ar.com.educationit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import ar.com.educationit.validators.MiValidador;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * mapeo de entidades con hibernate
 *
 * 
 * JPA : java persistence api (muchas interfases)
 * Hibernate : es una implementacion de JPA
 * @Entity > es una entidad: representa una tabla Deben tener un id = PK
 * @Table > indicar el nombre de la tabla
 * */


@Entity 
@Table(name = "socios")
//@Data
//@AllArgsConstructor
public class Socios {

	@Id
	//la clave en la db: es AUTOINCREMENTAL y se lo digo con la siguente anotacion...
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//pk compuesta(vem9os mas adelante)
	
	@Column(nullable = false, length =50, name= "apellido")//jpa+hibernate
	@NotEmpty
	//@MiValidador(value = "100")
	private String apellido;
	
	@Column(nullable = false, length =60, name= "nombre")
	@NotEmpty
	private String nombre;
	
	@Column(nullable = false, length =6, unique=true)
	@NotEmpty
	private String codigo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
