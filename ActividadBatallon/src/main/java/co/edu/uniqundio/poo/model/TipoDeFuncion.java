package co.edu.uniqundio.poo.model;

public enum TipoDeFuncion {
    LOGISTICA(1),
    COMUNICACIONES(2),
    MEDICO(3);

    private final int valor;

    TipoDeFuncion(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
    public static TipoDeFuncion valorATexto(int valor) {
        for (TipoDeFuncion tipoAux : TipoDeFuncion.values()) {
            if (tipoAux.getValor() == valor) {
                return tipoAux;
            }
        }
        throw new IllegalArgumentException("No existe ese esta funcionalidad de Vehiculo.");
    }

}
