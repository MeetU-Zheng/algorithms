package sorts;

import java.util.Arrays;

public class Sorts {

	// 交换两个数
	private static void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	// 冒泡排序
	public static void bubbleSort(int[] nums) {
		int n = nums.length;
		while (--n > 0) {
			for (int j = 0; j < n; j++) {
				if (nums[j] > nums[j + 1])
					swap(nums, j, j + 1);
			}
		}
	}

	// 冒泡排序，加标志位判断是否已排序完
	public static void bubbleSort2(int[] nums) {
		int n = nums.length;
		while (--n > 0) {
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
					flag = true;
				}
			}
			if (!flag) break;
		}
	}

	// 选择排序
	public static void selectionSort(int[] nums) {
		int n = nums.length;
		while (--n > 0) {
			int index = 0;
			for (int i = 1; i <= n; i++) {
				if (nums[index] < nums[i])
					index = i;
			}
			swap(nums, n, index);
		}
	}

	// 插入排序
	public static void insertionSort(int[] nums) {
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			int j = i;
			int cur = nums[i];
			while(j-- > 0) {
				if(nums[j] > cur)
					nums[j+1] = nums[j];
				else {
					nums[j+1]=cur;
					break;
				}
			}
			if(j == -1)
				nums[0] = cur;
		}
	}
	
	//希尔排序
	public static void shellSort(int[] nums) {
		
	}
	
	//归并排序
	public static void mergeSort(int[] nums) {
		
	}
	
	//快速排序
	public static void quickSort(int[] nums) {
		
	}
	
	//桶排序
	public static void bucketSort(int[] nums) {
		
	}
	
	public static void main(String[] args) {
		int[] array = new int[] { 3, 4, 2, 1, 5, 6, 7, 8 };
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
