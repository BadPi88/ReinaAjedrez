package org.iesalandalus.programacion.reinaajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reinaajedrez.modelo.Consola;
import org.iesalandalus.programacion.reinaajedrez.modelo.Reina;

public class MainApp {
	
	static Reina reina;
	private static void crearReinaPorDefecto() {
	 	reina = new Reina();
	}
	private static void crearReinaColor() {
		reina = new Reina(Consola.elegirColor());
	}
	private static void mover(){
		Consola.mostrarMenu();
		try {
			reina.mover(Consola.elegirDireccion(), Consola.elegirPasos());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args){
		
			
		}
	
}
