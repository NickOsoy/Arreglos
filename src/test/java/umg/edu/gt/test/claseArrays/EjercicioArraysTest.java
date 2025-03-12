package umg.edu.gt.test.claseArrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioArrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class EjercicioArraysTest {

    private static final Logger logger = LogManager.getLogger(EjercicioArraysTest.class);

    @Test
    public void testEncontrarClienteMasRico() {
        logger.info("Ejecutando test Encontrar Cliente Mas Rico....");

        int[][] cuentas1 = {{1, 2, 3}, {3, 2, 1}};
        int resultado1 = EjercicioArrays.encontrarClienteMasRico(cuentas1);
        
        logger.debug("Resultado Cliente Mas Rico ejemplo 1: {}", resultado1);
        assertEquals(6, resultado1, "El cliente más rico no tiene el patrimonio esperado");

        int[][] cuentas2 = {{1, 5}, {7, 3}, {3, 5}};
        int resultado2 = EjercicioArrays.encontrarClienteMasRico(cuentas2);
        
        logger.debug("Resultado Cliente Mas Rico ejemplo 2: {}", resultado2);
        assertEquals(10, resultado2, "El cliente más rico no tiene el patrimonio esperado");

        // Forzar un fallo
        int[][] cuentas3 = {{1, 1}, {1, 1}};
        int resultado3 = EjercicioArrays.encontrarClienteMasRico(cuentas3);
        
        logger.debug("Resultado Cliente Mas Rico ejemplo forzar fallo): {}", resultado3);
        assertEquals(3, resultado3, "Ejempl diseñado para fallar");
    }

    @Test
    public void testOrdenarDiagonales() {
        logger.info("Ejecutando test Ordenar Diagonales....");

        int[][] mat1 = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int[][] resultado1 = EjercicioArrays.ordenarDiagonales(mat1);
        
        logger.debug("Resultado Diagonales ejemplo 1: {}", Arrays.deepToString(resultado1));
        int[][] expected1 = {{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}};
        assertArrayEquals(expected1, resultado1, "El caso correcto falló: Las diagonales no están ordenadas como se esperaba");

        // Caso que falla
        int[][] mat2 = {{1, 2}, {3, 4}};
        int[][] resultado2 = EjercicioArrays.ordenarDiagonales(mat2);
        
        logger.debug("Resultado Diagonales Forzar fallo): {}", Arrays.deepToString(resultado2));
        int[][] expected2 = {{1, 2}, {5, 4}}; // Forzar un fallo cambiando un valor
        assertArrayEquals(expected2, resultado2, "El caso falló como se esperaba: Las diagonales no están ordenadas correctamente");
    }

    @Test
    public void testSumaMatriz() {
        logger.info("Ejecutando test Suma Matriz....");

        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int resultado1 = EjercicioArrays.sumaMatriz(mat1);
        
        logger.debug("Resultado Suma Matriz ejemplo 1: {}", resultado1);
        assertEquals(45, resultado1, "La suma de la matriz no es correcta");

        int[][] mat2 = {{10, 20}, {30, 40}};
        int resultado2 = EjercicioArrays.sumaMatriz(mat2);
        
        logger.debug("Resultado Suma Matriz ejemplo 2: {}", resultado2);
        assertEquals(100, resultado2, "La suma de la matriz no es correcta");

        // Forzar un fallo
        int[][] mat3 = {{1, 1}, {1, 1}};
        int resultado3 = EjercicioArrays.sumaMatriz(mat3);
        
        logger.debug("Resultado Suma Matriz ejemplo 3 Forzar fallo): {}", resultado3);
        assertEquals(5, resultado3, "Ejemplo diseñado para fallar");
    }
}
