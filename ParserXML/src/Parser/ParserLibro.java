package Parser;

import java.util.ArrayList;

import org.w3c.dom.Document;


public class ParserLibro {
	
	
	private static Parser parser;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parser = new Parser();
		
		//METODOS
		
		parser.parseadorFicheroXml("Biblioteca.xml");
		
		parser.parsearDocumento();
		
		parser.print();
	}

}
