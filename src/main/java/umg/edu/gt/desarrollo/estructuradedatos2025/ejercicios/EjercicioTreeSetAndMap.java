package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.TreeSet;


public class EjercicioTreeSetAndMap {
	
	   // ---------------------- EJERCICIO 1: Análisis de Frecuencia de Palabras ----------------------
    public TreeMap<String, Integer> analizarFrecuenciaPalabras(String rutaArchivo) throws IOException {
        TreeMap<String, Integer> frecuenciaPalabras = new TreeMap<>();
        BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        
        while ((linea = lector.readLine()) != null) {
            String[] palabras = linea.toLowerCase()
                                  .replaceAll("[^a-zA-ZáéíóúüñÁÉÍÓÚÜÑ ]", "")
                                  .split("\\s+");
            
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                }
            }
        }
        lector.close();
        return frecuenciaPalabras;
    }
    
    public void imprimirFrecuencias(TreeMap<String, Integer> mapaFrecuencias) {
        mapaFrecuencias.forEach((palabra, frecuencia) -> 
            System.out.println(palabra + ": " + frecuencia));
    }
    
    
    
	
 // ---------------------- EJERCICIO 2: Rastreador de Versiones ----------------------
    private TreeMap<Integer, String> versionesCodigo = new TreeMap<>();
    private int contadorVersiones = 0;
    
    public int agregarVersionCodigo(String codigo) {
        contadorVersiones++;
        versionesCodigo.put(contadorVersiones, codigo);
        return contadorVersiones;
    }
    
    public String obtenerVersion(int numeroVersion) {
        return versionesCodigo.get(numeroVersion);
    }
    
    public String obtenerUltimaVersion() {
        return versionesCodigo.lastEntry().getValue();
    }
    
    public boolean eliminarVersion(int numeroVersion) {
        return versionesCodigo.remove(numeroVersion) != null;
    }
    
    public void imprimirVersiones() {
        versionesCodigo.forEach((version, codigo) -> 
            System.out.println("Versión " + version + ": " + codigo));
    }
    
    
	
 // ---------------------- EJERCICIO 3: Gestión de Eventos ----------------------
    public static class Evento implements Comparable<Evento> {
        private LocalDateTime fecha;
        private String nombre;
        private String ubicacion;
        
        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }
        
     
        @Override
        public int compareTo(Evento otro) {
            return this.fecha.compareTo(otro.fecha);
        }
        
     // Agregar getters para los campos
        public LocalDateTime getFecha() {
            return fecha;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public String getUbicacion() {
            return ubicacion;
        }
        
        @Override
        public String toString() {
            return String.format("\"%s\", %s, %s", nombre, 
                fecha.toLocalDate() + " " + String.format("%02d:%02d", fecha.getHour(), fecha.getMinute()), 
                ubicacion);
        }
    }
    
    private final TreeSet<Evento> eventos = new TreeSet<>();
    
    public void agregarEvento(LocalDateTime fecha, String nombre, String ubicacion) {
        eventos.add(new Evento(fecha, nombre, ubicacion));
    }
    
    public Evento obtenerProximoEvento() {
        return eventos.isEmpty() ? null : eventos.first();
    }
    
    public void eliminarEventosPasados(LocalDateTime fechaReferencia) {
        eventos.removeIf(e -> e.getFecha().isBefore(fechaReferencia));
    }
    
    public void imprimirEventos() {
        System.out.println("Lista de eventos:");
        int i = 1;
        for (Evento evento : eventos) {
            System.out.println(i + ". " + evento);
            i++;
        }
    }
    
    // Método para test
    public int cantidadEventos() {
        return eventos.size();
    }
    
    
}
