package datastructures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// find duplicate characters
public class StringDuplicateCharacters {

	public static void main(String[] args) {
		String str = "234554";
		//str = "2345";
		System.out.println(str.matches("(\\d)\\1"));
		Pattern p = Pattern.compile("(\\d)\\1");
		Matcher m = p.matcher(str);
		while (m.find()) {
			String word = m.group();
			System.out.println(word + " " + m.start() + " " + m.end());
		}
	}

}
