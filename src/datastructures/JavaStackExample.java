package datastructures;

import java.util.Scanner;
import java.util.Stack;

public class JavaStackExample {

	public static void main(String[] args) {

		ExpressionEvaluator evaluator = new ExpressionEvaluator();
		Scanner scanner = new Scanner(System.in);
		System.out.println("USAGE: ((8*(9/(5+4)))+9) should give 17");
		System.out.println("Enter an expression");
		String exp = scanner.next();
		System.out.println(evaluator.evaluateExpression(exp));

		
	}

}
/**
 * Stack implemnetation for expression evalaution. Modifiction of Dijkistra's algorithm
 * 
 * @author gunjan
 *
 */
class ExpressionEvaluator {
	private Stack<String> stackOperator = new Stack<String>();
	private Stack<Integer> stackValues = new Stack<Integer>();

	public int evaluateExpression(String expression) {
		int len = expression.length();
		for (int i = 0; i < len; i++) {
			String c = String.valueOf(expression.charAt(i));
			switch (c) {
			case "*":
			case "+":
			case "-":
			case "/":
				stackOperator.push(c);
				break;
			case ")":
				String operator = stackOperator.pop();
				int ltOperand = stackValues.pop();
				int rtOperand = stackValues.pop();
				int value = 0;
				switch (operator) {
				case "*":
					value = ltOperand * rtOperand;
					break;
				case "+":
					value = ltOperand + rtOperand;
					break;
				case "-":
					value = ltOperand - rtOperand;
					break;
				case "/":
					value = ltOperand / rtOperand;
					break;
				}
				stackValues.push(value);
				break;
			case "(":
				break;
			default:
				stackValues.push(Integer.valueOf(c));
			}
		}
		return stackValues.pop();
	}
}
