package ejercicio4;

import java.util.Scanner;
/*
 * Esta clase Java implementa un m�todo recursivo que multiplica un n�mero entero, introducido
 * por el usuario, por todos los n�mero pares hasta el 100 incluido. Lo muestra por pantalla
 * como una tabla de multiplicar.
 */
public class Recursivo {
	
	/*
	 * Pre: Recibe un entero i dado por el usuario que ser� el n�mero a multiplicar, adem�s recibe
	 * 		un n�mero num que multiplicar� al n�mero i.
	 * Post: Este m�todo muestra por pantalla un n�mero dado(i) por todos los n�meros pares
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
	 * Post: Este m�todo pide al usuario que introduzca un n�mero entero y se lo manda junto con uno
	 * 		con valor 0 al m�todo tablaMultiplicar().
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Por favor introduce un n�mero entero");
		System.out.print("--> ");
		int i = entrada.nextInt();
		int num = 0;
		tablaMultiplicar(i, num);
		entrada.close();
	}

}
