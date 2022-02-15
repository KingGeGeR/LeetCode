package leetcode1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Leetcode1636 {
	
    public int[] frequencySort(int[] nums) {
    	int[] res = new int[nums.length];
    	ArrayList<ArrayList<Integer>> recordList = new ArrayList<>();
    	int[] record = new int[201];
//    	@SuppressWarnings("unchecked")
//		TreeMap<Integer, Integer> recMap = new TreeMap<Integer, Integer>((Map<? extends Integer, ? extends Integer>) new Comparator<Map.Entry<Integer, Integer>>() {
//
//			@Override
//			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
//				if (o1.getValue() == o2.getValue()) {
//					return o1.getKey() - o2.getKey();
//				}
//				return o1.getValue() - o2.getValue();
//			}
//
//		});
    	for (int elem : nums) {
    		record[elem + 100] += 1;
    	}
    	for (int i = 0; i < record.length; i++) {
    		if (record[i] != 0) {
    			ArrayList<Integer> temp = new ArrayList<Integer>();
    			temp.add(i - 100);
    			temp.add(record[i]);
    			recordList.add(temp);
    		}
    	}
    	recordList.sort((o1, o2) -> {
    		if (o1.get(1) == o2.get(1)) {
    			return o2.get(0) - o1.get(0);
    		};
    		return o1.get(1) - o2.get(1);
    	});
    	int j = 0;
    	for (int i = 0; i < recordList.size(); i++) {
    		for (int k = 0; k < recordList.get(i).get(1); k++) {
    			res[j] = recordList.get(i).get(0);
    			j++;
    		}
    	}
    	return res;
    }	
}
