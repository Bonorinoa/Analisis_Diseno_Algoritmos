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
	private VertexGonzalezBonorino myTail;

	/**
	 * Instance variable for the queue's head
	 */
	private VertexGonzalezBonorino myHead;
	
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
	public void enqueue(VertexGonzalezBonorino newVertex) {
		
		VertexGonzalezBonorino oldTail = myTail;
		myTail = newVertex;
		myTail.setNext(null);
		
		if ( isEmpty() )
			myHead = myTail;
		else
			oldTail.setNext(myTail);
	} //enqueue
	
	/**
	 * Method to delete and element from the Queue
	 * @return element extracted
	 */
	public VertexGonzalezBonorino dequeue() {
		
		VertexGonzalezBonorino ans = null;
		
		if ( !isEmpty() ) 
		{
			
			ans = myHead;
			myHead = myHead.getNext();
			
			if (isEmpty())
				myTail = null;
			
		} //if
		
		else
			System.out.println("Queue is empty");
		
		// return -777 if not found
		return ans;
		
	} //dequeue
	
} // QueueGonzalezBonorino
