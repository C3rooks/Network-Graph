
import java.util.*;

/*
 * 
 * This code was taken from Sedgewick's 4th edition files. Slight modification as been done with this class. 
 * 
 * 
 */


public class Vertex implements Comparable<Vertex>{
  public final String name;
        public ArrayList<Edge> neighbours;
        public LinkedList<Vertex> path;
        public double minDistance = Double.POSITIVE_INFINITY;
        public Vertex previous;
        public int compareTo(Vertex other){
                return Double.compare(minDistance,other.minDistance);                
        }
        public Vertex(String name){
                this.name = name;
                neighbours = new ArrayList<Edge>();
                path = new LinkedList<Vertex>();
        }
        public String toString(){
                return name;
        }        
        
        public boolean removeEdge(Vertex vertex) {       
        	return path.remove(vertex);    }
        
}