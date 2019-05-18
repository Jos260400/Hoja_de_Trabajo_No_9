/**
 * Universidad del Valle de Guatemala
 * Fernando José Garavito Ovando 18071
 * Grafo.java
 * @param <V>
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo<V> {
    public int Medida;
    public arco<V> [][];
    public Map<V,Punto<V>> El_Punto;
    public List<Integer> freeList;
    public List<String> Lista;
    Double[][] Datos;

    public Grafo(int Medida) {
        this.Lista = new ArrayList<>();
        this.Medida = Medida;
        this.Instrucciones = new arco[Medida][Medida];
        this.Datos = new Double[Medida][Medida];
        this.El_Punto = new HashMap<>(Medida);
        this.freeList = new ArrayList<>();
        for (int row = Medida-1; row >= 0; row--) { freeList.add(row); }
        for(int i = 0; i < Datos.length; i++) {
            for(int j = 0; j < Datos.length; j++) {
                Datos[i][j] = Double.POSITIVE_INFINITY;
                if(i==j){
                    Datos[i][j] = 0.0;
                }
            }
        }
    }
    public void add(V Nombre) {
        if (El_Punto.containsKey(Nombre)) return;
        int Place = freeList.remove(0);
        El_Punto.put(Nombre, new Punto<>(Nombre,Place));
        Lista.add(Nombre.toString());
    }
    public String addEdge(V LOL, V LOL2, double La_Distancia) {
        Punto<V> inicio = El_Punto.get(LOL);
        Punto<V> llegada = El_Punto.get(LOL2);
        if(inicio == null || llegada == null) {
            return "¡No se puede hacer el enlace";
        }else {
            Instrucciones[inicio.getLugar()][llegada.getLugar()] = new arco<V>(LOL, LOL2, La_Distancia, true);
            Datos[inicio.getLugar()][llegada.getLugar()] = La_Distancia;
            return "¡Enlace exitoso";
        }
    }
    public String removeEdge(V LOL, V LOL2){
        Punto<V> inicio = El_Punto.get(LOL);
        Punto<V> llegada = El_Punto.get(vrt2);
        if(inicio == null || llegada == null) {
            return "¡No se puede ejecutar";
        }else {
            Instrucciones[inicio.getLugar()][llegada.getLugar()] = null;
            Datos[inicio.getLugar()][llegada.getLugar()] = Double.POSITIVE_INFINITY;
            return "Se ha quitado el camino";
        }
    }
    public void printGraph() {
        System.out.println("Matriz adyacente: ");
        int no = Lista.Medida()-1;
        for (int i = 0; i < Datos.length; i++) {
            if(no>=0){
                System.out.print(Lista.get(no).toString()+"\t\t");
                no--;
            }
            for (int j = 0; j <Datos.length; j++) {
                System.out.print(Datos[i][j]+ " ");
            }
            System.out.println();
        }
    }




    public Double[][] floyd(Double[][] adyacencia)
    {
        int n=adyacencia.length;
        Double D[][]=adyacencia;

        String enlaces[][]=new String [n][n];
        String[][] aux_enlaces=new String[adyacencia.length][adyacencia.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                enlaces[i][j]="";
                aux_enlaces[i][j]="";
            }
        }
        String enl_rec="";
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Double aux=D[i][j];
                    Double aux2=D[i][k];
                    Double aux3=D[k][j];
                    Double aux4=aux2+aux3;
                    Double res=Math.min(aux,aux4);
                    if(aux!=aux4)
                    {
                        if(res==aux4)
                        {
                            enl_rec="";
                            aux_enlaces[i][j]=k+"";
                            enlaces[i][j]=enlaces(i,k,aux_enlaces,enl_rec)+(k+1);
                        }
                    }
                    D[i][j]=(Double) res;
                }
            }
        }
        return D;
    }

    public String enlaces(int i,int k,String[][] aux_enlaces,String enl_rec)
    {
        if(aux_enlaces[i][k].equals("")==true)
        {
            return "";
        }
        else
        {
            enl_rec+=enlaces(i,Integer.parseInt(aux_enlaces[i][k].toString()),aux_enlaces,enl_rec)+(Integer.parseInt(aux_enlaces[i][k].toString())+1)+" , ";
            return enl_rec;
        }
    }
    public String minDist(V nom1, V nom2) {
        Punto<V> vtx1 = El_Punto.get(nom1);
        Punto<V> vtx2 = El_Punto.get(nom2);
        if (vtx1 == null || vtx2 == null){
            return "No hay enlace!";
        }
        return "\nDesde " +nom1.toString()+" a "+ nom2.toString()+" la distancia mas corta es de "+this.datos[vtx1.getLugar()][vtx2.getLugar()] + ".";
    }

    public String getCentroGrafo(V label){

        int[] columna = new int[Datos.length];
        for(int i = 0; i < Datos.length; i++) {
            Double Max = Datos[i][0];
            int Place = 0;
            for(int j = 0; j < Datos.length; j++) {
                if (i!=j){
                    Double temp = Datos[i][j];
                    if(temp > Max) {
                        Max = temp;
                        Place = j;
                    }
                }
            }
            columna[i] = Place;
        }

        int minLugar = 0;
        Number min = columna[0];
        for(int x = 0; x < columna.length; x++) {
            Number temp = columna[x];
            if(temp.doubleValue() < min.doubleValue()) {
                min = temp;
                minLugar = x;
            }
        }
        return Lista.get(Lista.Medida()-1-minLugar);
    }

}
