package datastructures;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

	public static void main(String[] args) {

		List<String> lstOutput = new ArrayList<String>();
		getPermuations("", "abc", lstOutput);
		for(String str : lstOutput){
			System.out.println(str);	
		}
		
	}
	
	public static void getPermuations(String perm, String input, List<String> lstOutput){
		
		int len = input.length();
		if(len == 0){
			lstOutput.add(perm);
			return;
		}
		for(int i = 0; i < len; i++){
			char c = input.charAt(i);
		    getPermuations(perm + c, input.substring(0,i) + input.substring(i+1, len), lstOutput);
		}
		
	}

}
