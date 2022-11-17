package org.iesalandalus.programacion.reinaajedrez.modelo;

public enum Color {
	BLANCO("Blanco"), NEGRO("Negro");

	private String color;

	private Color(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return color;
	}

}
