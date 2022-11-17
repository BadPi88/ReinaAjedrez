package org.iesalandalus.programacion.reinaajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reinaajedrez.modelo.Consola;
import org.iesalandalus.programacion.reinaajedrez.modelo.Reina;

public class MainApp {

	static Reina reina;

	private static void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			crearReinaPorDefecto();
			mostrarReina();
			break;
		case 2:
			crearReinaColor();
			mostrarReina();
			break;
		case 3:

			// Incluimos if para evitar error de reina nula
			if (reina == null) {
				System.out.println("No es posible mover una reina que no existe.");
			} else {
				mover();
				mostrarReina();
			}
			break;
		case 4:
			Consola.despedirse();
			break;
		}
	}

	private static void crearReinaPorDefecto() {
		reina = new Reina();
	}

	private static void crearReinaColor() {
		reina = new Reina(Consola.elegirColor());
	}

	private static void mover() {
		Consola.mostrarMenuDirecciones();
		try {
			reina.mover(Consola.elegirDireccion(), Consola.elegirPasos());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void mostrarReina() {
		if (reina == null) {
			throw new NullPointerException("Reina no extiste");
		} else {
			System.out.println(reina.toString());
		}
	}

	public static void main(String[] args) {
		int opcion;
		do {
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcionMenu();
			ejecutarOpcion(opcion);

		} while (opcion != 4);
	}
}
