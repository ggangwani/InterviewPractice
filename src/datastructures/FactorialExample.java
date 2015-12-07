package datastructures;

public class FactorialExample {

	public static void main(String[] args) {
		System.out.println(factorialRecursion(15));
		System.out.println(factorial(15));
		System.out.println(factorialRecursion(2));
		System.out.println(factorial(2));
	}
	
	/**
	 * Complexity O(n-1) = O(n)
	 * @param n
	 * @return
	 */
	public static int factorial(int n){
		int product = 1;
		if( n == 0){
			return product;
		}
		int i = n;
		while(i > 0){
			product *= i;
			i--;
		}
		return product;
	}
	
	public static int factorialRecursion(int n){
		if(n == 0){
			return 1;
		}
		if(n == 1){
			return n;
		}
		return factorialRecursion(n-1) * n;
	}

}
