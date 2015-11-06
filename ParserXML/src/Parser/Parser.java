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
	
	public Libro obtenerLibro(Element elemento){
		String titulo = getTextValue(elemento,"titulo");
		String autor = getTextValue(elemento,"autor");
		int a�o = getIntValue(elemento,"a�o");
		String editorial = getTextValue(elemento,"editorial");
		int num_paginas = getIntValue(elemento,"num_paginas");
		
		Libro nuevoLibro = new Libro(titulo, autor, a�o, editorial,num_paginas);
		
		return nuevoLibro;
		
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
			Libro libro = (Libro) it.next();
			System.out.println("T�tulo: "+libro.getTitulo());
			System.out.println("Autor: "+libro.getAutor());
			System.out.println("A�o: "+libro.getA�o());
			System.out.println("Editorial: "+libro.getEditorial());
			System.out.println("P�ginas: "+libro.getNumero_paginas());
			System.out.println("");
		}
	}
}