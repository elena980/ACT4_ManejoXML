package main;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import entidades.Lider;
import entidades.Seguidor;
import entidades.Seguidores;


public class ObjetosAXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			// obtenemos un contexto con la clase Seguidores para poder gestionar el 
			// objeto o el archivo XML. 
			// Se mete en un try-catch ya que provocaría una 
			// excepción si no cumple los requisitos (anotaciones, constructores vacíos..)
			contexto = JAXBContext.newInstance(Seguidores.class);
		} catch (JAXBException e) {
			e.printStackTrace();
			// paro la ejecución en caso de saltar la excepción
			return;
		}

		Marshaller ms;
		try {
			// Con Marshaller asociado a un contexto, podremos serializar un objeto 
			ms = contexto.createMarshaller();
			// la propiedad JAXB_FORMATTED_OUTPUT con el valor true 
			// permite que en la conversión se incluyan el sangrado del texto.
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// Creo el lider para relacionarlo con el seguidor
			Lider l = new Lider(0, "Vladimir", "Putin", 70, "Putismo");
			
			// Creamos una lista de seguidores instanciado en el constructor del la
			// clase Seguidores.
			Seguidores seguidores = new Seguidores();
			seguidores.setCiudad("Moscú");
			// Añadimos los seguidores con su lider
			seguidores.getSeguidores().add(new Seguidor(0,"Adam", "Putismo",l));
			seguidores.getSeguidores().add(new Seguidor(1, "Gleb","Putismo",l));
			seguidores.getSeguidores().add(new Seguidor(2, "Marfa","Putismo",l));
			seguidores.getSeguidores().add(new Seguidor(3, "Ioann","Putismo",l));
			seguidores.getSeguidores().add(new Seguidor(4, "Larisa","Putismo",l));
			seguidores.getSeguidores().add(new Seguidor(5, "Miloslav","Putismo",l));
	
			// con el marshal lo que hacemos es crear un archivo con 
			// el objeto y el nuevo archivo como argumentos 
			ms.marshal(seguidores, new File("asalto.xml"));
			System.out.println("El archivo asalto.xml ha sido creado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
