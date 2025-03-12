package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EjercicioArrays {
	

	
	// Ejercicio 1: Encontrar la riqueza del cliente más rico
    public static int encontrarClienteMasRico(int[][] cuentas) {
    	//.error("Calculando la riqueza del cliente más rico...");
    	int maxRiqueza = 0;
        for (int[] cliente : cuentas) {
            int riqueza = 0;
            for (int cuenta : cliente) {
                riqueza += cuenta;
            }
            if (riqueza > maxRiqueza) {
                maxRiqueza = riqueza;
            }
        }
        return maxRiqueza;
    }

    // Ejercicio 2: Ordenar las diagonales de la matriz
    public static int[][] ordenarDiagonales(int[][] mat) {
    	
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            ordenarDiagonal(mat, i, 0);
        }
        for (int j = 1; j < n; j++) {
            ordenarDiagonal(mat, 0, j);
        }

        return mat;
    }

    private static void ordenarDiagonal(int[][] mat, int i, int j) {
        List<Integer> diagonal = new ArrayList<>();
        int x = i, y = j;
        while (x < mat.length && y < mat[0].length) {
            diagonal.add(mat[x][y]);
            x++;
            y++;
        }
        Collections.sort(diagonal);
        x = i;
        y = j;
        int index = 0;
        while (x < mat.length && y < mat[0].length) {
            mat[x][y] = diagonal.get(index);
            x++;
            y++;
            index++;
        }
    }

    // Ejercicio 3: Sumar todos los elementos de la matriz
    public static int sumaMatriz(int[][] mat) {

        int suma = 0;
        for (int[] fila : mat) {
            for (int elemento : fila) {
                suma += elemento;
            }
        }

        return suma;
    }

}
