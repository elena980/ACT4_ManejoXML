package Requerimiento1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Prueba {
	public static void main(String[] args) {
		//Lo primero necestimos una factoria que nos cree los objetos
		//el patron factoria es un patron de diseño creacional, en la cual
		//su funcion es evitar el acoplamiento de clases, y de esta manera,
		//centralizar la creacion de los objetos en una unica clase
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		//Sigue el patron de diseño builder y cuya funcion es crear objetos
		//complejos de manera simple
		DocumentBuilder analizador;
		//el nodo documento
		Document dom;
		//Este nodo representara el nodo raiz en este ejemplo
		Node concierto;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			//Lo primero es parsear el fichero cruceros.xml para
			//convertilo en un arbol DOM, basicamente lo que hacen los navegadores
			//El arbol DOM seran objetos con una jerarquia en forma de arbol
			dom = analizador.parse("conciertos.xml");
			//Ponemos la referencia raiz en el objeto Document
			concierto = dom.getDocumentElement();
			recorrerConciertos(concierto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		private static void recorrerConciertos(Node concierto) {
			NodeList nodos = concierto.getChildNodes();
			
			for (int i = 0; i < nodos.getLength(); i++) {
				Node nodoConcierto = nodos.item(i);
				if (nodoConcierto.getNodeType() == Node.ELEMENT_NODE) {
					Node fecha = nodoConcierto.getChildNodes().item(0);
					Node hora = nodoConcierto.getChildNodes().item(1);
					System.out.println("  Fecha y hora: " + fecha.getTextContent() + "\n" + hora.getTextContent());
					Node participante = nodoConcierto.getChildNodes().item(2);
					System.out.println("  Participan los siguientes grupos: ");
					recorrerParticipantes(participante);
				}
			}
		}
			private static void recorrerParticipantes(Node participante) {
				NodeList nodos = participante.getChildNodes();
				
				for (int i = 0; i < nodos.getLength(); i++) {
					Node nodoParticipante = nodos.item(i);
					if (nodoParticipante.getNodeType() == Node.ELEMENT_NODE) {
						Node entrada = nodoParticipante.getChildNodes().item(0);
						Node grupo = nodoParticipante.getChildNodes().item(1);
						System.out.println(entrada.getTextContent() + "\n" + grupo.getTextContent());
						
					}
				}
		
	}
}
