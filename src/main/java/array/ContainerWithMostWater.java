package array;

public class ContainerWithMostWater {
    public int solution1(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int h = height[left]<height[right]?height[left++]:height[right--];
            if(maxArea < h * width)
                maxArea = h * width;
        }
        return maxArea;
    }
}
