package co.edu.uniqundio.poo.model;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para probar los obejos de tipo batallon
 * @author FelipeMontenegro
 * @since 2025-4
 *
 * Licencia GNU GPL V3
 */

public class BatallonTest {
    private static final Logger LOG = Logger.getLogger(SoldadoTest.class.getName());
    private Batallon batallon1;
    private Vehiculo vehiculo1;

    @BeforeEach
    public void setUp() {
        LOG.info("Iniciando instancias Batallon");
        batallon1 = new Batallon("1213");
        batallon1.registrarMision("123", "12-10-2024", "Cali", 12, 5);
        batallon1.registrarVehiculo(1, 80, "ABCD123", "Modelo X", 2020, 20000, 1, 0);
        vehiculo1 = batallon1.getListaVehiculos().get(0);
        LOG.info("Instancias de Batallon creadas");

    }

    // Test Actualizacion de Misiones
    @Test
    public void testAgrgarMisionesBatallon() {
        LOG.info("Iniciando Prueba de Agragar una mision al Batallon");
        // Tamaño inicial de la lista de misiones
        int tamanioInicial = batallon1.getListaMisiones().size();

        // Se registra una nueva misión
        batallon1.registrarMision("8", "15-10-2024", "Bogotá", 10, 3);

        // Se espera que el tamaño aumente en 1
        int tamanioFinal = batallon1.getListaMisiones().size();

        assertEquals(tamanioInicial + 1, tamanioFinal, "No se registró la mision en la lista de misiones");
        LOG.info("Fin de la prueba de  Agragar una mision al Batallon");
    }

    // Test de Cambio de Estado
    @Test
    public void testCambioEstado() {
        LOG.info("Iniciando Prueba de Cambio de Estado Vehiculo");
        int estadoInicial = vehiculo1.getEstadoOperativo();
        batallon1.actualizarEstadoOperativo("ABCD123", 2);
        int estadoFinal = vehiculo1.getEstadoOperativo();

        assertNotEquals(estadoInicial, estadoFinal, "No se actualizó el estado");
        LOG.info("Fin prueba cambio de estado Vehiculo");
    }

    // Test de ingreso correcto de datos
    @Test
    public void testRegistroCompletoVehiculoApoyo() {
        LOG.info("Iniciando Prueba de Agregacion correcta de datos Vehiculo de apoyo");
        //1. Vehiculo de Tropas
        //2. Vehiculo Blindado
        //3. vehiculo de Apoyo
        batallon1.registrarVehiculo(3, 2, "A11", "ModeloY", 2021, 20000, 2, 3);
        Vehiculo vehiculoEsperado = batallon1.getListaVehiculos().get(1);

        // Verifico que el objeto obtenido de la lista no sea null
        assertNotNull(vehiculoEsperado, "El vehículo no debe ser null");
        // Verifica que el vehiculo guardado en efecto sea una instancia de Vehiculo de Apoyo
        assertTrue(vehiculoEsperado instanceof VehiculoApoyo, "El vehículo debe ser una instancia de VehiculoApoyo");

        // Verificar cada Ingresado con datos esperados
        assertEquals("A11", vehiculoEsperado.getId(), "ID incorrecto");
        assertEquals("ModeloY", vehiculoEsperado.getModelo(), "Modelo incorrecto");
        assertEquals(2021, vehiculoEsperado.getAnioFabricacion(), "Año incorrecto");
        assertEquals(20000, vehiculoEsperado.getKilometraje(), "kilometraje incorrecto");
        assertEquals(2, vehiculoEsperado.getEstadoOperativo(), "Estado operativo incorrecto");
        assertEquals(3, vehiculoEsperado.getMisionesCompletadas(), " Misiones Comletadas son incorrectas");
        LOG.info("Fin de la prueba de registro valido vehiculo de apoyo");
    }

    // Verifica que el kilometraje ingresado sea Mayor que cero
    @Test
    public void testIngresarKilometrajeValido() {
        LOG.info("Iniciando Prueba de validar entrada negativa en el kilometraje");
        int kilometrajeMinimo = 0;
        if (vehiculo1.getKilometraje() < kilometrajeMinimo) {
            throw new IllegalArgumentException("El kilometraje no puede ser negativo. incorrecto");
        }
        LOG.info("Fin de la prueba de  validar entrada negativa en el kilometraje");

    }
    // Verifica que el kilometraje se actualice correctamente

    @Test
    public void testAgregarRecorrido() {
        LOG.info("Iniciando la prueba de validar actualizacion del kilometraje ");
        int kilometrajeAntes = vehiculo1.getKilometraje();
        int kilometrajeRecorrido = 8000;

        batallon1.agregarRecorrido("ABCD123", kilometrajeRecorrido);

        int nuevoKilometraje = vehiculo1.getKilometraje();

        assertEquals(kilometrajeAntes + kilometrajeRecorrido, nuevoKilometraje, "El kilometraje no se actualizó de manera correcta");
        LOG.info("Fin de la prueba de  validar actualizacion del kilometraje ");

    }

    // verificar duplicados
    @Test
    public void testEvitarDuplicados() {
        LOG.info("Iniciando prueba de evitar el duplicado");
        String id1 = vehiculo1.getId();
        String id2 = "ABCD1234";
        batallon1.registrarVehiculo(2, 1, id2, "Modelo Y", 2010, 30000, 1, 0);
        assertNotEquals(id1, id2, "Las identificaciones de los vehiculos son las mismas");
        LOG.info("Fin de la prueba de evitar el duplicado");
    }

