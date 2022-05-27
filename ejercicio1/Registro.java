package ejercicio1;

/*
 * Esta clase Java crea el objeto de tipo Registro.
 */
public class Registro {
	private String letra;
	private String palabra;
	private int linea;
	
	public Registro(String letra, String palabra, int linea) {
		this.letra = letra;
		this.palabra = palabra;
		this.linea = linea;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	@Override
	public String toString() {
		return "Registro [letra=" + letra + ", palabra=" + palabra + ", linea=" + linea + "]";
	}
}
