package assignment1;
/**
 * 
 * @author Augusto Gonzalez Bonorino <br><br>
 *
 * This is the class definition for StackGonzalezBonorino
 */
public class StackGonzalezBonorino {
	/**
	 * Instance variable for the top of the stack
	 */
	private NodeGonzalezBonorino myTop;
	
	/**
	 * Default constructor for StackGonzalezBonorino
	 */
	public StackGonzalezBonorino() {
		
		myTop = null;
	} // default constructor
	
	/**
	 * Method to check if Stack is empty
	 * @return boolean true if empty false otherwise
	 */
	public boolean isEmpty() {
		
		if (myTop == null)
			return true;
		else
			return false;
	} // check if empty
	
	/**
	 * Method to add elements to the Stack
	 * @param element
	 */
	public void push(char element) {
		
		NodeGonzalezBonorino oldTop = myTop;
		myTop = new NodeGonzalezBonorino();
		myTop.setData(element);
		myTop.setNext(oldTop);
		
	} //push
	
	/**
	 * Method to delete and element from the Stack
	 * @return element extracted
	 */
	public char pop() {
		
		char ans = ' ';
		
		if (!(isEmpty())) 
		{	
			ans = myTop.getData();
			myTop = myTop.getNext();
		} //if
		else {
			System.out.println("Stack is empty"); } //else
		
		return ans;
	} // pop

} // Stack
