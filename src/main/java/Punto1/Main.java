package Punto1;                                         // Paquete donde estan todas las clases

import Punto2.Operacion;
import Punto2.Pila;

public class Main {                                     // Clase principal con la funcion y el main

    public static Pila<Operacion> obtenerUltimasConfirmadas(Pila<Operacion> historial, int n) {  // Recibe el historial y n
        Pila<Operacion> resultado = new Pila<>();       // Pila que se va a devolver
        if (n <= 0) return resultado;                   // Si n <= 0, devuelve la pila vacia

        Pila<Operacion> aux = new Pila<>();             // Auxiliar para restaurar el original
        Pila<Operacion> temp = new Pila<>();            // Guarda las confirmadas (quedan al reves)
        int cont = 0;                                   // Cuenta cuantas confirmadas llevamos

        while (!historial.isEmpty()) {                  // Mientras queden operaciones en el original
            Operacion op = historial.pop();             // Saca la operacion del tope
            aux.push(op);                               // La guarda en aux para no perderla
            if (op.estado == Punto2.Estado.CONFIRMADA && cont < n) {  // Si esta confirmada y aun no llego a n
                temp.push(op);                          // La guarda en temp
                cont++;                                 // Suma una confirmada al contador
            }
        }

        while (!aux.isEmpty()) {                        // Mientras aux tenga elementos
            historial.push(aux.pop());                  // Los devuelve al original (queda igual)
        }

        while (!temp.isEmpty()) {                       // Mientras temp tenga elementos
            resultado.push(temp.pop());                 // Los pasa a resultado (la mas reciente queda arriba)
        }

        return resultado;                               // Devuelve las n confirmadas mas recientes
    }

    public static void imprimir(String titulo, Pila<Operacion> pila) {  // Muestra una pila sin danarla
        Pila<Operacion> aux = new Pila<>();             // Auxiliar para restaurar la pila
        System.out.println(titulo + " (tope -> fondo):");  // Imprime el titulo
        while (!pila.isEmpty()) {                       // Mientras queden elementos
            Operacion op = pila.pop();                  // Saca el del tope
            System.out.println("  " + op);              // Lo imprime
            aux.push(op);                               // Lo guarda en aux
        }
        while (!aux.isEmpty()) {                        // Mientras aux tenga elementos
            pila.push(aux.pop());                       // Los devuelve a la pila original
        }
    }

    public static void main(String[] args) {            // Punto de entrada del programa
        Pila<Operacion> historial = new Pila<>();       // Crea el historial vacio
        historial.push(new Operacion("O1", Punto2.Estado.ANULADA));      // O1 queda en el fondo
        historial.push(new Operacion("O2", Punto2.Estado.CONFIRMADA));   // Apila O2
        historial.push(new Operacion("O3", Punto2.Estado.CONFIRMADA));   // Apila O3
        historial.push(new Operacion("O4", Punto2.Estado.ANULADA));      // Apila O4
        historial.push(new Operacion("O5", Punto2.Estado.CONFIRMADA));   // O5 queda en el tope (la mas reciente)

        imprimir("Historial original", historial);      // Muestra el historial antes de usar la funcion

        Pila<Operacion> r2 = obtenerUltimasConfirmadas(historial, 2);    // Prueba con n = 2
        imprimir("Resultado n = 2", r2);                // Debe mostrar O5 arriba y O3 debajo

        Pila<Operacion> r10 = obtenerUltimasConfirmadas(historial, 10);  // Prueba con n mayor a las confirmadas
        imprimir("Resultado n = 10", r10);              // Debe mostrar O5, O3 y O2

        Pila<Operacion> r0 = obtenerUltimasConfirmadas(historial, 0);    // Prueba con n = 0
        System.out.println("Resultado n = 0 vacia? " + r0.isEmpty());    // Debe imprimir true

        imprimir("Historial despues (debe ser igual)", historial);       // Comprueba que el original no cambio
    }
}