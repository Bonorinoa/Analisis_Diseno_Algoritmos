package assignment1;
/**
 * 
 * @author Augusto Gonzalez Bonorino
 * This is the class definition for NodeGonzalezBonorino
 * 
 */
public class NodeGonzalezBonorino {
	/**
	 * Instance variable to hold the data
	 */
	private char myData;
	
	/**
	 * Instance variable for the data of the next node
	 */
	private NodeGonzalezBonorino myNext;
	
	/**
	 * Default constructor for NodeGonzalezBonorino
	 */
	public NodeGonzalezBonorino() {
		
		myData = ' ';
		myNext = null;
		
	} // Default Constructor
	
	/**
	 * Semi-constructor for NodeGonzalezBonorino
	 * @param newData value to assign the data to myData
	 */
	public NodeGonzalezBonorino(char newData){
		
		myData = newData;
		myNext = null;
		
	} // Semi-constructor
	
	/**
	 * Method to get myData
	 * @return myData
	 */
	public char getData() {
		
		return myData;
	} // getData
	
	/**
	 * Method to get the value of the next node
	 * @return myNext
	 */
	public NodeGonzalezBonorino getNext() {
		
		return myNext;
	} //getNext
	
	/**
	 * Method to set the value of myData
	 * @param newData
	 */
	public void setData(char newData) {
		
		myData = newData;
	} //setData
	
	/**
	 * Method to set the value of myNext
	 * @param newNext
	 */
	public void setNext(NodeGonzalezBonorino newNext) {
		
		myNext = newNext;
	} // setNext
	
} // Node
