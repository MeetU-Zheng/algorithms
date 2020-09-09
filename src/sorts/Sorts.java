package sorts;

import java.util.Arrays;

public class Sorts {

	// 交换两个数
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
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
	
	//插入减少一个判断
	public static void insertionSort2(int [] nums) {
		for(int i=1;i<nums.length;i++) {
			int n=i;
			int tmp = nums[i];
			while(--n >= 0) {
				if(nums[n]>tmp)
					nums[n+1] = nums[n];
				else
					break;
			}
			nums[n+1]=tmp;
		}
	}
	
	//给插入排序多加一个希尔排序的增量
	public static void insertionSort3(int[] nums, int gap) {
		for(int i=0;i<gap;i++) {
			for(int j=i+gap;j< nums.length;j++) {
				int n=j;
				int tmp = nums[n];
				while((n-=gap)>=0) {
					if(nums[n]> tmp)
						nums[n+gap]=nums[n];
					else
						break;
				}
				nums[n+gap]=tmp;
			}
		}
	}

	// TODO:希尔排序
	// TODO:希尔排序仍然有多余的交换和移动，怎么解决
	public static void shellSort(int[] nums) {
		int gap = nums.length;
		while(gap>0) {
			gap/=2;
			//插入排序
			insertionSort3(nums, gap);
		}
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
		quickSortRecur(nums, 0, nums.length-1);
	}
	
	private static void quickSortRecur(int[] nums, int left, int right) {
		if(left>=right) return;
		int p = partition(nums, left, right);
		quickSortRecur(nums, left, p-1);
		quickSortRecur(nums, p+1, right);
	}
	//返回中间值下标，下标小于该返回值则对应数组元素小于中间值，下标大于……
	private static int partition(int[] nums, int left, int right) {
		int index=getPivotIndex(nums, left, right);
		swap(nums, index, right);
		
		int i,j;
		for(i=0,j=0;j<right;j++) {
			if(nums[j] < nums[right]) 
				swap(nums, i++, j);
		}
		swap(nums, i, right);
		return i;
	}
	
	//优化基准值的选取，防止快排性能退化
	//默认返回最右下标
	private static int getPivotIndex(int[] nums, int left, int right) {
		return right;
	}
	
	

	// TODO:桶排序
	public static void bucketSort(int[] nums) {

	}

	// TODO:堆排序
	public static void heapSort(int[] nums) {

	}
	
	// TODO:TimSort
	public static void timSort(int[] nums) {
		
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 4, 2, 1, 5, 6, 7, 8 };
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}

}
