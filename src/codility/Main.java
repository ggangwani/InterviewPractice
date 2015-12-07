package codility;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Determine whether a triangle can be built from a given set of edges.
		int[] A = {10,2,5,1,8,20};
		System.out.println(findHasTraingle(A));
		int[] B = {3,4,3,3,1,1};
		System.out.println(findDistinctCount(B));
	}


	public static int findHasTraingle(int[] A) {
        Arrays.sort(A);
        // {1,2,5,8,10,20}
        for (int i = 2; i < A.length; i++) {
            long sum = (long) A[i - 2] + A[i - 1];
            if (sum > A[i]) return 1;
        }
        return 0;
    }	
	
	public static int findDistinctCount(int[] A) {
        if (A.length <= 0) return 0;
        Arrays.sort(A);
        int pre = A[0], count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != pre) {
                pre = A[i];
                count++;
            }
        }
        return count;
    }
}
