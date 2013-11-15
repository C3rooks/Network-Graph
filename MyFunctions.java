/***************************************************************************************
 *  Author: Corey Crooks  												               *
 * Date: 11/1/2013																       *
 * Email: ccc35@pitt.edu														       *
 * Purpose: This class is the secondary control class to the main, where when called,  *
 * 			executes methods based on user input.								       *
 ***************************************************************************************/

import java.util.Scanner;


public class MyFunctions {

	 /*
     * 
     * Main functions of the application put together for the
     * entire network graph
     * 
     * 
     */
     
	EdgeWeightedGraph G;
	Queue[] components;
	
	int V; 
	// constructor
	public MyFunctions(EdgeWeightedGraph g)
	{	
		this.G = g; 
	}
	
	
	/*
	 * Step 1: Reporting  --> Completed 
	 * 
	 * 
	 */
	  public void reporting()
	    {
	    	// use to print the graph.
	           StdOut.println(G);
	           int count = 1; 
	           int vertices = G.V();         
	            CC cc = new CC(G); 
	         
	            if(cc.count() == 1){
	                System.out.println("Network is connected");
	              
	                   }else System.out.println("Network is not connected");
	       
	        components = new Queue[cc.count()]; // return the amount of components 
	        for (int i = 0; i < cc.count(); i++){
	            components[i] = new Queue();  // create new queues for each of the components 
	          }
	        
	        for(int i = 0; i < vertices; i++){
	            components[cc.id(i)].enqueue(i);
	          }
	        for (int i = 0; i < cc.count(); i++){
	        //	System.out.println("Connected Components"); if needed to show
	            System.out.println(count +": " +components[i]);
	            System.out.println("--------------------------------------------------------\n");
	            count++; // used to keep track of components 
	          }


	    }
	    
	  /*
	   * Step 2: Use files for the MST (KruskalMST) from Sedgewick's classes. 
			   -- completed 10/28/13
	   * 
	   * 
	   */
	    
	  
	  // MST function using KruskalsMST to find the shortest path. 
	  // code from Algorithms 4th edition by Sedgewick. 
	    public void mst()
	    {
	    
	    KruskalMST mst = new KruskalMST(G);
	    System.out.println("Minimum Spanning Tree");
	    for (Edge e : mst.edges()) {
	        StdOut.println(e);
	    }
	   
	    StdOut.printf("%.5f\n", mst.weight());
	    System.out.println("\n");
	    System.out.println("-----------------------------------------------------\n");
	    }
	    
	
	
	    /*
	     * Step 3: Shortest path using the EdgeweightedDigraph and Dijkstras from Sedgewick's files
	     * 
	     */
	
	   
	       public void dijkstraSP(Scanner inScan)
	       {
	        
	             EdgeWeightedDigraph g = new EdgeWeightedDigraph(G);
	            
	     
	             System.out.println("Enter from vertex: "); 
	             int vertex = inScan.nextInt();
	             System.out.println("Enter to vertex "); 
	             int vertex2 = inScan.nextInt();
	             
	             DijkstraSP sp = new DijkstraSP(g, vertex); //from i to every other node
	             
	             if (sp.hasPathTo(vertex2)){ //has path
	               System.out.println("Shortest Path from vertex " + vertex + " to " + "vertex " + vertex2 + " is \n" + "("+sp.distTo(vertex2) + ")");
	               for (DirectedEdge e : sp.pathTo(vertex2)){
	                 System.out.print(e+"   ");
	               }
	               System.out.print("\n");
	             } else { 
	               System.out.println("There is no path from " + vertex + " to " + vertex2);
	             }
	           

	           System.out.println("-----------------------------------------------------\n");
	       }
	       
	       
	       
	       /*
	        * Step 4: Method of removing vertex from - vertex to
	        * 
	        */

