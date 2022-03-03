package Requerimiento1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearArchivoXML {
	public static void main(String[] args) {
		// Para obtener una instancia de DocumentBuilder necesito un DocumentBuilderFactory 
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		// Con esta clase, DocumentBuilder, podr� obtener un documento XML
		DocumentBuilder analizador;
		// Nodo doc, va a tener una referencia al Document
		Document doc;
		
		try {
			// meto la clase DocumentBuilder un instancia del DocumentBuilderFactory
			// para poder leer los ficheros XML
			analizador = fabrica.newDocumentBuilder();
			// Creo nuevo documento
			// tenemos que parsear el fichero para poder convertirlo en un �rbol DOM
			doc = analizador.newDocument();
			// A�ado el elemento concierto
			Element concierto = doc.createElement("concierto");
			// se lo a�ado como elemento hijo a Doc
			doc.appendChild(concierto);
			
			// A�ado el elemento fecha
			Element fecha = doc.createElement("fecha");
			// se lo a�ado como elemento hijo a concierto y aprovecho
			// para crear y a�adir el elemento texto de fecha
			fecha.appendChild(doc.createTextNode("20-OCT-2018"));
			concierto.appendChild(fecha);
			
			// A�ado el elemento hora
			Element hora = doc.createElement("hora");
			// se lo a�ado como elemento hijo a concierto y aprovecho
			// para crear y a�adir el elemento texto de hora
			hora.appendChild(doc.createTextNode("21:30"));
			concierto.appendChild(hora);
			
			// A�ado el elemento participantes y llamo a la funci�n 
			// agregrarParticipantes, a esta funci�n le paso como par�metro un elemento y
			// el nodo raiz. Su funci�n es de a�adir participantes a la etiqueta participante
			Element participantes = doc.createElement("participantes");
			concierto.appendChild(participantes);
			agregarParticipantes(participantes, doc);
			
			// llamo a la funci�n guardar para guardar en disco el archivo XML
			// pasando como par�metro el nodo raiz
			guardar(doc);
			
			System.out.println("Se ha creado el archivo conciertos.xml");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void agregarParticipantes(Element participantes, Document doc) {
		// Primer participante
		// creo el elemento participantes
		Element participante = doc.createElement("participante");
		// le a�ado el elemento al nodo participantes
		participantes.appendChild(participante);	
		
		// creo el elemento entrada
		Element entrada = doc.createElement("entrada");
		// a�ado un elemento texto al nodo entrada
		entrada.appendChild(doc.createTextNode("21:30"));
		// le a�ado el elemento entrada al nodo participante
		participante.appendChild(entrada);	
		
		// creo un elemento grupo
		Element grupo = doc.createElement("grupo");
		// a�ado un elemento texto al nodo grupo
		grupo.appendChild(doc.createTextNode("Las Ardillas de Dakota"));
		// a�ado grupo al nodo participante
		participante.appendChild(grupo);
		
		// el resto de participantes lo hacemos de la mima manera
		// Segundo participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("22:15"));	
		participante.appendChild(entrada);
		
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante.appendChild(grupo);
		
		// Tercer participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("23:00"));	
		participante.appendChild(entrada);
		
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Coldplay"));
		participante.appendChild(grupo);
	}
	
	private static void guardar(Document doc) throws TransformerException {
		
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		// Con el objeto Transfomer serializamos el arbol dom a un fichero.
		// Para ello se tiene que apoyar en un conversor TransformerFactory.
		Transformer conversor = fabricaConversor.newTransformer();
		// Con DOMSource creo la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc); 
		// Abro el flujo de salida para el fichero que queremos
		StreamResult resultado = new StreamResult(new File("conciertos.xml"));
		// serializamos los datos
		conversor.transform(fuente, resultado);
	}
}
