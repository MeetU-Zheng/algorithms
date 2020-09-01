package binary_search;

//LeetCode 704
public class binarySearch {
	
	//递归
	public int solution1(int[] nums, int target) {
		return dp(nums, 0, nums.length-1, target);
	}
	
	private int dp(int[] nums, int start, int end, int target) {
		if(start > end)
			return -1;
		int mid = start + (end - start)/2;
		if(nums[mid] == target)
			return mid;
		else if (nums[mid]>target) 
			return dp(nums, start, mid-1, target);
		else
			return dp(nums, mid+1, end, target);
	}
	
	public int solution2(int[] nums, int target) {
		int right = nums.length-1;
		int left = 0;
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(nums[mid] == target)
				return mid;
			else if (nums[mid]>target)
				right = mid-1;
			else
				left = mid +1;
		}
		return -1;
	}
	
	
}
