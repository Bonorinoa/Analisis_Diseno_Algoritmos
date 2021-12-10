import java.io.*;
import java.util.*;

public class MainDirectedGraph 
{

	private static String GRAPH_NAME = "graphs2.txt";

    ArrayList<VertexGonzalezBonorino> nodes;
    
    public MainDirectedGraph()
    {
        nodes = new ArrayList<>();
    } // constructor

    //addVertex takes id as argument and adds it to the nodes
    public void addVertex(int id)
    {
    	VertexGonzalezBonorino newNode = new VertexGonzalezBonorino(id);
        nodes.add(newNode);

    } // addVertex

    public void populateGraph(ArrayList<String> list)
    {

		for(int i = 0; i < list.size(); i++)
	        {
			
	            if(list.get(i).equals("") || list.get(i).substring(0, 2).equals("--"))
		            {
		                //gets rid of results print out
		                if(list.get(i).contains("-->") || list.get(i).contains("Results") )
			                {
			                    continue;
			                } // if results
		                
		                else 
			                {
			                    System.out.println(list.get(i));
			                } // else 
		                
		            } // if blank or comment
	
	            else if(list.get(i).contains("vertex"))
		            {
		                //take the last string, convert to an int and add a vertex with this id
		                int id = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ") + 1));
		                addVertex(id);
		
		            } // else if contains vertex
	

	            else if(list.get(i).contains("edge"))
		            {
	            		EdgeGonzalezBonorino edge = new EdgeGonzalezBonorino();
	            	
		                // get from_VertexID
		                int from_VertexID = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") - 2, list.get(i).indexOf("-") - 1));
		
		                // get to_VertexID and weight of edge
		                edge.to_VertexID = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") + 2, list.get(i).indexOf("-") + 3));
		                edge.weight = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ") + 1));
		
		                // add edge. Recall 0-indexing
		                nodes.get(from_VertexID - 1).addEdge(edge);
		                
		            } // if line contains edge

	        } // for
		
    } // populateGraph


    public void printGraph(MainDirectedGraph graph)
    {

        for(int i = 0; i < graph.nodes.size(); i++)
	        {
	            System.out.println(graph.nodes.get(i).id);
	            System.out.println("Shortest path: " + graph.nodes.get(i).short_path);
	            
	            if(graph.nodes.get(i).prev_vertex != null)
		            {
		                System.out.println("Prev Vertex: " + graph.nodes.get(i).prev_vertex.id);
		                
		            } // if
	            
	            for(int j = 0; j < graph.nodes.get(i).neighbors.size(); j++)
		            {
		                System.out.print(graph.nodes.get(i).neighbors.get(j).to_VertexID + ": " +
		                        "with weight: " + graph.nodes.get(i).neighbors.get(j).weight + ", ");
		                
		            } // for
	            
	            System.out.println();
	            System.out.println("********");
	            
	        } // outer for
        
    } // printGraph

    public void Bellman_Ford(MainDirectedGraph graph)
    {
        // Initialize first node's short_path
        graph.nodes.get(0).short_path = 0;
        
        for(int k = 0; k < graph.nodes.size() - 1; k++) //do this |V| - 1 times
        {
   
            for(int i = 0; i < graph.nodes.size(); i++)
            {
            	
            	VertexGonzalezBonorino from_Vertex = graph.nodes.get(i);
            	
                for(int j = 0; j < graph.nodes.get(i).neighbors.size(); j++)
                {
                	
                	VertexGonzalezBonorino to_Vertex = graph.nodes.get(from_Vertex.neighbors.get(j).to_VertexID - 1);
                	
                    if(to_Vertex.short_path > from_Vertex.short_path + from_Vertex.neighbors.get(j).weight)
	                    {
	                        to_Vertex.short_path = from_Vertex.short_path + from_Vertex.neighbors.get(j).weight;

	                        to_Vertex.prev_vertex = from_Vertex;
	                        
	                    } // if
                    
                } // for all edges
                
            } // for all nodes
            
        } // first for loop

        // print paths
        for(int i = 1; i < graph.nodes.size(); i++)
        {
            System.out.print("1 --> " + graph.nodes.get(i).id);
            System.out.print(" cost is " + (int) graph.nodes.get(i).short_path + "; ");
            System.out.print("path is ");

            VertexGonzalezBonorino cur_Vertex = graph.nodes.get(i);

            ArrayList<VertexGonzalezBonorino> path = new ArrayList<>();
            
            //add current vertex to path
            path.add(cur_Vertex);
            
            while(cur_Vertex.prev_vertex != null)
	            {
	                // add previous vertex to path
	                path.add(cur_Vertex.prev_vertex);
	                
	                // set curr to prev
	                cur_Vertex = cur_Vertex.prev_vertex;
	                
	            } // while
            

            for(int j = path.size() - 1; j >= 0; j--)
	            {
	                //if the vertex is the vertex we are going to, just print it out
	                if(graph.nodes.get(i).id == path.get(j).id) 
		                {
		                    System.out.print(path.get(j).id);
		                    
		                } // if
	                
	                else
		                {
		                    System.out.print(path.get(j).id + " --> ");
		                    
		                } // else
	                
	            } // for all vertices
            
            System.out.println();
            
        } // outer for loop

    } // Bellman_Ford
	
