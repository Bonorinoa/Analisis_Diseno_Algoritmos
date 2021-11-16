package testing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// create GraphNode class with id, processed and neighbors
class GraphNode {
    int id;
    boolean processed;
    ArrayList<GraphNode> neighbors;

    public GraphNode(int id){
        this.id = id;
        processed = false;
        neighbors = new ArrayList<>();

    }

    // addEdge adds to neighbors ArrayList
    public void addEdge(GraphNode gn){
        neighbors.add(gn);
    }






}

public class Graph {
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        BufferedReader in = new BufferedReader(new FileReader("graphs1.txt"));
        String str;

        ArrayList<String> list = new ArrayList<String>();


        while ((str = in.readLine()) != null) {
            list.add(str);
        }
        ArrayList<String> list1 = new ArrayList<>();

        // take lines from file up until first blank line
        for(int i = 0; i < list.indexOf(""); i++){
            list1.add(list.get(i));
        }


        // create first graph
        Graph graph1 = new Graph();
        graph1.populateGraph(list1);
        System.out.println("*******");
        //graph1.printGraph(graph1);
        graph1.printMatrix(graph1);
        graph1.printAdjacencyList(graph1);
        System.out.println("Depth First Search: ");
        graph1.depthFirstSearch(graph1.nodes.get(0));
        System.out.println();
        for(int i = 0; i < graph1.nodes.size(); i++){
            graph1.nodes.get(i).processed = false;
        }
        System.out.println("Breadth First Search: ");
        //graph1.breadthFirstSearch(graph1.nodes.get(0));



        int start = 0;
        int end = 0;
        int breaks = 0;
        //iterate through file
        for(int j = 0; j < list.size(); j++){

            //if line is blank, increment breaks
            if(list.get(j).equals("")){
                breaks++;
            }
            //if breaks is 1, set starting pos to 1 after blank line and increment breaks once more to avoid
            //meeting this if condition again
            if(breaks == 1){
                breaks++;
                start = j + 1;
            }
            // if breaks is 3, set end to that line
            if(breaks == 3){
                end = j;
                break;
            }
        }
        //create new ArrayList from start to end
        ArrayList<String> list2 = new ArrayList<String> (list.subList(start, end));

        //create second graph
        Graph graph2 = new Graph();
        graph2.populateGraph(list2);
        System.out.println("*******");
        //graph2.printGraph(graph2);
        graph2.printMatrix(graph2);
        graph2.printAdjacencyList(graph2);
        System.out.println("***********");
        System.out.println("Depth First Search: ");
        //graph2.depthFirstSearch(graph2.nodes.get(0));


        start = 0;
        end = 0;
        breaks = 0;
        //same as prev, but break conditions increased by one to get the sublist of next graph
        for(int j = 0; j < list.size(); j++){

            if(list.get(j).equals("")){
                breaks++;
            }
            if(breaks == 2){
                breaks++;
                start = j + 1;
            }
            if(breaks == 4){
                end = j;
                break;
            }
        }

        ArrayList<String> list3 = new ArrayList<String> (list.subList(start, end));

        Graph graph3 = new Graph();
        graph3.populateGraph(list3);
        System.out.println("*******");
        //graph3.printGraph(graph3);
        graph3.printMatrix(graph3);
        graph3.printAdjacencyList(graph3);
        //graph3.depthFirstSearch(graph3.nodes.get(0));


        start = 0;
        end = 0;
        breaks = 0;
        //get next graph
        for(int j = 0; j < list.size(); j++){

            if(list.get(j).equals("")){
                breaks++;
            }
            if(breaks == 3){
                breaks++;
                start = j + 1;
            }
            if(breaks == 5){
                end = j;
                break;
            }
        }

        ArrayList<String> list4 = new ArrayList<String> (list.subList(start, end));

        Graph graph4 = new Graph();
        graph4.populateGraph(list4);
        System.out.println("*******");
        //graph4.printGraph(graph4);
        graph4.printMatrix(graph4);
        graph4.printAdjacencyList(graph4);
        //graph4.depthFirstSearch(graph4.nodes.get(0));



        start = 0;
        end = list.size();
        breaks = 0;
        //get next graph
        for(int j = 0; j < list.size(); j++){

            if(list.get(j).equals("")){
                breaks++;
            }
            if(breaks == 4){
                breaks++;
                start = j + 1;
            }

        }

        ArrayList<String> list5 = new ArrayList<String> (list.subList(start, end));

