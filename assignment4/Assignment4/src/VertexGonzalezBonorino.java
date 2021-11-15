import java.util.ArrayList;

public class VertexGonzalezBonorino {

	private int myId;
	
	private ArrayList<VertexGonzalezBonorino> myNeighbours;
	
	private boolean processed;
	
	// constructor
	
	public VertexGonzalezBonorino()
		{
			
			myId = 1;
			processed = false;
			myNeighbours = new ArrayList<>();
			
		} // VertexGonzalezBonorino
	
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
	
} // VertexGonzalezBonorino
