package whitepages;

import java.util.ArrayList;
import java.util.List;

public class ArrayHopper {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5, 6, 0, 4, 2, 4, 1, 0, 0, 4};
		List<Integer> hop = hop(arr);
		System.out.println(hop);
	}
	
	private static List<Integer> hop(int[] arr){
		List<Integer> result = new ArrayList<Integer>();
		
		int intermediateHop = arr[0],currentHop = arr[0];
		result.add(0);
		int selectedIndex = 0;
		for(int i = 0 ; i < arr.length; i++){
			int maxHop = i + arr[i];
			intermediateHop = Math.max(maxHop, intermediateHop);
			if(maxHop >= arr.length){
				result.add(i);
				return result;
			}
			if(i < currentHop){
				if(maxHop > intermediateHop){
					selectedIndex = i;	
				}
				
			}
			else{
				currentHop = intermediateHop;
				i = selectedIndex;
				result.add(selectedIndex);
				
			}
		}
		return result;
	}
	
}
