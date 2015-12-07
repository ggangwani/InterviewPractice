package JWPlayer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangram {


    static String isPangram(String[] strings) {
       StringBuilder builder = new StringBuilder();
       for(String str : strings){
           builder.append( isPangram(str) ? "1" : "0");
       }
        return builder.toString();
    }

  static boolean isPangram(String string) {
      Set<Character> setAlphabets = new HashSet<Character>();
      char[] arrChars = string.toCharArray();
      for(int i = 0 ; i < arrChars.length; i++){
          if(Character.isLetter(arrChars[i])){
              setAlphabets.add(arrChars[i]);
          }
      }
      return setAlphabets.size() == 26;
    }
  
  public static void main(String[] args) throws IOException{
      Scanner in = new Scanner(System.in);
      final String fileName = System.getenv("OUTPUT_PATH");
      BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
      String res;
      
      int _strings_size = 0;
      _strings_size = Integer.parseInt(in.nextLine());
      String[] _strings = new String[_strings_size];
      String _strings_item;
      for(int _strings_i = 0; _strings_i < _strings_size; _strings_i++) {
          try {
              _strings_item = in.nextLine();
          } catch (Exception e) {
              _strings_item = null;
          }
          _strings[_strings_i] = _strings_item;
      }
      
      res = isPangram(_strings);
      bw.write(res);
      bw.newLine();
      
      bw.close();
  }
	
}
