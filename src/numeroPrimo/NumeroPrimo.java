package numeroPrimo;

import java.util.ArrayList;
import java.util.Scanner;

import utilidades.Utilidades;

public class NumeroPrimo {

	public static final int LIMITE_INFERIOR = 0;
	public static final int LIMITE_SUPERIOR = 999999999;
	public static final Character CHARACTER_VALIDO_TRUE = 's';

	public static void main(String[] args) {

		int num;
		Character opcion;
		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("ingrese el numero que desea comprobar si es primo");
			num = Utilidades.pedirEntero(scanner, LIMITE_INFERIOR, LIMITE_SUPERIOR);

			if (comprobarPrimo(num)) {
				System.out.println("El numero " + num + " es primo");
				System.out.println(generarPrimos(num));
			} else {
				System.out.println("El numero " + num + " NO es primo");
				System.out.println(generarPrimos(num));
			}

			System.out.println("Desea consultar otro numero? (s/n)");
			opcion = Utilidades.pedirContinuar(scanner);

		} while (opcion.equals(CHARACTER_VALIDO_TRUE));

		scanner.close();
	}

	public static boolean comprobarPrimo(int num) {

		if (num < 2) {
			return false;
		} else if (num == 2) {
			return true;
		} else if (num % 2 == 0) {
			return false;
		} else {
			for (int i = 3; i <= Math.sqrt(num); i += 2) {

				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public static ArrayList<Integer> generarPrimos(int num) {
		int contador;
		ArrayList<Integer> primos = new ArrayList<Integer>();
		if (num >= 2) {
			primos.add(2);
		}
		for (int i = 3; i <= num; i += 2) {
			contador = 0;
			for (int j = 3; j <= Math.sqrt(i); j += 2) {
				if (i % j == 0) {
					contador++;
				}
			}

			if (contador == 0) {
				primos.add(i);
			}
		}
		return primos;
	}
}
