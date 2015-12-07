package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
		selectionSort(input);
		
		for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
	}

	private static void selectionSort(int[] input) {
		int length = input.length;
		for(int i = 0; i<length; i++){
			int smallestIndex = i;
			for(int j = i+1; j < length; j++){
				if(input[j] < input[smallestIndex]){
					smallestIndex = j;
				}
			}
			int swapValue = input[i];
			input[i] = input[smallestIndex];
			input[smallestIndex] = swapValue;
		}
	}

}
