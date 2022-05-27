package ejercicio1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Esta clase Main lee un fichero .txt y localiza una serie de palabras que empiezan o terminan por una letra
 * determinada. Además guarda toda la información en una base de datos.
 */
public class Main {
	
	/*
	 * Pre: Recibe un String con la dirección del fichero .txt, un String con la letra y un objeto de tipo
	 * MySQLAccess para poder llamar al método que ejecuta el insert.
	 * Post: Este método Java lee un texto de un fichero .txt y guarda en un ArrayList las palabras de ese texto
	 * que empiezan o terminan por la letra indicada. Después manda la información de la palabra, junto con la letra
	 * y la línea donde está dicha palabra a una base de datos donde es almacenada la información.
	 */
	public static void leerFichero(String fichero, String letra, MySQLAccess dao) {
		ArrayList<Registro> registro = new ArrayList<Registro>();
		File file = new File(fichero);
		int contador = 0;
		try {
			Scanner f = new Scanner(file);
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] palabra = linea.split(" ");
				contador++;
				for(int i=0; i<palabra.length; i++) {
					String buena = "";
					//En este bucle limpio las palabras de carácteres que no son letras.
					for(int j=0; j<palabra[i].length(); j++) {
						if(palabra[i].substring(j, j+1).equals(".") || palabra[i].substring(j, j+1).equals(",") ||
								palabra[i].substring(j, j+1).equals("¿") || palabra[i].substring(j, j+1).equals("?") ||
								palabra[i].substring(j, j+1).equals(";")) {
						} else {
							buena = buena + palabra[i].substring(j, j+1);
						}
					}
					//Añado la información al ArrayList de tipo Registro.
					Registro x = new Registro(letra, buena, contador);
					registro.add(x);
				}
			}
			f.close();
		}catch(Exception e) {
			System.out.println("El fichero " + fichero + " no ha podido ser leído");
		}
		int num = 0;
		//Leo la información el ArrayList y mando las palabras que empiezan o acaban por la letra indicada a la base de datos.
		for(int i=0; i<registro.size(); i++) {
			if(registro.get(i).getPalabra().substring(0, 1).equals(letra) || 
					registro.get(i).getPalabra().substring(registro.get(i).getPalabra().length()-1, registro.get(i).getPalabra().length()).equals(letra)) {
				System.out.println(registro.get(i).getPalabra());
				try {
					dao.insertInfoDataBase(registro.get(i).getLetra(), registro.get(i).getPalabra(), registro.get(i).getLinea());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				num++;
			}
		}
		System.out.println("Número de palabras que empiezan o acaban por " + letra + "-->" + num);
	}
	
	/*
	 * Pre:---
	 * Post: Este método Java manda dos String y un objeto de tipo MySQLAccess al método leerFicheros.
	 */
	public static void main(String[] args) {
		MySQLAccess dao = new MySQLAccess();
		String fichero = "C:\\Users\\Luisao\\Desktop\\HablanosDelDon.txt";
		String letra = "a";
		leerFichero(fichero, letra, dao);
	}

}
