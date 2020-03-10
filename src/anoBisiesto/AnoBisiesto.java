package anoBisiesto;

import java.util.Scanner;

import utilidades.Utilidades;

public class AnoBisiesto {
	public static final int LIMITE_INFERIOR = 1;
	public static final int LIMITE_SUPERIOR = 90000000;
	public static final Character CHARACTER_VALIDO_TRUE = 's';

	public static void main(String[] args) {

		int ano;
		Character opcion;
		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("ingrese el año que desea comprobar si es bisiesto");
			ano = Utilidades.pedirEntero(scanner, LIMITE_INFERIOR, LIMITE_SUPERIOR);

			if (comprobarBisiesto(ano)) {
				System.out.println("El año " + ano + " es bisiesto");
			} else {
				System.out.println("El año " + ano + " NO es bisiesto");
			}

			System.out.println("Desea consultar otro año? (s/n)");
			opcion = Utilidades.pedirContinuar(scanner);

		} while (opcion.equals(CHARACTER_VALIDO_TRUE));

		scanner.close();
	}

	public static boolean comprobarBisiesto(int ano) {
		if (ano % 4 == 0 && ano % 100 != 0) {
			return true;
		} else if (ano % 4 == 0 && ano % 400 == 0) {
			return true;

		} else {
			return false;
		}
	}

}
