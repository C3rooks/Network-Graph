


/*
 * 
 * This code was taken from Sedgewick's 4th edition files. No modification as been done with this class. 
 * 
 * 
 */


public class CC {
    private boolean[] marked;   // marked[v] = has vertex v been marked?
    private int[] id;           // id[v] = id of connected component containing v
    private int[] size;         // size[id] = number of vertices in given component
    private int count;          // number of connected components

    /**
     * Computes the connected components of the undirected graph <tt>G</tt>.
     * @param G the graph
     */
    public CC(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    // depth-first search
    public void dfs(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (Edge e : G.adj(v)) {
            if (e.getConnected()){ //MUST BE ACTIVE!
              if (!marked[e.other(v)]) {
                  dfs(G, e.other(v));
              }
            }
          }
    }

    /**
     * Returns the component id of the connected component containing vertex <tt>v</tt>.
     * @param v the vertex
     * @return the component id of the connected component containing vertex <tt>v</tt>
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * Returns the number of vertices in the connected component containing vertex <tt>v</tt>.
     * @param v the vertex
     * @return the number of vertices in the connected component containing vertex <tt>v</tt>
     */
    public int size(int v) {
        return size[id[v]];
    }

    /**
     * Returns the number of connected components.
     * @return the number of connected components
     */
    public int count() {
        return count;
    }

    /**
     * Are vertices <tt>v</tt> and <tt>w</tt> in the same connected component?
     * @param v one vertex
     * @param w the other vertex
     * @return <tt>true</tt> if vertices <tt>v</tt> and <tt>w</tt> are in the same
     *     connected component, and <tt>false</tt> otherwise
     */
    public boolean areConnected(int v, int w) {
        return id(v) == id(w);
    }


    
}