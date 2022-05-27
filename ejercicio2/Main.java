package ejercicio2;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	public static void leerFichero(String fichero) {
		File file = new File(fichero);
		int conSeparacion = 0;
		int sinSeparacion = 0;
		try {
			Scanner f = new Scanner(file);
			f.nextLine();
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] palabra = linea.split(";");
				String numero = "";
				for(int i=0; i<palabra[3].length(); i++) {
					if(palabra[3].substring(i, i+1).equals(".")) {
					} else {
						numero = numero + palabra[3].substring(i, i+1);
					}
				}
				if (palabra[2].equals("2019")) {
					int num = Integer.parseInt(numero);
					if (palabra[1].equals("Si")) {
						conSeparacion = conSeparacion + num;
					} else {
						sinSeparacion = sinSeparacion + num;
					}
				}
			}
			f.close();
		}catch(Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser leído");
		}
		System.out.println("Total divorcios CON separación previa --> " + conSeparacion);
		System.out.println("Total divorcios SIN separación previa --> " + sinSeparacion);
	}
	
	public static void main(String[] args) {
		String fichero = "C:\\Users\\Luisao\\Desktop\\ExamenProgramacion\\Divorcios.csv";
		leerFichero(fichero);
	}

}
