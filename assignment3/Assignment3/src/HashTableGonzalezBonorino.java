import java.util.LinkedList;

public class HashTableGonzalezBonorino {

    public static class HTObject {
        public String key;
        public String value;
    }

    public static final int HASH_TABLE_SIZE = 250;


    @SuppressWarnings("unchecked")
	private LinkedList<HTObject>[] arr = new LinkedList[HASH_TABLE_SIZE];

    public HashTableGonzalezBonorino() {
        //init vals in array
        for(int i=0; i<HASH_TABLE_SIZE; i++) {
            arr[i] = null;
        }
    }

    private HTObject getObj(String key) {
    	
        if(key == null)
            return null;

        int index = makeHashCode(key);
        LinkedList<HTObject> items = arr[index];
        
        if(items == null)
            return null;
        
		
        for(HTObject item : items) {
        	
            if(item.key.equals(key))
            {
                return item;
            }
            
        }
        
    return null;    
    }
       
public int getObjComps(String key) {
	
	int hashTableComparisons = 0;
	
    if(key == null)
        return -5;

    int index = makeHashCode(key);
    LinkedList<HTObject> items = arr[index];
    
    
    if(items == null)
        return -5;
    
	
    for(HTObject item : items) {
    	
    	hashTableComparisons++;
    	
        if(item.key.equals(key))
        {
                return hashTableComparisons;
            }
        }
    
    return -5;
}

    public String get(String key) {
        HTObject item = getObj(key);
        
        
        if(item == null)
            return null;
        else
        {
        	//System.out.println("Number of comparisons made to find " + item.value + " were " + hashTableComparisons);
        	
            return item.value;
        }
    }
    /*
    public int getComps()
    {
    	return hashTableComparisons;
    	
    }
*/
    public void put(String key, String value) {
    	int index = makeHashCode(key);
        LinkedList<HTObject> items = arr[index];

        if(items == null) {
            items = new LinkedList<HTObject>();

            HTObject item = new HTObject();
            item.key = key;
            item.value = value;

            items.add(item);

            arr[index] = items;
        }
        else {
            for(HTObject item : items) {
                if(item.key.equals(key)) {
                    item.value = value;
                    return;
                }
            }

            HTObject item = new HTObject();
            item.key = key;
            item.value = value;

            items.add(item);
        }
    }

    public void delete(String key) {
        int index = makeHashCode(key);
        LinkedList<HTObject> items = arr[index];

        if(items == null)
            return;

        for(HTObject item : items) {
            if (item.key.equals(key)) {
                items.remove(item);
                return;
            }
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

}