/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrices;

import java.awt.Dimension;
import java.util.Random;

/**
 *
 * @author galvez
 */
public class Matriz {
    private int[][]datos;
    private Random rnd = new Random();
    
    public Matriz(int filas, int columnas, boolean inicializarAleatorio){
        datos = new int[columnas][];
        for(int i=0; i<columnas; i++){
            datos[i] = new int[filas];
            if (inicializarAleatorio)
                for(int j=0; j<filas; j++)
                    datos[i][j] = rnd.nextInt(100);
        }
    }
    
    // Constructor para inicializar matriz con valores específicos
    public Matriz(int[][] valores){
        this.datos = valores;
    }
    
    // Método para establecer un valor en una posición específica
    public void setValor(int fila, int columna, int valor){
        datos[columna][fila] = valor;
    }
    
    // Método para obtener un valor de una posición específica
    public int getValor(int fila, int columna){
        return datos[columna][fila];
    }
    public Matriz(Dimension d, boolean inicializarAleatorio){
        this(d.height, d.width, inicializarAleatorio);
    }
    
    public Dimension getDimension(){
        return new Dimension(datos.length, datos[0].length);
    }
    
    public static Matriz sumarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles { 
        if(! a.getDimension().equals(b.getDimension())) throw new DimensionesIncompatibles("La suma de matrices requiere matrices de las mismas dimensiones");        
        int i, j, filasA, columnasA; 
        filasA = a.getDimension().height; 
        columnasA = a.getDimension().width; 
        Matriz matrizResultante = new Matriz(filasA, columnasA, false);
        for (j = 0; j < filasA; j++) { 
            for (i = 0; i < columnasA; i++) { 
                matrizResultante.datos[i][j] += a.datos[i][j] + b.datos[i][j]; 
            } 
        } 
        return matrizResultante; 
    }

    public static Matriz multiplicarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles {
        if(a.getDimension().width != b.getDimension().height) throw new DimensionesIncompatibles("La multiplicación de matrices requiere que el número de columnas de A sea igual al número de filas de B");
        int filasA = a.getDimension().height;
        int columnasA = a.getDimension().width;
        int columnasB = b.getDimension().width;
        Matriz matrizResultante = new Matriz(filasA, columnasB, false);
        
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                int suma = 0;
                for (int k = 0; k < columnasA; k++) {
                    suma += a.datos[k][i] * b.datos[j][k];
                }
                matrizResultante.datos[j][i] = suma;
            }
        }
        return matrizResultante;
    }

    public static Matriz traspuesta(Matriz a) {
        int filasA = a.getDimension().height;
        int columnasA = a.getDimension().width;
        Matriz matrizTraspuesta = new Matriz(columnasA, filasA, false);
        
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                matrizTraspuesta.datos[i][j] = a.datos[j][i];
            }
        }
        return matrizTraspuesta;
    }

    @Override
    public String toString(){
        String ret = "";
        ret += "[\n";
        for (int i = 0; i < getDimension().width; i++) {
            ret += "(";
            for (int j = 0; j < getDimension().height; j++) {  
                ret += String.format("%3d", datos[i][j]); 
                if (j != getDimension().height - 1) ret += ", ";
            } 
            ret += ")";
            if (i != getDimension().width - 1) ret += ",";
            ret += "\n";
        } 
        ret += "]\n";
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Matriz otra = (Matriz) obj;
        if (!getDimension().equals(otra.getDimension())) return false;
        
        for (int i = 0; i < getDimension().height; i++) {
            for (int j = 0; j < getDimension().width; j++) {
                if (getValor(i, j) != otra.getValor(i, j)) return false;
            }
        }
        return true;
    }
}
