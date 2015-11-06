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
public class Grafo {

    int numVerts;
    static int maxVerts = 20;
    Vertice[] verts;
    int[][] matAd;

    public Grafo() {

        this(maxVerts);
    }

    public Grafo(int mx) {
        matAd = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matAd[i][j] = -1;
            }
        }
        numVerts = 0;
    }

    public void nuevoVertice(String nom) {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nom);
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
    }

    public int numVertice(String vs) {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;) {
            encontrado = verts[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }
        return (i < numVerts) ? i : -1;
    }

    public void nuevoArco(String a, String b, int valor) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) {
            throw new Exception("Vértice no existe");
        }
        matAd[va][vb] = valor;
    }

    public boolean adyacente(String a, String b) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) {
            throw new Exception("Vértice no existe");
        }
        return matAd[va][vb] == 1;
    }
    
    public void imprimir(int mx){
        System.out.println("matriz:");
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                System.out.print(matAd[i][j]+", ");
            }
            System.out.println("");
        }
    }
}
