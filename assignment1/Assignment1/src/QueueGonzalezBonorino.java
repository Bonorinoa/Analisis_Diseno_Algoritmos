/**
 * 
 * @author Augusto Gonzalez Bonorino <br><br>
 *
 * This is the class definition for QueueGonzalezBonorino
 */
public class QueueGonzalezBonorino {
	
	/**
	 * Instance variable for the queue's tail
	 */
	private NodeGonzalezBonorino myTail;

	/**
	 * Instance variable for the queue's head
	 */
	private NodeGonzalezBonorino myHead;
	
	/**
	 * Default constructor for QueueGonzalezBonorino
	 */
	public QueueGonzalezBonorino() {
		
		myTail = null;
	} // constructor
	
	/**
	 * Method to check if Queue is empty
	 * @return boolean true if empty false otherwise
	 */
	public boolean isEmpty() {
		
		if (myHead == null)
			return true;
		else
			return false;
	} // check if empty
	
	/**
	 * Method to add elements to the Queue
	 * @param element
	 */
	public void enqueue(char element) {
		
		NodeGonzalezBonorino oldTail = myTail;
		myTail = new NodeGonzalezBonorino();
		myTail.setData(element);
		myTail.setNext(null);
		
		if (isEmpty())
			myHead = myTail;
		else
			oldTail.setNext(myTail);
	} //enqueue
	
	/**
	 * Method to delete and element from the Queue
	 * @return element extracted
	 */
	public char dequeue() {
		
		char ans = ' ';
		
		if (!isEmpty()) {
			
			ans = myHead.getData();
			myHead = myHead.getNext();
			
			if (isEmpty())
				myTail = null;
			
		} //if
		
		else
			System.out.println("Queue is empty");
		
		return ans;
		
	} //dequeue
	
} // QueueGonzalezBonorino
