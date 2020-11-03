package array;

import java.util.Arrays;

public class MoveZeroes {
	
	//1. move all the non-zero elements to the beginning of array
	//2. fill remaining array with zero
	public void solution1(int[] nums) {
		int j=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=0){
				nums[j++]=nums[i];
			}
		}
		while(j<nums.length)
			nums[j++]=0;
	}
	
	public static void main(String[] args) {
		int nums[]= {0,1,0,3,12};
		MoveZeroes moveZeroes=new MoveZeroes();
		moveZeroes.solution1(nums);
		System.out.println(Arrays.toString(nums));
	}

}
