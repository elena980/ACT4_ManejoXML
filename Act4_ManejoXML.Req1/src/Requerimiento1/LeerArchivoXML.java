package Requerimiento1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerArchivoXML {
	public static void main(String[] args) {
		// Para obtener una instancia de DocumentBuilder necesitamos un
		// DocumentBuilderFactory
		DocumentBuilderFactory lector = DocumentBuilderFactory.newInstance();
		// Con esta clase, DocumentBuilder, podremos obtener un documento XML
		DocumentBuilder analizador;
		// Nodo doc, va a tener una referencia al Document
		Document doc;
		Node concierto;

		try {
			// metemos a la clase DocumentBuilder un instancia del DocumentBuilderFactory
			// para poder leer los ficheros XML
			analizador = lector.newDocumentBuilder();
			// tenemos que parsear el fichero para poder convertirlo en un �rbol DOM
			doc = analizador.parse("conciertos.xml");
			// asignamos el nodo doc como raiz principal y se lo meto como par�metro a un
			// m�todo que lo que hace es recorrer todos los nodos, en modo lectura de
			// ArrayList
			// va a tener una referencia a la etiqueta concierto
			concierto = doc.getDocumentElement();
			recorrerConciertos(concierto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// M�todo que devuelve todos los nodos hijos Directos del elemento "concierto"
	private static void recorrerConciertos(Node concierto) {
		// Meto en una variable NodeList el listado de hijos directos del elemento "concierto"
		NodeList nodos = concierto.getChildNodes();
		// paso a paso voy obteniendo los elementos y meti�ndolos en variables
		Node fecha = nodos.item(0);
		Node hora = nodos.item(1);
		// imprimo por pantalla la informaci�n de cada etiqueta con .getContent()
		System.out.println("Fecha y hora de los conciertos:");
		System.out.println("       " + fecha.getTextContent() + "    " + hora.getTextContent() + "\n");
		// el nodo "participantes" se componte de varios participantes es por eso 
		// que lo mento dentro de una funci�n para imprimir toda su informaci�n
		Node participantes = nodos.item(2);
		System.out.println("Participan los siguientes grupos: ");
		recorrerParticipantes(participantes);
	
	}
	// M�todo que devuelve todos los nodos hijos Directos del elemento "Participantes"
	private static void recorrerParticipantes(Node participantes) {
		// Meto en una variable NodeList el listado de hijos directos del elemento "participantes"
		NodeList nodos = participantes.getChildNodes();
			// cada participante tiene a su vez otros elementos, para imprimir su informaci�n
			// llamo al m�todo recorrerParticipante
			Node participante1 = nodos.item(0);
			recorrerParticipante(participante1);
			Node participante2 = nodos.item(1);
			recorrerParticipante(participante2);
			Node participante3 = nodos.item(2);
			recorrerParticipante(participante3);
	}
	// M�todo que devuelve todos los nodos hijos Directos del elemento "Participante"
	private static void recorrerParticipante(Node participante) {
		// Meto en una variable NodeList el listado de hijos directos del elemento "participante"
		NodeList nodos = participante.getChildNodes();
			// desde aqu� imprimo toda la informaci�n de cada nodo hijo de "participante"
			Node entrada = nodos.item(0);
			Node grupo = nodos.item(1);
			System.out.println("       " + entrada.getTextContent() + " " + grupo.getTextContent());
	}
}
