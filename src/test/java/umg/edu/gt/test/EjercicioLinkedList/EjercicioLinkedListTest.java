package umg.edu.gt.test.EjercicioLinkedList;


import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkList;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EjercicioLinkedListTest {
	private static final Logger logger = LogManager.getLogger(EjercicioLinkedListTest.class);

    @Test
    public void testEliminarDuplicados() {
        logger.info("--- Probando removeDuplicates ---");

        // Crear una lista con duplicados
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(4);
        lista.add(4);

        logger.info("Lista original: " + lista);

        // Eliminar duplicados
        EjercicioLinkList.eliminarDuplicados(lista);

        logger.info("Lista sin duplicados: " + lista);

        // Lista esperada después de eliminar duplicados
        LinkedList<Integer> esperada = new LinkedList<>();
        esperada.add(1);
        esperada.add(2);
        esperada.add(3);
        esperada.add(4);

        // Verificar que la lista sin duplicados coincide con la esperada
        try {
            assertEquals(esperada, lista, "La lista no tiene duplicados eliminados correctamente.");
            logger.info("Test eliminarDuplicados pasado correctamente.\n");
        } catch (AssertionError e) {
            logger.error("Test eliminarDuplicados falló: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testInvertirLinkedList() {
        logger.info("---** Probando el metodo InvertirLinkedList **---");

        // Crear una lista de cadenas
        LinkedList<String> lista = new LinkedList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        

        logger.info("Lista original: " + lista);

        // Invertir la lista
        EjercicioLinkList.invertirLinkedList(lista);

        logger.info("Lista invertida: " + lista);

        // Lista resultado después de invertir
        LinkedList<String> resultado = new LinkedList<>();
        resultado.add("C");
        resultado.add("B");
        resultado.add("A");

        // Verificar que la lista invertida coincide con la esperada
        try {
            assertEquals(resultado, lista, "La lista no se invirtió correctamente.");
            logger.info("Test invertirLinkedLista pasado correctamente.\n");
        } catch (AssertionError e) {
            logger.error("Test invertirLinkedLista falló: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testIntercarlarListas() {
        logger.info("---** Probando el metodo IntercarlarListas **---");

        // Crear dos listas ordenadas
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        logger.info("Lista 1: " + lista1);
        logger.info("Lista 2: " + lista2);

        // Intercalar las dos listas
        LinkedList<Integer> listaIntercalada = EjercicioLinkList.intercarlarListas(lista1, lista2);

        logger.info("Lista intercalada: " + listaIntercalada);

        // Lista resultado después de intercalar
        LinkedList<Integer> resultado = new LinkedList<>();
        resultado.add(1);
        resultado.add(2);
        resultado.add(3);
        resultado.add(4);
        resultado.add(5);
        resultado.add(6);

        // Verificar que la lista intercalada coincide con la esperada
        try {
            assertEquals(resultado, listaIntercalada, "Las listas no se intercalaron correctamente.");
            logger.info("Test intercalarListas pasado correctamente.\n");
        } catch (AssertionError e) {
            logger.error("Test intercalarListas falló: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testIntercalarListasForzandoFallo() {
        logger.info("---** Probando intercalarListas  (forzando fallo) **---");

        // Crear dos listas ordenadas
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        logger.info("Lista 1: " + lista1);
        logger.info("Lista 2: " + lista2);

        // Intercalar las dos listas
        LinkedList<Integer> listaIntercalada = EjercicioLinkList.intercarlarListas(lista1, lista2);

        logger.info("Lista intercalada: " + listaIntercalada);

        // Lista resultado esperado incorrecto forzando el fallo
        LinkedList<Integer> resultado = new LinkedList<>();
        resultado.add(1);
        resultado.add(2);
        resultado.add(3);
        resultado.add(4);

        // Verificar que la lista intercalada NO coincide con la esperada
        try {
        	assertEquals(resultado, listaIntercalada, "Este test está diseñado para fallar.");
            logger.info("Test IntercalarListasForzandoFallo pasado correctamente.\n");
        } catch (AssertionError e) {
            logger.error("Test IntercalarListasForzandoFallo falló: " + e.getMessage());
            throw e;
        }
    }
}