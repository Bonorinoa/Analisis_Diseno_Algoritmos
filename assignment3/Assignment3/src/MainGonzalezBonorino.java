import java.util.*;
import java.io.*;

/**
 * 
 * @author Augusto Gonzalez Bonorino <br>
 * 
 * assignment1GonzalezBonorino <br>
 * Due Date and Time: 09/24/21 <br><br>
 *
 * Purpose: Develop program that leverages a singly linked list, stacks and queues to find palindromes. <br><br>
 *			
 * Input: A text file containing the words or sentences to check for palindromes.
 * 		  
 * Output: The program prints out those words or sentences that were indeed palindromes.<br><br>
 *		   
 *
 * Certification of Authenticity: <br>
 * 
 * I certify that this assignment is entirely my own work. <br>
 */
public class MainGonzalezBonorino {
	
	static Scanner keyboard = new Scanner(System.in);
	
	private static final String FILE_NAME = "magicitems.txt";
	private static final int FILE_LEN = 666;
	
	static int linearSearchComparisons = 0;
	static int binarySearchComparisons = 0;
    static int avgHashComps = 0;

	
	public static void main(String[] args) {
		
		File theMagicFile = null;
		QuickSortGonzalezBonorino sort = new QuickSortGonzalezBonorino();
		
		String tempString = null;

		String [] myMagicList = new String[FILE_LEN];
		
		int numItems = 0;
		
		String ans = "\nSome suggestions: \n"
				+ "\n* Check that the name of the file was typed correctly"
				+ "\n* Make sure that you are not missing any information in your item description in the file"
				+ "\n* Make sure you are not entering more or less items than specified";
		
		try
		{
			
			theMagicFile = new File(FILE_NAME);
			
			Scanner input = new Scanner(theMagicFile);
			
			while(input.hasNextLine()) {
				
				tempString = input.nextLine();
				myMagicList[numItems] = tempString;
				
				numItems++;
				
			} //while 
			
			input.close();
			
		} //try
		
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
		
		// Quick Sort
		
		System.out.println(sort.quickSort(myMagicList, 0, myMagicList.length - 1));
		
		// Select 42 random items for sorted myMagicList
		// Add random items to temporary array of strings
		
		Random rand = new Random();
		String [] tempMagicList = new String[42];
		
		// loop to generate 42 random numbers to randomly index myMagicList
		
		for (int i = 0; i < tempMagicList.length; i++)
		{ 
			
			int idx = rand.nextInt(FILE_LEN);
			
			tempString = myMagicList[idx];
			
			tempMagicList[i] = tempString;
			
			
		} // for loop
		
		// double check that elements in tempMagicList are random
		
		for (int j = 0; j < tempMagicList.length; j++)
		{
			System.out.println(tempMagicList[j]);
			
		} // for loop
		
		// Linear Search
		
		//LinearSearchGonzalezBonorino linearSearch = new LinearSearchGonzalezBonorino();
		
		// use linear search to look for each of the 42 random items and print comparisons
		

		int avgComparisonsLS = 0;
		
		System.out.println("LINEAR SEARCH");
		System.out.println("*********************************************");
		System.out.println(" ");
		
		for (int k = 0; k < tempMagicList.length; k++)
		{
			
			System.out.println("Comparisons made with linear search to find element "+ tempMagicList[k] + ": " + linearSearch(myMagicList, tempMagicList[k]));
			
			avgComparisonsLS += linearSearch(myMagicList, tempMagicList[k]);
			
			
		} // for loop
		
		// Compute and print average number of comparisons for LS
		
		avgComparisonsLS /= tempMagicList.length;
		
		System.out.println(" ");
		
		System.out.println("Average Comparisons for Linear Search: " + avgComparisonsLS);
		
		System.out.println(" ");
		
		
		
		// Binary Search
		
		//BinarySearchGonzalezBonorino binarySearch = new BinarySearchGonzalezBonorino();
		
		// use binary search to look for each of the 42 random items and print comparisons
		
		int avgComparisonsBS = 0;
		
		System.out.println("BINARY SEARCH");
		System.out.println("****************************************************");
		System.out.println(" ");
		
		for (int k = 0; k < tempMagicList.length; k++)
		{
			// System.out.println("Search string: " + tempMagicList[k] + ", found at index: " + binarySearch(myMagicList, 0, tempMagicList.length - 1, tempMagicList[k]));
			
			System.out.println("Comparisons made with binary search to find element "+ tempMagicList[k] + ": " + binarySearch(myMagicList, tempMagicList[k]));
			
			avgComparisonsBS += binarySearch(myMagicList, tempMagicList[k]);
			
			
		} // for loop
		
		// Compute and print average number of comparisons for BS
		
		avgComparisonsBS /= tempMagicList.length;
	
		System.out.println(" ");
		
		System.out.println("Average Comparisons for Binary Search: " + avgComparisonsBS);
		
		System.out.println(" ");
		

		// Hashing
		
        System.out.println("HASH TABLE");
        System.out.println("*************************************************");
        System.out.println(" ");
		
        
        
        HashTableGonzalezBonorino hash = new HashTableGonzalezBonorino();
       
     
        
        for (int h = 0; h < myMagicList.length; h++)
        {
        	hash.put(myMagicList[h], myMagicList[h]);
        }
        
        for (int a = 0; a < tempMagicList.length; a++)
        {
        	int localComps = 0;
        	int globalComps = 0;
        	
        	System.out.println("Looking for: " + hash.get(tempMagicList[a]));
        	System.out.println("Hash comparisons: " + hash.getObjComps(tempMagicList[a]));
        	
        	globalComps = hash.getObjComps(tempMagicList[a]);
        	
        	localComps = globalComps + 1; 
        	
        	avgHashComps += localComps;
        	System.out.println("total comps: " + avgHashComps);
        	System.out.println();
        }
        
        System.out.println("Overall Average Comparisons for Hash Table: " + avgHashComps / tempMagicList.length);


	
	} // main
	

public static int linearSearch(String[] arr, String key){ 
	
	int idx = 0;
	
	for(int i=0;i<arr.length;i++)
	{
		linearSearchComparisons++;
        if(arr[i].compareToIgnoreCase(key) == 0)
        {    
            return i;    
        }    
    }    
    return linearSearchComparisons;
    
} // linearSearch


public static int binarySearch(String[] arr, String key)
{
    int start = 0;
    int mid = 0;
    int stop = arr.length - 1;
    int pos = 0;
    int idx = -1;;
    int comps = 0;
    
    while (start <= stop && idx == -1)
    {
    	binarySearchComparisons++;
    	
    	comps++;
    	
    	mid = start + (stop - start) / 2;
    	
    	pos = key.compareToIgnoreCase(arr[mid]);
    	
    	if (pos == 0)
    		idx = mid;
    	
    	if (pos > 0)
    		start = mid + 1;
    	
    	else
    		
    		stop = mid - 1;
    	
    } // while
	
	
    return comps;
}

	
} // MainGonzalezBonorino

	