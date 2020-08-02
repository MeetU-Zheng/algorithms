package array;

public class RemoveDuplicates {
	public int solution1(int nums[]) {
		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[count] != nums[i])
				nums[++count] = nums[i];
		}
		return count + 1;
	}
}
