/**
 * Universidad del Valle de Guatemala
 * Fernando José Garavito Ovando 18071
 * vertice.java
 * @param <V>
 */

public class Punto<E> {
    int Lugar;
    public E Nombre;
    public boolean Conocido;
    public Punto(E Nombre2, int Place) {
        this.Nombre = Nombre2;
        this.Conocido = false;
        this.Lugar = Place;
    }
    public boolean isVisited(){
        return Conocido;
    }
    public void reset(){
        Conocido = false;
    }
    public int getLugar(){
        return this.Lugar;
    }
}
