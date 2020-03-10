package maximoComunDivisor;

import java.util.ArrayList;
import java.util.Scanner;

import numeroPrimo.NumeroPrimo;
import utilidades.Utilidades;

public class MaximoComunDivisor {
	public static final int LIMITE_INFERIOR = 0;
	public static final int LIMITE_SUPERIOR = 999999999;
	public static final Character CHARACTER_VALIDO_TRUE = 's';

	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<Integer>();

		Character opcion;
		Scanner scanner = new Scanner(System.in);

		System.out.println("ingrese el primer numero de los que desea calcular el mcd");
		numeros.add(Utilidades.pedirEntero(scanner, LIMITE_INFERIOR, LIMITE_SUPERIOR));
		System.out.println("ingrese el segundo numero de los que desea calcular el mcd");
		numeros.add(Utilidades.pedirEntero(scanner, LIMITE_INFERIOR, LIMITE_SUPERIOR));

		System.out.println("Desea ingresar otro numero? (s/n)");
		opcion = Utilidades.pedirContinuar(scanner);

		while (opcion.equals(CHARACTER_VALIDO_TRUE)) {

			System.out.println("ingrese el siguiente numero");
			numeros.add(Utilidades.pedirEntero(scanner, LIMITE_INFERIOR, LIMITE_SUPERIOR));

			System.out.println("Desea ingresar otro numero? (s/n)");
			opcion = Utilidades.pedirContinuar(scanner);

		}

		numeros.sort(null);

		System.out.println("el MCD es: " + calcularMCD(numeros));

		scanner.close();

	}

	public static int calcularMCD(ArrayList<Integer> numeros) {

		ArrayList<Integer> primos = new ArrayList<Integer>();
		ArrayList<Integer> potencias = new ArrayList<Integer>();

		primos = NumeroPrimo.generarPrimos(numeros.get(numeros.size() - 1));

		int i;
		int j = 0;
		int potencia;

		// se genera un arraylist para obtener las potencias del mismo tamaño de los
		// primos
		for (int k = 0; k < primos.size(); k++) {
			potencias.add(k, 999999999);
		}

		// se realiza un bucle que toma cada numero ingresado y lo va dividiendo entre
		// los primos menores a el
		do {
			i = 0;

			int numtemp = numeros.get(j);
			// se busca la potencia de cada primo y se guarda solo la menor
			while (i != primos.size()) {
				potencia = 0;
				// se divide el numero hasta que el resto sea distinto de cero y se guarda la
				// minima potencia de cada primo
				while (numtemp % primos.get(i) == 0) {
					numtemp = numtemp / primos.get(i);
					potencia++;
				}
				// se guarda el valor solo si la potencia es menor que los valores previamente
				// obtenidos
				if (potencia < potencias.get(i)) {
					potencias.set(i, potencia);
				}
				i++;
			}

			j++;
		} while (j < numeros.size());

		// se multiplican los primos por las minimas potencias obtenidas
		int mcm = 1;
		for (int k = 0; k < potencias.size(); k++) {
			mcm *= (int) Math.pow(primos.get(k), potencias.get(k));
		}

		return mcm;
	}

}
