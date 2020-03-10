package utilidades;

import java.util.Scanner;

public class Utilidades {
	
	public static int pedirEntero(Scanner scanner, int limiteInferior, int limiteSuperior) {

		int entero;

		do {
			entero = pedirEntero(scanner);

			if (entero < limiteInferior || entero > limiteSuperior)
				System.err.print(String.format("Ingrese un año entre %d y %d", limiteInferior, limiteSuperior));
		} while (entero < limiteInferior || entero > limiteSuperior);

		return entero;
	}

	public static int pedirEntero(Scanner scanner) {

		while (!scanner.hasNextInt()) {
			System.err.print("Ingrese un numero por favor" + ": ");
			scanner.next();
			
			/* si agregan mas un de una linea con este comando no enviara dos veces el mensaje de error*/
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		
		return scanner.nextInt();
	}

	public static Character pedirContinuar(Scanner scanner) {

		while (!scanner.hasNext("s") && !scanner.hasNext("n") && !scanner.hasNext("N") && !scanner.hasNext("S") ) {
			System.err.print("Ingrese un caracter valido s o n: ");
			scanner.next();
			
			/* si agregan mas un de una linea con este comando no enviara dos veces el mensaje de error*/
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}
		return scanner.next().toLowerCase().charAt(0);
	}
}
