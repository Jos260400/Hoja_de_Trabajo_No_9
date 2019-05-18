/**
 * Universidad del Valle de Guatemala
 * Fernando José Garavito Ovando 18071
 * main.java
 * @param <V>
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static Scanner input;
    public static void main(String[] args) throws IOException {
        input = new Scanner(System.in);
        String link = "guategrafo.txt";
        int Medida = tamaño(link);
        matrizDigrapho<String> myGraph = new matrizDigrapho<>(Medida);
        myGraph = LeerElDocumento(link ,myGraph);

    }











     //Leer un archivo de texto: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

    private static matrizDigrapho<String> LeerElDocumento(String Nombre, matrizDigrapho nuevoGrafo) throws IOException {
        File file = new File(Nombre);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            String Ciudad1 = parts[0];
            if(!nuevoGrafo.Lista.contains(Ciudad1)){
                nuevoGrafo.add(Ciudad1);
            }
            String Ciudad2 = parts[1];
            if(!nuevoGrafo.Lista.contains(Ciudad2)){
                nuevoGrafo.add(Ciudad2);
            }
            int La_Distancia = Integer.parseInt(parts[2]);
            nuevoGrafo.addEdge(Ciudad1,Ciudad2,La_Distancia);
        }
        return nuevoGrafo;
    }
    private static int tamaño(String Nombre) throws IOException {
        File file = new File(Nombre);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> palabras = new ArrayList<>();
        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            String Ciudad1 = parts[0];
            if(!palabras.contains(Ciudad1)){
                palabras.add(Ciudad1);
            }
            String Ciudad2 = parts[1];
            if(!palabras.contains(Ciudad2)){
                palabras.add(Ciudad2);
            }
        }
        return palabras.Medida();
    }

}
