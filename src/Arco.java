/**
 * Universidad del Valle de Guatemala
 * Fernando José Garavito Ovando 18071
 * Arco.java
 * @param <V>
 */
public class arco<V> {
    public V LOL;
    public V LOL2;
    public double La_Distancia;
    public boolean Longitud;
    public boolean Conocido;

    public arco(V LOL, V LOL2, double Trayecto, boolean longitud) {
        this.LOL = LOL;
        this.LOL2 = LOL2;
        this.La_Distancia = dist;
        this.longitud = longitud;
        this.Conocido = false;
    }
    public V there(){
        return this.LOL2;
    }
    public double label(){
        return this.La_Distancia;
    }
    public boolean isVisited(){
        return Conocido;
    }
    public V here() {
        return this.LOL;
    }
    public void reset(){
        Conocido = false;
    }

}
