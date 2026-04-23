package co.edu.uniqundio.poo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Clase para probar los obejos de tipo Vehiculo
 * @author FelipeMontenegro
 * @since 2025-4
 *
 * Licencia GNU GPL V3
 */

public class VehiculoTest {
    private static final Logger LOG = Logger.getLogger(SoldadoTest.class.getName());

    private Vehiculo vehiculo1;
    @BeforeEach
    public void setUp() {
        Vehiculo vehiculo1 = new VehiculoApoyo(1, "ABC123", "Modelo X", 2020, 10000, 1, 0);
    }
    @Test
    public void testConteoMisionesVehiculo() {
        int cantidadMisionesIniciales = vehiculo1.getMisionesCompletadas();
        int cantidadMisionesFinales = vehiculo1.registrarMision();

        // se espera que la cantidad de misiones haya aumentado en uno
        assertEquals(cantidadMisionesIniciales + 1, cantidadMisionesFinales);
    }
}
