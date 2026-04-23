package co.edu.uniqundio.poo.model;

public abstract class Vehiculo {
    protected String id;
    protected String modelo;
    protected int anioFabricacion;
    protected int kilometraje;
    protected int estadoOperativo;
    protected int misionesCompletadas;

    public Vehiculo(String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {
        this.id = id;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
        this.estadoOperativo = estadoOperativo;
        this.misionesCompletadas = misionesCompletadas;
    }

    public int registrarMision(){
        int cantidadMisiones = getMisionesCompletadas();
        cantidadMisiones ++;
        return cantidadMisiones;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    public int getEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(int estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }

    public int getMisionesCompletadas() {
        return misionesCompletadas;
    }

    public void setMisionesCompletadas(int misionesCompletadas) {
        this.misionesCompletadas = misionesCompletadas;
    }

    public String toString() {
        return String.format("ID: %s, Modelo: %s, Año: %d, Km: %d, Estado: %s, Misiones: %d\n",
                id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public int getKilometraje() {
        return kilometraje;
    }


}
