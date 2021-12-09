import java.util.ArrayList;
/**
 * 
 * @author Augusto Gonzalez Bonorino <br><br>
 * 
 * This is the class definition for a graph's Vertex.
 *
 */
public class VertexGonzalezBonorino {

	/**
	 * Instance variable for vertex's id
	 */
	private int myId;
	
	/**
	 * Instance variable to hold vertex's neighbours
	 */
	private ArrayList<VertexGonzalezBonorino> myNeighbours;
	
	/**
	 * Pointer to next Vertex for Linked List implementation
	 */
	private VertexGonzalezBonorino myNext;
	
	/**
	 * Instance variable to track if the vertex has been processed 
	 */
	private boolean processed;
	
	
	/**
	 * Default Constructor
	 * @param newId
	 */
	public VertexGonzalezBonorino(int newId)
		{
			
			myId = newId;
			myNext = null;
			processed = false;
			myNeighbours = new ArrayList<>();
			
		} // VertexGonzalezBonorino
	
	/**
	 * Method to get the next Vertex
	 * @return myNext
	 */
	public VertexGonzalezBonorino getNext()
		{
			return myNext;
			
		} // getNext
	
	/**
	 * Method to set next Vertex 
	 * @param newNext
	 */
	public void setNext(VertexGonzalezBonorino newNext)
		{
			myNext = newNext;
			
		} // setNext
	
	/**
	 * Method to get vertex's id
	 * @return myId
	 */
	public int getId()
		{
			return myId;
			
		} // getId
	
	/**
	 * Method to set the vertex's id
	 * @param vertexId
	 */
	public void setId(int vertexId)
		{
			myId = vertexId;
			
		} // setId
	
	/**
	 * Method to get the neighbours of vertex
	 * @return
	 */
	public ArrayList<VertexGonzalezBonorino> getNeighbours()
		{
			return myNeighbours;
			
		} // getNeighbours
	
	/**
	 * Method to add a neighbour vertex
	 * @param neighbour
	 */
	public void addNeighbour(VertexGonzalezBonorino neighbour)
		{
			myNeighbours.add(neighbour);
			
		} // addNeighbour
	
	/**
	 * Method to check if vertex has been processed
	 * @return processed
	 */
	public boolean isProcessed()
		{
			return processed;
			
		} // isProcessed
	
	/**
	 * Method to process a vertex
	 */
	public void process()
		{
			processed = true;
			
		} // process
	
	/**
	 * Method to unprocess a vertex
	 */
	public void unprocess()
		{
			processed = false;
			
		} // unprocess
	
} // VertexGonzalezBonorino
