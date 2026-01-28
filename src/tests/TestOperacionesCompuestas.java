package tests;

import matrices.Matriz;
import matrices.DimensionesIncompatibles;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test 4: Operaciones compuestas con matrices
 * - Verifica que (Z^T)^T = Z
 * - Verifica que (Z·Q)^T = Q^T·Z^T
 */
public class TestOperacionesCompuestas {
    
    @Test
    public void testTraspuestaDeTraspuestaEsOriginal() {
        // Crear matriz Z de 3x3
        Matriz matrizZ = new Matriz(3, 3, false);
        matrizZ.setValor(0, 0, 1);
        matrizZ.setValor(0, 1, 2);
        matrizZ.setValor(0, 2, 3);
        matrizZ.setValor(1, 0, 4);
        matrizZ.setValor(1, 1, 5);
        matrizZ.setValor(1, 2, 6);
        matrizZ.setValor(2, 0, 7);
        matrizZ.setValor(2, 1, 8);
        matrizZ.setValor(2, 2, 9);
        
        // Calcular (Z^T)^T
        Matriz traspuesta1 = Matriz.traspuesta(matrizZ);
        Matriz traspuesta2 = Matriz.traspuesta(traspuesta1);
        
        // Verificar que (Z^T)^T = Z
        assertEquals(matrizZ, traspuesta2);
    }
    
    @Test
    public void testTraspuestaDelProducto() throws DimensionesIncompatibles {
        // Crear matriz Z de 3x3
        Matriz matrizZ = new Matriz(3, 3, false);
        matrizZ.setValor(0, 0, 1);
        matrizZ.setValor(0, 1, 2);
        matrizZ.setValor(0, 2, 3);
        matrizZ.setValor(1, 0, 4);
        matrizZ.setValor(1, 1, 5);
        matrizZ.setValor(1, 2, 6);
        matrizZ.setValor(2, 0, 7);
        matrizZ.setValor(2, 1, 8);
        matrizZ.setValor(2, 2, 9);
        
        // Crear matriz Q de 3x3
        Matriz matrizQ = new Matriz(3, 3, false);
        matrizQ.setValor(0, 0, 9);
        matrizQ.setValor(0, 1, 8);
        matrizQ.setValor(0, 2, 7);
        matrizQ.setValor(1, 0, 6);
        matrizQ.setValor(1, 1, 5);
        matrizQ.setValor(1, 2, 4);
        matrizQ.setValor(2, 0, 3);
        matrizQ.setValor(2, 1, 2);
        matrizQ.setValor(2, 2, 1);
        
        // Calcular (Z·Q)^T
        Matriz productoZQ = Matriz.multiplicarDosMatrices(matrizZ, matrizQ);
        Matriz traspuestaProducto = Matriz.traspuesta(productoZQ);
        
        // Calcular Q^T·Z^T
        Matriz traspuestaQ = Matriz.traspuesta(matrizQ);
        Matriz traspuestaZ = Matriz.traspuesta(matrizZ);
        Matriz productoTraspuestas = Matriz.multiplicarDosMatrices(traspuestaQ, traspuestaZ);
        
        // Verificar que (Z·Q)^T = Q^T·Z^T
        assertEquals(traspuestaProducto, productoTraspuestas);
    }
}
