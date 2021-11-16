import java.util.ArrayList;

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

	
	public int getNumVertices()
		{
			return numVertices;
			
		} // getNumVertices
	
	public void populateGraph(ArrayList<String> list)
	{

        //iterate through arrayList
        for(int i = 0; i < list.size(); i++)
        {
            //if line is empty or a comment, print it out
            if(list.get(i).equals("") || list.get(i).substring(0, 2).equals("--"))
            {
                System.out.println(list.get(i));
            }

            //if line wants us to add vertex...
            else if(list.get(i).contains("vertex"))
            {
                //take the last string, convert to an int and add a vertex with this id
                int id = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ") + 1));
                
                addVertex(id);

            }

            //if line wants us to add an edge...
            else if(list.get(i).contains("edge"))
            {
                //first id is first string after last instance of the letter 'e', until before the '-', convert to an int
                int id1 = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf("e") + 2,
                        list.get(i).indexOf("-") - 1));
                //second id is from instance of '-' till end of string, convert to int
                int id2 = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") + 2));

                //if the first node id is a 0, we take the id's as they are
                if(myVertices.get(0).getId() == 0)
                {
                	myVertices.get(id1).addEdge(myVertices.get(id2));
                	myVertices.get(id2).addEdge(myVertices.get(id1));
                }

                //if the first node is not a 0 (it will be 1), we need to subtract one
                // as ArrayLists start at 0 but our id is 1
                else 
                {
                	myVertices.get(id1 - 1).addEdge(myVertices.get(id2 - 1));
                	myVertices.get(id2 - 1).addEdge(myVertices.get(id1 - 1));
                }

            }
            
        } // for loop
        
    } // populateGraph

    //test function to print attributes of graph
    public void printGraph(GraphGonzalezBonorino graph)
    {

        for(int i = 0; i < graph.myVertices.size(); i++){
            System.out.println(graph.myVertices.get(i).getId());
            System.out.println(graph.myVertices.get(i).isProcessed());
            for(int j = 0; j < graph.myVertices.get(i).getNeighbours().size(); j++){
                System.out.print(graph.myVertices.get(i).getNeighbours().get(j).getId() + ", " );
            }
            System.out.println();
            System.out.println("********");
        }
    }

    public void printMatrix(GraphGonzalezBonorino graph){
        int[][] matrix = new int[graph.myVertices.size()][graph.myVertices.size()];

        //iterate through rows of matrix
        for(int i = 0; i <graph.myVertices.size(); i++){
            //iterate through columns of matrix
            for(int j = 0; j < graph.myVertices.size(); j++){
                //iterate through neighbors list
                for(int k = 0; k < graph.myVertices.get(i).getNeighbours().size(); k++){
                    //if first node starts at 0...
                    if(graph.myVertices.get(0).getId() == 0){
                        //we check neighbor id directly to j and if they are equal, set matrix[i][j] to 1
                        if(graph.myVertices.get(i).getNeighbours().get(k).getId() == j){
                            matrix[i][j] = 1;
                            break;
                        }
                    }
                    //else (first node will be 1)
                    else{
                        //we check neighbor id to j + 1 because matrices start at 0 while our graph starts at 1
                        if(graph.myVertices.get(i).getNeighbours().get(k).getId() == j + 1){
                            matrix[i][j] = 1;
                            break;
                        }
                    }

                    matrix[i][j] = 0;
                }

            }
        }
        //print out matrix
        for(int i = 0; i < graph.myVertices.size(); i++){
            for(int j = 0; j < graph.myVertices.size(); j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    
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
