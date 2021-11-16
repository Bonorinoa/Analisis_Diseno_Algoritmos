import java.util.ArrayList;

public class VertexGonzalezBonorino {

	private int myId;
	
	private ArrayList<VertexGonzalezBonorino> myNeighbours;
	
	private VertexGonzalezBonorino myNext;
	
	private boolean processed;
	
	// constructor
	
	public VertexGonzalezBonorino(int newId)
		{
			
			myId = newId;
			myNext = null;
			processed = false;
			myNeighbours = new ArrayList<>();
			
		} // VertexGonzalezBonorino
	
	public VertexGonzalezBonorino getNext()
		{
			return myNext;
			
		} // getNext
	
	public void setNext(VertexGonzalezBonorino newNext)
		{
			myNext = newNext;
			
		} // setNext
	
	public int getId()
		{
			return myId;
			
		} // getId
	
	
	public void setId(int vertexId)
		{
			myId = vertexId;
			
		} // setId
	
	public ArrayList<VertexGonzalezBonorino> getNeighbours()
		{
			return myNeighbours;
			
		} // getNeighbours
	
	public void addNeighbour(VertexGonzalezBonorino neighbour)
		{
			myNeighbours.add(neighbour);
			
		} // addNeighbour
	
	public boolean isProcessed()
		{
			return processed;
			
		} // isProcessed
	
	public void process()
		{
			processed = true;
			
		} // process
	
	public void unprocess()
		{
			processed = false;
			
		} // unprocess
	

    public void addEdge(VertexGonzalezBonorino newNeighbour)
	    {
	        myNeighbours.add(newNeighbour);
	        
	    } // addEdge
	
} // VertexGonzalezBonorino
