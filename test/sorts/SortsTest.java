package test.java.sorts;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class SortsTest {

	@Test
	public void test1() {
		int[] nums= new int[100];
		for(int i=0;i<200;i++) {
			generate(nums);
//			sorts.Sorts.quickSort(nums);
			
			assertTrue(verify(nums));
		}
	}

	private void generate(int[] nums) {
		Random random = new Random();
		for(int i=0;i<nums.length;i++) {
			nums[i]=random.nextInt(500)-250;
		}
	}

	private boolean verify(int[] nums) {
		boolean res = true;
		int temp = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<temp) {
				res = false;
				break;
			}
			temp = nums[i];
		}
		return res;
	}

}
