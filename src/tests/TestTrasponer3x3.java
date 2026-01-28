package tests;

import matrices.Matriz;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test 3: Operación trasponer con una matriz 3x3
 * Verifica que el resultado es el esperado
 */
public class TestTrasponer3x3 {
    
    @Test
    public void testTrasponer3x3() {
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
        
        // Trasponer la matriz
        Matriz resultado = Matriz.traspuesta(matrizA);
        
        // Crear matriz esperada (traspuesta)
        Matriz esperada = new Matriz(3, 3, false);
        esperada.setValor(0, 0, 1);
        esperada.setValor(0, 1, 4);
        esperada.setValor(0, 2, 7);
        esperada.setValor(1, 0, 2);
        esperada.setValor(1, 1, 5);
        esperada.setValor(1, 2, 8);
        esperada.setValor(2, 0, 3);
        esperada.setValor(2, 1, 6);
        esperada.setValor(2, 2, 9);
        
        // Verificar que el resultado es el esperado
        assertEquals(esperada, resultado);
    }
}
