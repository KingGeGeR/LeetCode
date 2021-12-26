package leetcode000;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode46 {
	// 123 213 231 132 312 321
    List<List<Integer>> arrRes;
    public List<List<Integer>> permute(int[] nums) {
        arrRes = new ArrayList<List<Integer>>();
        boolean[] tags = new boolean[nums.length];
        Deque<Integer> arrs = new LinkedList<Integer>();
        int depth = 0;
        dfs(nums, depth, arrs, tags);
        return arrRes;
    }
    
    void dfs(int[] nums, int depth, Deque<Integer> list, boolean[] tags) {
        if (depth == nums.length) {
            arrRes.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tags[i] != true) {
                tags[i] = true;
                list.addLast(nums[i]);
                dfs(nums, depth + 1, list, tags);
                list.removeLast();
                tags[i] = false;
            }
        }
        
    }   
}
