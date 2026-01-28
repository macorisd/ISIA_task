package tests;

import matrices.Matriz;
import matrices.DimensionesIncompatibles;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test 2: Operación multiplicar con dos matrices 3x3
 * Verifica que el resultado es el esperado
 */
public class TestMultiplicar3x3 {
    
    @Test
    public void testMultiplicar3x3() throws DimensionesIncompatibles {
        // Crear matriz A de 3x3
        Matriz matrizA = new Matriz(3, 3, false);
        matrizA.setValor(0, 0, 1);
        matrizA.setValor(0, 1, 2);
        matrizA.setValor(0, 2, 3);
        matrizA.setValor(1, 0, 4);
        matrizA.setValor(1, 1, 5);
        matrizA.setValor(1, 2, 6);
        matrizA.setValor(2, 0, 7);
        matrizA.setValor(2, 1, 8);
        matrizA.setValor(2, 2, 9);
        
        // Crear matriz B de 3x3
        Matriz matrizB = new Matriz(3, 3, false);
        matrizB.setValor(0, 0, 1);
        matrizB.setValor(0, 1, 0);
        matrizB.setValor(0, 2, 0);
        matrizB.setValor(1, 0, 0);
        matrizB.setValor(1, 1, 1);
        matrizB.setValor(1, 2, 0);
        matrizB.setValor(2, 0, 0);
        matrizB.setValor(2, 1, 0);
        matrizB.setValor(2, 2, 1);
        
        // Multiplicar las matrices
        Matriz resultado = Matriz.multiplicarDosMatrices(matrizA, matrizB);
        
        // Crear matriz esperada
        // A * B donde B es la identidad debería dar A
        Matriz esperada = new Matriz(3, 3, false);
        esperada.setValor(0, 0, 1);
        esperada.setValor(0, 1, 2);
        esperada.setValor(0, 2, 3);
        esperada.setValor(1, 0, 4);
        esperada.setValor(1, 1, 5);
        esperada.setValor(1, 2, 6);
        esperada.setValor(2, 0, 7);
        esperada.setValor(2, 1, 8);
        esperada.setValor(2, 2, 9);
        
        // Verificar que el resultado es el esperado
        assertEquals(esperada, resultado);
    }
}
