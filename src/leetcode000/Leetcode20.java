package leetcode000;

import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
    	// put the left bracket into stack
    	Stack<Character> chArr = new Stack<>();
    	for (char elem : s.toCharArray()) {
    		if (elem == '(' || elem == '{' || elem == '[') {
    			chArr.push(elem);
    		} else {
    			if (!chArr.isEmpty() && ((elem == ')' && chArr.peek() == '(') ||
    			    (elem == '}' && chArr.peek() == '{') ||	
    			    (elem == ']' && chArr.peek() == '['))) {
    				chArr.pop();
    			} else {
    				return false;
    			}
    		}
    		
    	}
    	return chArr.isEmpty() ? true : false;
    }
}
