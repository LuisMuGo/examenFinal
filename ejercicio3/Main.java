package ejercicio3;

/*
 * Esta clase Java crea y manda los nodos a los distintos métodos de la clase
 * ListaenlazaSimple. Los muestra por pantalla y ejecuta un método que elimina
 * el nodo con el contenido(enteros) mayor de todos.
 */
public class Main {
	
	/*
	 * Pre:---
	 * Post: Este método main crea los nodos y los añade a la lista enlaza simple.
	 * 		También llama a los métodos eliminarMayor() y show() de la clase
	 * 		ListaenlazadaSimple.
	 */
	public static void main(String[] args) {
		ListaenlazadaSimple l = new ListaenlazadaSimple();
		Node n1 = new Node(20, null);
		Node n2 = new Node(25, null);
		Node n3 = new Node(30, null);
		Node n4 = new Node(35, null);
		Node n5 = new Node(40, null);
		Node n6 = new Node(80, null);
		Node n7 = new Node(50, null);
		Node n8 = new Node(55, null);
		Node n9 = new Node(60, null);
		l.add(n1);
		l.add(n2);		
		l.add(n3);
		l.add(n4);
		l.add(n5);
		l.add(n6);
		l.add(n7);
		l.add(n8);
		l.add(n9);
		l.show();
		System.out.println("#################################");
		l.eliminarMayor(l);
		l.show();
	}
}
