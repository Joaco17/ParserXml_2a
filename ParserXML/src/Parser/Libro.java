package Parser;

import java.io.Serializable;

public class Libro implements Serializable {
private String titulo;
private String autor;
private int a�o;
private String editorial;
private int numero_paginas;

public Libro(String t, String a, int a�, String e, int num){
	this.titulo=t;
	this.autor= a;
	this.a�o=a�;
	this.editorial=e;
	this.numero_paginas=num;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getAutor() {
	return autor;
}

public void setAutor(String autor) {
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
	return numero_paginas;
}

public void setNumero_paginas(int numero_paginas) {
	this.numero_paginas = numero_paginas;
}


}

