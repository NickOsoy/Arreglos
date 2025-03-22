package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;


import java.util.LinkedList;
import java.util.HashSet;
import java.util.Iterator;

public class EjercicioLinkList {
	
	// Problema 1: Eliminar valores duplicados de una LinkedList<Integer>
    public static void eliminarDuplicados(LinkedList<Integer> list) {
        HashSet<Integer> visto = new HashSet<>();
        Iterator<Integer> iterator = list.iterator();
        
        while (iterator.hasNext()) {
            Integer valor = iterator.next();
            if (visto.contains(valor)) {
                iterator.remove();
            } else {
            	visto.add(valor);
            }
        }
    }

    // Problema 2: Invertir los elementos de una LinkedList<String>
    public static void invertirLinkedList(LinkedList<String> lista) {
        int tamaño = lista.size();
        for (int i = 0; i < tamaño / 2; i++) {
            String temp = lista.get(i);
            lista.set(i, lista.get(tamaño - i - 1));
            lista.set(tamaño - i - 1, temp);
        }
    }

    // Problema 3: Intercalar dos listas enlazadas ordenadas
    public static LinkedList<Integer> intercarlarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> listaIntercalada = new LinkedList<>();
        Iterator<Integer> iterator1 = lista1.iterator();
        Iterator<Integer> iterator2 = lista2.iterator();
        
        Integer valor1  = iterator1.hasNext() ? iterator1.next() : null;
        Integer valor2  = iterator2.hasNext() ? iterator2.next() : null;
        
        while (valor1 != null || valor2 != null) {
            if (valor1 != null && (valor2 == null || valor1 <= valor2)) {
            	listaIntercalada.add(valor1);
                valor1 = iterator1.hasNext() ? iterator1.next() : null;
            } else if (valor2 != null) {
            	listaIntercalada.add(valor2 );
                valor2 = iterator2.hasNext() ? iterator2.next() : null;
            }
        }
        
        return listaIntercalada;
    }
}
