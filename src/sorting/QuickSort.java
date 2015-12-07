package sorting;

public class QuickSort {

	public static void main(String[] args) {

		int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
		quickSort(input);
		
		for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
	}

	private static void quickSort(int[] input) {
		int lowerIndex = 0;
		int higherIndex = input.length - 1;
		quickSort(lowerIndex, higherIndex, input);
		
	}

	private static void quickSort(int lowerIndex, int higherIndex, int[] input) {

		int i = lowerIndex;
		int j = higherIndex;
		// Find pivot element
		int pivot = input[lowerIndex + (higherIndex - lowerIndex)/2];
		System.out.println("pivot: " + pivot);
		
		while(i <= j){
			while(input[i] < pivot){
				i++;
			}
			
			while(input[j] > pivot){
				j--;
			}
			
			if(i<=j){
				swapNumbers(i,j, input);
				i++;
				j--;
			}
		}
		if(lowerIndex < j){
			quickSort(lowerIndex, j, input);
		}
		if(higherIndex > i){
			quickSort(i, higherIndex, input);
		}
		
		
	}

	private static void swapNumbers(int i, int j, int[] input) {
		System.out.println("Swapping: " + input[i] + "," + input[j]);
		int swap = input[i];
		input[i] = input[j];
		input[j] = swap;
		
	}

}
