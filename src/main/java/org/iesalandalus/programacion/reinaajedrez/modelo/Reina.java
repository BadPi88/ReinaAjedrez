package org.iesalandalus.programacion.reinaajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Reina {

	private Color color;
	private Posicion posicion;

	public Reina() {
		setColor(Color.BLANCO);
		this.posicion = new Posicion(1, 'd');
	}

	public Reina(Color color) {
		setColor(color);

		switch (color) {
		case BLANCO:
			setPosicion(new Posicion(1, 'd'));
			break;
		case NEGRO:
			setPosicion(new Posicion(8, 'd'));
			break;
		}
	}

	public Color getColor() {
		return color;
	}

	// Color no puede ser nulo hacer condicion.
	private void setColor(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: El color no puede ser nulo.");
		}
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	//Excepciones y posibles movimientos

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {

		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (pasos < 1 || pasos > 7) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe estar comprendido entre 1 y 7.");
		}

		char nuevaColumna = getPosicion().getColumna();
		int nuevaFila = getPosicion().getFila();
		// Incluir todas las posibles direcciones
		switch (direccion) {
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
			setPosicion(new Posicion(nuevaFila, nuevaColumna));

		} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
		}
	}

	public String toString() {
		return "color=" + color + ", posicion=(" + getPosicion().toString() + ")";
	}

}
