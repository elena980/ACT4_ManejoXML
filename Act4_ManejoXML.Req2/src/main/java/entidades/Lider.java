package entidades;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// Etiqueta imprescindible para notificar el nodo raiz
// con el atributo "name" le asignamos un nombre
@XmlRootElement(name="Lider")

// de manera opcional la etiqueta XmlType es para establecer 
// el orden en el que aparecen las equitetas
@XmlType(propOrder = {
		"id",
	    "nombre",
	    "apellido",
	    "edad",
	    "ideologia"
	})

public class Lider {
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private String ideologia;
	
	// necesitamos un constructor vacío para las librerías de JAXB
	public Lider() {
		
	}

	public Lider(int id, String nombre, String apellido, int edad, String ideologia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ideologia = ideologia;
	}

	// etiqueta que uso para decir que el id será un atributo de la etiqueta seguidor
	// con el atributo "name" le asignamos un nombre
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// etiqueta para la creación de una etiqueta XML como elemento
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// etiqueta para la creación de una etiqueta XML como elemento
	// con la el atributo "name" podemos darle otro nombre
	@XmlElement(name="apellidos")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// etiqueta para la creación de una etiqueta XML como elemento
	@XmlElement
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	// etiqueta para la creación de una etiqueta XML como elemento
	// con la el atributo "name" podemos darle otro nombre
	@XmlElement(name="ideologias")
	public String getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}

	@Override
	public String toString() {
		return "Lider [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", ideologia="
				+ ideologia + "]";
	}
}