package arbolNario;

public class ArbolNario {

	private NodoArbolNario raiz;

	public ArbolNario(int dato) {
		raiz = new NodoArbolNario(dato);
	}

	public void insertar(ArbolNario arbol) {
		raiz.getHijos().insertar(arbol.raiz);
	}

	// ------------------------------------------------------------------------
	// TODO 2.2: Mostrar el arbol recorriendo en profundidad de forma RECURSIVA
	public void mostrarProfundidadRecursivo() {
		System.out.print("Profundidad Recursivo: ");
		preOrdenRec(raiz);
		System.out.println();
	}
	private void preOrdenRec(NodoArbolNario nodo) {
		if (nodo != null) {
			IteradorAdelanteListaNodosArbolNario it = nodo.getHijos().getIteradorAdelante();
			System.out.print(nodo.getDato() + " ");
			while (it.hasNext()){
				preOrdenRec(it.next());
			}
		}
	}
	// ------------------------------------------------------------------------
	// TODO 2.3: Mostrar el arbol recorriendo en profundidad de forma ITERATIVA
	public void mostrarProfundidadIterativo() {
		System.out.print("Profundidad Iterativo: ");
		PilaNodosArbolNario pila = new PilaNodosArbolNario();
		pila.apilar(raiz);
		while (!pila.vacia()){
			NodoArbolNario nodo = pila.desapilar();
			System.out.print(nodo.getDato() + " ");
			IteradorAtrasListaNodosArbolNario it = nodo.getHijos().getIteradorAtras();
			while (it.hasPrevious()){
				NodoArbolNario hijo = it.previous();
				pila.apilar(hijo);
			}
		}
		System.out.println();
	}

	// ------------------------------------------------------------------------
	// TODO 2.4: Mostrar el arbol recorriendo en amplitud de forma ITERATIVA
	public void mostrarAmplitud() {
		System.out.print("Amplitud: ");
		ColaNodosArbolNario cola = new ColaNodosArbolNario();
		cola.encolar(raiz);
		while (!cola.vacia()) {
			NodoArbolNario nodo = cola.desencolar();
			System.out.print(nodo.getDato() + " ");
			IteradorAdelanteListaNodosArbolNario it = nodo.getHijos().getIteradorAdelante();
			while (it.hasNext()) {
				cola.encolar(it.next());
			}
		}
		System.out.println();
	}
}