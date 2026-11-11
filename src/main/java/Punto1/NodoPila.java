package Punto1;

class NodoPila<T> {                                     // Nodo generico exclusivo de la pila
    T dato;                                             // Dato que guarda el nodo
    NodoPila<T> sig;                                    // Enlace al nodo de abajo

    NodoPila(T dato) {                                  // Constructor: recibe el dato
        this.dato = dato;                               // Guarda el dato
    }                                                   // Fin del constructor
}                                                       // Fin de Punto1.NodoPila