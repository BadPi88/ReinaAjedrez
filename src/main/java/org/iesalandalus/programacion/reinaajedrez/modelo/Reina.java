package org.iesalandalus.programacion.reinaajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Reina {
	
	 private Color color;
	 private Posicion posicion;
	 
	public Color getColor() {
		return color;
	}
	
	private void setColor(Color color) {
		if(color != Color.BLANCO || color != Color.NEGRO) {
			throw new NullPointerException("El color de la reina tiene que ser blanco o negro");
		} else 
		this.color = color;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Reina(){
		setColor(Color.BLANCO);
		this.posicion = new Posicion(1,'d');
	}
	public Reina(Color color){
		setColor(color);
		
		switch (color){
		case BLANCO:
			  setPosicion(new Posicion(1,'d'));
			break;
		case NEGRO:
			setPosicion(new Posicion(8,'d'));
			break;
		}
	}
	public void Mover(Direccion direccion, int pasos) throws OperationNotSupportedException{
		
		if(pasos < 1 || pasos > 7 ){
			throw new IllegalArgumentException("Movimiento no valido");
		}
		
		if(direccion == null ){
			throw new NullPointerException("Movimiento no valido");
		}
		
		char nuevaColumna = getPosicion().getColumna() ;
		int nuevaFila = getPosicion().getFila();
		
		switch(direccion){
		case ESTE:
			nuevaColumna += pasos; 
			break;
		case NORESTE:
			nuevaColumna += pasos;
			nuevaFila += pasos;
			break;
		case NOROESTE:
			nuevaColumna -= pasos;
			nuevaFila += pasos;
			break;
		case NORTE:
			nuevaFila += pasos;
			break;
		case OESTE:
			nuevaColumna -= pasos;
			break;
		case SUR:
			nuevaFila -= pasos;
			break;
		case SURESTE:
			nuevaColumna += pasos;
			nuevaFila -= pasos;
			break;
		case SUROESTE:
			nuevaColumna -= pasos;
			nuevaFila -= pasos;
			break;
		}
		try {
			setPosicion(new Posicion(nuevaFila,nuevaColumna));
			
		}catch(IllegalArgumentException e){
			throw new OperationNotSupportedException("movimientoNoValido");
		}
			
		}
		
	}

