package Punto1;

class Operacion {                                       // Representa una operacion del historial
    String codigo;                                      // Codigo de la operacion (ej: "O5")
    Punto1.Estado estado;                                      // Punto1.Estado: CONFIRMADA o ANULADA

    Operacion(String codigo, Punto1.Estado estado) {           // Constructor con codigo y estado
        this.codigo = codigo;                           // Guarda el codigo
        this.estado = estado;                           // Guarda el estado
    }                                                   // Fin del constructor

    @Override                                          // Redefinimos un metodo de Object
    public String toString() {                          // Como se imprime la operacion
        return codigo + " (" + estado + ")";            // Formato: O5 (CONFIRMADA)
    }                                                   // Fin de toString
}                                                       // Fin de Punto1.Operacion