        Graph graph5 = new Graph();
        graph5.populateGraph(list5);
        System.out.println("*******");
        graph5.printGraph(graph5);
        graph5.printMatrix(graph5);
        graph5.printAdjacencyList(graph5);
        //graph5.depthFirstSearch(graph5.nodes.get(0));



    } // main

    ArrayList<GraphNode> nodes;

    public Graph(){
        nodes = new ArrayList<>();
    }

    //addVertex takes id as argument and adds it to the nodes
    public void addVertex(int id){
        nodes.add(new GraphNode(id));

    }

    public void populateGraph(ArrayList<String> list) throws FileNotFoundException, IOException{


        //iterate through arrayList
        for(int i = 0; i < list.size(); i++){
            //if line is empty or a comment, print it out
            if(list.get(i).equals("") || list.get(i).substring(0, 2).equals("--")){
                System.out.println(list.get(i));
            }

            //if line wants us to add vertex...
            else if(list.get(i).contains("vertex")){
                //take the last string, convert to an int and add a vertex with this id
                int id = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ") + 1));
                addVertex(id);

            }

            //if line wants us to add an edge...
            else if(list.get(i).contains("edge")){
                //first id is first string after last instance of the letter 'e', until before the '-', convert to an int
                int id1 = Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf("e") + 2,
                        list.get(i).indexOf("-") - 1));
                //second id is from instance of '-' till end of string, convert to int
                int id2 = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") + 2));

                //if the first node id is a 0, we take the id's as they are
                if(nodes.get(0).id == 0){
                    nodes.get(id1).addEdge(nodes.get(id2));
                    nodes.get(id2).addEdge(nodes.get(id1));
                }

                //if the first node is not a 0 (it will be 1), we need to subtract one
                // as ArrayLists start at 0 but our id is 1
                else {
                    nodes.get(id1 - 1).addEdge(nodes.get(id2 - 1));
                    nodes.get(id2 - 1).addEdge(nodes.get(id1 - 1));
                }

            }
            else{

            }
        }
    }

    //test function to print attributes of graph
    public void printGraph(Graph graph) throws FileNotFoundException, IOException{

        for(int i = 0; i < graph.nodes.size(); i++){
            System.out.println(graph.nodes.get(i).id);
            System.out.println(graph.nodes.get(i).processed);
            for(int j = 0; j < graph.nodes.get(i).neighbors.size(); j++){
                System.out.print(graph.nodes.get(i).neighbors.get(j).id + ", " );
            }
            System.out.println();
            System.out.println("********");
        }
    }

    public void printMatrix(Graph graph){
        int[][] matrix = new int[graph.nodes.size()][graph.nodes.size()];

        //iterate through rows of matrix
        for(int i = 0; i <graph.nodes.size(); i++){
            //iterate through columns of matrix
            for(int j = 0; j < graph.nodes.size(); j++){
                //iterate through neighbors list
                for(int k = 0; k < graph.nodes.get(i).neighbors.size(); k++){
                    //if first node starts at 0...
                    if(graph.nodes.get(0).id == 0){
                        //we check neighbor id directly to j and if they are equal, set matrix[i][j] to 1
                        if(graph.nodes.get(i).neighbors.get(k).id == j){
                            matrix[i][j] = 1;
                            break;
                        }
                    }
                    //else (first node will be 1)
                    else{
                        //we check neighbor id to j + 1 because matrices start at 0 while our graph starts at 1
                        if(graph.nodes.get(i).neighbors.get(k).id == j + 1){
                            matrix[i][j] = 1;
                            break;
                        }
                    }

                    matrix[i][j] = 0;
                }

            }
        }
        //print out matrix
        for(int i = 0; i < graph.nodes.size(); i++){
            for(int j = 0; j < graph.nodes.size(); j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printAdjacencyList(Graph graph){
        //if first node starts at 1...
        if(graph.nodes.get(0).id == 1) {
            //iterate through nodes
            for (int i = 0; i < graph.nodes.size(); i++) {
                //print out i + 1 (since i is 0 but graph starts at  1) and print out the neighbors
                System.out.print("[" + (i + 1) + "] ");
                for (int j = 0; j < graph.nodes.get(i).neighbors.size(); j++) {
                    System.out.print(graph.nodes.get(i).neighbors.get(j).id + " ");
                }
                System.out.println();
            }
        }
        //else (graph starts at 0)
        else{
            //same thing but we can print i directly
            for (int i = 0; i < graph.nodes.size(); i++) {
                System.out.print("[" + i + "] ");
                for (int j = 0; j < graph.nodes.get(i).neighbors.size(); j++) {
                    System.out.print(graph.nodes.get(i).neighbors.get(j).id + " ");
                }
                System.out.println();
            }
        }
    }

    public void depthFirstSearch(GraphNode vertex){
        if(vertex.processed == false){
            System.out.print(vertex.id + " ");
            vertex.processed = true;
        }
        for(int i = 0; i < vertex.neighbors.size(); i++){
            if(vertex.neighbors.get(i).processed == false){
                depthFirstSearch(vertex.neighbors.get(i));
            }
        }
    }

    /*
    public void breadthFirstSearch(GraphNode vertex){
        QueueListGraph Q = new QueueListGraph();
        Q.enqueue(vertex);
        vertex.processed = true;
        while(!Q.isEmpty()){
            GraphNode vertex_temp = Q.dequeue().vertex;
            System.out.println(vertex_temp.id + " " + vertex_temp.processed);
            for(int i = 0; i < vertex_temp.neighbors.size(); i++){
                System.out.println(vertex_temp.neighbors.get(i).id + " " + vertex_temp.neighbors.get(i).processed);
                if(vertex_temp.neighbors.get(i).processed == false){
                    Q.enqueue(vertex_temp.neighbors.get(i));
                    vertex_temp.neighbors.get(i).processed = true;
                }
            }
        }
    }
    */
}



