package codility.reonomy;

import java.util.Stack;

public class StackPostFixEvaluator {

	public static void main(String[] args) {
		PostFixEvaluator evalator = new PostFixEvaluator();
		System.out.println(evalator.evaluateExpression("13+62*7+*"));
		System.out.println(evalator.evaluateExpression("11++"));
		System.out.println(evalator.evaluateExpression(""));
		System.out.println(evalator.evaluateExpression("?3345?"));
	}
	

}

class PostFixEvaluator {

	public int evaluateExpression(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		if(expression == null || expression.isEmpty()) return -1;
		
		int len = expression.length();
		for (int i = 0; i < len; i++) {
			char c = expression.charAt(i);
			switch (c) {
			case '*':
				if(stack.size() < 2) return -1;
				stack.push(stack.pop() * stack.pop());
				break;
			case '+':
				if(stack.size() < 2) return -1;
				stack.push(stack.pop() + stack.pop());
				break;
			case '-':
				if(stack.size() < 2) return -1;
				stack.push(stack.pop() - stack.pop());
				break;
			case '/':
				if(stack.size() < 2) return -1;
				stack.push(stack.pop() / stack.pop());
				break;
			default:
				if(Character.isDigit(c))
					stack.push(Integer.valueOf(String.valueOf(c)));
				else
					return -1;
				
			}
		}
		return stack.pop();
	}
	
    public int solution(String S) {
        if(S == null || S.isEmpty()) return -1;

        Stack<Integer> stack = new Stack<Integer>();
		int len = S.length();
		for (int i = 0; i < len; i++) {
			char c = S.charAt(i);
			switch (c) {
			case '*':
				if(stack.size() < 2) return -1;
				stack.push(stack.pop() * stack.pop());
				break;
			case '+':
				if(stack.size() < 2) return -1;
				stack.push(stack.pop() + stack.pop());
				break;
			case '-':
				if(stack.size() < 2) return -1;
				stack.push(stack.pop() - stack.pop());
				break;
			case '/':
				if(stack.size() < 2) return -1;
				stack.push(stack.pop() / stack.pop());
				break;
			default:
				if(Character.isDigit(c))
					stack.push(Integer.valueOf(String.valueOf(c)));
				else
					return -1;
				
			}
		}
		return stack.pop();
	
}
}

