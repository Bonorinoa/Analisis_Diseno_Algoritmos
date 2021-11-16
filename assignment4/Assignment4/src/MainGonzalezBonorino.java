import java.util.*;
import java.io.*;
/**
 * 
 * @author Augusto Gonzalez Bonorino <br>
 * 
 * Assignment4GonzalezBonorino <br>
 * Due Date and Time: 11/19/21 <br><br>
 *
 * Purpose: Implement graph and tree data structures, and to understand the performance of their traversals <br><br>
 *			
 * Input: A text file containing data describing multiple undirected graphs and another one containing the Strings to populate BST.
 * 		  
 * Output: Matrix and Adjacency list version of undirected graphs, plus number of comparisons per lookup. <br><br>
 *		   
 *
 * Certification of Authenticity: <br>
 * 
 * I certify that this assignment is entirely my own work. <br>
 */
public class MainGonzalezBonorino {

	
	static Scanner keyboard = new Scanner(System.in);
	
	private static final int MAGIC_LENGTH = 666;
	private static final int GRAPH_LENGTH = 366;
	
	private static String MAGIC_NAME = "magicitems.txt";
	private static String GRAPH_NAME = "graphs1.txt";
	
	public static void main(String[] args) {
		
		

		ArrayList<String> myMagicList = new ArrayList<String>();
		ArrayList<String> myGraphList = new ArrayList<String>();
		
		String tempStringG = null;
		String tempMagicString = null;

		
		String ans = "\nSome suggestions: \n"
				+ "\n* Check that the name of the file was typed correctly"
				+ "\n* Make sure that you are not missing any information in your item description in the file"
				+ "\n* Make sure you are not entering more or less items than specified";
		
		try
			{
				
				BufferedReader inputG = new BufferedReader(new FileReader("graphs1.txt"));
				
				while ( (tempStringG = inputG.readLine()) != null )
					{
						myGraphList.add(tempStringG);
						
					} // while
				
				BufferedReader inputMagic = new BufferedReader(new FileReader("magicitems.txt"));
				
				while( (tempMagicString = inputMagic.readLine()) != null) 
					{
						myMagicList.add(tempMagicString);
						
					} //while
				
				// check files were properly read
				
				System.out.println("***** MAGIC lIST *****");
				System.out.println(" ");
				

				for (int h=0; h < myMagicList.size(); h++)
					{
						System.out.println(myMagicList.get(h) + " ");
					}	
			
				
				System.out.println(" ");
				System.out.println("***** GRAPH lIST *****");
				System.out.println(" ");
				
				
				for (int h=0; h < myGraphList.size(); h++)
					{
						System.out.println(myGraphList.get(h) + " ");
					}
				
				
				inputMagic.close();
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
		
		// I have the commands from myGraphList, now use them to create graphs
		
		/*
		ArrayList<List<String>> commands = new ArrayList<List<String>>();	
        
		ArrayList<String> tempCommands = new ArrayList<>();

        int i = 0;
        
        while ( i < myGraphList.size() ) 
        {
        	
        	if (myGraphList.get(i) != "")
        		tempCommands.add(myGraphList.get(i));
        		
        	i++;
        	
        } // while

        //System.out.println(commands1);
        System.out.println(tempCommands);

		*/
        System.out.println(" ");
		System.out.println("**** GRAPH 1 ****");
		System.out.println(" ");
		
		ArrayList<String> commands1 = new ArrayList<>();

        // take lines from file up until first blank line
        for(int i = 0; i < myGraphList.indexOf(""); i++){
        	commands1.add(myGraphList.get(i));
        }

        // create first graph
        
        GraphGonzalezBonorino graph1 = new GraphGonzalezBonorino();
        graph1.populateGraph(commands1);
        
        System.out.println(" ");
        System.out.println("**** Matrix form ****");
        //graph1.printGraph(graph1);
        graph1.printMatrix(graph1);
       
        System.out.println(" ");
        System.out.println("**** Adjancency List ****");
        graph1.printAdjacencyList(graph1);
    
        System.out.println(" ");
        System.out.println("**** Depth First Search ****");
        graph1.depthFirstSearch(graph1.myVertices.get(0));
        
        // vertices have been process with DFS so we need to set them all to false again
        
        for(int i = 0; i < graph1.myVertices.size(); i++)
        {
            graph1.myVertices.get(i).unprocess();
            
        } // for loop
        
        
        System.out.println(" ");
        System.out.println("**** Breadth First Search ****");
        graph1.breadthFirstSearch(graph1.myVertices.get(0));
        
        
		// create second graph
        System.out.println(" ");
		System.out.println("**** GRAPH 2 ****");
		System.out.println(" ");
        
        int start = 0;
        int end = 0;
        int breaks = 0;
        
        //iterate through file
        for(int j = 0; j < myGraphList.size(); j++)
	        {
	
	            //if line is blank, increment breaks
	            if(myGraphList.get(j).equals(""))
		            {
		                breaks++;
		                
		            } // if
	            
	            //if breaks is 1, set starting pos to 1 after blank line and increment breaks once more to avoid
	            //meeting this if condition again
	            if(breaks == 1)
		            {
		                breaks++;
		                start = j + 1;
		                
		            } // if 1 break
	            
	            // if breaks is 3, set end to that line
	            if(breaks == 3)
		            {
		                end = j;
		                break;
		                
		            } // if 3 breaks
	            
	        } // for loop
        
        //create new ArrayList from start to end
        ArrayList<String> commands2 = new ArrayList<String> (myGraphList.subList(start, end));
		
        GraphGonzalezBonorino graph2 = new GraphGonzalezBonorino();
        graph2.populateGraph(commands2);
        
        System.out.println(" ");
        System.out.println("**** Matrix form ****");
        graph2.printMatrix(graph2);
       
        System.out.println(" ");
        System.out.println("**** Adjancency List ****");
        graph2.printAdjacencyList(graph2);
        
        System.out.println(" ");
        System.out.println("**** Depth First Search ****");
        graph2.depthFirstSearch(graph2.myVertices.get(0));
        
        // vertices have been process with DFS so we need to set them all to false again
        
        for(int i = 0; i < graph2.myVertices.size(); i++)
        {
            graph2.myVertices.get(i).unprocess();
            
        } // for loop
        
        System.out.println(" ");
        System.out.println("**** Breadth First Search ****");
        graph2.breadthFirstSearch(graph2.myVertices.get(0));
		
        // third graph
        System.out.println(" ");
		System.out.println("**** GRAPH 3 ****");
		System.out.println(" ");
        
        
        start = 0;
        end = 0;
        breaks = 0;
        //same as prev, but break conditions increased by one to get the sublist of next graph
        for(int j = 0; j < myGraphList.size(); j++)
        {

            if(myGraphList.get(j).equals(""))
            {
                breaks++;
            }
            if(breaks == 2)
            {
                breaks++;
                start = j + 1;
            }
            if(breaks == 4)
            {
                end = j;
                break;
            }
        }
        
        ArrayList<String> commands3 = new ArrayList<String> (myGraphList.subList(start, end));
        
        GraphGonzalezBonorino graph3 = new GraphGonzalezBonorino();
        graph3.populateGraph(commands3);
        
        System.out.println(" ");
        System.out.println("**** Matrix form ****");
        //graph1.printGraph(graph1);
        graph3.printMatrix(graph3);
       
        System.out.println(" ");
        System.out.println("**** Adjancency List ****");
        graph3.printAdjacencyList(graph3);
        
        System.out.println(" ");
        System.out.println("**** Depth First Search ****");
        graph3.depthFirstSearch(graph3.myVertices.get(0));
        
        // vertices have been process with DFS so we need to set them all to false again
        
        for(int i = 0; i < graph3.myVertices.size(); i++)
        {
            graph3.myVertices.get(i).unprocess();
            
        } // for loop
        
        System.out.println(" ");
        System.out.println("**** Breadth First Search ****");
        graph3.breadthFirstSearch(graph3.myVertices.get(0));
        
        
        // fourth graph
        System.out.println(" ");
		System.out.println("**** GRAPH 4 ****");
		System.out.println(" ");
        
        start = 0;
        end = 0;
        breaks = 0;
        //same as prev, but break conditions increased by one to get the sublist of next graph
        for(int j = 0; j < myGraphList.size(); j++)
        {

            if(myGraphList.get(j).equals(""))
            {
                breaks++;
            }
            if(breaks == 3)
            {
                breaks++;
                start = j + 1;
            }
            if(breaks == 5)
            {
                end = j;
                break;
            }
        }
        
        ArrayList<String> commands4 = new ArrayList<String> (myGraphList.subList(start, end));
        
        GraphGonzalezBonorino graph4 = new GraphGonzalezBonorino();
        graph4.populateGraph(commands4);
        
        System.out.println(" ");
        System.out.println("**** Matrix form ****");
        //graph1.printGraph(graph1);
        graph4.printMatrix(graph4);
       
        System.out.println(" ");
        System.out.println("**** Adjancency List ****");
        graph4.printAdjacencyList(graph4);
        
        System.out.println(" ");
        System.out.println("**** Depth First Search ****");
        graph4.depthFirstSearch(graph4.myVertices.get(0));
        
        // vertices have been process with DFS so we need to set them all to false again
        
        for(int i = 0; i < graph4.myVertices.size(); i++)
        {
            graph4.myVertices.get(i).unprocess();
            
        } // for loop
        
        System.out.println(" ");
        System.out.println("**** Breadth First Search ****");
        graph4.breadthFirstSearch(graph4.myVertices.get(0));
        
        // fifth graph
        System.out.println(" ");
		System.out.println("**** GRAPH 5 ****");
		System.out.println(" ");
        
        start = 0;
        end = myGraphList.size();
        breaks = 0;
        //get next graph
        for(int j = 0; j < myGraphList.size(); j++)
        {

            if(myGraphList.get(j).equals(""))
            {
                breaks++;
            }
            
            if(breaks == 4)
            {
                breaks++;
                start = j + 1;
            }

        }
        
        
        ArrayList<String> commands5 = new ArrayList<String> (myGraphList.subList(start, end));
        
        GraphGonzalezBonorino graph5 = new GraphGonzalezBonorino();
        graph5.populateGraph(commands5);
        
        System.out.println(" ");
        System.out.println("**** Matrix form ****");
        //graph1.printGraph(graph1);
        graph5.printMatrix(graph5);
       
        System.out.println(" ");
        System.out.println("**** Adjancency List ****");
        graph5.printAdjacencyList(graph5);
        
        System.out.println(" ");
        System.out.println("**** Depth First Search ****");
        graph5.depthFirstSearch(graph5.myVertices.get(0));
        
        // vertices have been process with DFS so we need to set them all to false again
        
        for(int i = 0; i < graph5.myVertices.size(); i++)
        {
            graph5.myVertices.get(i).unprocess();
            
        } // for loop

        System.out.println(" ");
        System.out.println("**** Breadth First Search ****");
        graph5.breadthFirstSearch(graph5.myVertices.get(0));
        
	} // main

} // MainGonzalezBonorino
