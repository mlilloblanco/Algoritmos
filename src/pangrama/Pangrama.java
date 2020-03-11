package pangrama;

import java.util.Scanner;

import utilidades.Utilidades;

public class Pangrama {
	
	public static final Character CHARACTER_VALIDO_TRUE = 's';

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Scanner entrada = new Scanner(System.in);
		Character opcion;
		String texto;

		do {
			System.out.println("Ingrese el texto que desea comprobar si es pangrama");
			texto = entrada.nextLine().toLowerCase();

			if (esPangrama(texto)) {
				System.out.println("El texto es pangrama");
			} else {
				System.out.println("El texto NO es pangrama");
			}

			System.out.println("Desea consultar otro texto? (s/n)");
			opcion = Utilidades.pedirContinuar(scanner);

		} while (opcion.equals(CHARACTER_VALIDO_TRUE));

		scanner.close();
		entrada.close();
	}

	public static boolean esPangrama(String texto) {

		String abecedario = "abcdefghijklmnñopqrstuvwxyz";
		// se quitan espacios,puntos y comas. Ademas se reemplazan espacios
		String textoCorregido = texto.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("ü", "u").replace(" ", "")
				.replace(".", "").replace(",", "");

		for (int i = 0; i < abecedario.length(); i++) {
			if (!textoCorregido.contains("" + abecedario.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
