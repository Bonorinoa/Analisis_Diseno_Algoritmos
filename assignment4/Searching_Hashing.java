import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Searching_Hashing {
    static double binary_search_counter = 0.0;
    static double Overall_Comps_Hash = 0.0;
    public static void main(String[] args) throws FileNotFoundException, IOException {




        BufferedReader in = new BufferedReader(new FileReader("D:/AAD/Assignment_1/magicitems.txt"));
        String str;

        ArrayList<String> list = new ArrayList<String>();


        while ((str = in.readLine()) != null) {
            list.add(str);
        }

        String[] stringArr = list.toArray(new String[0]);

        MergeSort msort = new MergeSort(list);
        msort.sort();
        msort.pcomps();

        final int NUM_SEARCH_ITEMS = 42;

        Random rand = new Random();
        ArrayList<String> search_items = new ArrayList<>();

        // create 42 random indexes and use those indexes on magic items to input them into a list
        for (int i = 0; i < NUM_SEARCH_ITEMS; i++) {
            int n = rand.nextInt(665);
            search_items.add(list.get(n));
        }

        /*
        //Print out sorted list with indexes
        for (int x = 0; x < list.size(); x++) {
            System.out.println(list.get(x) + " " + x);
        }
         */

        float overall_average = 0;

        // Linear search for 42 random items
        System.out.println("LINEAR SEARCH");
        for(int j = 0; j < NUM_SEARCH_ITEMS; j++){
            System.out.println("Search string '" + search_items.get(j) + "' found at index: " + LinearSearch(list, search_items.get(j)));
            System.out.println("Number of Comparisons: " + LinearSearch(list, search_items.get(j)));
            overall_average += LinearSearch(list, search_items.get(j));
        }

        //print overall average comps for linear search
        System.out.println("Overall Average Comparisons: " + overall_average / NUM_SEARCH_ITEMS);

        System.out.println();
        System.out.println("*************************************************");
        System.out.println("BINARY SEARCH");

        //Binary Search for 42 random items
        for (int k = 0; k < NUM_SEARCH_ITEMS; k++) {
            System.out.println("Search string '" + search_items.get(k) + "' found at index: " + BinarySearch(list, search_items.get(k)));
        }

        //print overall average comps for binary search
        System.out.println("Average Comparisons for Binary Search: " + binary_search_counter / NUM_SEARCH_ITEMS);


        System.out.println();
        System.out.println("*************************************************");
        System.out.println("HASH TABLE (WITH CHAINING)");
        // create an array of queues
        QueueList[] arr = new QueueList[250];


        // populate hash table with 665 magic items
        for(int n = 0; n < list.size(); n++){
            int hash = makeHashCode(list.get(n));

            if(arr[hash] == null){
                arr[hash] = new QueueList();
            }
            arr[hash].enqueue(list.get(n));

        }

        /*
        for(int z = 0; z < arr.length; z++){
            if(arr[z] != null){
                System.out.println("At index " + z);
                arr[z].printQList();
                System.out.println();
            }
        }
        */



        //find the 42 random items in hash table and print out comps
        for(int a = 0; a < search_items.size(); a++){
            int local_comps = 0;
            int hash = makeHashCode(search_items.get(a));
            local_comps = arr[hash].find(search_items.get(a)) + 1;
            System.out.println("Search String '" + search_items.get(a) + "' at index " + hash);
            System.out.println("Number of Comparisons: " + local_comps);
            Overall_Comps_Hash = Overall_Comps_Hash + local_comps;
        }

        System.out.println("Overall Average Comparisons for Hash Table: " + Overall_Comps_Hash / NUM_SEARCH_ITEMS);
    }

    public static int LinearSearch(ArrayList<String> searchlist, String target) {

        for (int i = 0; i < searchlist.size(); i++) {
            if (searchlist.get(i) == target) {
                return i;
            }
        }
        return -1;
    }


    public static int BinarySearch(ArrayList<String> searchlist, String target) {
        int low = 0;
        int high = searchlist.size() - 1;
        int mid = (low + high) / 2;
        int comps = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (searchlist.get(mid).toLowerCase().compareTo(target.toLowerCase()) < 0) {
                low = mid + 1;
            } else if (searchlist.get(mid).toLowerCase().compareTo(target.toLowerCase()) > 0) {
                high = mid - 1;
            } else {
                comps++;
                binary_search_counter = binary_search_counter + 1;
                System.out.println("Number of comparisons: " + comps);
                return mid;
            }
            comps++;
            binary_search_counter = binary_search_counter + 1;
        }
        return -1;
    }



    private static final int HASH_TABLE_SIZE = 250;

    private static int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;

        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int)thisLetter;
            letterTotal = letterTotal + thisValue;
        }

        // Scale letterTotal to fit in HASH_TABLE_SIZE
        int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
        return hashCode;
    }



}
