

/*
 * 
 * This code was taken from Sedgewick's 4th edition files. Slight modification as been done with this class. 
 * 
 * 
 */


public class Edge implements Comparable<Edge> {

	
    private double weight; // holds the edge weight for the edgeweightedgraph
    private boolean connected; // used for checking status of the edge 
    public boolean set; // used for checking to see if has been set or not. 

    private final int v;
    private final int w;

    /**
* Initializes an edge between vertices <tt>v/tt> and <tt>w</tt> of
* the given <tt>weight</tt>.
* param v one vertex
* param w the other vertex
* param weight the weight of the edge
* @throws java.lang.IndexOutOfBoundsException if either <tt>v</tt> or <tt>w</tt>
* is a negative integer
*/
    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        this.v = v;
        this.w = w;
        this.weight = weight;
        this.connected= true; 
   
    }

    /**
* Returns the weight of the edge.
* @return the weight of the edge
*/
    public double weight() {
        return weight;
    }

    /**
* Returns either endpoint of the edge.
* @return either endpoint of the edge
*/
    public int either() {
        return v;
    }

    /**
* Returns the endpoint of the edge that is different from the given vertex
* (unless the edge represents a self-loop in which case it returns the same vertex).
* @param vertex one endpoint of the edge
* @return the endpoint of the edge that is different from the given vertex
* (unless the edge represents a self-loop in which case it returns the same vertex)
* @throws java.lang.IllegalArgumentException if the vertex is not one of the endpoints
* of the edge
*/
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    /**Used for step 6 for changing the graphs weight.
     * 
     * @param weight
     */
    public void setWeight(int weight){
      this.weight = weight;
    }
    

    /**
* Compares two edges by weight.
* @param that the other edge
* @return a negative integer, zero, or positive integer depending on whether
* this edge is less than, equal to, or greater than that edge
*/
    public int compareTo(Edge that) {
        if (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else return 0;
    }
  
    /**
* Returns a string representation of the edge.
* @return a string representation of the edge
*/
    public String toString() {
    	  String result;
          if(connected) result = String.format("%d-%d, %1.2f", v, w, weight);
           else result = String.format("'Disabled'");
          
          return result;
    }

    //returns if connected
   public boolean getConnected(){
      return connected;
    }
    
   // this will set if it is connected or not  
    public void isConnected(boolean b){
      this.connected= b;
    }

  
    
}