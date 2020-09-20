package competition;

/***
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *  子数组 定义为原数组中的一个连续子序列。 请你返回 arr 中
 * 所有奇数长度子数组的和 。
 *
 */
public class SumOddLengthSubarrays {
	public int solution1(int[] arr) {
		
		int len = arr.length;
		//n表示奇数的数量。
		int n= (len+1)/2;
		int ans=0;
		
		for(int i=0;i<n;i++) {
			//当前的奇数
			int curr=i*2+1;
			//j表示当前的下标
			for(int j=0;j<len;j++) {
				ans+=arr[j]*(Math.min(Math.min(curr,Math.min(len-j,j+1)),len-curr+1));
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		int[] arr= {1,4,2,5,3};
		System.out.println(
				new SumOddLengthSubarrays().solution1(arr));
	}
}
