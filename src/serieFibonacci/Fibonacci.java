package serieFibonacci;

import java.util.ArrayList;
import java.util.Scanner;

import utilidades.Utilidades;

public class Fibonacci {

	public static final int FIBONACCI_0 = 0;
	public static final int FIBONACCI_1 = 1;
	public static final int LIMITE_INFERIOR = 1;
	public static final int LIMITE_SUPERIOR = 999999999;
	public static final Character CHARACTER_VALIDO_TRUE = 's';

	public static void main(String[] args) {

		int num;
		Character opcion;
		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("ingrese cuantos numeros desea ver la serie de Fibonacci");
			num = Utilidades.pedirEntero(scanner, LIMITE_INFERIOR, LIMITE_SUPERIOR);
			ArrayList<Integer> fibonacci = generarFibonacci(num);
			if (num == 1) {
				System.out.println("[" + fibonacci.get(0) + "]" );
			} else if (num == 2) {
				System.out.println("[" + fibonacci.get(0) + "," + fibonacci.get(1) + "]" );
			} else
			System.out.println(fibonacci);

			System.out.println("Desea generar la serie de Fibonacci con otra longitud? (s/n)");
			opcion = Utilidades.pedirContinuar(scanner);

		} while (opcion.equals(CHARACTER_VALIDO_TRUE));

		scanner.close();

	}

	public static ArrayList<Integer> generarFibonacci(int num) {

		ArrayList<Integer> fibonacci = new ArrayList<Integer>();
		
		fibonacci.add(FIBONACCI_0);
		fibonacci.add(FIBONACCI_1);
		
		int suma = 0;
		int aux1 = FIBONACCI_0;
		int aux2 = FIBONACCI_1;
		int i = 2;
		do {
			
			suma = aux1 + aux2;
			fibonacci.add(suma);
			aux1 = aux2;
			aux2 = suma;
			i += 1;
		} while (i <num);
		return fibonacci;
	}
}

