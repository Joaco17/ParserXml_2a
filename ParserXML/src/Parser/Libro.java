package Parser;

import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {
private String titulo;
private ArrayList<String> autor;
private int a�o;
private String editorial;
private int numPaginas;

public Libro(String t, ArrayList<String> autor, int a�, String e, int numP){
	this.titulo=t;
	this.autor= autor;
	this.a�o=a�;
	this.editorial=e;
	this.numPaginas=numP;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public ArrayList<String> getAutor() {
	return autor;
}

public void setAutor(ArrayList<String> autor) {
	this.autor = autor;
}

public int getA�o() {
	return a�o;
}

public void setA�o(int a�o) {
	this.a�o = a�o;
}

public String getEditorial() {
	return editorial;
}

public void setEditorial(String editorial) {
	this.editorial = editorial;
}

public int getNumero_paginas() {
	return numPaginas;
}

public void setNumero_paginas(int numero_paginas) {
	this.numPaginas = numero_paginas;
}

public void print(){
	System.out.println("Titulo: "+titulo);
	
	System.out.println("Autor: "+autor.get(0)+" "+autor.get(1));			
	
	System.out.println("A�o: "+a�o);
	System.out.println("Editorial: "+editorial);
	System.out.println("Numero de paginas: "+numPaginas);
	System.out.println("------------------------------------");
}


}

