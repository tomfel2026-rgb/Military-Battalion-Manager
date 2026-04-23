package co.edu.uniqundio.poo.model;

public class VehiculoBlindado extends Vehiculo {
    private int nivelBlindaje;
    public VehiculoBlindado(int nivelBlindaje, String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas){
        super(id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
        this.nivelBlindaje = nivelBlindaje;
    }
    public void setNivelBlindaje(int nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }
    public int getNivelBlindaje() {
        return nivelBlindaje;
    }
    @Override
    public String toString() {
        return String.format("Vehículo Blindado - Nivel de Blindaje: %s, ID: %s, Modelo: %s, Año: %d, Km: %d, Estado: %s, Misiones: %d\n",
                nivelBlindaje, id , modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
    }
}
