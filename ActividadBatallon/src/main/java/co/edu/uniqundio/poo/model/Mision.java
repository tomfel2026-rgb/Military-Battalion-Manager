package co.edu.uniqundio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mision {
    private String id;
    private final String fechaMision;
    private final String ubicacionMision;
    private final int personalAsignado;
    private final int vehiculosUtilizados;
    private List<Soldado> ListaSolados;

    public Mision(String id, String fechaMision, String ubicacionMision, int personalAsignado, int vehiculosUtilizados) {
        this.fechaMision = fechaMision;
        this.ubicacionMision = ubicacionMision;
        this.personalAsignado = personalAsignado;
        this.vehiculosUtilizados = vehiculosUtilizados;
        this.ListaSolados = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Misión - Fecha: %s, Ubicación: %s, Personal: %s, Vehículos: %s\n",
                fechaMision, ubicacionMision, personalAsignado, vehiculosUtilizados);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mision mision = (Mision) o;
        return Objects.equals(id, mision.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

