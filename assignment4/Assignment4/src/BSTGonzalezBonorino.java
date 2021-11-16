
public class BSTGonzalezBonorino 
{
	
	public class treeNode
		{
		
			public String myData;
			public treeNode myLeft;
			public treeNode myRight;
			
			public treeNode(String newData)
				{
					myData = newData;
					myLeft = null;
					myRight = null;
					
				} // Node constructor
			
		} // treeNode
	
	/**
	 * Instance variable for tree's root
	 */
	public treeNode myRoot;
	
	/**
	 * Variable to keep count of comparisons
	 */
	private static float BSTcomparisons;
	
	
	public BSTGonzalezBonorino()
		{
			myRoot = null;
			
		} // Tree constructor
	
	
	public float getComps()
		{
			return BSTcomparisons;
			
		} // getComps
	
	public void resetCount()
		{
			BSTcomparisons = 0;
			
		} // resetCount
	

    public void insert(String newData) 
	    {
	        myRoot = insert(myRoot, newData);
	        
	    } // insert

    public treeNode insert(treeNode root, String newData) 
	    {
	        // Base Case: root is null or not
	        if (root == null) 
		        {
		            // Insert the new data, if root is null.
		            root = new treeNode(newData);
		            // return the current root to his sub tree
		            return root;
		        } // if
	        
	        // Check if root is greater than or equal to root
	        else if (root.myData.compareToIgnoreCase(newData) >= 0) 
		        {
		            // if root is greater than or equal newData then go left
		            root.myLeft = insert(root.myLeft, newData);
		            System.out.print("L, ");
		            
		        } // else if
	        
	        else 
		        {
		            // if root is less than newData then go right
		            root.myRight = insert(root.myRight, newData);
		            System.out.print("R, ");
		            
		        } // else
	        
	        return root;
	    }// insert
    
    
    public String search(treeNode root, String target)
    {
    	String ans = " ";
    	
    	BSTcomparisons++;
    	if (root == null || root.myData.compareToIgnoreCase(target) == 0)
	    	{
	    		ans = root.myData;
	    		
	    	} // if
    	
    	else
	    	{
	    		
	    		if ( target.compareToIgnoreCase(root.myData) < 0)
		    		{
		    			search(root.myLeft, target);
		    			System.out.print("L, ");
		    			
		    		} // if
	    		
	    		else
		    		{
		    			search(root.myRight, target);
		    			System.out.print("R, ");
		    			
		    		} // else
	    		
	    	} // else
    	
    	return ans;
    	
    } // search
    
    
    /**
     * traverse Binary Tree in order
     */
    public void inOrder() 
	    {
	      inOrder(myRoot);
	      
	    } // inOrder Recursive
    
    private void inOrder(treeNode node) 
	    {
	    	
	      if (node == null) 
		      {
		        return;
		      }
	      
	      inOrder(node.myLeft);
	      System.out.println(node.myData);
	      inOrder(node.myRight);
	      
	    } // inOrder 
    
} // BSTGonzalezBonorino
