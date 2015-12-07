package datastructures;

public class FibonacciSeries {

	public static void main(String[] args) {
		FibonacciAlgo algo = new FibonacciAlgo();
		System.out.println( algo.getSeries(15) );
		System.out.println( algo.getSeriesByRecursion(15) );
	}

}

class FibonacciAlgo{
	
	public String getSeries(int febCount){
		String output = "";
		int[] fib = new int[febCount];
		fib[0] = 0;
		fib[1] = 1;
		for(int i =2; i< febCount; i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		for (int val : fib) {
			output += val + " ";
		}
		return output;
	}
	
	public String getSeriesByRecursion(int febCount){
		StringBuilder output = new StringBuilder();
		for(int i = 0 ;i<febCount;i++){
			output.append(fibonacciRecursive(i) + " ");
		}
		return output.toString();
	}
	
	public int fibonacciRecursive(int n)  {
	    if(n <= 1){
	        return n;
	    }
	   else{
	      return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	   }
	}
	
	
}
