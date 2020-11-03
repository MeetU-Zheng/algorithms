package binary_search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//LeetCode 349
public class IntersectionOfTwoArrays {

	//先排序，再双指针
	public int[] solution1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Set<Integer> set = new HashSet<Integer>();
		int i =0,j=0;
		while(i< nums1.length && j < nums2.length) {
			if(nums1[i] > nums2[j])
				j++;
			else if (nums1[i] < nums2[j]) 
				i++;
			else {
				set.add(nums1[i++]);
			}
		}
		int res[] = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		i = 0;
		while(it.hasNext()) {
			res[i++]=it.next();
		}
		return res;
	}
	
	public static void main(String[] args) {
		
	}

}
