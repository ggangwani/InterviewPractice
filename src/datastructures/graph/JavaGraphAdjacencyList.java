package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Data structures to hold graph data are Adjacency matrix, Adjacency list
 * 
 * @author gunjan
 *
 */
public class JavaGraphAdjacencyList {

	public static void main(String[] args) {
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

class Graph<T> {

	static class Node<T> {
		T data;
		/** Used only for traversal **/
		private MODE mode = MODE.NOT_VISITED;
		
		public enum MODE{
			NOT_VISITED,
			VISITING,
			VISITED
			
		};
		
		public Node(T data) {
			this.data = data;
		}

		@Override
		public int hashCode() {
			return data.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Graph.Node) {
				return (this.data.equals(((Graph.Node) obj).data));
			}
			return false;
		}
	
		public void setMode(MODE mode){
			this.mode = mode;
		}
		
		public MODE getMode() {
			return mode;
		}
		
		@Override
		public String toString() {
			return "data: " + data + ",mode:" + mode.name();
		}
		
	}

	protected Map<Node<T>, List<Node<T>>> mapAdjacency = new HashMap<Node<T>, List<Node<T>>>();
	// To make sure we have one set of nodes, not multiple references of same data nodes should get created.
	protected Map<T, Node<T>> mapNodeStore = new HashMap<T, Graph.Node<T>>();

	public Graph(List<T> lstValues) {
		for (T val : lstValues) {
			Node<T> node = getNode(val);
			if (!mapAdjacency.containsKey(node)) {
				mapAdjacency.put(node, new LinkedList<Node<T>>());
			}
		}

	}
	
	protected Node<T> getNode(T value){
		if(!mapNodeStore.containsKey(value)){
			Node<T> node = new Node(value);
			mapNodeStore.put(value, node);
		}
		
		return mapNodeStore.get(value);
	}

	public void addEdges(T from, T to) {
		Node<T> fromNode = getNode(from);
		Node<T> toNode = getNode(to);
		if (mapAdjacency.containsKey(fromNode)) {
			List<Node<T>> lst = mapAdjacency.get(fromNode);
			lst.add(toNode);
		}
		if (mapAdjacency.containsKey(toNode)) {
			List<Node<T>> lst = mapAdjacency.get(toNode);
			lst.add(fromNode);
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Set<Node<T>> nodes = mapAdjacency.keySet();
		for (Node<T> node : nodes) {
			builder.append(node.data + ":::");
			List<Node<T>> list = mapAdjacency.get(node);
			for (Node<T> edge : list) {
				builder.append(edge.data + "->");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
