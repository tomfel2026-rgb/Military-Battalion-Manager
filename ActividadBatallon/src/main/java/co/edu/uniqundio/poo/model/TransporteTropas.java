package co.edu.uniqundio.poo.model;

public class TransporteTropas extends Vehiculo {
    private int capacidadSoldadosTransportados;

    public TransporteTropas(int capacidadSoldadosTransportados, String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {
        super(id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
        this.capacidadSoldadosTransportados = capacidadSoldadosTransportados;
    }

    public void setCapacidadSoldadosTransportados(int capacidadSoldadosTransportados) {
        this.capacidadSoldadosTransportados = capacidadSoldadosTransportados;
    }

    @Override
    public String toString() {
        return String.format("Vehículo de Tropas - Capacidad de Soldados: %s, ID: %s, Modelo: %s, Año: %d, Km: %d, Estado: %s, Misiones: %d\n",
            capacidadSoldadosTransportados, id , modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
    }
}
