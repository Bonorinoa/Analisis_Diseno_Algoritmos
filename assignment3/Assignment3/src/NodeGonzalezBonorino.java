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
	private String myData;
	
	/**
	 * Instance variable for the data of the next node
	 */
	private NodeGonzalezBonorino myNext;
	
	/**
	 * Default constructor for NodeGonzalezBonorino
	 */
	public NodeGonzalezBonorino() {
		
		myData = "";
		myNext = null;
		
	} // Default Constructor
	
	/**
	 * Semi-constructor for NodeGonzalezBonorino
	 * @param newData value to assign the data to myData
	 */
	public NodeGonzalezBonorino(String newData){
		
		myData = newData;
		myNext = null;
		
	} // Semi-constructor
	
	/**
	 * Method to get myData
	 * @return myData
	 */
	public String getData() {
		
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
	public void setData(String newData) {
		
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
