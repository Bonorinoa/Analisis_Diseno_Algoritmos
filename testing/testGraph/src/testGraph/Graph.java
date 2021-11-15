package testGraph;
/*
Java Program for 
Undirected graph representation by using adjacency list 
*/
class AjlistNode
{
// Vertices node key
public int id;
public AjlistNode next;
public AjlistNode(int id)
{
    // Set value of node key
    this.id = id;
    this.next = null;
}
}
class Vertices
{
public int data;
public AjlistNode next;
public AjlistNode last;
public Vertices(int data)
{
    this.data = data;
    this.next = null;
    this.last = null;
}
}
public class Graph
{
// Number of Vertices
public int size;
public Vertices[] node;
public Graph(int size)
{
    // Set value
    this.size = size;
    this.node = new Vertices[size];
    this.setData();
}
// Set initial node value
public void setData()
{
    if (size <= 0)
    {
        System.out.println("\nEmpty Graph");
    }
    else
    {
        for (int index = 0; index < size; index++)
        {
            node[index] = new Vertices(index);
        }
    }
}
// Connect two nodes
public void connect(int start, int last)
{
    AjlistNode edge = new AjlistNode(last);
    if (node[start].next == null)
    {
        node[start].next = edge;
    }
    else
    {
        // Add edge at the end
        node[start].last.next = edge;
    }
    // Get last edge 
    node[start].last = edge;
}
//  Handling the request of adding new edge
public void addEdge(int start, int last)
{
    if (start >= 0 && start < size && 
        last >= 0 && last < size )
    {
        connect(start, last);
        if(start==last)
        {
            // When self loop
            return;
        }
        connect(last,start);
    }
    else
    {
        // When invalid nodes
        System.out.println("\nHere Something Wrong");
    }
}
public void printGraph()
{
    if (size > 0 )
    {
        // Print graph ajlist Node value
        for (int index = 0; index < size; ++index)
        {
            System.out.print("\nAdjacency list of vertex " + index + " :");
            AjlistNode temp = node[index].next;
            while (temp != null)
            {
                // Display graph node 
                System.out.print("  " + node[temp.id].data);
                // Visit to next edge
                temp = temp.next;
            }
        }
    }
}
	public static void main(String[] args) {
		// 5 implies the number of nodes in graph
        Graph g = new Graph(5);
        // Connect node with an edge
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,4);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        // print graph element
        g.printGraph();

	}

}
