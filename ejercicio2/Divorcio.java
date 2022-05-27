package ejercicio2;

public class Divorcio {
	private String provincia;
	private int numDivorcios;
	
	public Divorcio(String provincia, int numDivorcios) {
		super();
		this.provincia = provincia;
		this.numDivorcios = numDivorcios;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getNumDivorcios() {
		return numDivorcios;
	}

	public void setNumDivorcios(int numDivorcios) {
		this.numDivorcios = numDivorcios;
	}

	@Override
	public String toString() {
		return "Divorcio [provincia=" + provincia + ", numDivorcios=" + numDivorcios + "]";
	}
}
