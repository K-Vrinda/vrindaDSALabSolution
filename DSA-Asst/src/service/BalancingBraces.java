package service;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancingBraces {
	
	public BalancingBraces() {
	}
	
	public boolean isStringBalanced(String inputString) {
		Deque<Character> bracesStack = new ArrayDeque<Character>();

		for (int i = 0; i < inputString.length(); i++){
            char bracket = inputString.charAt(i);
 
            if (bracket == '(' || bracket == '[' || bracket == '{'){
                bracesStack.push(bracket);
                continue;
            }

            if (bracesStack.isEmpty()) {
            	return false;
            }
                
            char tos;
            
            switch (bracket) {
            case ')':
                tos = bracesStack.pop();
                if (tos == '{' || tos == '[')
                    return false;
                break;
 
            case '}':
                tos = bracesStack.pop();
                if (tos == '(' || tos == '[')
                    return false;
                break;
 
            case ']':
                tos = bracesStack.pop();
                if (tos == '(' || tos == '{')
                    return false;
                break;
            }
        }
        return (bracesStack.isEmpty());
	}
}
