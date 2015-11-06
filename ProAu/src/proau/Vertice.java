/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proau;

/**
 *
 * @author Franco
 */
public class Vertice {

    String nombre;
    int numVertice;

    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
    }

    public String nomVertice() // devuelve identificador del vértice
    {
        return nombre;
    }

    public boolean equals(Vertice n) // true, si dos vértices son iguales
    {
        return nombre.equals(n.nombre);
    }

    public void asigVert(int n) // establece el número de vértices
    {
        numVertice = n;
    }

    public String toString() // características del vértice
    {
        return nombre + " (" + numVertice + ")";
    }
}
