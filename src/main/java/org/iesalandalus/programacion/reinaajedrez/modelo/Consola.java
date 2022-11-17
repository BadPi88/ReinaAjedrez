package org.iesalandalus.programacion.reinaajedrez.modelo;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private Consola() {
	}
	public static void mostrarMenu(){
		System.out.println("Menu: ");
		System.out.println("1.Crear reina por defecto.");
		System.out.println("2.Crear reina eligiendo color.");
		System.out.println("3.Mover");
		System.out.println("4.Salir");
	}
	public static int elegirOpcionMenu() {
		int opcion;
		
		do {
			System.out.println("Elige una opcion.");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 4 );
		return opcion;
	}
	public static Color elegirColor() {
		int opcionColor;
		do {
			System.out.println("1.Reina de color negro");
			System.out.println("2.Reina de colo Blanco");
			opcionColor = Entrada.entero();
		} while (opcionColor <1 || opcionColor > 2);
		
		if(opcionColor == 1){
		return Color.NEGRO;
		}else {
		return Color.BLANCO;
		}
		
	}
	
	public static void mostrarMenuDirecciones() {
		System.out.println("1.Norte");
		System.out.println("2.Noreste");
		System.out.println("3.Este");
		System.out.println("4.Sureste");
		System.out.println("5.Sur");
		System.out.println("6.Suroeste");
		System.out.println("7.Oeste");
		System.out.println("8.Noroeste");
	}
	public static Direccion elegirDireccion(){
		int opcionDireccion;
		Direccion direccion = Direccion.NOROESTE;
		
		do {
			System.out.println("Elige una opcion.");
			opcionDireccion = Entrada.entero();

		} while (opcionDireccion < 1 || opcionDireccion > 8);
		
		//respetar orden de orientaciones de mostrarMenuDirecciones.
		switch (opcionDireccion) {
		case 1:
			direccion = Direccion.NORTE;
			break;
		case 2:
			direccion = Direccion.NORESTE;
			break;
		case 3:
			direccion = Direccion.ESTE;
			break;
		case 4:
			direccion = Direccion.SURESTE;
			break;
		case 5:
			direccion = Direccion.SUR;
			break;
		case 6:
			direccion = Direccion.SUROESTE;
			break;
		case 7:
			direccion = Direccion.OESTE;
			break;
		}
		// Case 8 lo saltamos porque ya tenemos direccion con valor NOROESTE y en el caso de que
		// no se cumpla ningun otro case valdra NOROESTE.
		return direccion;
	}
	public static int elegirPasos() {
		int pasos;
		System.out.println("Elige un numero de pasos.");
		pasos = Entrada.entero();
		return pasos;
	}
	public static void despedirse(){
		System.out.println("Adios.");
	}
}