    public static void main(String[] args) throws FileNotFoundException, IOException  
	{
		
		ArrayList<String> myGraphList = new ArrayList<String>();
		
		String tempStringG = null;

		
		String ans = "\nSome suggestions: \n"
				+ "\n* Check that the name of the file was typed correctly"
				+ "\n* Make sure that you are not missing any information in your item description in the file"
				+ "\n* Make sure you are not entering more or less items than specified";
		
		try 
			{
				BufferedReader inputG = new BufferedReader(new FileReader(GRAPH_NAME));
				
				while ( (tempStringG = inputG.readLine()) != null )
					{
						myGraphList.add(tempStringG);
						
					} // while
				
				/*
				 * Test code to check file was correctly read
				
				System.out.println(" ");
				System.out.println("***** GRAPH lIST *****");
				System.out.println(" ");
				
				
				for (int h=0; h < myGraphList.size(); h++)
					{
						System.out.println(myGraphList.get(h) + " ");
						
					} // for
				 */
				
				inputG.close();
				
			} // try
		
		catch(IndexOutOfBoundsException ex)
	    {
			System.out.println("Oops, something went wrong!");
			System.out.println("It seems that the program has reached an index out of bounds.");
			
	    } // catch index out of bound
		
		catch (NullPointerException ex2)
		{
			System.out.println("The program encountered a null value.");
			System.out.println(ans);
			
		} // catch null pointer
	      
		catch (IllegalArgumentException ex3)
		{
			System.out.println("An illegal argument has been given to the program.");
			System.out.println("\nSome suggestions: \n"
			+ "\n* Check that the name of the file was typed correctly"
			+ "\n* Make sure that you are not missing any information in your item description in the file");
			
		} // catch illegal argument
		
		catch (IOException ex4)
		{
			System.out.println("There seems to be an issue with the input given or with the file that you are trying to open.");
			System.out.println(ans);
			
		} // catch IOException
		
		catch (NoSuchElementException ex5)
		{
			System.out.println("\nAn element was not found.");
			System.out.println("Make sure you are not inputting less items than specified in the first line of the text file,\n"
					+ "or that the name of the item inputted does not contain a whitespace. \nWe apologize for the inconvenience, we are constantly working to improve our systems.");
			
		} // catch no such element

		System.out.println(" ");
		System.out.println("**** GRAPH 1 ****");
		System.out.println(" ");
		
		ArrayList<String> commands1 = new ArrayList<>();

        for(int i = 0; i < myGraphList.indexOf(""); i++)
        {
        	commands1.add(myGraphList.get(i));
        	
        } // for

        MainDirectedGraph graph1 = new MainDirectedGraph();
        
        graph1.populateGraph(commands1);
        graph1.Bellman_Ford(graph1);

        int start = 0;
        int end = 0;
        int breaks = 0;

        for(int j = 0; j < myGraphList.size(); j++)
	        {
	
	            //if line is blank, increment breaks
	            if(myGraphList.get(j).equals(""))
		            {
		                breaks++;
		            } // if

	            if(breaks == 1)
		            {
		                breaks++;
		                start = j + 1;
		            } // if
	            
	            if(breaks == 3)
		            {
		                end = j;
		                break;
		            } //if
	            
	        } // for 
        


		System.out.println(" ");
		System.out.println("**** GRAPH 2 ****");
		System.out.println(" ");
		
        //create new ArrayList from start to end
        ArrayList<String> commands2 = new ArrayList<String> (myGraphList.subList(start, end));

        //create second graph, run Bellman_Ford
        MainDirectedGraph graph2 = new MainDirectedGraph();
        graph2.populateGraph(commands2);
        graph2.Bellman_Ford(graph2);

        start = 0;
        end = 0;
        breaks = 0;
        //same as before but getting 3rd graph
        for(int j = 0; j < myGraphList.size(); j++)
        {


            if(myGraphList.get(j).equals(""))
	            {
	                breaks++;
	            } // if

            if(breaks == 2)
	            {
	                breaks++;
	                start = j + 1;
	            } //if

            if(breaks == 4)
	            {
	                end = j;
	                break;
	            } // if
        } // for
        

		System.out.println(" ");
		System.out.println("**** GRAPH 3 ****");
		System.out.println(" ");
		
        //create new ArrayList from start to end
        ArrayList<String> commands3 = new ArrayList<String> (myGraphList.subList(start, end));

        //create third graph, Bellman_Ford
        MainDirectedGraph graph3 = new MainDirectedGraph();
        graph3.populateGraph(commands3);
        graph3.Bellman_Ford(graph3);

        start = 0;
        end = myGraphList.size();
        breaks = 0;
        
        for(int j = 0; j < myGraphList.size(); j++)
	        {
	
	            if(myGraphList.get(j).equals(""))
		            {
		                breaks++;
		            } //if
	            
	            if(breaks == 3)
		            {
		                breaks++;
		                start = j + 1;
		            } // if
	        }// for


		System.out.println(" ");
		System.out.println("**** GRAPH 4 ****");
		System.out.println(" ");
		
        ArrayList<String> commands4 = new ArrayList<String> (myGraphList.subList(start, end));

        MainDirectedGraph graph4 = new MainDirectedGraph();
        graph4.populateGraph(commands4);
        graph4.Bellman_Ford(graph4);

    } // main
}