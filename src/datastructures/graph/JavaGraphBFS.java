package datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.graph.Graph.Node.MODE;

public class JavaGraphBFS {

	public static void main(String[] args) {
		// Create a graph
		List<Integer> lstIntegers = new ArrayList<Integer>();
		lstIntegers.add(1);
		lstIntegers.add(4);
		lstIntegers.add(5);
		lstIntegers.add(9);
		lstIntegers.add(2);
		GraphBFS<Integer> graph = new GraphBFS(lstIntegers);
		graph.addEdges(1, 2);
		graph.addEdges(1, 4);
		graph.addEdges(4, 5);
		graph.addEdges(4, 9);
		graph.addEdges(5, 9);
		graph.addEdges(5, 4);
		graph.addEdges(9, 4);
		graph.addEdges(9, 5);
		System.out.println(graph);
		System.out.println("bfs: " + graph.bfs(5));

	}

}

class GraphBFS<T> extends Graph<T> {

	private Queue<Node<T>> queue = new LinkedList<Node<T>>();

	public GraphBFS(List<T> lstValues) {
		super(lstValues);
	}

	public String bfs(T source) {
		StringBuilder connection = new StringBuilder();
		Node<T> node = getNode(source);
		queue.offer(node);
		node.setMode(MODE.VISITING);
		while (!queue.isEmpty()) {
			Node<T> top = queue.peek();
			List<Node<T>> lstNeighbours = mapAdjacency.get(top);
			for (Node<T> n : lstNeighbours) {
				if (n.getMode() == MODE.NOT_VISITED) {
					n.setMode(MODE.VISITING);
					queue.offer(n);
				}

			}
			Node<T> topVisited = queue.poll();
			topVisited.setMode(MODE.VISITED);
			connection.append(topVisited.data + " ");
		}
		return connection.toString();
	}

}
