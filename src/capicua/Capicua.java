package capicua;

import java.util.Scanner;

import utilidades.Utilidades;

public class Capicua {
	public static final Character CHARACTER_VALIDO_TRUE = 's';

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Character opcion;

		do {
			System.out.println("Ingrese el numero que desea comprobar si es capicua");
			int num = Utilidades.pedirEntero(scanner);
			
			if (comprobarCapicua(num)) {
				System.out.println("El numero: " + num + " es capicua");
			} else {
				System.out.println("El numero: " + num + " NO es capicua");
			}
			
			System.out.println("Desea consultar otro numero? (s/n)");
			opcion = Utilidades.pedirContinuar(scanner);
			
		} while (opcion.equals(CHARACTER_VALIDO_TRUE));

		scanner.close();
	}

	public static boolean comprobarCapicua(int num) {
		int numRestante = num;
		int numInvertido = 0;
		boolean esCapicua;

		//se realiza un bucle dividiendo el numero en 10 hasta que el numero ya no sea mayor a 1
		do {
			//se invierte el numero multiplicando el numero existente en 10 y agregandole el resto
			numInvertido = numInvertido * 10 + numRestante % 10;
			numRestante = numRestante / 10;

		} while (numRestante >= 1);

		if (num == numInvertido) {
			esCapicua = true;
			return esCapicua;
		} else {
			esCapicua = false;
			return esCapicua;
		}
	}
}
