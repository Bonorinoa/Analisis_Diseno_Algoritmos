
public class LinearSearchGonzalezBonorino {
	
	public static int linearSearchComparisons = 0;

	public static int linearSearch(String[] arr, String key){ 
		
		int idx = -1;
		
        for(int i=0;i<arr.length;i++){    
        	
        	// update counter for each comparison
        	linearSearchComparisons++;
        	
            if(arr[i].compareToIgnoreCase(key) == 0) 
            	
            	// assign index where item was found to idx
            	
            	idx = i;
            
        } // for loop
        
        // return -1 if item not found
        
        return linearSearchComparisons; 
        
    } // linearSearch
	
} // LinearSearchGonzalezBonorino
