package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite que ejecuta todos los tests de matrices
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestMultiplicarDimensionesIncompatibles.class,
    TestMultiplicar3x3.class,
    TestTrasponer3x3.class,
    TestOperacionesCompuestas.class
})
public class MatricesTestSuite {
    // Esta clase permanece vacía, se usa únicamente como contenedor para las anotaciones
}
