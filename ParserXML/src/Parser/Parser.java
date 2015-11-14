package Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Parser {
	private Document dom;
	private ArrayList<Libro> libros;
	
	
	public Parser(){
		dom = null;
		libros = new ArrayList<Libro>();
	}
	
	public void parseadorFicheroXml(String nombreXml){
	// Instancia DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			//DocumentBuilder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//Parseo del XML en un objeto Document
			dom = db.parse(nombreXml);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTextValue(Element elemento, String tagName){
		String textValue=null;
		NodeList listaNodos = elemento.getElementsByTagName(tagName);
		
		if(listaNodos != null && listaNodos.getLength()>0){
			Element elementoObtenido = (Element) listaNodos.item(0);
			textValue = elementoObtenido.getFirstChild().getNodeValue();
		}
		return textValue;
	}
	
	public  int getIntValue(Element elemento, String tagName){
		return Integer.parseInt(getTextValue(elemento,tagName));
		
	}
	public int getIntAttributeValue(Element element, String tag, String attribute){
		int i = -1;
		NodeList list = element.getElementsByTagName(tag);
		if(list != null && list.getLength() > 0){
			Element e = (Element) list.item(0);
			String value = e.getAttribute(attribute);
			try{
				i = Integer.parseInt(value);
			}catch(NumberFormatException ex){
				i = -1;
			}
		}
		return i;
	}
	
	public Libro obtenerLibro(Element elemento){
		String titulo = getTextValue(elemento,"titulo");
		ArrayList<String> autor = getNombresAutor(elemento,"autor","nombre");
		int año = getIntAttributeValue(elemento,"titulo","anyo");
		String editorial = getTextValue(elemento,"editor");
		int numPaginas = getIntValue(elemento,"paginas");
		
		Libro nuevoLibro = new Libro(titulo, autor, año, editorial,numPaginas);
		
		return nuevoLibro;
		
	}
	
	public void getAtributo(Element element, String tagName, String atributo){
		String textValue = null;
		NodeList listaNodos = (NodeList) element.getAttributes();
		
	}
	
	public ArrayList<String> getNombresAutor(Element element, String autor, String nombre){
		ArrayList<String> nombres = new ArrayList<String>();
		NodeList list = element.getElementsByTagName(autor);
		if(list != null && list.getLength() > 0){
				Element elementNombre = (Element) list.item(0);
				NodeList nodeList = elementNombre.getElementsByTagName(nombre);
				for(int i = 0;i<nodeList.getLength();i++){
					Element e = (Element) nodeList.item(i);
					String nom = e.getTextContent();
					nombres.add(nom);	
				}
				
		}
		return nombres;
	}
	
	
	public void parseDocument(){
		Element element = dom.getDocumentElement();
		NodeList nodeList = element.getElementsByTagName("libro");
		
		if(nodeList != null && nodeList.getLength()>0){
				  
			for(int i=0;i<nodeList.getLength();i++){
			element = (Element)nodeList.item(i);
				    
				    if(element.hasAttribute("anyo")){
				    	System.out.println(element.getAttribute("anyo"));{
				    }
				    
				    }
				  }
				}
	}
	
	
	public void parsearDocumento(){
		//Obtenemos y guardamos el elemento raiz
		Element element = dom.getDocumentElement();
		
		//Recogemos los elementos del nodo libro
		NodeList listaNodos = element.getElementsByTagName("libro");
		//Recorremos los elementos del nodo libro(Atributos)(Objeto Libro)
		if(listaNodos != null && listaNodos.getLength()>0);
			for(int i=0;i<listaNodos.getLength();i++){
				Element elemento = (Element) listaNodos.item(i);
				
				Libro libroObtenido= obtenerLibro(elemento);
				
				libros.add(libroObtenido);
			}
		}
	
	public void print(){
		Iterator it = libros.iterator();
		while(it.hasNext()){
			Libro l = (Libro)it.next();
			l.print();
		}
	}
}