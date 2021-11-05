import java.util.LinkedList;
/**
 * Class definition for my implementation of hash table (with chaining).
 * @author Bonoc
 *
 */
public class HashTableGonzalezBonorino {

	/**
	 * local class definition for our custom object used to store the key/value pair in the hash table
	 * @author Bonoc
	 *
	 */
    public static class HashObject {
        public String key;
        public String value;
    }
    
    /**
     * Constant to hold the maximum size of the hash table
     */
    public static final int HASH_TABLE_SIZE = 250;

    /**
     * Linked list of custom HashObject class which simply stores a key and a value.
     */
    @SuppressWarnings("unchecked")
	private LinkedList<HashObject>[] arr = new LinkedList[HASH_TABLE_SIZE];

    /**
     * Constructor
     */
    public HashTableGonzalezBonorino() {
    	
        //init vals in array
        for(int i=0; i<HASH_TABLE_SIZE; i++) {
            arr[i] = null;
            
        } // for loop
        
    } // HashTableGonzalezBonorino

    /**\
     * Method to get object (HashObject) from the hash table
     * @param key
     * @return item if found null if not found
     */
    private HashObject getObj(String key) {
    	
    	
        if(key == null)
            return null;

        int index = makeHashCode(key);
        LinkedList<HashObject> items = arr[index];
        
        if(items == null)
            return null;
        
		// for each item in items
        for(HashObject item : items) {
        	
        	// if we find it end the loop and return item
            if(item.key.equals(key))
            {
                return item;
            } // if
            
        } // for each
        
    return null;    
    } // getObj
       
    /**
     * Method to get the total number of comparisons made per query
     * @param key
     * @return number of comparisons
     */
	public int getObjComps(String key) {
		
		int hashTableComparisons = 0;
		
	    if(key == null)
	        return -5;
	
	    int index = makeHashCode(key);
	    LinkedList<HashObject> items = arr[index];
	    
	    
	    if(items == null)
	        return -5;
	    
		
	    for(HashObject item : items) {
	    	
	    	hashTableComparisons++;
	    	
	        if(item.key.equals(key))
	        {
	                return hashTableComparisons;
	            } // if
	        } // for each
	    
	    return -5;
	} //getObjComps

	/**
	 * Method to retrieve an element from the hash table
	 * @param key
	 * @return the value of the item found
	 */
    public String get(String key) {
    	HashObject item = getObj(key);
        
        
        if(item == null)
            return null;
        else
        {	
            return item.value;
            
        } // else
        
    } // get
 
    /** 
     * Method to insert an element into the hash table
     * @param key
     * @param value
     */
    public void put(String key, String value) {
    	int index = makeHashCode(key);
        LinkedList<HashObject> items = arr[index];

        if(items == null) {
            items = new LinkedList<HashObject>();

            HashObject item = new HashObject();
            item.key = key;
            item.value = value;

            items.add(item);

            arr[index] = items;
        } // if
        
        else 
        {
            for(HashObject item : items) 
            {
                if(item.key.equals(key)) 
                {
                    item.value = value;
                    return;
                } // if
                
            } // for each

            HashObject item = new HashObject();
            item.key = key;
            item.value = value;

            items.add(item);
            
        } // else
        
    } // put

    /**
     * Method to delete item from hash table
     * @param key
     */
    public void delete(String key) {
        int index = makeHashCode(key);
        LinkedList<HashObject> items = arr[index];

        if(items == null)
            return;

        for(HashObject item : items) 
        {
            if (item.key.equals(key)) 
            {
                items.remove(item);
                return;
                
            } // if 
            
        } // for each
        
    } // delete
    
    /**
     * Method to generate hash code for indexing
     * @param key
     * @return hash code generated
     */
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
        // ANS: It takes a greater number of comparisons to find an element

        return hashCode;
        
     	} // makeHashCode

} // HashTablegonzalezBonorino