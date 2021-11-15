import java.util.ArrayList;

public class GraphGonzalezBonorino {
	
	private int numVertices;
	
	public ArrayList<VertexGonzalezBonorino> myVertices;
	
	/**
	 * Constructor
	 */
	public GraphGonzalezBonorino()
		{
			myVertices = new ArrayList<VertexGonzalezBonorino>();
			
		} // GraphGonzalezBonorino
	
	/**
	 * Add vertex to graph given vertex object and id
	 * @param newVertex
	 * @param id
	 */
	public void addVertex(VertexGonzalezBonorino newVertex, int id)
		{	
			newVertex.setId(id);
			myVertices.add(newVertex);
			
			numVertices++;
			
		} // addVertex
	
	/**
	 * Add edge between two vertices
	 * @param graph
	 * @param vertex1
	 * @param vertex2
	 */
	public void addEdge(ArrayList<ArrayList<Integer>> graph, int vertex1, int vertex2)
		{
			// edge goes both ways since it is undirected
		
			graph.get(vertex1).add(vertex2);
			graph.get(vertex2).add(vertex1);			
			
		} // addEdge
	
	public int getNumVertices()
		{
			return numVertices;
			
		} // getNumVertices

} // GraphGonzalezBonorino
