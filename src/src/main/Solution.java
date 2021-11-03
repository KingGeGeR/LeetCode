package src.main;

import leetcode200.Leetcode211;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode211 solution = new Leetcode211();
		solution.addWord("bad");
		solution.addWord("dad");
		solution.addWord("mad");
		solution.search(".a.");
		System.out.println(solution.search(".a."));
	}

}
