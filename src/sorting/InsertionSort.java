package sorting;

/**
 * Insertion sort as the name suggests picks one element at a time and inserts it at the right place.
 * Like a deck of cards. I have 4 cards 3,5,7,9 and I get a new card 8, I find out where to insert 
 * it i.e after 7 and before 9. 
 * Outer loop picks each element at a time, Inner loop iterates through the sorted 
 * sublist and inserts the element at right place by swapping
 * Worst case/ average complexity - O(n2), Best case when the list is already sorted O(n)
 * @author gunjan
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
		insertionSort(input);
		
		for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
	}

	private static void insertionSort(int[] input) {
		int length = input.length;
		for(int i = 0; i <length; i++){
			for(int j = i; j > 0; j--){
				if(input[j] < input[j-1]){
					int swap = input[j];
					input[j] = input[j-1];
					input[j-1] =swap;
				}
					
			}
		}
		
	}

}
