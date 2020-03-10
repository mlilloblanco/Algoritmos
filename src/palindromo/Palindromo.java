package palindromo;

import java.util.Scanner;

import utilidades.Utilidades;

public class Palindromo {

	public static final Character CHARACTER_VALIDO_TRUE = 's';

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Scanner entrada = new Scanner(System.in);
		Character opcion;
		String texto;

		do {
			System.out.println("Ingrese el texto que desea comprobar si es palindromo");
			texto = entrada.nextLine().toLowerCase();

			if (esPalindromo(texto)) {
				System.out.println("El texto es palindromo");
			} else {
				System.out.println("El texto NO es palindromo");
			}

			System.out.println("Desea consultar otro texto? (s/n)");
			opcion = Utilidades.pedirContinuar(scanner);

		} while (opcion.equals(CHARACTER_VALIDO_TRUE));

		scanner.close();
		entrada.close();
	}

	public static boolean esPalindromo(String texto) {

		boolean esPalindromo;
		// se quitan espacios,puntos y comas. Ademas se reemplazan espacios
		String textoCorregido = texto.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u").replace("ü", "u").replace(" ", "")
				.replace(".", "").replace(",", "");

		//invierte el texto ya corregido sin comas , puntos y espacios
		String textoInvertido = new StringBuilder(textoCorregido).reverse().toString();
		
		if (textoCorregido.equals(textoInvertido)) {
			esPalindromo = true;
			return esPalindromo;
		} else {
			esPalindromo = false;
			return esPalindromo;
		}
	}
}