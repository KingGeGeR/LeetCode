package leetcode1600;

public class Leetcode1603 {
	int[] nums;
	
    public Leetcode1603(int big, int medium, int small) {
    	nums = new int[3];
    	nums[0] = big;
    	nums[1] = medium;
    	nums[2] = small;
    }
    
    boolean recordCarNums(int carType) {
    	nums[carType - 1] = nums[carType - 1] - 1;
    	return nums[carType - 1] >= 0 ? true : false;
    }
    
    public boolean addCar(int carType) {	
		return recordCarNums(carType);
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */