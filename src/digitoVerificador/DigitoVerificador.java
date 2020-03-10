package digitoVerificador;

import java.util.ArrayList;
import java.util.Scanner;

import utilidades.Utilidades;

public class DigitoVerificador {

	public static final int[] SERIE_NUMERICA = { 2, 3, 4, 5, 6, 7, 2, 3 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese su RUN sin digito verificador obviamente");
		int run = Utilidades.pedirEntero(scanner);
		System.out.println("Su digito verificador es: " + ObtenerDigitoVerificador(run));
		scanner.close();
	}

	public static String ObtenerDigitoVerificador(int run) {
		String digitoVerificador;
		int runRestante = run;
		ArrayList<Integer> digitos = new ArrayList<Integer>();

		do {

			digitos.add(runRestante % 10);
			runRestante = runRestante / 10;

		} while (runRestante >= 1);

		int suma = 0;
		for (int i = 0; i < digitos.size(); i++) {
			suma += digitos.get(i) * SERIE_NUMERICA[i];

		}

		int calmod11 = 11 - (suma % 11);

		switch (calmod11) {
		case 11:
			digitoVerificador = "0";
			break;
		case 10:
			digitoVerificador = "K";
			break;
		default:
			digitoVerificador = Integer.toString(calmod11);
			break;
		}

		return digitoVerificador;
	}
}
