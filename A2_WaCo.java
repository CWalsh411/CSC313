package assignment2;

import java.util.ArrayDeque;

public class A2_WaCo {
	public static boolean isMatch(String expressionLine){
		ArrayDeque<Character> deque = new ArrayDeque<Character>();
		for(int i = 0; i < expressionLine.length(); i++) {
			switch(expressionLine.charAt(i)) {
			case '(' :
				deque.addFirst(expressionLine.charAt(i));
				break;
			case '{' :
				deque.addFirst(expressionLine.charAt(i));
				break;
			case '[' :
				deque.addFirst(expressionLine.charAt(i));
				break;
			case ')' :
				if(!deque.isEmpty() && deque.getFirst() == '(')
					deque.removeFirst();
				else
					return false;
				break;
			case '}' :
				if(!deque.isEmpty() && deque.getFirst() == '{')
					deque.removeFirst();
				else
					return false;
				break;
			case ']' :
				if(!deque.isEmpty() && deque.getFirst() == '[')
					deque.removeFirst();
				else
					return false;
				break;
			default : 
				break;
				
			}
		}
		if (deque.isEmpty())
			return true;
		return false;
	}
	
	public static void main(String[] args){
		 String[] expression = new String[]{"{5*(x+2)+(y-1);}", "32*(20+(x[i]*3)-1",
		"((){([][])})", "({}((0))", "{([]})", "{}())", "{"};
		 for (String st: expression)
		 System.out.println(st + " is " + isMatch(st));
		}
}
