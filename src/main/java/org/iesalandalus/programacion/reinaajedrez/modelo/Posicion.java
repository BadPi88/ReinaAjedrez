package org.iesalandalus.programacion.reinaajedrez.modelo;

public class Posicion {
	
	private int fila;
	private char columna;
	
	private Posicion(int fila){
		setFila(fila);
		if(fila < 1 || fila > 8) {
			throw new NullPointerException ("El movimiento fila no es valido");
			}
		
		setColumna(columna);
		if(columna < 'a'|| columna > 'h' ) {
			throw new NullPointerException ("El movimiento en columna no es valido");
		}
	}
	
	private Posicion(char columna) {
		setColumna(columna);
		if(columna < 'a'|| columna > 'h' ) {
			throw new NullPointerException ("El movimiento en columna no es valido");
		}
	this.columna = columna;
	}
	
	public int getFila() {
		return fila;
	}
	
	public char getColumna() {
		return columna;
	}
	
	private void setColumna(char columna) {
		if(columna < 'a'|| columna > 'h' ) {
			throw new NullPointerException ("El movimiento no es valido");
		}
	this.columna = columna;
	}
	
	private void setFila(int fila) {
		if(fila < 1 || fila > 8) {
			throw new NullPointerException ("El movimiento no es valido");
		}
		this.fila= fila;
	}
	
}
