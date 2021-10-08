import java.util.*;
import java.io.*;
/**
 * 
 * @author Augusto Gonzalez Bonorino <br>
 * 
 * assignment2GonzalezBonorino <br>
 * Due Date and Time: 10/08/21 <br><br>
 *
 * Purpose: Test out various sorting algorithms on a given text document. <br><br>
 *			
 * Input: A text file containing the words or sentences to sort.
 * 		  
 * Output: <br><br>
 *		   
 *
 * Certification of Authenticity: <br>
 * 
 * I certify that this assignment is entirely my own work. <br>
 */
public class mainGonzalezBonorino {
	
	static Scanner keyboard = new Scanner(System.in);
	public static int quickSortComparisons = 0;
	
	public static void main(String[] args) {
		
		File theMagicFile = null;
		
		String fileName = "magicitems.txt";
		String tempString = null;
		final int FLENGTH = 666;
		
		String [] myMagicList = new String[FLENGTH];
		int numItems = 0;
		
		String ans = "\nSome suggestions: \n"
				+ "\n* Check that the name of the file was typed correctly"
				+ "\n* Make sure that you are not missing any information in your item description in the file"
				+ "\n* Make sure you are not entering more or less items than specified";
		
		try
		{
			
			theMagicFile = new File(fileName);
			
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
		
		// shuffle myMagicList
		//knuthShuffle(myMagicList);
		
		// Selection sort
		
		System.out.println(selectionSort(myMagicList));

		
		// shuffle myMagicList
		//knuthShuffle(myMagicList);

		
		// Insertion sort

		System.out.println(insertionSort(myMagicList));
		
		
		// shuffle myMagicList
		//knuthShuffle(myMagicList);
		
		// Merge Sort
		
		System.out.println(mergeSort(myMagicList, 0));
		
		// shuffle myMagicList
		//knuthShuffle(myMagicList);
		
		// Quick Sort
		
		System.out.println(quickSort(myMagicList, 0, myMagicList.length - 1));
		

	} // main
	
	public static int selectionSort(String[] magicList) {
		
		knuthShuffle(magicList);
		int len = magicList.length;
		int numComparisons = 0;
		
		for (int i = 0; i < len - 1; i++) {
			
			int smallPos = i;
			
			for (int j = i + 1; j <= len - 1; j++) {
				
				if (magicList[j].compareToIgnoreCase(magicList[smallPos]) < 0 ) //compare strings
				{	
					smallPos = j;
				}
				numComparisons++;
						
			} // inner for loop
			
			// swap
			String temp = magicList[smallPos];
			magicList[smallPos] = magicList[i];
			magicList[i] = temp;
			
		} // outer for loop
		
		return numComparisons;
		
	} // selectionSort
	
	
	public static int insertionSort(String[] magicList) {
		
		knuthShuffle(magicList);
		int len = magicList.length;
		int numComparisons = 0;
		
		for (int j = 1; j <= len - 2; j++) {
			
			String key = magicList[j];
			int i = j - 1;
			
			while ( (i >= 0) && ( magicList[i].compareToIgnoreCase(key) > 0) ) {
				
				magicList[i + 1] = magicList[i];
				i = i - 1;
				
				numComparisons++;
				
			} // while loop
			
			magicList[i + 1] = key;
			
		} // for loop
		
		return numComparisons;
		
	} // insertionSort
	
	public static void knuthShuffle(String[] listToShuffle) {
		
		for (int i = 0; i < listToShuffle.length; i++) {
		
			// generate random index
			int idx = (int) (Math.random() * (i + 1));
			
			// swap
			String temp = listToShuffle[idx];
			listToShuffle[idx] = listToShuffle[i];
			listToShuffle[i] = temp;
			
		} // for loop

		
	} // Knuth shuffle
	
	public static int mergeSort(String[] magicList, int comparisons) {

		
		int len = magicList.length;

		if (len < 2)
			return comparisons;
		
		// Array's midpoint
		int midPoint = len / 2;
		
		// Left and right sub-arrays
		String[] left = new String[midPoint];
		String[] right = new String[len - midPoint];
		
		// Populate sub-arrays
		for (int i = 0; i < midPoint; i++)
			left[i] = magicList[i];
		
		for (int j = midPoint; j < len; j++)
			right[j - midPoint] = magicList[j];
		
		// Recursive call to keep dividing sub-arrays
		comparisons = mergeSort(left, comparisons);
		comparisons = mergeSort(right, comparisons);
		comparisons = merge(left, right, magicList, comparisons);
		
		return comparisons;
		
	}
	
	public static int merge(String[] left, String[] right, String[] magicList, int comparisons) {
		
		// merge sub-arrays back together
		int i = 0;
		int j = 0;
		int k = 0;
 		
		knuthShuffle(magicList);
		while (i < left.length && j < right.length) {
			
			comparisons++;
			
			if (left[i].compareToIgnoreCase(right[j]) < 0 ) {
				
				magicList[k] = left[i];
				i++;
				
			} // if statement
			
			else {
				
				magicList[k] = right[j];
				j++;
				
			} // else statement
			
			k++; 
			
		} // while loop
		
		
		while (i < left.length) {
			
			magicList[k] = left[i];
			i++;
			k++;
			
		} // while loop
		
		while (j < right.length) {
			
			magicList[k] = right[j];
			j++;
			k++;
			
		} // while loop
		
		return comparisons;
		
	} // mergeSort
	

	public static int quickSort(String[] magicList, int lowIndex, int highIndex) {
		
		knuthShuffle(magicList);
		if (lowIndex < highIndex) {
			
			int partIndex = partition(magicList, lowIndex, highIndex);
			
			quickSort(magicList, lowIndex, partIndex - 1);
			quickSort(magicList, partIndex + 1, highIndex);
			
		} // if statement

		return quickSortComparisons;
	} // Quick Sort
	
	
	public static int partition(String[] magicList, int lowIndex, int highIndex) {
		
		
		// Take the last element as the pivot value
		String pivot = magicList[highIndex];
		int idx = lowIndex - 1;
		
		for (int j = lowIndex; j < highIndex; j++) {
			
			if (magicList[j].compareToIgnoreCase(pivot) < 0) {
				
				idx++;
				
				String temp = magicList[idx];
				magicList[idx] = magicList[j];
				magicList[j] = temp;
				
			} // if statement
			
			quickSortComparisons++;
				
		} // for loop
		
		String temp2 = magicList[idx + 1];
		magicList[idx + 1] = magicList[highIndex];
		magicList[highIndex] = temp2;
		
		return idx + 1;
		
	} // partition
	

} // MainGonzalezBonorino
