/***************************************************************************************
 *  Author: Corey Crooks  												               *
 * Date: 11/1/2013																       *
 * Email: ccc35@pitt.edu														       *
 * Purpose: The purpose of this application is to provide a lesson in learning graph   *
 * 			algorithms and their implementations. This application is called from the  *
 * 			main class and executes based on user input.							   *
 ***************************************************************************************/


/*
 * Main Class written by Corey Crooks (ccc35@pitt.edu)
 * 
 */


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		
			// comments of thought process. 
           /*Setup main program. 
            * 
            * 
            */ 
            
      
            /*
             * Step 2: Get the reporting to work. 
             *    -- completed! 
             */
		
		
			/*
			 * Step 3: Use files for the MST (KruskalMST) from Sedgewicks classes. 
			 *   -- completed 10/28/13
			 */
          
		
			/*
			 * Step 4: Next! delete vertex to to from
			 *  -- completed OCT 31 
			 */
		
			/*
			 * Step 5: Restore vertex 
			 *  -- completed Nov 1
			 */
		
			/*
			 * Step 6: complete with changing the graph from Edge methods. 
			 * 
			 */
		
		
			/* Step 7: Eulerian Path completed 
			 * 	--10/29/2013
			 * 
			 */
		
           
          
            if(args.length == 1){
            
            boolean exit = false; 
            Scanner inScan = new Scanner(System.in); 
            String file = args[0];
            
            In in = new In(file);
            EdgeWeightedGraph g = new EdgeWeightedGraph(in); 
            MyFunctions f = new MyFunctions(g);
            
            
            while(exit != true)
            {
                     System.out.println("1. R (eport)\n" + "2. M (inimum Spanning Tree)\n" +
                    "3. S (hortest Path from) i j\n" + "4. D (own edge) i j\n" +
                    "5. U (p edge) i j\n" + "6. C (hange weight of edge) i j x\n" +
                     "7. E (ulerian)\n" + "8. Q (uit)\n");
            
                     System.out.println("Enter your choice: ");
                     int var = inScan.nextInt();
                     
                     // use switch statement for every possible choice that user can select.
                   if(var >= 1 && var <= 8){
                     switch(var){
                             case 1:
                                  
                            	 f.reporting();
                                 exit = false; 
                                 break; 
                                 
                             case 2: 
                                 f.mst();
                                 exit = false;
                                 break;
                                 
                             case 3:
                                 f.dijkstraSP(inScan);
                                 exit = false;
                                 break;
                                 
                                 
                                // case 4 is for making graph go down 
                             case 4:
                            	// use for pushing down the graph 
                            	 f.disableVertex(inScan);
                           
                            	 exit = false; 
                                 break;
                                 
                             case 5:
                            	 // use for pushin up the graph. 
                            	 f.enableVertex(inScan);
                            	 exit = false;
                                 break; 
                                 
                             case 6: // change weight of the graph 
                            	 f.changeGraph(inScan);
                            	 exit = false;
                                 break; 
                                 
                             case 7: 
                            	int a = f.isEulerianCycle();
                            	if(a == 0 || a == 2) System.out.println("Graph has an Eulerian path.");
                            	//else if(a == 2) System.out.println("Graph has an Semi-Eulerian path.");
                            	else if(a == 1)  System.out.println("Error odd count");
                            	exit = false; 
                                break;
                                 
                             case 8:
                                 exit = true; 
                                 break; 
 
                                 
                     }
	    
                   } else System.out.println("Error unrecognized input\n ");
                
            }
            
            
            }else if(args.length == 0){
            System.out.println("Error usage: java Main graph.txt");
            }
            	
            
            
            
        }
	
 
        
        
        

} // end class
 