	       public void disableVertex(Scanner inScan)
	       {   
	    	   	boolean connected = false; 
    	
	    	   	System.out.println("Enter from vertex:");
	    	   	int vertex = inScan.nextInt(); 
	    	   	System.out.println("Enter to vertex:");
	    	   	int vertex2 = inScan.nextInt(); 

	    	   	// System.out.println("The old edge count is : " + G.E);
	    	   	// 4 to 2 
	    	   	//removes all of 2 
	    	   	for (Edge e : G.adj[vertex]){
	    	   		if (e.other(vertex) == vertex2){
	    	   			connected = true;
	    	   			if(e.getConnected()){
	    	   				e.isConnected(false);
	    	   				System.out.println("Edge has been deleted");
	    	   				//    System.out.println("The new edge count is : " + G.E);
             }
             }
           }
       
	    	   	// handle if the edge isnt connected
	    	   	if (!connected){ 
	    	   		System.out.println("Error there is now connection between edges");
	    	   	} else {
	    	   		for (Edge f : G.adj[vertex2]){
	    	   			if (f.other(vertex2) == vertex){
	    	   				f.isConnected(false); // handles the opposite, tra
	    	   			}
	    	   		}
	    	   	}
    	
	       }
	       
	       /*
	        * Step 5: Re-enable the vertex from - vertex to
	        * 
	        */

	       // Note: Process is simply the same for removing, just reversing the removal. 
	       public void enableVertex(Scanner inScan)
	       {
	    	   	// Reusable code bad 
	    	   	System.out.println("Enter from vertex:");
	    	   	int vertex = inScan.nextInt(); 
	    	   	System.out.println("Enter to vertex:");
	    	   	int vertex2 = inScan.nextInt(); 
	    	   	boolean connected = false; 
	    	
	    	   	for (Edge e : G.adj[vertex]){
	    	   		if (e.other(vertex) == vertex2){
	    	   			connected = true;
	    	   			if(!e.getConnected()){
	    	   				e.isConnected(true);
	    	   				System.out.println("Edge has been restored");
	    	   			}
	               
	    	   		}
	    	   	}
	    	 
	    	   	// handle if the edge isnt connected
	    	   	if (!connected){ 
	    	   		System.out.println("Error edge has not been disabled!");
	    	   	} 
	       	
	       }
    	
    	
    	
    	/*
    	 * Step 6: Change the graph by finding the vertexs and changing the weight. 
    	 * 
    	 */
    

	       public void changeGraph(Scanner inScan){
	       	boolean connected = false; // need to find for checking matching
	       	
	       		System.out.println("Enter from vertex:");
	       		int vertex = inScan.nextInt();
	       		System.out.println("Enter to vertex:");
	       		int vertex2 = inScan.nextInt();  // user input 
	       		System.out.println("Enter to weight:");
	       		int weight = inScan.nextInt(); 
	       
	       		// use Edge's method other. 
	       		for (Edge e : G.adj[vertex]){
	       			if (e.other(vertex) == vertex2){
	       				connected = true;
	       				if (weight <= 0){
	       					e.isConnected(false);
	       					System.out.println("Remove edge " + vertex );
	       				} else {
	       					e.isConnected(true);
	       					e.setWeight(weight);
	                	System.out.println("Edge " + vertex + "->" +vertex2+ " now has a new weight of " + weight);
	       				}
	       				break;
	       			}
	       		}
	       		if (!connected){
	           	
	       			// create a new edge 
	       			G.addEdge(new Edge(vertex, vertex2, weight));
	       			System.out.println("Edge " + vertex + "->" + vertex2 + "now has "+ weight);
	       		} else { 
	       			for (Edge edge : G.adj[vertex2]){
	           	 
	       				// again check if equal
	       				if (edge.other(vertex2) == vertex){
	                   
	       					if (weight <= 0){
	       						edge.isConnected(false);
	       					} else {
	       						edge.isConnected(true);
	       						edge.setWeight(weight);
	       					}
	       					break;
	       				}
	       			}
	       		}
	       }
	       	
	       	
	       /*
	        * 7: Final Step, Check for Eulerian Cycle
	        * 
	        */
    
	       public int isEulerianCycle() {     
	    	   CC cc = new CC(G); 
	    	   int odd = 0;
	    	   if(cc.count() != 1) 
	    		   return 0; 
    	
	    	   for(int v = 0; v < V; v++) {            
	    		   if(G.adj.length % 2 != 1) {
	    			   ++odd;  }  
	    	   }
	    	   if(odd > 2)
	    	   {
	    		   return 0; 
	    	   }
    
	    	   return (odd == 2) ? 1 : 2; 
	       }
    
    
    
    
    
    	
    	
    	
    	
    	
    	
    	
    	
  
   
    
    
    
	
}
