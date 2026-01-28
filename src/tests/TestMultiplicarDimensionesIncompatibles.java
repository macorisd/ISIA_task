package tests;

import matrices.Matriz;
import matrices.DimensionesIncompatibles;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test 1: Operación multiplicar con matrices de dimensiones incompatibles
 * Debe lanzar la excepción DimensionesIncompatibles
 */
public class TestMultiplicarDimensionesIncompatibles {
    
    @Test(expected = DimensionesIncompatibles.class)
    public void testMultiplicarDimensionesIncompatibles() throws DimensionesIncompatibles {
        // Crear matriz A de 2x3
        Matriz matrizA = new Matriz(2, 3, false);
        matrizA.setValor(0, 0, 1);
        matrizA.setValor(0, 1, 2);
        matrizA.setValor(0, 2, 3);
        matrizA.setValor(1, 0, 4);
        matrizA.setValor(1, 1, 5);
        matrizA.setValor(1, 2, 6);
        
        // Crear matriz B de 2x2 (incompatible para multiplicar con A)
        Matriz matrizB = new Matriz(2, 2, false);
        matrizB.setValor(0, 0, 1);
        matrizB.setValor(0, 1, 2);
        matrizB.setValor(1, 0, 3);
        matrizB.setValor(1, 1, 4);
        
        // Intentar multiplicar matrices incompatibles - debe lanzar excepción
        Matriz.multiplicarDosMatrices(matrizA, matrizB);
    }
}
