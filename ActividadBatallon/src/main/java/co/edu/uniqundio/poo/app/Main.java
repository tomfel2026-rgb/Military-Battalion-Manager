package co.edu.uniqundio.poo.app;
import co.edu.uniqundio.poo.model.*;
import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Bienvenido al gestor de Batallón");
        String numerobatallon = JOptionPane.showInputDialog("ingrese el numero del batallón: ");
        Batallon batallon1 = new Batallon(numerobatallon);

        boolean salir = false;
        while(!salir){
            String opcion = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:\n" +
                            "1. Agregar Vehiculo\n" +
                            "2. Editar Vehiculo\n" +
                            "3. Mostrar Vehiculo por ID\n" +
                            "4. Mostrar lista de Vehiculos\n" +
                            "5. Actualizar numero de misiones\n" +
                            "6. Actualizar estado del Vehículo\n" +
                            "7. Eliminar Vehiculo\n" +
                            "8. Mostarar Vehiculos mas de 50 misiones\n" +
                            "9. Registrar Misión\n" +
                            "10. Mostrar Misiones\n" +
                            "11. Salir", "Menú", JOptionPane.QUESTION_MESSAGE);
            if(opcion == null || opcion.equals("11")){
                salir = true;
            }

            switch (opcion){
                case "1":
                    int tipoDeVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de vehiculo:\n(1)Transporte de Tropas\n(2)Vehiculo Blindado\n(3)Vehiculo de Apoyo"));
                    switch(tipoDeVehiculo){
                        case 1:
                            int capacidadSoldados = Integer.parseInt(JOptionPane.showInputDialog("ingrese la capacidad de Soldados que tiene el vehiculo"));
                            String id = JOptionPane.showInputDialog("ingrese la ID unica del vehiculo");
                            String modelo = JOptionPane.showInputDialog("ingrese el modelo del vehiculo");
                            int anioFabricacion = Integer.parseInt(JOptionPane.showInputDialog("ingrese la año de fabricacion del vehiculo"));
                            int kilomentraje = Integer.parseInt(JOptionPane.showInputDialog("ingrese el kilometraje del vehiculo"));
                            int estadoOperativo = Integer.parseInt(JOptionPane.showInputDialog("ingrese el estado operativo del vehiculo:\n" +
                                    "(1)Disponible\n(2)En_Mision\n(3)En_Mantenimiento"));
                            if(estadoOperativo > 3 || estadoOperativo < 1){
                                JOptionPane.showMessageDialog(null, "El estado operativo es invalido");
                            }
                            int misionesCompletadas = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de misiones completadas del vehiculo"));
                            String mensaje = batallon1.registrarVehiculo(tipoDeVehiculo, capacidadSoldados, id, modelo, anioFabricacion, kilomentraje, estadoOperativo, misionesCompletadas);
                            JOptionPane.showMessageDialog(null,mensaje);
                            break;
                        case 2:
                            int nivelBlinaje = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nivel de Blindaje del vehículo"));
                            String id1 = JOptionPane.showInputDialog("ingrese la ID unica del vehiculo");
                            String modelo1 = JOptionPane.showInputDialog("ingrese el modelo del vehiculo");
                            int anioFabricacion1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la año de fabricacion del vehiculo"));
                            int kilomentraje1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el kilometraje del vehiculo"));
                            int estadoOperativo1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el estado operativo del vehiculo:\n" +
                                    "(1)Disponible\n(2)En_Mision\n(3)En_Mantenimiento"));
                            int misionesCompletadas1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de misiones completadas del vehiculo"));
                            String mensaje1 = batallon1.registrarVehiculo(tipoDeVehiculo, nivelBlinaje, id1, modelo1, anioFabricacion1, kilomentraje1, estadoOperativo1, misionesCompletadas1);
                            JOptionPane.showMessageDialog(null,mensaje1);
                            break;
                        case 3:
                            int tipoFuncion = Integer.parseInt(JOptionPane.showInputDialog("ingrese el tipo de funcion del vehículo:\n(1)LOGISTICA\n(2)COMUNICACIONES\n(3)MEDICO"));
                            String id2 = JOptionPane.showInputDialog("ingrese la ID unica del vehiculo");
                            String modelo2 = JOptionPane.showInputDialog("ingrese el modelo del vehiculo");
                            int anioFabricacion2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la año de fabricacion del vehiculo"));
                            int kilomentraje2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el kilometraje del vehiculo"));
                            int estadoOperativo2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el estado operativo del vehiculo:\n" +
                                    "(1)Disponible\n(2)-En_Mision\n(3)-En_Mantenimiento"));
                            int misionesCompletadas2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de misiones completadas del vehiculo"));
                            String mensaje2 = batallon1.registrarVehiculo(tipoDeVehiculo, tipoFuncion , id2, modelo2, anioFabricacion2, kilomentraje2, estadoOperativo2, misionesCompletadas2);
                            JOptionPane.showMessageDialog(null,mensaje2);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "esta opción no está disponible.");

                    }
                    break;

                case "2":
                    String idEditada = JOptionPane.showInputDialog("ingrese la ID unica del vehiculo");
                    int tipoDeVehiculoEditar = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el nuevo tipo de vehiculo:\n(1)Transporte de Tropas\n(2)Vehiculo Blindado\n(3)Vehiculo de Apoyo"));
                    switch (tipoDeVehiculoEditar) {
                        case 1:
                            int extraVehiculoEditar1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la nueva capacidad de Soldados que tiene el vehiculo"));
                            String modeloEditado1 = JOptionPane.showInputDialog("ingrese el modelo del vehiculo");
                            int anioFabricacionEditado1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la año de fabricacion del vehiculo"));
                            int kilomentrajeEditado1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el kilometraje del vehiculo"));
                            int estadoOperativoEditado1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el estado operativo del vehiculo:\n" +
                                    "(1)Disponible\n(2)En_Mision\n(3)En_Mantenimiento"));
                            int misionesCompletadasEditadas1 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de misiones completadas del vehiculo"));
                            String mensaje1 = batallon1.editarVehiculo( idEditada, tipoDeVehiculoEditar, extraVehiculoEditar1, modeloEditado1, anioFabricacionEditado1, kilomentrajeEditado1, estadoOperativoEditado1, misionesCompletadasEditadas1);
                            JOptionPane.showMessageDialog(null,mensaje1);
                            break;
                        case 2:
                            int extraVehiculoEditar2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo nivel de Blindaje del vehículo"));
                            String modeloEditado2 = JOptionPane.showInputDialog("ingrese el nuevo modelo del vehiculo");
                            int anioFabricacionEditado2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo año de fabricacion del vehiculo"));
                            int kilomentrajeEditado2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo kilometraje del vehiculo"));
                            int estadoOperativoEditado2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo estado operativo del vehiculo:\n" +
                                    "(1)Disponible\n(2)En_Mision\n(3)En_Mantenimiento"));
                            int misionesCompletadasEditadas2 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de misiones completadas del vehiculo"));
                            String mensaje2 = batallon1.editarVehiculo( idEditada, tipoDeVehiculoEditar, extraVehiculoEditar2, modeloEditado2, anioFabricacionEditado2, kilomentrajeEditado2, estadoOperativoEditado2, misionesCompletadasEditadas2);
                            JOptionPane.showMessageDialog(null,mensaje2);
                            break;
                        case 3:
                            int extraVehiculoEditar3 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuwvo tipo de funcion del vehículo:\n(1)LOGISTICA\n(2)COMUNICACIONES\n(3)MEDICO"));
                            String modeloEditado3 = JOptionPane.showInputDialog("ingrese el nuevo modelo del vehiculo");
                            int anioFabricacionEditado3 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo año de fabricacion del vehiculo"));
                            int kilomentrajeEditado3 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo kilometraje del vehiculo"));
                            int estadoOperativoEditado3 = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo estado operativo del vehiculo:\n" +
                                    "(1)Disponible\n(2)En_Mision\n(3)En_Mantenimiento"));
                            int misionesCompletadasEditadas3 = Integer.parseInt(JOptionPane.showInputDialog("ingrese la nueva cantidad de misiones completadas del vehiculo"));
                            String mensaje3 = batallon1.editarVehiculo( idEditada, tipoDeVehiculoEditar, extraVehiculoEditar3, modeloEditado3, anioFabricacionEditado3, kilomentrajeEditado3, estadoOperativoEditado3, misionesCompletadasEditadas3);
                            JOptionPane.showMessageDialog(null,mensaje3);
                            break;
                    }

                case "3":
                    String idBuscar = JOptionPane.showInputDialog("ingrese la ID unica del vehiculo");
                    String mensaje2 = batallon1.mostrarVehiculoPorID(idBuscar);
                    JOptionPane.showMessageDialog(null,mensaje2);
                    break;

                case "4":
                    String mensaje3 = batallon1.mostrarListaVehciculos();
                    JOptionPane.showMessageDialog(null,mensaje3);
                    break;

                case "5":
                    String idBuscar1 = JOptionPane.showInputDialog("ingrese la ID unica del vehiculo");
                    int misionesCompletadasActualizado = Integer.parseInt(JOptionPane.showInputDialog("ingrese la nueva cantidad de misiones completadas del vehiculo"));
                    String mensaje4 = batallon1.actualizarNumeroMisiones(idBuscar1, misionesCompletadasActualizado);
                    JOptionPane.showMessageDialog(null,mensaje4);
                    break;
                case "6":
                    String idCambiaEstado = JOptionPane.showInputDialog("ingrese la ID del vehiculo para editar estado");
                    int esatdoActualizado = Integer.parseInt(JOptionPane.showInputDialog("ingrese el estado operativo del vehiculo:\n(1)Disponible\n(2)En_Mision\n(3)En_Mantenimiento"));
                    String mensaje8 = batallon1.actualizarEstadoOperativo(idCambiaEstado, esatdoActualizado);
                    JOptionPane.showMessageDialog(null,mensaje8);
                    break;
                case "7":
                    String idParaEliminar = JOptionPane.showInputDialog("ingrese la ID del vehiculo para eliminar");
                    String mensaje5 = batallon1.eliminarVehiculo(idParaEliminar);
                    JOptionPane.showMessageDialog(null,mensaje5);
                    break;

                case "8":
                    String mensaje6 = batallon1.obtenerVehiculosMas50Misiones();
                    JOptionPane.showMessageDialog(null,mensaje6);
                    break;

                case "9":
                    String idMision = JOptionPane.showInputDialog("ingrese la ID de la mision");
                    String fechaMision = JOptionPane.showInputDialog("ingrese la fecha de la mision");
                    String ubicacionMision = JOptionPane.showInputDialog("ingrese el ubicacion de la mision");
                    int personalAsignado = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de personal asignado"));
                    int vehiculosUtilizados = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de vehiculos utilizados"));
                    String mensaje7 = batallon1.registrarMision(idMision, fechaMision, ubicacionMision, personalAsignado, vehiculosUtilizados);
                    JOptionPane.showMessageDialog(null,mensaje7);
                    break;

                case "10":
                    String mensaje9= batallon1.mostrarListaMisiones();
                    JOptionPane.showMessageDialog(null,mensaje9);
                    break;

                case "11":
                    JOptionPane.showMessageDialog(null,"Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "esta opción no está disponible.");
            }
        }
    }
}