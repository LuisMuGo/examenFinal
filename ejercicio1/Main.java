package ejercicio1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void leerFichero(String fichero, String letra) {
		ArrayList<String> palabras = new ArrayList<String>();
		File file = new File(fichero);
		int contador = 0;
		try {
			Scanner f = new Scanner(file);
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] palabra = linea.split(" ");
				for(int i=0; i<palabra.length; i++) {
					String buena = "";
					for(int j=0; j<palabra[i].length(); j++) {
						if(palabra[i].substring(j, j+1).equals(".") || palabra[i].substring(j, j+1).equals(",") ||
								palabra[i].substring(j, j+1).equals("¿") || palabra[i].substring(j, j+1).equals("?") ||
								palabra[i].substring(j, j+1).equals(";")) {
						} else {
							buena = buena + palabra[i].substring(j, j+1);
						}
					}
					palabras.add(buena);
				}
			}
			f.close();
		}catch(Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser leído");
		}
		for(int i=0; i<palabras.size(); i++) {
			if(palabras.get(i).substring(0, 1).equals(letra) || 
					palabras.get(i).substring(palabras.get(i).length()-1, palabras.get(i).length()).equals(letra)) {
				System.out.println(palabras.get(i));
				contador++;
			}
		}
		System.out.println("Número de palabras que empiezan o acaban por " + letra + "-->" + contador);
	}
	
	public static void main(String[] args) {
		String fichero = "C:\\Users\\Luisao\\Desktop\\HablanosDelDon.txt";
		String letra = "a";
		leerFichero(fichero, letra);
	}

}
