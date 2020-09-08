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
			if (!flag)
				break;
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
			while (j-- > 0) {
				if (nums[j] > cur)
					nums[j + 1] = nums[j];
				else {
					nums[j + 1] = cur;
					break;
				}
			}
			if (j == -1)
				nums[0] = cur;
		}
	}

	// TODO:希尔排序
	public static void shellSort(int[] nums) {

	}

	// TODO:归并排序
	// 递归
	// TODO:如果原本的数组已排好序，该怎么判断
	public static void mergeSort1(int[] nums) {
		mergeSortRecur(nums, 0, nums.length - 1);
	}

	private static void mergeSortRecur(int[] nums, int left, int right) {
		if (left >= right)
			return;
		int mid = left + (right - left) / 2;
		mergeSortRecur(nums, left, mid);
		mergeSortRecur(nums, mid + 1, right);
		merge(nums, left, mid + 1, right);
	}

	// 能否化简
	private static void merge(int[] nums, int left, int p, int right) {
		//判断是否已排好序
		if (nums[p - 1] <= nums[p])
			return;
		int temp[] = new int[right - left + 1];
		int i = 0, j = left, k = p;
		while (i < temp.length) {
			if (j < p && k <= right)
				temp[i++] = nums[j] > nums[k] ? nums[k++] : nums[j++];
			else
				break;
		}
		while (j < p) {
			temp[i++] = nums[j++];
		}
		while (k <= right) {
			temp[i++] = nums[k++];
		}
		for (i = 0; i <= right - left; j++, i++) {
			nums[i + left] = temp[i];
		}
	}

	// TODO:快速排序
	public static void quickSort(int[] nums) {

	}

	// TODO:桶排序
	public static void bucketSort(int[] nums) {

	}

	// TODO:堆排序
	public static void heapSort(int[] nums) {

	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 4, 2, 1, 5, 6, 7, 8 };
		mergeSort1(array);
		System.out.println(Arrays.toString(array));
	}

}
