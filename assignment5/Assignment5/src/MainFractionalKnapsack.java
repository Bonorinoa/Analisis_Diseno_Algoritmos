import java.util.*;
import java.io.*;

public class MainFractionalKnapsack 
{
	
	private static String SPICE_NAME = "spice.txt";

	public static void main(String[] args) throws FileNotFoundException, IOException 
		{
			
			ArrayList<SpiceGonzalezBonorino> spices =  createSpices();
	        greedyKnapsack(spices);
			
		} // main
	
	public static ArrayList<SpiceGonzalezBonorino> createSpices()
		{
	
			ArrayList<String> mySpiceList = new ArrayList<String>();
			
			String tempSpiceString = null;
			
			String ans = "\nSome suggestions: \n"
					+ "\n* Check that the name of the file was typed correctly"
					+ "\n* Make sure that you are not missing any information in your item description in the file"
					+ "\n* Make sure you are not entering more or less items than specified";
			
			
			try 
			{
				BufferedReader inputSpice = new BufferedReader(new FileReader(SPICE_NAME));
	
		        while ((tempSpiceString = inputSpice.readLine()) != null) 
		        {
		        	mySpiceList.add(tempSpiceString);
		        	
		        } // while
		        
		        inputSpice.close();
		        
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
	  
	
	        // create ArrayList of spices
	        ArrayList<SpiceGonzalezBonorino> spices = new ArrayList<>();

	        for(int i = 0; i < mySpiceList.size(); i++)
		        {
		
		            if(mySpiceList.get(i).equals("") || mySpiceList.get(i).substring(0, 2).equals("--"))
			            {
			                continue;
			            } // if blank line or comment
		
		            else if(mySpiceList.get(i).contains("spice"))
			            {
			                String line = mySpiceList.get(i);
			
			                // get myColor
			                String myColor = line.substring(line.indexOf("=") + 2, line.indexOf(";"));
			                SpiceGonzalezBonorino spice = new SpiceGonzalezBonorino(myColor);
			
			                // get total price
			                double myTotalPrice = Double.parseDouble( line.substring(line.lastIndexOf(" ", 39) + 1, line.indexOf(';', 20)) );
			                spice.myTotalPrice = myTotalPrice;
			
			                // get myQuant
			                int qty = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1, line.lastIndexOf(';')));
			                spice.myQuant = qty;
			
			                // compute price per unit
			                double myUnitPrice = myTotalPrice / qty;
			                spice.myUnitPrice = myUnitPrice;
			
			                //add new spice object to list of spices
			                spices.add(spice);
			
			            } // else if we must add spice
		            
		        } // for 
	
	        return spices;
	        
	    } // createSpices

    public static void greedyKnapsack(ArrayList<SpiceGonzalezBonorino> spices)
    {
    	
		ArrayList<String> myKnapsackCommands = new ArrayList<String>();
    	
    	String tempKnapsackString = null;
		
		String ans = "\nSome suggestions: \n"
				+ "\n* Check that the name of the file was typed correctly"
				+ "\n* Make sure that you are not missing any information in your item description in the file"
				+ "\n* Make sure you are not entering more or less items than specified";
		
		try 
		{
			BufferedReader inputKnapsack = new BufferedReader(new FileReader(SPICE_NAME));

	        while ((tempKnapsackString = inputKnapsack.readLine()) != null) 
	        {
	        	myKnapsackCommands.add(tempKnapsackString);
	        	
	        } // while
	        
	        inputKnapsack.close();
	        
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

        // List with knapsacks commands
        ArrayList<String> myKnapsacksList = new ArrayList<String>(myKnapsackCommands.subList(9, myKnapsackCommands.size()));

        //sort spices by myUnitPrice descending
        selectionSort(spices);

        //create an ArrayList that hold the beginning quantities of all spices
        ArrayList<Integer> prev_quantities = new ArrayList<>();
        
        for(int i = 0; i < spices.size(); i++)
	        {
	            prev_quantities.add(spices.get(i).myQuant);
	            
	        } // for


        for(int i = 0; i < myKnapsacksList.size(); i++)
        {

            int capacity = Integer.parseInt(myKnapsacksList.get(i).substring(myKnapsacksList.get(i).lastIndexOf(" ") + 1, myKnapsacksList.get(i).indexOf(";")));

            int holding = 0;

            double worth = 0.0;


            for(int j = 0; j < spices.size(); j++)
	            {
	                while(spices.get(j).myQuant > 0 & holding < capacity)
		                {
		                    //add the unit price of the spice to the knapsack worth
		                    worth = worth + spices.get(j).myUnitPrice;
		                    
		                    // update qty
		                    spices.get(j).myQuant = spices.get(j).myQuant - 1;
		                    
		                    // update num of spices in knapsack
		                    holding = holding + 1;
		                    
		                } // while spice qty > 0 and knapsack not full
	                
	            } // for each spice
            
            System.out.print("Knapsack of capacity " + capacity + " is worth " + worth + " quatloos and contains ");


            for(int k = 0; k < spices.size(); k++)
            {

                if(spices.get(k).myQuant != prev_quantities.get(k))
	                {
	                    //print the difference in myQuant
	                    System.out.print(prev_quantities.get(k) - spices.get(k).myQuant);
	                    
	                    //print myColor
	                    System.out.print(" scoop(s) of " + spices.get(k).myColor + ", ");
	                    
	                } // if qty changed
                
            } // for each spice


            for(int x = 0; x < spices.size(); x++)
	            {
	                spices.get(x).myQuant = prev_quantities.get(x);
	                
	            } // reset each spice's qty
            
            System.out.println();
            
        } // for each knapsack

    } // greedyKnapsack


    public static void selectionSort(ArrayList<SpiceGonzalezBonorino> spices) 
    {

    	int len = spices.size();
    	
        for (int i = 0; i < len - 1; i++) 
        {
            int smallPos = i;
            
            for (int j = i + 1; j < len; j++) 
            {
                if (spices.get(j).myUnitPrice > spices.get(smallPos).myUnitPrice) 
                {
                	smallPos = j;
                    
                } // if
                
            } // for
            
            SpiceGonzalezBonorino temp = spices.get(i);
            spices.set(i, spices.get(smallPos));
            spices.set(smallPos, temp);
            
        } // for
        

    } // selection
 

} // MainFractionalKnapsack
