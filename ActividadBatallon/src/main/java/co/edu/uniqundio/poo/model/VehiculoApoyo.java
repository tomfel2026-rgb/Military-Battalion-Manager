package co.edu.uniqundio.poo.model;

public class VehiculoApoyo extends Vehiculo {
    private int tipoDeFuncion;
    public VehiculoApoyo (int tipoDeFuncion, String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {
        super(id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
        this.tipoDeFuncion = tipoDeFuncion;
    }
    public void setTipoDeFuncion(int tipoDeFuncion) {
        this.tipoDeFuncion = tipoDeFuncion;
    }

    @Override
    public String toString() {
        return String.format("Vehiculo de Apoyo - Tipo de Funcion: %s, ID: %s, Modelo: %s, Año: %d, Km: %d, Estado: %s, Misiones: %d\n",
                tipoDeFuncion, id , modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
    }

    public int getTipoDeFuncion() {
        return tipoDeFuncion;
    }
}
