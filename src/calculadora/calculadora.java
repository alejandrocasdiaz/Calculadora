package calculadora;

import java.util.Scanner;

public class calculadora {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int opcion = -1; // Iniciamos la opción de menú con un valor cualquiera
		
		// Iniciamos un bucle para que el usuario pueda volver al menú tras realizar una operación
		while (opcion!=0) {
			
			System.out.println("=== Calculadora Básica ===");
			System.out.println();
			
			System.out.println("1.- Suma");
			System.out.println("2.- Resta");
			System.out.println("3.- Multiplicación");
			System.out.println("4.- División");
			System.out.println("5.- Raíz cuadrada");
			System.out.println("6.- Potencia");
			System.out.println("0.- Salir");System.out.println();
			System.out.print("Selecciona una opción: ");
			
			// Validamos que la opción introducida por el usuario sea un valor de tipo int
			try {
				opcion = entrada.nextInt();
			} catch (Exception e) {
				System.out.println("ERROR: Por favor, introduce un número.");
				entrada.next();
			}
			
			// Iniciamos un switch con las diferentes opciones del menú
			switch (opcion) {
			
			// Pedimos dos números y llamamos al método que realiza la operación de suma
			case 1:
				double num1 = leerNumero(entrada, "Introduce un primer número: ");
				double num2 = leerNumero(entrada, "Introduce un segundo número: ");
				
				System.out.printf("Resultado: %.2f%n", suma(num1,num2));System.out.println();
				System.out.println("Regresando al menú...");System.out.println();
				break;

			// Pedimos dos números y llamamos al método que realiza la operación de resta
			case 2:
				num1 = leerNumero(entrada, "Introduce un primer número: ");
				num2 = leerNumero(entrada, "Introduce un segundo número: ");
				
				System.out.printf("Resultado: %.2f%n", resta(num1,num2));System.out.println();
				System.out.println("Regresando al menú...");System.out.println();
				break;
			
			// Pedimos dos números y llamamos al método que realiza la operación de multiplicación
			case 3:
				num1 = leerNumero(entrada, "Introduce un primer número: ");
				num2 = leerNumero(entrada, "Introduce un segundo número: ");
				
				System.out.printf("Resultado: %.2f%n", multiplicacion(num1,num2));System.out.println();
				System.out.println("Regresando al menú...");System.out.println();
				break;
			
			// Pedimos dos números y llamamos al método que realiza la operación de división
			case 4:
				num1 = leerNumero(entrada, "Introduce un primer número: ");
				num2 = leerNumero(entrada, "Introduce un segundo número: ");
				
				// Con un bucle While, comprobamos que el segundo número no sea 0, ya que la división no se podrá realizar
				while (num2==0) {
					System.out.println("ERROR: La división entre 0 no está permitida.");System.out.println();
					System.out.print("Introduce un segundo número: ");
					num2 = entrada.nextDouble();
					entrada.nextLine();
				}
				
				System.out.printf("Resultado: %.2f%n", division(num1,num2));System.out.println();
				System.out.println("Regresando al menú...");System.out.println();
				break;
				
			// Pedimos un número y llamamos al método que realiza la operación de raíz cuadrada
			case 5:
				num1 = leerNumero(entrada, "Introduce un número: ");
				
				// Bucle que lanza un error cuando el usuario inserta un número negativo
				while (num1<0) {
					System.out.println("ERROR: El número no puede ser negativo.");
					num1 = leerNumero(entrada, "Introduce un número: ");
				}
				System.out.printf("Resultado: %.2f%n", raizCuadrada(num1));System.out.println();
				System.out.println("Regresando al menú...");System.out.println();
				break;
				
			// Pedimos dos números y llamamos al método que realiza la operación de potencia
			case 6:
				num1 = leerNumero(entrada, "Introduce un número: ");
				num2 = leerNumero(entrada, "Introduce el número de la potencia: ");
				
				System.out.printf("Resultado: %.2f%n", potencia(num1,num2));System.out.println();
				System.out.println("Regresando al menú...");System.out.println();
				break;
			
			// Opción que ejecuta el fin del programa
			case 0:
				System.out.println("Fin del programa.");
				break;
			
			// Mensaje de error en caso de introducir una opción inválida del menú
			default:
				System.out.println("Opción no válida, introduzca un número del 0-6.");
				System.out.println();
				break;
			}
		}
		
		entrada.close();
	}
	
	// Método para la validación de números
	public static double leerNumero(Scanner entrada, String mensaje) {
		double numero = 0;
		boolean valido = false;
		
		while (!valido) {
			System.out.print(mensaje);
			try {
				numero = entrada.nextDouble();
				valido = true;
			} catch (Exception e) {
				System.out.println("ERROR: Por favor, introduce un número.");System.out.println();
				entrada.next();
			}
		}
		
		return numero;
	}
	
	// Método para la suma
	public static double suma(double num1, double num2) {
		return num1+num2;
	}
	
	// Método para la resta
	public static double resta(double num1, double num2) {
		return num1-num2;
	}
	
	// Método para la multiplicación
	public static double multiplicacion(double num1, double num2) {
		return num1*num2;
	}
	
	// Método para la división
	public static double division(double num1, double num2) {
		return num1/num2;
	}
	
	// Método para la raíz cuadrada
	public static double raizCuadrada(double num1) {
		return Math.sqrt(num1);
	}
	
	// Método para la potencia
	public static double potencia(double num1, double num2) {
		return Math.pow(num1, num2);
	}

}