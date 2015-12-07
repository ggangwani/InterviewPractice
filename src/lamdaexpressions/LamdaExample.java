package lamdaexpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LamdaExample {

	public static void main(String[] args) {
	   List<Integer> lstValues = new ArrayList<Integer>();
	   for (int i = 1; i < 10; i++) {
		   lstValues.add(i);
	   }
	// Java way
	   lstValues.forEach(new Consumer<Integer>() {

		@Override
		public void accept(Integer t) {
			System.out.println(t);
			
		}
	    });
	   
	// Scala way
	   lstValues.forEach(value -> {
		   System.out.println(value);
	   });
	   
	   // Scala way
	   lstValues.forEach(value -> System.out.println(value));
	   
	   // Java way
	   lstValues.sort(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	   });
	   
	   // Scala way
	   lstValues.sort((o1,o2) -> o2.compareTo(o1));
	   lstValues.forEach(value -> System.out.println(value));
	   
	 
	}

}
