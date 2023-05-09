package arbolBusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;

	public ArbolBinarioBusqueda() {
		raiz = null;
	}

	// Muestra los elementos del arbol binario en orden central ---------------
	public void mostrar() {
		this.mostrar(raiz, "  ");
	}

	private void mostrar(NodoArbol nodo, String espacios) {
		if (nodo != null) {
			this.mostrar(nodo.getIzquierdo(), espacios + "    ");
			System.out.print(espacios);
			nodo.getDato().mostrar();
			this.mostrar(nodo.getDerecho(), espacios + "    ");
		}
	}

	// Inserta un elemento con una cierta clave -------------------------------
	public void insertar(Alumno dato) {
		raiz = this.insertarRec(raiz, dato);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato) {
		if (nodo == null) {     // Crear nuevo nodo
			nodo = new NodoArbol(dato);
		} else if (dato.getMatricula() < nodo.getDato().getMatricula()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getDato().getMatricula()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {      // Clave repetida
			System.out.println("Error. El alumno con matrícula " + dato.getMatricula() + " ya existe");
		}
		return nodo;    // Devolver la nueva raíz del subárbol
	}


	// ------------------------------------------------------------------------
	// TODO 3.2: Devuelve el numero de nodos del arbol de forma RECURSIVA
	public int getNumElementos() {
		return getNumElementosRec(raiz);
	}

	private int getNumElementosRec(NodoArbol nodo) {
		if (nodo == null)
			return 0;
		return 1 + getNumElementosRec(nodo.getIzquierdo()) + getNumElementosRec(nodo.getDerecho());
	}


	// ------------------------------------------------------------------------
	// TODO 3.3: Devuelve el numero de nodos del arbol con clave
	// menor a una clave dada de forma RECURSIVA
	public int getNumMenores(int clave) {
		return getNumMenoresRec(clave, raiz);
	}

	private int getNumMenoresRec(int clave, NodoArbol nodo) {
		if (nodo == null)
			return 0;
		else if (nodo.getDato().getMatricula() < clave)
			return 1 + getNumElementosRec(nodo.getIzquierdo()) + getNumMenoresRec(clave, nodo.getDerecho());
		else
			return getNumMenoresRec(clave, nodo.getIzquierdo());
	}

	// ------------------------------------------------------------------------
	// TODO 3.4: Devuelve el elemento con la menor clave de forma RECURSIVA
	public Alumno getMenorElemento() {
		return getMenorElementoRecursivo(raiz);
	}

	private Alumno getMenorElementoRecursivo(NodoArbol nodo) {
		if (nodo == null) {
			return null;
		}
		if (nodo.getIzquierdo() == null) {
			return nodo.getDato();
		}
		return getMenorElementoRecursivo(nodo.getIzquierdo());
	}


	// ------------------------------------------------------------------------
	// TODO 3.5: Devuelve el número de nodos del árbol con clave mayor que
	// claveMinimo y menor que claveMaximo


	public int getNumIntermedios(int min, int max) {
		return getNumIntermediosRec(raiz, min, max);
	}

	private int getNumIntermediosRec(NodoArbol nodo, int min, int max) {
		if (nodo == null) {
			return 0;
		} else if (nodo.getDato().getMatricula() < min) {
			return getNumIntermediosRec(nodo.getDerecho(), min, max);
		} else if (nodo.getDato().getMatricula() > max) {
			return getNumIntermediosRec(nodo.getIzquierdo(), min, max);
		} else {
			return 1 + getNumIntermediosRec(nodo.getIzquierdo(), min, max) + getNumIntermediosRec(nodo.getDerecho(), min, max);
		}
	}
}

	/*
	public int getNumIntermedios(int claveMinimo, int claveMaximo) {
		return getNumIntermediosRec(claveMinimo, claveMaximo, raiz);
	}

	private int getNumIntermediosRec(int min, int max, NodoArbol nodo){
		return getNumElementos() - getNumMenores(min) - getNumMayores(max, nodo);
	}

	private int getNumMayores(int max, NodoArbol nodo){
		if (nodo == null) {
			return 0;
		}
		else if (nodo.getDato().getMatricula() > max)
			return 1 + getNumElementosRec(nodo.getDerecho()) + getNumMayores(max, nodo.getIzquierdo());
		else return getNumMayores(max, nodo.getDerecho());
	}
}
*/
