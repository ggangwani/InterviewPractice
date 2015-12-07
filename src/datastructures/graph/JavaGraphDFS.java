package datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class JavaGraphDFS {

	public static void main(String[] args) {
		// Create a graph
		List<Integer> lstIntegers = new ArrayList<Integer>();
		lstIntegers.add(1);
		lstIntegers.add(4);
		lstIntegers.add(5);
		lstIntegers.add(9);
		lstIntegers.add(2);
		Graph<Integer> graph = new Graph(lstIntegers);
		graph.addEdges(1, 2);
		graph.addEdges(4,5);
		graph.addEdges(5,9);
		System.out.println(graph);
	}

	
}
