package co.edu.uniqundio.poo.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Batallon {
    private String numeroBatallon;
    private List<Vehiculo> listaVehiculos;
    private List<Mision> listaMisiones;
    private List<Soldado> ListaSoldados;

    public Batallon(String numeroBatallon) {
        this.numeroBatallon = numeroBatallon;
        this.listaVehiculos = new ArrayList<>();
        this.listaMisiones = new ArrayList<>();
        this.ListaSoldados = new ArrayList<>();
    }
    public ArrayList<Vehiculo> filtrarVehiculosMedicos(){
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo vehiculoAux : listaVehiculos){
            if(vehiculoAux instanceof VehiculoApoyo vehiculoApoyoaux){
                int tipoFuncion = vehiculoApoyoaux.getTipoDeFuncion();
                if(tipoFuncion == 3){
                    resultado.add(vehiculoApoyoaux);
                }
            }
        }
        return resultado;
    }

    public String agregarRecorrido(String id, int kilometrajeRecorrido) {
        String mensaje = "";
        Optional<Vehiculo> vehiculoEncontrado = buscarVehiculo2(id);

        if (vehiculoEncontrado.isPresent()) {
            Vehiculo vehiculo = vehiculoEncontrado.get();

            int kilometrajeAntes = vehiculo.getKilometraje();
            int nuevoKilometraje = kilometrajeAntes + kilometrajeRecorrido;
            vehiculo.setKilometraje(nuevoKilometraje);
            mensaje = "Kilometraje actualizado correctamente";

        } else {
            mensaje = "El vehículo no existe en la lista";
        }
        return mensaje;
    }
public ArrayList obtenerVehiculosEstadoDisponible(){
    ArrayList<Vehiculo> resultado = new ArrayList();
    for (Vehiculo vehiculoAux : listaVehiculos){
        if (vehiculoAux.getEstadoOperativo() == 1){
            resultado.add(vehiculoAux);
        }
    }
    return resultado;
}

