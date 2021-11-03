import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class HashTableGonzalezBonorino {

	private static final int HASH_TABLE_SIZE = 250;
	private NodeGonzalezBonorino[] table;
	int mySize;
	
	public HashTableGonzalezBonorino()
	{
		table = new NodeGonzalezBonorino[HASH_TABLE_SIZE];
		mySize = 0;
	}
	

	/* Function to insert an element */
    public void insert(String val)
    {
    	mySize++;
        int pos = makeHashCode(val);        
        NodeGonzalezBonorino nptr = new NodeGonzalezBonorino(val);                
        if (table[pos] == null)
            table[pos] = nptr;            
        else
        {
            nptr.next = table[pos];
            table[pos] = nptr;
        }    
    }
    
	public static int makeHashCode(String key) {
		 
		key = key.toUpperCase();
	    int length = key.length();
	    int letterTotal = 0;
	
	    // Iterate over all letters in the string, totalling their ASCII values.
	    
	    for (int i = 0; i < length; i++) 
	    {	
	       char thisLetter = key.charAt(i);
	       int thisValue = (int)thisLetter;
	       letterTotal = letterTotal + thisValue;
	       
	    } // for loop
	
	    // Scale letterTotal to fit in HASH_TABLE_SIZE.
	    int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
	    
	    // TODO: Experiment with letterTotal * 2, 3, 5, 50, etc.
	
	    return hashCode;
	    
	 	} // makeHashCode
	 
	public void printHashTable ()
    {
        System.out.println();
        for (int i = 0; i < table.length; i++)
        {
            System.out.print ("Bucket " + i + ":  ");             
            NodeGonzalezBonorino start = table[i];
            while(start != null)
            {
                System.out.print(start.data +"; ");
                start = start.next;
            }
            System.out.println();
        }
    }   
	
	public String get(int idx)
	{
		String elem = "";
		
		NodeGonzalezBonorino start = table[idx];
		
		elem = start.data;
		
		
		return elem;
	}
		 											
} // HashTableGonzalezBonorino
