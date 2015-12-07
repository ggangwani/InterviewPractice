package ias.practice;


public class IntegralAdscienceQuestions {

	public static void main(String[] args) {
		/**
		 * 1. Generate reverse of a number without using string comparison
		 * 2. Given string is a permutation of a certain input string
		 * 3. Add a method to a map value like data structure called getindex(int index) that returns value at the given index 
		 * 4. Create a MinStack that is LIFO and has operations to push and pop but in addition has a method getMin() that returns the min most number
		 * 
		 */
		
		reverseNumber(1234);
		System.out.println(isPermutation("cb"));
	}
	
	public static void reverseNumber(int no){
		int output = 0;
		while(no > 0){ 
			int lastDigit = no % 10; 
			output = (output * 10) + lastDigit;
			no = no/10;
		}
		System.out.println(output);
	}
	
	
	public static boolean isPermutation(String str){
		String input = "abc";
		StringBuilder builder = input.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
		StringBuilder builderInput = str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
		if(builderInput.indexOf(builder.toString()) >= 0){
			return true;
		}
		return false;
	}

}
