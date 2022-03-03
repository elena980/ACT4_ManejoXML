package entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Etiqueta imprescindible para notificar el nodo raiz
//con el atributo "name" le asignamos un nombre
@XmlRootElement(name="Seguidore")

//de manera opcional la etiqueta XmlType es para establecer 
//el orden en el que aparecen las equitetas
@XmlType(propOrder = {
		"id",
	    "nombre",
	    "ideologia",
	    "lider"
	})

public class Seguidor {
	private int id;
	private String nombre;
	private String ideologia;
	private Lider lider;
	
	// necesitamos un constructor vacío para las librerías de JAXB
	public Seguidor() {
	}
	

	public Seguidor(int id, String nombre, String ideologia, Lider lider) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ideologia = ideologia;
		this.lider= lider;
	}



	// etiqueta que uso para decir que el id será un atributo de la etiqueta seguidor
	// con el atributo "name" le asignamos un nombre
	@XmlElement(name = "id")
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
	@XmlElement(name="ideologias")
	public String getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}

	// etiqueta para la creación de una etiqueta XML como elemento
	@XmlElement
	public Lider getLider() {
		return lider;
	}


	public void setLider(Lider lider) {
		this.lider = lider;
	}
	
	@Override
	public String toString() {
		return "Seguidor [id=" + id + ", nombre=" + nombre + ", ideologia=" + ideologia  + "]";
	}
}
