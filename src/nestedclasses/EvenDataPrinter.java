package nestedclasses;

import java.util.Iterator;

/**
 * Example of Inner Class at class level
 * @author gunjan
 *
 */
public class EvenDataPrinter {

	public static void main(String[] args) {
		DataStructure structure = new DataStructure();
		structure.printEven();
	}

}

class DataStructure{
	
	private final int SIZE = 15;
	private int[] arrayOfInts = new int[SIZE];
	
	public DataStructure() {
		for(int i = 1; i <= SIZE; i++){
			arrayOfInts[i-1] = i;
		}
	}
	
	void printEven(){
		DataStructureIterator iterator = new EvenDataStructureIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	private interface DataStructureIterator extends Iterator<Integer> {};
	
	private class EvenDataStructureIterator implements DataStructureIterator{

		private int currentIndex = 1;
		@Override
		public boolean hasNext() {
			return currentIndex > -1 && currentIndex < SIZE;
		}

		@Override
		public Integer next() {
		    int value = arrayOfInts[currentIndex];
			currentIndex += 2;
			return value;
		}
		
	}
	
}
