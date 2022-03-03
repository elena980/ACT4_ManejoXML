package entidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// Etiqueta imprescindible para notificar el nodo raiz
// con el atributo "name" le asignamos un nombre
@XmlRootElement(name="Movimiento")

// de manera opcional la etiqueta XmlType es para establecer 
// el orden en el que aparecen las equitetas
@XmlType(propOrder = {
		"id",
	    "ciudad",
	    "seguidores"
	})

public class Seguidores {
	private int id;
	private String ciudad;
	private List<Seguidor> seguidores;

	public Seguidores() {
		seguidores = new ArrayList<Seguidor>();
	}
	
	public Seguidores(int id, String ciudad, List<Seguidor> seguidores) {
		super();
		this.ciudad = ciudad;
		this.seguidores = seguidores;
	}

	// etiqueta para la creación de una etiqueta XML como elemento
	// con la el atributo "name" podemos darle otro nombre
	@XmlElement(name="identificador")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// etiqueta para la creación de una etiqueta XML como elemento
	// con la el atributo "name" podemos darle otro nombre
	@XmlElement(name="cuidad")
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	// etiqueta para la creación de una etiqueta XML como elemento
	@XmlElement(name = "seguidor")
	// esta etqueta es para que la etiqueta "seguidores" envuelva todas las 
	// etiquetas "seguidor
	@XmlElementWrapper(name = "seguidores")
	public List<Seguidor> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Seguidor> seguidores) {
		this.seguidores = seguidores;
	}


	@Override
	public String toString() {
		return "Seguidores [ciudad=" + ciudad + ", seguidores=" + seguidores + "]";
	}
	
}
