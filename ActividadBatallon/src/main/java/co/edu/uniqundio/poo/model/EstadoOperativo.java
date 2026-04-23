package co.edu.uniqundio.poo.model;

enum EstadoOperativo {
    DISPONIBLE(1),
    EN_MISION(2),
    EN_MANTENIMIENTO(3);


    private final int valor;

    EstadoOperativo(int valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return valor;
    }

    public static EstadoOperativo valorATexto(int valor) {
        for (EstadoOperativo estadoAux : EstadoOperativo.values()) {
            if (estadoAux.getCodigo() == valor) {
                return estadoAux;
            }
        }
        throw new IllegalArgumentException("No existe ese EstadoOperativo.");
    }
}