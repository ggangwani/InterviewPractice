package datastructures;

import java.util.Stack;

public class JavaStackInfixToPostfix {
	
    public static void main(String[] args) {
    	InfixToPostfix converter = new InfixToPostfix();
    	System.out.println(converter.convertInfixToPostfix("(1+(2*3))"));
    }
}

class InfixToPostfix{
	private Stack<String> stack = new Stack<String>();
	public String convertInfixToPostfix(String infixExp){
		String postfixExp = "";
		for( int i = 0; i< infixExp.length(); i++){
			String character = String.valueOf(infixExp.charAt(i));
			switch(character){
			case "+":
			case "*":
			case "/":
			case "-":
				stack.push(character);
				break;
			case "(":
				break;
			case ")":
				postfixExp += stack.pop() + " ";
				break;
			default:
				postfixExp += character + " ";
			}
		}
		
		return postfixExp;
	}
}