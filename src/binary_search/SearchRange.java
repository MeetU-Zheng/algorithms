package binary_search;

//LeetCode 34
public class SearchRange {

	
	public int[] solution1(int []nums, int target) {
		int left =0,right = nums.length-1;
		int[] ans = {-1,-1};
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(nums[mid]==target)
				right = mid-1;
			else if (nums[mid]>target)
				right = mid-1;
			else
				left = mid+1;
		}
		if(left==nums.length || nums[left]!=target)
			return ans;
		else 
			ans[0]=left;
			
		right=nums.length-1;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(nums[mid]==target)
				left = mid+1;
			else if (nums[mid]>target)
				right = mid-1;
			else
				left = mid+1;
		}
		ans[1]=right;
		return ans;
	}
	
	//TODO:简化方法1
	public int[] solution2(int[] nums,int target) {
		int[] ans = {-1,-1};
		int start = firstGreaterOrEqual(nums, target);
		if(start == nums.length || nums[start]!=target)
			return ans;
		ans[0]=start;
		ans[1] = firstGreaterOrEqual(nums, target+1)-1;
		return ans;
	}
	
	private int firstGreaterOrEqual(int[] nums, int target) {
		int left = 0,right = nums.length-1;
		while(left<=right) {
			int mid = left + (right - left)/2;
			if(nums[mid] >= target)
				right=mid-1;
			else
				left = mid +1;
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] n = {5,7,7,8,8,10};
		new SearchRange().solution1(n, 6);
	}
}
