/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proau;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Franco
 */
public class Automata {

    String archivo;

    public Automata() {

    }

    public void leer(String archivo) throws FileNotFoundException, IOException, Exception {
        String cadena;
        int cont;
        char[] estado, len;
        ArrayList<Character> estados = new ArrayList<>();
        ArrayList<Character> lenguaje = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();//lee la primera linea
        len = cadena.toCharArray();
        for (int i = 0; i < cadena.length(); i++) {

            if (!lenguaje.contains(len[i]) && len[i] != '*' && len[i] != 9) {
                if (len[i] == 'v' && len[i + 1] == 'a') {
                    lenguaje.add('v');
                    i++;
                } else {
                    lenguaje.add(len[i]);
                }
            }
        }
        while ((cadena = b.readLine()) != null) {
            estado = cadena.toCharArray();
            for (int i = 0; i < cadena.length(); i++) {
                if (estado[i] != 9) {
                    if (estado[i] == 'v' && estado[i + 1] == 'a') {
                        i++;
                    } else {
                        if (!estados.contains(estado[i]) && estado[i] != '-') {
                            estados.add(estado[i]);
                        }

                    }
                }
            }
        }
        b.close();
        Grafo g = new Grafo(estados.size());
        Iterator<Character> iterador = estados.iterator();
        Iterator<Character> iterador1 = lenguaje.iterator();
        System.out.println("Estados: " + estados.size());
        while (iterador.hasNext()) {
            char elemento = iterador.next();
            g.nuevoVertice(elemento + "");
            System.out.print(elemento + " / ");
        }
        System.out.println("\nLenguaje:");
        while (iterador1.hasNext()) {
            char elemento1 = iterador1.next();
            System.out.print(elemento1 + " / ");
        }
        System.out.println("");
        System.out.println("Posicion 0 = " + lenguaje.get(0));
        System.out.println("Posicion 1 = " + lenguaje.get(1));
        System.out.println("Posicion 2 = " + lenguaje.get(2));
        FileReader f1 = new FileReader(archivo);
        BufferedReader b1 = new BufferedReader(f1);
        cadena = b1.readLine();
        while ((cadena = b1.readLine()) != null) {
            estado = cadena.toCharArray();
            cont = -1;
            for (int i = 0; i < cadena.length(); i++) {
                if (estado[i] != 9) {
                    if (estados.contains(estado[i]) && i != 0) {
                        System.out.println("A(" + estado[0] + " , " + estado[i] + " , " + cont + ")");
                        g.nuevoArco(estado[0] + "", estado[i] + "", cont);
                    }
                    cont++;
                }
            }
        }
        g.imprimir(7);
        b1.close();
    }

}
