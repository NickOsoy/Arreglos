package umg.edu.gt.test.EjercicioTree;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.TreeMap;

public class EjercicioTreeTest {

	 @Test
	    public void testEjercicio1() throws Exception {
	        System.out.println("\nEJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)");
	        
	        EjercicioTreeSetAndMap ejercicios = new EjercicioTreeSetAndMap();
	        TreeMap<String, Integer> frecuencias = ejercicios.analizarFrecuenciaPalabras("src/main/resources/test.txt");
	        
	        // Mostrar resultados en consola
	        System.out.println("Palabras en orden alfabético con su frecuencia:");
	        frecuencias.forEach((palabra, frecuencia) -> 
	        System.out.printf("%-15s: %d%n", palabra, frecuencia));
	        
	        assertEquals(2, (int) frecuencias.get("hola")); // Forzar fallo cambiando el valor esperado a 3
	        assertEquals(1, (int) frecuencias.get("mundo"));
	        
	 }
	    
	    @Test
	    public void testEjercicio2() {
	        System.out.println("\nEJERCICIO 2: Rastreador de Versiones de Código (TreeMap)");
	        
	        EjercicioTreeSetAndMap ejercicios = new EjercicioTreeSetAndMap();
	        
	        System.out.println("Agregando versiones");
	        ejercicios.agregarVersionCodigo("Hola Mundo");
	        System.out.println("-Agregar versión 1: Hola Mundo");
	        
	        ejercicios.agregarVersionCodigo("Hola Java");
	        System.out.println("-Agregar versión 2: Hola Java");
	        
	        System.out.println("-Última versión: \"" + ejercicios.obtenerUltimaVersion() + "\"");
	        System.out.println("-Versión 1: \"" + ejercicios.obtenerVersion(1) + "\"");
	        
	        assertEquals("Hola Java", ejercicios.obtenerUltimaVersion());
	        assertEquals("Hola Mundo", ejercicios.obtenerVersion(1));
	        
	        // Forzar fallo cambiando a eliminarVersion(3)
	        System.out.println("Eliminando versión 2...");
	        assertTrue(ejercicios.eliminarVersion(3), "Debería retornar true al eliminar una versión existente");
	        
	       
	    }
	    
	    @Test
	    public void testEjercicio3() {
	        System.out.println("\nEJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)");
	        
	        EjercicioTreeSetAndMap ejercicios = new EjercicioTreeSetAndMap();
	        
	     // Crear eventos con fechas específicas
	        LocalDateTime fechaTaller = LocalDateTime.of(2025, 4, 15, 14, 0);
	        LocalDateTime fechaConferencia = LocalDateTime.of(2025, 5, 10, 10, 0);
	        
	        System.out.println("Agregando nuevos eventos");
	        ejercicios.agregarEvento(fechaTaller, "Taller de Machine Learning", "Sala 3");
	        ejercicios.agregarEvento(fechaConferencia, "Conferencia de Java", "Auditorio A");
	        
	        // Obtener próximo evento
	        EjercicioTreeSetAndMap.Evento proximo = ejercicios.obtenerProximoEvento();
	        System.out.println("Próximo evento: " + proximo);
	        
	        // Mostrar eventos en consola
	        ejercicios.imprimirEventos();
	        
	        
	        // Verificaciones
	        assertEquals("Taller de Machine Learning", proximo.getNombre()); 
	        assertEquals(2, ejercicios.cantidadEventos());
	        
	        // Eliminar eventos pasados
	        LocalDateTime fechaReferencia = LocalDateTime.of(2025, 4, 16, 0, 0); // Un día después del taller
	        System.out.println("\nEliminando eventos pasados a la fecha: " + fechaReferencia);
	        ejercicios.eliminarEventosPasados(fechaReferencia);
	       	        
	        System.out.println("\nLista eventos actualizada:");
	        ejercicios.imprimirEventos();
	        
	        // Ahora la conferencia debería ser la próxima
	        EjercicioTreeSetAndMap.Evento nuevoProximo = ejercicios.obtenerProximoEvento();
	        System.out.println("\nPróximo evento después de eliminar: " + nuevoProximo);
	        assertEquals("Conferencia de Java", nuevoProximo.getNombre());
	        assertEquals(1, ejercicios.cantidadEventos());
	    }
}
