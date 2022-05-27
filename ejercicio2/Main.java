package ejercicio2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Esta clase Java lee un fichero .csv con la información de los divorcios en España de los últimos años
 * y muestra por pantalla información variada sobre estos.
 */
public class Main {
	
	/*
	 * Pre: Este método Java recibe un String con la localización del fichero.
	 * Post: Este método Java lee el fichero Divorcios.csv con información sobre los divorcios en España de los
	 * 	 	 últimos años. Muestra por pantalla el número de divorcios en 2019 con separación previa, el número
	 * 		 de divorcios en 2018 sin separación previa y la comunidad autónoma que mayor número de divorcios
	 * 		 ha tenido desde 2013 hasta 2019.
	 */
	public static void leerFichero(String fichero) {
		File file = new File(fichero);
		ArrayList<Divorcio> a = new ArrayList<Divorcio>();
		boolean encontrado = false;
		int conSeparacion = 0;
		int sinSeparacion = 0;
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] palabra = linea.split(";");
				String numero = "";
				String provincia = palabra[0];
				int position = 0;
				//En este bucle limpio la información del fichero de puntos.
				for(int i=0; i<palabra[3].length(); i++) {
					if(palabra[3].equals("..")) {
						numero = numero + "0";
						break;
					}
					if(palabra[3].substring(i, i+1).equals(".")) {
					} else {
						numero = numero + palabra[3].substring(i, i+1);
					}
				}
				//Como la información está en String hay que pasarla a entero para poder sumarla.
				int num = Integer.parseInt(numero);
				if (palabra[2].equals("2019")) {
					if (palabra[1].equals("Si")) {
						conSeparacion = conSeparacion + num;
					} 
				} 
				else if (palabra[2].equals("2018")) {
					if (palabra[1].equals("No")) {
						sinSeparacion = sinSeparacion + num;
					} 
				}
				//Recorro el ArrayList para comprobar si mi provincia está o no guardada.
				for (int i=0; i<a.size(); i++) {
					if (provincia.equals(a.get(i).getProvincia())) {
						encontrado = true;
						position = i;
						break;
					}
				}
				if (encontrado) {
					a.get(position).setNumDivorcios(a.get(position).getNumDivorcios()+num);
					position = 0;
					encontrado = false;
				} else {
					Divorcio x = new Divorcio(provincia, 1);
					a.add(x);
				}
			}
			f.close();
		}catch(Exception e) {
			System.out.println("Error en la lectura del fichero " + fichero);
		}
		//Encuentro la posición de la provincia en el ArrayList que tiene mayor número de divorcios.
		int guardado = 0;
		for(int i=0; i<a.size(); i++) {
			if(a.get(i).getNumDivorcios()>=a.get(guardado).getNumDivorcios()) {
				guardado = i;
			}
		}
		System.out.println("Total divorcios CON separación previa en 2019--> " + conSeparacion);
		System.out.println("Total divorcios SIN separación previa en 2018--> " + sinSeparacion);
		System.out.println("Provincia con más dicorcios--> " + a.get(guardado).getProvincia() + " con un total de " +
				a.get(guardado).getNumDivorcios() + " de divorcios");
	}
	
	/*
	 * Pre:---
	 * Post: Este método Java manda la localización del fichero Divorcios.csv al método leerFichero().
	 */
	public static void main(String[] args) {
		String fichero = "C:\\Users\\Luisao\\Desktop\\Divorcios.csv";
		leerFichero(fichero);
	}

}
