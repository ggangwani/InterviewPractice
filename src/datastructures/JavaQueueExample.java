package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueueExample {

	public static void main(String[] args) {
		JosephusAlgo jos = new JosephusAlgo();
		//System.out.println(jos.execute(5, 2));
		System.out.println(jos.executeRecursive(5, 2));
	}

}

class JosephusAlgo {
	// initialize the queue
	private Queue<Integer> q = new LinkedList<Integer>();
	
	public String execute(int N, int M) {
		String output = "";
		
		for (int i = 1; i <= N; i++)
			q.add(i);

		while (!q.isEmpty()) {
			for (int i = 0; i < M-1; i++){
				// M is the number of numbers to skip, until M poll the queue and save those numbers by adding it to the end. 
				q.add(q.poll());
			}
			// The first element now on the queue is the number to be removed
			output += q.poll() + " ";
		}
		return output;
	}
	
	public int executeRecursive(int n, int m) {
		if(n == 1){
			return n;
		}
		else{
			int returnValue = executeRecursive(n-1, m);
			return (returnValue + m-1) % n + 1;
		}
	}
}