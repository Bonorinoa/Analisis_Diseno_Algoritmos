import java.util.*;

public class MainGonzalezBonorino {
	
	// fixed infection rate 
	final static double infectionRate = 0.02;
	
	// number of experiments to conduct
	final static int numExperiments = 4;

	public static void main(String[] args) 
	{
		
		// array to hold different population sizes to test
		ArrayList<Integer> populationsSize = new ArrayList<Integer>();
		
		// size of first population
		int size = 1000;
		
		for (int i = 0; i < numExperiments; i++)
			{
				populationsSize.add(size);
				
				size = size * 10;
				
			} // for

		System.out.println("SEMESTER PROJECT - COVID POOL TESTING");
        
	    for ( int j = 0; j < numExperiments; j++)
	    {

	    	int popSize = populationsSize.get(j);
	    	
	        ArrayList<Integer> population = infectPopulation(popSize);
	        
	        ArrayList<ArrayList<Integer>> grouped_pop = groupBy8(population);
	        
			System.out.println(" ");
			
			System.out.println("************* TEST " + (j+1) + " ***************");
			
	        System.out.println("Population size " + popSize + " with " + infectionRate + " infection rate");
	
			System.out.println(" ");

	        
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
	
	        } // inner for
	        
		    //print cases and percentages
	        System.out.println("Case (1): " + grouped_pop.size() + " x " + case1 / (population.size() / 8) + " = " + grouped_pop.size() * Math.round( (case1 / (population.size() / 8) * 100.0)) / 100.0 + " instances requiring " + (int) (case1 * 1) + " tests");
	        System.out.println("Case (2): " + grouped_pop.size() + " x " + case2 / (population.size() / 8) + " = " + grouped_pop.size() *  Math.round( (case2 / (population.size() / 8) * 100.0)) / 100.0  + " instances requiring " + (int) (case2 * 7) + " tests");
	        System.out.println("Case (3): " + grouped_pop.size() + " x " + case3 / (population.size() / 8) + " = " + grouped_pop.size() *  Math.round( (case3 / (population.size() / 8) * 100.0)) / 100.0  + " instances requiring " + (int) (Math.ceil(case3) * 11) + " tests");
	        
	        int totalNumTests = (int) ( (case1 * 1) + (case2 * 7) + (Math.ceil(case3) * 11) );
	        
	        System.out.println("Total number of tests required: " + totalNumTests);

	        
	    } // outer for

	} // main
	
	public static ArrayList<Integer> infectPopulation(int popSize)
		{
			
			// to infect random people
			Random rand = new Random();
			
			// set to store unique ids
			Set<Integer> idxs = new LinkedHashSet<Integer>();
			
			// list to populate the full population with 1s and 0s
	        ArrayList<Integer> patients = new ArrayList<Integer>();
	        
	        for (int i = 0; i < popSize; i++)
				{
		        	patients.add(0);
				    
				} // for
	        
	        int idx = 0;
			
			while (idxs.size() < patients.size() * infectionRate)
				{
				    idx = rand.nextInt(patients.size());
				    
				    idxs.add(idx);
				    
				} // for

			
			for (int id : idxs)
				{
				    
				    // set infected patient to 1
				    patients.set(id, 1);
					
				} // for each unique random id in idxs
			
			/*
			 * Test code to count number of people infected
			int count = 0;
			
	        for (int i = 0; i < patients.size(); i++)
		        {
		        	if (patients.get(i) == 1)
		        		count++;
		        	
		        } // for
		        
	        System.out.println("Patients infected: " + count); // Should always be 2% of population since it is 2% infection rate
	        */
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
	        
	        /*
	         * Test code to check number of groups of 8 generated for the given population size
	        System.out.println("Number of groups of 8 in grouped population: " + grouped_pop.size()); // should be equal to (popSize / 8)
	        */
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
