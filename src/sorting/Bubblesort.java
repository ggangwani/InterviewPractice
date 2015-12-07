package sorting;

public class Bubblesort {

	public static void main(String[] args) {
		int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
		bubbleSort(input);
		
		for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
	}

	private static void bubbleSort(int[] input) {
		int length = input.length;
		for(int i = 0 ; i<length; i++){
			for(int j=i+1; j<length; j++){
				if(input[i] > input[j]){
					int swapValue = input[i];
					input[i] = input[j];
					input[j] = swapValue;
				}
			}
		}
	}

}
