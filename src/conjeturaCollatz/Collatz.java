package conjeturaCollatz;

import java.util.ArrayList;
import java.util.Scanner;

import utilidades.Utilidades;

public class Collatz {

	public static final int LIMITE_INFERIOR = 0;
	public static final int LIMITE_SUPERIOR = 999999999;
	public static final Character CHARACTER_VALIDO_TRUE = 's';

	public static void main(String[] args) {

		int num;
		Character opcion;
		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("ingrese el numero al que desea genera la serie de Collatz");
			num = Utilidades.pedirEntero(scanner, LIMITE_INFERIOR, LIMITE_SUPERIOR);

			System.out.println(generarCollatz(num));

			System.out.println("Desea consultar otro numero? (s/n)");
			opcion = Utilidades.pedirContinuar(scanner);

		} while (opcion.equals(CHARACTER_VALIDO_TRUE));

		scanner.close();
	}

	public static ArrayList<Integer> generarCollatz(int num) {
		int numero = num;
		ArrayList<Integer> collatz = new ArrayList<Integer>();
		do {
			if (numero % 2 == 0) {
				numero = numero / 2;
				collatz.add(numero);
			} else {
				numero = numero * 3 + 1;
				collatz.add(numero);
			}
		} while (numero > 1);

		return collatz;
	}
}
