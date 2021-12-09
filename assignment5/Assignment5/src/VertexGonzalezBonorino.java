import java.util.*;

public class VertexGonzalezBonorino 
{
	int id;
    ArrayList<EdgeGonzalezBonorino> neighbors;
    double short_path;
    VertexGonzalezBonorino prev_vertex;

    public VertexGonzalezBonorino(int id)
    {
        this.id = id;
        neighbors = new ArrayList<>();
        short_path = Double.POSITIVE_INFINITY;
        prev_vertex = null;

    } // constructor

    public void addEdge(EdgeGonzalezBonorino edge)
    {
        neighbors.add(edge);
        
    } // addEdge
    
} // VertexGonzalezBonorino
