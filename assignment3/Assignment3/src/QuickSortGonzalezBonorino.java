
public class QuickSortGonzalezBonorino {
	
	public static int quickSortComparisons = 0;
	
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
	
}
