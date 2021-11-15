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
		
		File theMagicFile = null;
		File theGraphFile = null;

		String [] myMagicList = new String[MAGIC_LENGTH];
		String [] myGraphList = new String[GRAPH_LENGTH];
		
		String tempString = null;
		int numItems = 0;
		
		String ans = "\nSome suggestions: \n"
				+ "\n* Check that the name of the file was typed correctly"
				+ "\n* Make sure that you are not missing any information in your item description in the file"
				+ "\n* Make sure you are not entering more or less items than specified";
		
		try
			{
				
				theGraphFile = new File(GRAPH_NAME);
				
				Scanner inputG = new Scanner(theGraphFile);
				
				while (inputG.hasNextLine())
					{
						
						tempString = inputG.nextLine();
						
						//System.out.println("String: " + tempString);
						
						if (tempString.charAt(0) != '-')
							{
								
								myGraphList[numItems] = tempString;
								
								numItems++;
								
							} // if string is not a comment
						
					} // while
				
				numItems = 0;
				
				theMagicFile = new File(MAGIC_NAME);
				
				Scanner input = new Scanner(theMagicFile);
				
				while(input.hasNextLine()) {
					
					tempString = input.nextLine();
					myMagicList[numItems] = tempString;
					
					numItems++;
					
				} //while
				
				System.out.println("***** MAGIC lIST *****");
				System.out.println(" ");
				
				for (int j = 0; j < myMagicList.length; j++)
				{
					System.out.println(myMagicList[j]);
					
				}
				
				System.out.println(" ");
				System.out.println("***** GRAPH lIST *****");
				System.out.println(" ");
				
				// loop to check the strings are loaded correctly
				for (int i=0; i < myGraphList.length; i++)
				{
					System.out.println(myGraphList[i]);
				}
				
				input.close();
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
		
		ArrayList<GraphGonzalezBonorino> listOfGraphs = new ArrayList<>();
		
		
		// I have the commands from myGraphList, now use them to create graphs
		
		for (int j = 0; j < myGraphList.length; j++)
			{
				
			if (myGraphList[j].contains("new graph"))
				{
					
					GraphGonzalezBonorino graph = new GraphGonzalezBonorino();
				
					listOfGraphs.add(graph);
					
				} // if new graph
			
			else if (myGraphList[j].contains("add vertex"))
				{
					VertexGonzalezBonorino vertex = new VertexGonzalezBonorino();
					
					if (myGraphList[j].length() == 11)
						{
							int vertexId = myGraphList[j].charAt(11);
							listOfGraphs.get(j).addVertex(vertex, vertexId);
							
						} // if id is one digit
						
						
					} // if new vertex
				
				
			} // for loop
		
		System.out.println("TEST");
		
		for (int h = 0; h < listOfGraphs.get(0).getNumVertices(); h++)
		{
			System.out.println(listOfGraphs.get(0).myVertices.toString());
			
		}	
		
		
	} // main

} // MainGonzalezBonorino