public ArrayList obtenerVehiculosSegunBlindaje(String blindajeBuscado){
        ArrayList<Vehiculo> resultado = new ArrayList();

        switch (blindajeBuscado.toLowerCase()){
            case "alto":
                for (Vehiculo vehiculoAux : listaVehiculos){
                    // cast de la clase VehiculoAux a Blindado en una sola linea
                    if(vehiculoAux instanceof VehiculoBlindado vehiculoBlindadoAux){
                        if(vehiculoBlindadoAux.getNivelBlindaje() > 75){
                            resultado.add(vehiculoAux);
                        }
                    }
                }
                break;
            case "medio":
                for (Vehiculo vehiculoAux : listaVehiculos){
                    if(vehiculoAux instanceof VehiculoBlindado vehiculoBlindadoAux){
                        if(vehiculoBlindadoAux.getNivelBlindaje() <= 55 && vehiculoBlindadoAux.getNivelBlindaje() >= 45){
                            resultado.add(vehiculoAux);
                        }
                    }
                }
                break;
            case "bajo":
                for (Vehiculo vehiculoAux : listaVehiculos){
                    if(vehiculoAux instanceof VehiculoBlindado vehiculoBlindadoAux){
                        if(vehiculoBlindadoAux.getNivelBlindaje() < 45){
                            resultado.add(vehiculoAux);
                        }
                    }
                }
                break;
        }


        return  resultado;
}

    public Optional<Vehiculo> buscarVehiculo2(String id) {
        return listaVehiculos.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    public String registrarVehiculo(int tipoVehiculo, int extra, String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {
        String mensaje = "";
        switch (tipoVehiculo) {
            case 1:
                Vehiculo nuevoVehiculo = null;
                nuevoVehiculo = buscarVehiculo(id);
                if (nuevoVehiculo == null) {
                    nuevoVehiculo = new TransporteTropas(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                    listaVehiculos.add(nuevoVehiculo);
                    mensaje = "Vehiculo de Tropas registrado correctamente";
                }else{
                    mensaje = "Vehiculo ya existe en la lista de vehiculos";
                }
                break;
            case 2:
                Vehiculo nuevoVehiculo1 = null;
                nuevoVehiculo1 = buscarVehiculo(id);
                if (nuevoVehiculo1 == null) {
                    nuevoVehiculo1 = new VehiculoBlindado(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                    listaVehiculos.add(nuevoVehiculo1);
                    mensaje = "Vehiculo Blindado registrado correctamente";
                }else{
                    mensaje = "Vehiculo ya existe en la lista de vehiculos";
                }
                break;
            case 3:
                Vehiculo nuevoVehiculo2 = null;
                nuevoVehiculo2 = buscarVehiculo(id);
                if (nuevoVehiculo2 == null) {
                    nuevoVehiculo2 = new VehiculoApoyo(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                    listaVehiculos.add(nuevoVehiculo2);
                    mensaje = "Vehiculo de apoyo registrado correctamente";
                }else{
                    mensaje = "Vehiculo ya existe en la lista de vehiculos";
                }
                break;
            default:
                mensaje = "Tipo de Vehiculo no existe";
        }
        return mensaje;
    }

    public String editarVehiculo(String id, int tipoVehiculo, int extra, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas){
        String mensaje = "";
        Vehiculo vehiculoEditar = null;
        vehiculoEditar = buscarVehiculo(id);
        if (vehiculoEditar == null) {
            mensaje = "Vehiculo no existe";
        }else{
            switch (tipoVehiculo) {
                case 1:
                    //Aquí hago un cast del VehiculoEditar a TransporteTropas
                    ((TransporteTropas) vehiculoEditar).setCapacidadSoldadosTransportados(extra);
                    vehiculoEditar.setId(id);
                    vehiculoEditar.setModelo(modelo);
                    vehiculoEditar.setAnioFabricacion(anioFabricacion);
                    vehiculoEditar.setKilometraje(kilometraje);
                    vehiculoEditar.setEstadoOperativo(estadoOperativo);
                    vehiculoEditar.setMisionesCompletadas(misionesCompletadas);
                    mensaje = "Vehiculo de transporte de tropas editado correctamente";
                    break;
                case 2:
                    //Aquí hago un cast del VehiculoEditar a Vehiculo Blindado
                    ((VehiculoBlindado) vehiculoEditar).setNivelBlindaje(extra);
                    vehiculoEditar.setId(id);
                    vehiculoEditar.setModelo(modelo);
                    vehiculoEditar.setAnioFabricacion(anioFabricacion);
                    vehiculoEditar.setKilometraje(kilometraje);
                    vehiculoEditar.setEstadoOperativo(estadoOperativo);
                    vehiculoEditar.setMisionesCompletadas(misionesCompletadas);
                    mensaje = "Vehiculo Blindado editado correctamente";
                    break;
                case 3:
                    //Aquí hago un cast del VehiculoEditar a Vehiculo de Apoyo
                    ((VehiculoApoyo) vehiculoEditar).setTipoDeFuncion(extra);
                    vehiculoEditar.setId(id);
                    vehiculoEditar.setModelo(modelo);
                    vehiculoEditar.setAnioFabricacion(anioFabricacion);
                    vehiculoEditar.setKilometraje(kilometraje);
                    vehiculoEditar.setEstadoOperativo(estadoOperativo);
                    vehiculoEditar.setMisionesCompletadas(misionesCompletadas);
                    mensaje = "Vehiculo de Apoyo editado correctamente";
                    break;
                default:
                    mensaje = "Ese Tipo de Vehiculo no existe";
            }
        }
        return  mensaje;
    }

    public String mostrarVehiculoPorID(String id) {
        String mensaje = "";
        Vehiculo vehiculoMostrar = null;
        vehiculoMostrar = buscarVehiculo(id);
        mensaje = vehiculoMostrar.toString();
        return mensaje;
    }

    public String mostrarListaVehciculos(){
        String mensaje = "";
        for(Vehiculo vehiculoAux : listaVehiculos){
            mensaje += vehiculoAux.toString();
        }
        return mensaje;
    }

    public String actualizarNumeroMisiones(String id, int numeroMisionesActualizada){
        String mensaje = "";
        Vehiculo vehiculoActualizarMisiones = null;
        vehiculoActualizarMisiones = buscarVehiculo(id);
        if  (vehiculoActualizarMisiones != null) {
            vehiculoActualizarMisiones.setMisionesCompletadas(numeroMisionesActualizada);
            mensaje = "Numero de misiones actualizado correctamente";
        }else{
            mensaje = "Id del vehiculo no encontrada";
        }
        return  mensaje;
    }
    public String actualizarEstadoOperativo(String id, int estadoOperativo){
        String mensaje = "";
        Vehiculo vehiculoActualizarEstadoOperativo = null;
        vehiculoActualizarEstadoOperativo = buscarVehiculo(id);
        if(vehiculoActualizarEstadoOperativo != null) {
            vehiculoActualizarEstadoOperativo.setEstadoOperativo(estadoOperativo);
            mensaje = "Estado Operativo actualizado correctamente";
        }else{
            mensaje = "Este ID de Vehiculo no existe";
        }
        return mensaje;
    }

    public String eliminarVehiculo(String id) {
        String mensaje = "";
        Vehiculo vehiculoEliminar = null;
        vehiculoEliminar = buscarVehiculo(id);
        if (vehiculoEliminar != null) {
            listaVehiculos.remove(vehiculoEliminar);
            mensaje = "Vehiculo eliminado correctamente";
        }else{
            mensaje  = "Vehiculo no existe para eliminar";
        }
        return  mensaje;
    }

    public String obtenerVehiculosMas50Misiones() {
        ArrayList<Vehiculo> vehiculosMas50Misiones = new ArrayList<>();
        for  (Vehiculo vehiculoAux : listaVehiculos) {
            if (vehiculoAux.getMisionesCompletadas() > 50) {
                vehiculosMas50Misiones.add(vehiculoAux);
            }
        }
        String resultado = "";
        resultado += vehiculosMas50Misiones.toString();
        return resultado;
    }

    public String registrarMision(String id, String fechaMision, String ubicacionMision, int personalAsignado, int vehiculosUtilizados){
        String mensaje = "";
        Mision nuevoRegistroMision = new Mision(id, fechaMision, ubicacionMision, personalAsignado, vehiculosUtilizados);
        listaMisiones.add(nuevoRegistroMision);
        mensaje = "Registro de la misión exitoso";
        return  mensaje;
    }

    public String mostrarListaMisiones(){
        String mensaje = "";
        for(Mision misionAux : listaMisiones){
            mensaje = misionAux.toString();
        }
        return mensaje;
    }

    private Vehiculo buscarVehiculo(String id) {
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculoAux : listaVehiculos) {
            if (vehiculoAux.getId().equals(id)) {
                vehiculoEncontrado = vehiculoAux;
            }
        }
        return  vehiculoEncontrado;
    }

    public String getNumeroBatallon() {
        return numeroBatallon;
    }

    public void setNumeroBatallon(String numeroBatallon) {
        this.numeroBatallon = numeroBatallon;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public List<Mision> getListaMisiones() {
        return listaMisiones;
    }

    public void setListaMisiones(List<Mision> listaMisiones) {
        this.listaMisiones = listaMisiones;
    }
}
