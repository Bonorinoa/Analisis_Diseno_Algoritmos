import java.util.ArrayList;
/**
 * 
 * @author Augusto Gonzalez Bonorino <br><br>
 *
 * This is the class definition for GraphGonzalezBonorino, which implements an undirected graph
 *
 */
public class GraphGonzalezBonorino {
	
	private int numVertices;
	
	public ArrayList<VertexGonzalezBonorino> myVertices;
	
	/**
	 * Constructor
	 */
	public GraphGonzalezBonorino()
		{
			myVertices = new ArrayList<>();
			
		} // GraphGonzalezBonorino
	
	/**
	 * Add vertex to graph given vertex object and id
	 * @param newVertex
	 * @param id
	 */
	public void addVertex(int id)
		{	
		
			VertexGonzalezBonorino newVertex = new VertexGonzalezBonorino(id);
			myVertices.add(newVertex);
			
			numVertices++;
			
		} // addVertex

	/**
	 * Get number of vertices in the graph
	 * @return numVertices
	 */
	public int getNumVertices()
		{
			return numVertices;
			
		} // getNumVertices
	
	/**
	 * Method to populate graph given the list of Strings of commands from text file
	 * @param list of Strings 
	 */
	public void populateGraph(ArrayList<String> list)
		{
	
	        //iterate through arrayList
	        for(int i = 0; i < list.size(); i++)
		        {
		            //if line is empty or a comment, print it out
		            if(list.get(i).equals("") || list.get(i).substring(0, 2).equals("--"))
			            {
			                System.out.println(list.get(i));
			                
			            } // if
		
		            // add vertex
		            else if(list.get(i).contains("vertex"))
			            {
			                // get vertex's id
			                int id = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ") + 1));
			                
			                addVertex(id);
			
			            } // else if
		
		            // add edge
		            else if(list.get(i).contains("edge"))
			            {
		            		// get id of first vertex
			                int id1 = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf("e") + 2,
			                        list.get(i).indexOf("-") - 1));
			                
			                // get id of second vertex
			                int id2 = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") + 2));
			
			                
			                if(myVertices.get(0).getId() == 0)
				                {
				                	myVertices.get(id1).addNeighbour(myVertices.get(id2));
				                	myVertices.get(id2).addNeighbour(myVertices.get(id1));
				                	
				                } // if
			
			                //if the first node is not a 0 we need to subtract one to comply with list indexation
			                else 
				                {
				                	myVertices.get(id1 - 1).addNeighbour(myVertices.get(id2 - 1));
				                	myVertices.get(id2 - 1).addNeighbour(myVertices.get(id1 - 1));
				                	
				                } // else
			
			            } // else if
		            
		        } // for loop
	        
	    } // populateGraph

    
    /**
     * Method to print the Matrix representation of the graph
     * @param GraphGonzalezBonorino object
     */
    public void printMatrix(GraphGonzalezBonorino graph)
	    {
	        int[][] matrix = new int[graph.myVertices.size()][graph.myVertices.size()];
	
	        //iterate through rows of matrix
	        for(int i = 0; i <graph.myVertices.size(); i++)
	        {
	            //iterate through columns of matrix
	            for(int j = 0; j < graph.myVertices.size(); j++)
		            {
		                //iterate through neighbors list
		                for(int k = 0; k < graph.myVertices.get(i).getNeighbours().size(); k++)
			                {
			                    //if first node starts at 0...
			                    if(graph.myVertices.get(0).getId() == 0)
				                    {
				                        //we check neighbor id directly to j and if they are equal, set matrix[i][j] to 1
				                        if(graph.myVertices.get(i).getNeighbours().get(k).getId() == j)
					                        {
					                            matrix[i][j] = 1;
					                            break;
					                            
					                        } // if
				                        
				                    } // if
			                    
			                   
			                    else
				                    {
				                        //we check neighbor id to j + 1 because matrices start at 0 while our graph starts at 1
				                        if(graph.myVertices.get(i).getNeighbours().get(k).getId() == j + 1)
					                        {
					                            matrix[i][j] = 1;
					                            break;
					                            
					                        } // if
				                        
				                    } // else
			
			                    matrix[i][j] = 0;
			                    
			                } // third loop
		
		            } // second loop
	            
	        } // first loop
	        
	        //print out matrix
	        for(int i = 0; i < graph.myVertices.size(); i++)
		        {
		            for(int j = 0; j < graph.myVertices.size(); j++)
			            {
			                System.out.print(matrix[i][j] + " ");
			                
			            } // inner for loop
		            
		            System.out.println();
		            
		        } // outer for loop
	        
	    } // printMatrix

    /**
     * Method to print the Adjacency list representation of the graph
     * @param GraphGonzalezBonorino object
     */
    public void printAdjacencyList(GraphGonzalezBonorino graph)
	    {
	        //if first node starts at 1...
	        if(graph.myVertices.get(0).getId() == 1) 
		        {
		            //iterate through nodes
		            for (int i = 0; i < graph.myVertices.size(); i++) 
			            {
			                //print out i + 1 (since i is 0 but graph starts at  1) and print out the neighbors
			                System.out.print("[" + (i + 1) + "] ");
			                for (int j = 0; j < graph.myVertices.get(i).getNeighbours().size(); j++) 
				                {
				                    System.out.print(graph.myVertices.get(i).getNeighbours().get(j).getId() + " ");
				                    
				                } // inner for loop
			                
			                System.out.println();
			                
			            } // outer for loop
		            
		        } // if
	        
	        //else (graph starts at 0)
	        else
		        {
		            //same thing but we can print i directly
		            for (int i = 0; i < graph.myVertices.size(); i++) 
			            {
			                System.out.print("[" + i + "] ");
			                for (int j = 0; j < graph.myVertices.get(i).getNeighbours().size(); j++) 
				                {
				                    System.out.print(graph.myVertices.get(i).getNeighbours().get(j).getId() + " ");
				                    
				                } // inner for loop
			                
			                System.out.println();
			                
			            } // outer for loop
		            
		        } // else
	        
	    } // printAdjacencyList
    
    /**
     * Depth First Search traversal of a linked list implementation of the graph
     * @param vertex
     */
    public void depthFirstSearch(VertexGonzalezBonorino vertex)
	    {
	    	if (vertex.isProcessed() == false)
		    	{
		    		System.out.println("Vertex id: " + vertex.getId());
		    		vertex.process();
		    		
		    	} // if 
	    	
	    	for (int i = 0; i < vertex.getNeighbours().size(); i++)
		    	{
		    		if (vertex.getNeighbours().get(i).isProcessed() == false)
		    			depthFirstSearch(vertex.getNeighbours().get(i));
		    		
		    	} // for loop
	    	
	    } // depthFirstSearch
    
    /**
     * Breadth First Search traversal of a linked list implmentation of the graph with a Queue
     * @param vertex
     */
    public void breadthFirstSearch(VertexGonzalezBonorino vertex)
	    {
	    	QueueGonzalezBonorino queue = new QueueGonzalezBonorino();
	    	VertexGonzalezBonorino currVertex;
	    	
	    	queue.enqueue(vertex);
	    	
	    	vertex.process();
	    	
	    	while ( !(queue.isEmpty()) )
		    	{
		    		currVertex = queue.dequeue();
		    		System.out.println(currVertex.getId());
		    		
		    		for (int i = 0; i < currVertex.getNeighbours().size(); i++)
			    		{
			    			if ( currVertex.getNeighbours().get(i).isProcessed() == false )
				    			{
				    				queue.enqueue(currVertex.getNeighbours().get(i));
				    				currVertex.getNeighbours().get(i).process();
				    				
				    			} // if
			    				
			    		} // for loop
			    		
		    	} // while loop
	    	
	    } // breadthFirstSearch

} // GraphGonzalezBonorino
