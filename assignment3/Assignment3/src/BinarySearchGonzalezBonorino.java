
public class BinarySearchGonzalezBonorino {
	
	public static int binarySearchComparisons = 0;
	
	public static int binarySearch(String[] arr, int start, int stop, String key)
	{
		
		int mid = (start + stop) / 2;
		boolean h = false;
		
		binarySearchComparisons++;
		
		if (start > stop)
			h = false;

		else if (arr[mid].compareToIgnoreCase(key) == 0)
			h = true;
		
		else if (arr[mid].compareToIgnoreCase(key) < 0)
			binarySearch(arr, start, mid - 1, key);
		
		else
			binarySearch(arr, mid + 1, stop, key);
		
		
		return binarySearchComparisons;
		
	}

}
