import java.util.*;

public class MainGonzalezBonorino {

	public static void main(String[] args) 
	{

		
		System.out.println("SEMESTER PROJECT - COVID POOL TESTING");
		
		System.out.println("************* TEST 1 ***************");
		
        System.out.println("Population size 1000, 2% infection rate");
        
        // Population of 1000
        ArrayList<Integer> population = infectPopulation(1000);
        
        int count = 0;
        for (int i = 0; i < population.size(); i++)
        {
        	if (population.get(i) == 1)
        		count++;
        	
        }
        
        System.out.println("Population infected: " + count);
        
        ArrayList<ArrayList<Integer>> grouped_pop = groupBy8(population);

        // number of cases
        
        double case1 = 0.0;
        double case2 = 0.0;
        double case3 = 0.0;


        for(int i = 0; i < grouped_pop.size(); i++)
        {
            String cases = checkInfection(grouped_pop.get(i));
            if(cases.equals("Case 1"))
            {
                case1++;
                
            } // case 1
            
            else if(cases.equals("Case 2"))
            {
                case2++;
                
            } // case 2 
            
            else if(cases.equals("Case 3"))
            {
                case3++;
                
            } // case 3

        } // for

        //print cases and percentages
        System.out.println("Case 1, 1 test: " + case1 + " instances --> " + case1 / (population.size() / 8));
        System.out.println("Case 2, 7 tests: " + case2 + " instances --> " + case2 / (population.size() / 8));
        System.out.println("Case 3, 11 tests: " + case3 + " instances --> " + case3 / (population.size() / 8));


		System.out.println("************* TEST 2 ***************");

        System.out.println("Population size 10000, 2% infection rate");

        // Population of 10000
        ArrayList<Integer> population2 = infectPopulation(10000);
        ArrayList<ArrayList<Integer>> grouped_pop2 = groupBy8(population2);

        case1 = 0.0;
        case2 = 0.0;
        case3 = 0.0;

        for(int i = 0; i < grouped_pop2.size(); i++){
            String cases = checkInfection(grouped_pop2.get(i));
            if(cases.equals("Case 1")){
                case1++;
            }
            else if(cases.equals("Case 2")){
                case2++;
            }
            else if(cases.equals("Case 3")){
                case3++;
            }

        }

        System.out.println("Case 1, 1 test: " + case1 + " instances --> " + case1 / (population2.size() / 8));
        System.out.println("Case 2, 7 tests: " + case2 + " instances --> " + case2 / (population2.size() / 8));
        System.out.println("Case 3, 11 tests: " + case3 + " instances --> " + case3 / (population2.size() / 8));

		System.out.println("************* TEST 3 ***************");

        System.out.println("Population size 100000, 2% infection rate");

        // Population of 100000
        ArrayList<Integer> population3 = infectPopulation(100000);
        ArrayList<ArrayList<Integer>> grouped_pop3 = groupBy8(population3);

        case1 = 0.0;
        case2 = 0.0;
        case3 = 0.0;

        for(int i = 0; i < grouped_pop3.size(); i++){
            String cases = checkInfection(grouped_pop3.get(i));
            if(cases.equals("Case 1")){
                case1++;
            }
            else if(cases.equals("Case 2")){
                case2++;
            }
            else if(cases.equals("Case 3")){
                case3++;
            }

        }

        System.out.println("Case 1, 1 test: " + case1 + " instances --> " + case1 / (population3.size() / 8));
        System.out.println("Case 2, 7 tests: " + case2 + " instances --> " + case2 / (population3.size() / 8));
        System.out.println("Case 3, 11 tests: " + case3 + " instances --> " + case3 / (population3.size() / 8));

		System.out.println("************* TEST 4 ***************");

        System.out.println("Population size 1000000, 2% infection rate");

        // Population of 100000
        ArrayList<Integer> population4 = infectPopulation(1000000);
        ArrayList<ArrayList<Integer>> grouped_pop4 = groupBy8(population4);

        case1 = 0.0;
        case2 = 0.0;
        case3 = 0.0;

        for(int i = 0; i < grouped_pop4.size(); i++){
            String cases = checkInfection(grouped_pop4.get(i));
            if(cases.equals("Case 1")){
                case1++;
            }
            else if(cases.equals("Case 2")){
                case2++;
            }
            else if(cases.equals("Case 3")){
                case3++;
            }

        }

        System.out.println("Case 1, 1 test: " + case1 + " instances --> " + case1 / (population4.size() / 8));
        System.out.println("Case 2, 7 tests: " + case2 + " instances --> " + case2 / (population4.size() / 8));
        System.out.println("Case 3, 11 tests: " + case3 + " instances --> " + case3 / (population4.size() / 8));


	} // main
	
	public static ArrayList<Integer> infectPopulation(int popSize)
	{
		// fixed infection rate 
		final double infection_rate = .02;
		
		// list to populate the full population with 1s and 0s
        ArrayList<Integer> patients = new ArrayList<Integer>();
        
        // populate population
        for(int i = 0; i < popSize; i++)
        {
            double n = Math.random(); // Random values 0 < n < 1 with 2% probability of n <= 0.02
            
            if(n <= infection_rate)
            {
            	patients.add(1);
            }// if
            
            else
            {
            	patients.add(0);
            } // else
            
        } // for
        
        return patients;
        
    } // infectPopulation

   
    public static ArrayList<ArrayList<Integer>> groupBy8(ArrayList<Integer> patients)
    {
        ArrayList<ArrayList<Integer>> grouped_pop = new ArrayList<>();
        ArrayList<Integer> group8 = new ArrayList<>();

        for(int i = 0; i < patients.size(); i++)
        {

            if(group8.size() == 7)
            {
                // add an 8th person
                group8.add(patients.get(i));
                
                // clone group8
                @SuppressWarnings("unchecked")
				ArrayList<Integer> group8_temp = (ArrayList<Integer>) group8.clone();
                
                // add it to the ArrayList of ArrayLists
                grouped_pop.add(group8_temp);
                
                // clear group8 to add more people
                group8.clear();
                
            } // if it is a group of 7
            
            else
            {
                
                group8.add(patients.get(i));

            } // else
            
        } // for every patient
        
        return grouped_pop;
        
    } //groupBy8

    
    public static String checkInfection(ArrayList<Integer> group8)
    {

        if(!group8.contains(1))
        {
            // Case 1
            return "Case 1";
            
        } // if no one is infected
        
        else if(group8.contains(1))
        {
            // split in half for first pool
            ArrayList<Integer> group4_1 = new ArrayList<Integer> (group8.subList(0, 4));
            ArrayList<Integer> group4_2 = new ArrayList<Integer> (group8.subList(4, 8));

            
            if(group4_1.contains(1) & group4_2.contains(1))
            {
                //it is case 3
                return "Case 3";
                
            } // if there are 2 or more infected
            
            
            else if(group4_1.contains(1) & !group4_2.contains(1) || (!group4_1.contains(1) & group4_2.contains(1)))
            {
                return "Case 2";
                
            } // else if only one of the groups has infection
            

        } // else if there is an infected person

        return "";
        
    } // checkInfection

} // MainGonzalezBonorino
