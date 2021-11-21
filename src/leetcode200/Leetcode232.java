package leetcode200;

import java.util.LinkedList;
import java.util.List;

public class Leetcode232 {
	LinkedList<Integer> recorder;
	LinkedList<Integer> tempCache;
	
    public Leetcode232() {
    	recorder = new LinkedList<Integer>();
    	tempCache = new LinkedList<>();
    }
    
    public void push(int x) {
    	recorder.push(x);
    }
    
    public int pop() {
    	int i = recorder.size();
    	int result;
    	while(i > 1) {
    		tempCache.push(recorder.pop());
    		i--;
    	}
    	i = tempCache.size();
    	result = recorder.pop();
    	while(i > 0) {
    		recorder.push(tempCache.pop());
    		i--;
    	}
    	tempCache.clear();
    	return result;
    }
    
    public int peek() {
    	int i = recorder.size();
    	int result;
    	while(i > 1) {
    		tempCache.push(recorder.pop());
    		i--;
    	}
    	i = tempCache.size() + 1;
    	result = recorder.pop();
    	tempCache.push(result);
    	while(i > 0) {
    		recorder.push(tempCache.pop());
    		i--;
    	}
    	tempCache.clear();
    	return result;
    }
    
    public boolean empty() {
    	return recorder.isEmpty();
    }
}
