package com.example.tattoC.utils;


public class ElementosPagina {
	private int numero;
	private boolean actual;
	
	public ElementosPagina(int numero, boolean actual) {
		super();
		this.numero = numero;
		this.actual = actual;
	}
	
	public ElementosPagina() {
		super();
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isActual() {
		return actual;
	}
	public void setActual(boolean actual) {
		this.actual = actual;
	}	
	
}

