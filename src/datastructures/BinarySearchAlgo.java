package datastructures;

/**
 * Worst case performance: O(log n)
 * Best case performance: O(1)
 * @author gunjan
 *
 */
public class BinarySearchAlgo {

	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		int[] input = {2, 4, 6, 8, 10, 12, 14, 16};
		System.out.println( search.search(input, 10) );
		System.out.println( search.searchRecursive(input, 10) );
	}

}

class BinarySearch{
	
	public int search(int[] input, int value){
		int low = 0;
		int high = input.length -1;
		int searchIndex = -1;
		while(low <= high){
			int middle = low + (high - low)/2;
			if(input[middle] == value){
				return middle;
			}
			if(value < input[middle]){
				high = middle - 1;
			}else if(value > input[middle]){
				low = middle + 1;
			}
		}
		return searchIndex;
	}
	
	public int searchRecursive(int[] input, int value){
		int low = 0;
		int high = input.length -1;
		return search(low, high, value, input);
	}
	
	private int search(int low, int high, int value, int[] input){
		if(low > high)
			return -1;
		int middle = low + (high - low)/2;
		if(input[middle] == value){
			return middle;
		}
		if(value < input[middle]){
			return search(low, middle - 1,value,input);
		}
		if(value > input[middle]){
			return search(middle+1, high, value, input);
		}
		return -1;
	}
}