    // Verificar que se busque el vehículo correctamente
    @Test
    public void testBuscarVehiculo() {
        LOG.info("Iniciando prueba de buscar vehiculo");
        String idEsperado = vehiculo1.getId();
        Optional<Vehiculo> vehiculoEncontrado = batallon1.buscarVehiculo2(idEsperado);

        assertTrue(vehiculoEncontrado.isPresent(), "El vehículo con ese ID no se encontró en la lista");
        assertEquals(idEsperado, vehiculoEncontrado.get().getId(), "El ID del vehículo encontrado no coincide");
        LOG.info("Fin de la prueba de buscar vehiculo");
    }

    // Test Vehiculo no encontrado
    @Test
    public void testVehiculoExistente() {
        LOG.info("Iniciando prueba de buscar vehiculo existente");
        String idInvalido = "Id incorrecto";
        Optional <Vehiculo> vehiculoEncontrado = batallon1.buscarVehiculo2(idInvalido);
        assertFalse(vehiculoEncontrado.isPresent(), "Se ecnocntró un vehiculo que no está registrado en la lista");
        LOG.info("Fin de la prueba de buscar vehiculo existente");
    }

    // Test de Listar Vehiculos con estado Disponible

    @Test
    public void testListarVehiculosEstadoDISPONIBLE() {
        LOG.info("Iniciando prueba de listar vehiculos de tipo disponible");
        int estadoPrueba2 = 2;
        int estadoOperativo = vehiculo1.getEstadoOperativo();
        ArrayList<Vehiculo> ListaResultado = batallon1.obtenerVehiculosEstadoDisponible();
        assertEquals(estadoOperativo, ListaResultado.get(0).getEstadoOperativo(), "El estado operativo guardado es incorrecto");
        LOG.info("Fin de la prueba de listar vehiculos de tipo disponible");
    }

    // test para obtener lista de vehiculos segun su blindaje

    @Test
    public void testVerificarVehiculoBlindadoExistente() {
        LOG.info("Iniciando prueba de verificar vehiculo blindado Existente");
        batallon1.registrarVehiculo(2, 80, "ABCD12333", "Modelo X", 2020, 20000, 1, 0);
        Vehiculo vehiculoPrueba = batallon1.getListaVehiculos().getLast();

        // Verifica que es el tipo de Vehiculo correcto
        assertTrue(vehiculoPrueba instanceof VehiculoBlindado, "se agregó un vehículo de tipo blindado");
        LOG.info("Fin de la prueba de verificar vehiculo blindado existente");
    }
    @Test
    public void testObtenerVehiculosBlindadosConBlindajeAlto() {
        LOG.info("Iniciando prueba de obtener vehiculos con blindaje alto");
        batallon1.registrarVehiculo(2, 80, "ABCD333", "Modelo X", 2010, 43120, 1, 0);
        batallon1.registrarVehiculo(2, 60, "A12333", "Modelo X", 2020, 20000, 1, 0);
        batallon1.registrarVehiculo(2, 70, "333", "Modelo X", 2007, 20000, 1, 0);
        batallon1.registrarVehiculo(2, 20, "33", "Modelo X", 2020, 20000, 1, 0);
        batallon1.registrarVehiculo(2, 10, "XXX", "Modelo X", 2002, 20000, 1, 0);

        ArrayList<Vehiculo> listaResultado = batallon1.obtenerVehiculosSegunBlindaje("Alto");
        assertEquals(1, listaResultado.size(), "El vehículo blindado no se agregó en la lista");
        LOG.info("Fin de la pruaba de  obtener vehiculos con blindaje alto");
    }
    @Test
    public void testObtenerVehiculosSegunBlindajeAlto() {
        batallon1.getListaVehiculos().get(0);
    }

    //Test filtrar vehiculos  de apoyo medicos
    @Test
    public void TestFiltrarVehiculosMedicos(){
        LOG.info("Iniciando prueba de obtener lista de vehiculos medicos");

        batallon1.registrarVehiculo(3, 1, "id1", "Modelo X", 2010, 43120, 1, 0);
        Optional<Vehiculo> vehiculo1 = batallon1.buscarVehiculo2("id1");
        batallon1.registrarVehiculo(3, 1, "id2", "Modelo X", 2020, 20000, 1, 0);
        Optional<Vehiculo> vehiculo2 = batallon1.buscarVehiculo2("id2");
        batallon1.registrarVehiculo(3, 1, "id3", "Modelo X", 2007, 20000, 1, 0);
        Optional<Vehiculo> vehiculo3 = batallon1.buscarVehiculo2("id3");
        batallon1.registrarVehiculo(3, 3, "id4", "Modelo X", 2020, 20000, 1, 0);
        Optional<Vehiculo> vehiculo4 = batallon1.buscarVehiculo2("id4");
        batallon1.registrarVehiculo(3, 3, "id5", "Modelo X", 2002, 20000, 1, 0);
        Optional<Vehiculo> vehiculo5 = batallon1.buscarVehiculo2("id5");

        ArrayList<Vehiculo> esperados = new ArrayList<>();
        esperados.add(vehiculo4.get());
        esperados.add(vehiculo5.get());

        ArrayList<Vehiculo> listaResultado = batallon1.filtrarVehiculosMedicos();
        assertIterableEquals(esperados, listaResultado);

        LOG.info("Fin de la prueba de obtener lista de vehiculos medicos");
    }
}

