package datastructures.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Connected class provides the ability to evaluate the connections between Cities passed as an program Arguments.
 * 	<p>Class expect 3 program argument where 
 *  	a) 1st should be the fileName 
 * 		b) 2nd and 3rd Should be Origin and Destination city Names 
 *  </p>
 *  
 * Connected parse the passed input file and a build  model like a graph where each city can be connected to multiple cities (Bi-directional).
 * Connected uses Breadth First Search Algorithm (BFS) to traverse over the city nodes and identify whether the passed arguments
 * are connected or not.
 *  
 * In BFS, Time complexity can be expressed as O(e) + O(v) (e= edges, v= vertices (nodes))  
 *  
 * Please refer to below link for more detail on BFS algorithm
 *  
 * @link http://en.wikipedia.org/wiki/Breadth-first_search
 *  
 * @author vikash
 *
 */
public class JavaGraphBFSApplication {

	/**
	 * Map to store City as key and connected cities list as Value
	 * 
	 */
	private Map<String, List<GraphNode>> mapCities = new HashMap<String, List<GraphNode>>();
	
	/**
	 * Map to Store city as key and GraphNode as corresponding value
	 */
	 Map<String,GraphNode> mapGraphNodes = new HashMap<String, GraphNode>();
	
	/**
	 * Holds the currently traversing cities in the queue having a node Marker of NOT_VISITED (WHITE)
	 * 
	 */
	private Queue<GraphNode> queue = new LinkedList<GraphNode>();

	
	private static final String SEPARATOR=",";
	
	/**
	 * Responsible for reading the city pair from the file path and build the Connected Graph Data Model
	 * @param fileName
	 */
	private void initInput(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String readLine = reader.readLine();
			while(readLine!=null){
				String[] split = readLine.split(SEPARATOR);
				String origin = split[0].trim();
				String destination = split[1].trim();
				processCities(origin, destination);
				readLine = reader.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found: "+ fileName);
		} catch (IOException e) {
			System.err.println("Error encountered in reading file: "+ fileName);
		}
	}
	
	/**
	 * Identifies whether source is connected to destination by using BFS traversal algorithm
	 * 
	 * @param source city
	 * @param destination city
	 * @return boolean true source city is connected to destination city else false
	 */
	private boolean isConnected(String source, String destination) {
		if(source.equals(destination))
			return true;
		GraphNode node = getNode(source);
		if(node.getMarker()!=(GraphNode.WHITE))
			return true;
		node.setMarker(GraphNode.BLUE);
		queue.offer(node);
		String currentCityName = source;
		while(!queue.isEmpty()){
			GraphNode top = queue.peek();
			currentCityName = top.getCity();
			List<GraphNode> connectedCities = mapCities.get(currentCityName);
			if(connectedCities==null || connectedCities.isEmpty())
				return false;
			for (GraphNode n : connectedCities) {
				if(n.getMarker() != GraphNode.WHITE)
					continue;
				n.setPrevious(top);
				if(n.getCity().equals(destination))
					return true;
				n.setMarker(GraphNode.BLUE);
				queue.offer(n);
			}
			queue.poll();
			top.setMarker(GraphNode.BLACK);
		}
		
		return false;
	}

	/**
	 * Stores each Origin and Destination as a key in the model with value as a list of Connecting Cities.
	 * 
	 * <a>
	 *         key-> {Value.....}
	 *      Origin-> {Destination....}
	 * Destination-> {Origin....}
	 * </a>
	 */
	private void processCities(String origin, String destination) {
		if(!mapCities.containsKey(origin))
		{
			List<GraphNode> cityList = new LinkedList<GraphNode>();
			cityList.add(getNode(destination));
			mapCities.put(origin, cityList);
		}
		else
			mapCities.get(origin).add(getNode(destination));

		if(!mapCities.containsKey(destination))
		{
			List<GraphNode> cityList = new LinkedList<GraphNode>();
			cityList.add(getNode(origin));
			mapCities.put(destination, cityList);
		}
		else
			mapCities.get(destination).add(getNode(origin));
	}

	
	/**
	 * Return the Graph Node for passes City Name
	 */
	public GraphNode getNode(String city)
	{
		if(!mapGraphNodes.containsKey(city))
			mapGraphNodes.put(city,new GraphNode(city));
		
		return mapGraphNodes.get(city);
	}
	
	public static void main(String[] args) {
		if(args == null || args.length != 3)
		{
			System.err.println("Incorrect Program arguments, arguments count should be 3");
			System.exit(1);
		}
		String fileName = args[0].trim();
		String origin = args[1].trim();
		String destination = args[2].trim();

		JavaGraphBFSApplication evaluator = new JavaGraphBFSApplication();
		evaluator.initInput(fileName);
		
		if(origin.length()==0 || destination.length()==0){
			System.err.println("Invalid connection input");
			System.exit(1);
		}
		
		if(evaluator.isConnected(origin,destination))
			System.out.println(origin +" and "+destination+ " are connected ");
		else
			System.out.println(origin +" and "+destination+ " are not connected ");
	}

	
}


/**
 * Represent City as Node of a Graph and holds properties required for traversing using BFS algorithm
 * BFS algorithm
 * 
 * @author vikash
 *
 */
class GraphNode
{
	private GraphNode previous;
	private String city;
	
	/**
	 * Node Marker for non visited mode
	 */
	public static byte WHITE=0; 
	/**
	 * Node Marker for visiting node
	 */
	public static byte BLUE=1; 
	/**
	 * Node Marker of Visited node
	 */
	public static byte BLACK=2; 

	/**
	 * Default status of Graph node
	 */
	private byte marker =WHITE;
	
	public GraphNode(String city) {
		this.city = city;
	}

	public GraphNode getPrevious() {
		return previous;
	}
	public void setPrevious(GraphNode predecessor) {
		this.previous = predecessor;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public short getMarker() {
		return marker;
	}
	public void setMarker(byte marker) {
		this.marker = marker;
	}

	public String toString() {
		return city;
	}

	public boolean equals(Object o) {
		return city.equals(((GraphNode)o).city);
	}
}


