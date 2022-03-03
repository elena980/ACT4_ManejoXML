package main;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import entidades.Seguidores;

public class XMLAObjetos {

	public static void main(String[] args) {
		try {
			// obtenemos un contexto con la clase Seguidores para poder gestionar el 
			// objeto o el archivo XML. 
	        // Se mete en un try-catch ya que provocaría una 
			// excepción si no cumple los requisitos (anotaciones, constructores vacíos..)
			JAXBContext contexto = JAXBContext.newInstance(Seguidores.class);
			
			// Con Unmarshaller asociado a un contexto, podremos deserializar un objeto 
			Unmarshaller u = contexto.createUnmarshaller();
			
			// instancio el fichero asalto.xml
			File fichero = new File("asalto.xml");
			// compruebo si existe el fichero asalto.xml
			if (fichero.exists()) {
				
				// Ejecuto el unmarshal pasándole como parámentro
				// el fichero que he instanciado.
				// lo parseo ya que el unmarshal devuelve un objeto
				Seguidores s = (Seguidores) u.unmarshal(fichero);
				System.out.println(s);
			} else {
				System.out.println("El fichero asalto.xml no existe");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
}
