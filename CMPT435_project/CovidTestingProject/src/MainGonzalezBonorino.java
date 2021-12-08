import java.util.*;

public class MainGonzalezBonorino {

	public static void main(String[] args) 
	{

		
		System.out.println("SEMESTER PROJECT - COVID POOL TESTING");
		
		System.out.println("************* TEST 1 ***************");
		
        System.out.println("Population size 1000, 2% infection rate");
        
        // Population of 1000
        ArrayList<Integer> population = infectPopulation(1000);
        
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
        System.out.println("Case (1): 125 x " + case1 / (population.size() / 8) + " = " + 125 * (double) (case1 / (population.size() / 8)) + " instances requiring " + case1 * 1 + " tests");
        System.out.println("Case (2): 125 x "  + case2 / (population.size() / 8) + " = " + 125 * (double) (case2 / (population.size() / 8)) + " instances requiring " + case2 * 7 + " tests");
        System.out.println("Case (3): 125 x " + case3 / (population.size() / 8) + " = " + 125 * (double) (case3 / (population.size() / 8)) + " instances requiring " + Math.ceil(case3) * 11 + " tests");
        //System.out.println("Total number of tests required: " + )

        /*
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

        for(int i = 0; i < grouped_pop4.size(); i++)
        {
            String cases = checkInfection(grouped_pop4.get(i));
            if(cases.equals("Case 1"))
            {
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
        */

	} // main
	
	public static ArrayList<Integer> infectPopulation(int popSize)
		{
			// fixed infection rate 
			final double infection_rate = 0.02;
			
			// to infect random people
			Random rand = new Random();
			
			// list to populate the full population with 1s and 0s
	        ArrayList<Integer> patients = new ArrayList<Integer>();
	        
	        for (int i = 0; i < popSize; i++)
				{
		        	patients.add(0);
				    
				} // for
	        
	        int idx = 0;
			
			for (int j = 0; j < patients.size() * infection_rate; j++)
				{
				    idx = rand.nextInt(patients.size());
				    
				    /*
				     * Test code to check indices are random
				    System.out.println("Random index " + j + " : " + idx);
				    */
				    
				    // set infected patient to 1
				    patients.set(idx, 1);
				    
				} // for
			
			int count = 0;
			
	        for (int i = 0; i < patients.size(); i++)
		        {
		        	if (patients.get(i) == 1)
		        		count++;
		        	
		        } // for
		        
	        System.out.println("Patients infected: " + count); // Should always be 2% of population since it is 2% infection rate
	        
	        return patients;
	        
	    } // infectPopulation

   
    public static ArrayList<ArrayList<Integer>> groupBy8(ArrayList<Integer> patients)
	    {	
	        ArrayList<ArrayList<Integer>> grouped_pop = new ArrayList<>();
	        ArrayList<Integer> group8 = new ArrayList<>();
	
	        for(int i = 0; i < patients.size(); i++)
		        {
		
		            if (group8.size() == 7)
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
    	
    	String caseObserved = " ";

        if(!group8.contains(1))
        {
            // Case 1
        	caseObserved = "Case 1";
            
        } // if no one is infected
        
        else if(group8.contains(1))
        {
        	
        	try 
	        	{
		            // split in half for first pool
		            ArrayList<Integer> subGroup_1 = new ArrayList<Integer> (group8.subList(0, 4));
		            ArrayList<Integer> subGroup_2 = new ArrayList<Integer> (group8.subList(4, 8));
		
		            
		            if(subGroup_1.contains(1) & subGroup_2.contains(1))
		            {
		                //it is case 3
		            	caseObserved = "Case 3";
		                
		            } // if both group have an infected person
		            
		            
		            else if(subGroup_1.contains(1) & !subGroup_2.contains(1) || (!subGroup_1.contains(1) & subGroup_2.contains(1)))
		            {
		            	caseObserved = "Case 2";
		                
		            } // else if only one of the groups has an infected person
		            
	        	} // try 
        	
        	catch (IndexOutOfBoundsException ex) 
	        	{
	                System.out.println("Exception thrown : " + ex);
	                
	            } // check index not out of bounds
	      
	        catch (IllegalArgumentException ex) 
	        	{
	                System.out.println("Exception thrown : " + ex);
	                
	            } // check arguments are not illegal

        } // else if there is an infected person

        return caseObserved;
        
    } // checkInfection

} // MainGonzalezBonorino
