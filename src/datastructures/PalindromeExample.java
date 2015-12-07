package datastructures;

public class PalindromeExample {

	public static void main(String[] args) {

		System.out.println("dad:" + isTextPalindrome("dad"));
		System.out.println("madam:" + isTextPalindrome("madam"));
		System.out.println("dasdf:" + isTextPalindrome("dasdf"));
		System.out.println("madam:" + isPalindromeByReverse("madam"));
		System.out.println("madam:" + isTextPalindromeRecursion("madam"));
		System.out.println("dasdf:" + isTextPalindrome("dasdf"));
		
	}
	/**
	 * complexity O(n/2) = O(n)
	 * @param str
	 * @return
	 */
	/**
	 * Complexity of O(n/2) = O(n)
	 * @param str
	 * @return
	 */
	public static boolean isTextPalindrome(String str){
		if(str == null){
			return false;
		}
		int low = 0;
		int high = str.length()-1;
		while(low < high){
			if(str.charAt(low++) != str.charAt(high--)){
				return false;
			}
		}
		return true;
			
		/**
		 * Alternative approach
		 */
		 /*int n = str.length();
	        for( int i = 0; i < n/2; i++ )
	            if (str.charAt(i) != str.charAt(n-i-1)) return false;
	        return true; */   
	}
	
	/**
	 * Complexity will be O(n) for reverse + O(n) for toString + O(n) for equals = O(3n) = O(n)
	 * @param str
	 * @return
	 */
	public static boolean isPalindromeByReverse(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
	
	public static boolean isTextPalindromeRecursion(String str){
		if(str.length() == 0 || str.length() == 1)
			return true;
		if(str.charAt(0) == str.charAt(str.length() - 1)){
			return isTextPalindromeRecursion(str.substring(1,str.length()-1));
		}
		
		return false;
			
	}

}
