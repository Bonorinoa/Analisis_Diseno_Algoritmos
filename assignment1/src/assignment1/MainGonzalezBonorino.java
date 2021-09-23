package assignment1;
import java.util.*;
import java.io.*;
/**
 * 
 * @author Augusto Gonzalez Bonorino <br>
 * 
 * assignment1GonzalezBonorino <br>
 * Due Date and Time: 09/24/21 before 9:00 a.m. <br><br>
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
	
	public static void main(String[] args) {
		
		File theMagicFile = null;
		
		String fileName = null;
		String tempString = null;
		
		String [] myMagicList = new String[666];
		int numItems = 0;
		
		String ans = "\nSome suggestions: \n"
				+ "\n* Check that the name of the file was typed correctly"
				+ "\n* Make sure that you are not missing any information in your item description in the file"
				+ "\n* Make sure you are not entering more or less items than specified";
		
		try
		{
			System.out.print("Enter the name of the file: ");
			fileName = keyboard.next();
			
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
		
		
		for (int i = 0; i < myMagicList.length; i++) {
			
			StackGonzalezBonorino stack = new StackGonzalezBonorino();
			QueueGonzalezBonorino queue = new QueueGonzalezBonorino();
			String coolWord = myMagicList[i].replaceAll(" ", "").toUpperCase();
			
			
			for (int j = 0; j < coolWord.length(); j++) {
				
				char c = coolWord.charAt(j);
				
				stack.push(c);
				queue.enqueue(c);
				
				
			} //inner for loop
			
			boolean isPalindrome = true;
			
			while ( !stack.isEmpty() && isPalindrome) {
				
				char elemS = stack.pop();
				char elemQ = queue.dequeue();
				if (Character.compare(elemS, elemQ) != 0)
					isPalindrome = false;
				
			} //while
				
			if(isPalindrome)
				System.out.println(myMagicList[i]);
			
		} // for loop
		
		
	} // main

} // MainGonzalezBonorino
