package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
		mergeSort(input);
		
		for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
	}

	private static void mergeSort(int[] input) {
		
		int[] inputCopy = new int[input.length];
		int lowerIndex = 0;
		int higherIndex = input.length - 1;
		
		doMergeSort(lowerIndex, higherIndex, input);
		
		
	}

	private static void doMergeSort(int lowerIndex, int higherIndex, int[] input) {
		
		if(lowerIndex < higherIndex){
			int middle = lowerIndex + (higherIndex  - lowerIndex)/2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle , input);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex , input);
			// Now merge both sides
	        mergeParts(lowerIndex, middle, higherIndex, input);
		}
	}

	private static void mergeParts(int lowerIndex, int middle, int higherIndex, int[] input) {
		int[] inputCopy = new int[higherIndex+1];
		for(int i = lowerIndex; i<= higherIndex; i++){
			inputCopy[i] = input[i];
		}
		
		int i = lowerIndex;
		int j = middle + 1;
		int k = i;
		
		while(i <= middle && j <= higherIndex){
			if(inputCopy[i] <= inputCopy[j]){
				input[k] = inputCopy[i];
				i++;
			}else{
				input[k] = inputCopy[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle){
			input[k] = inputCopy[i];
			i++;
			k++;
		}
	}
	
	
	

}
