package ejercicio4;

import java.util.Scanner;
/*
 * Esta clase Java implementa un método recursivo que multiplica un número entero, introducido
 * por el usuario, por todos los número pares hasta el 100 incluido. Lo muestra por pantalla
 * como una tabla de multiplicar.
 */
public class Recursivo {
	
	/*
	 * Pre: Recibe un entero i dado por el usuario que será el número a multiplicar, además recibe
	 * 		un número num que multiplicará al número i.
	 * Post: Este método muestra por pantalla un número dado(i) por todos los números pares
	 * 		hasta el 100.
	 */
	public static void tablaMultiplicar(int i, int num) {
		if (num < 100) {
			System.out.println(i + " x " + num + " = " + i*num);
			tablaMultiplicar(i, num+2);
		} else {
			System.out.println(i + " x " + num + " = " + i*num);
		}
	}
	
	/*
	 * Pre: 
	 * Post: Este método pide al usuario que introduzca un número entero y se lo manda junto con uno
	 * 		con valor 0 al método tablaMultiplicar().
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Por favor introduce un número entero");
		System.out.print("--> ");
		int i = entrada.nextInt();
		int num = 0;
		tablaMultiplicar(i, num);
		entrada.close();
	}

}
