/*

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

![Image of histogram1]
(https://leetcode.com/static/images/problemset/histogram.png)
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

![Image of histogram1_area]
(https://leetcode.com/static/images/problemset/histogram_area.png)
The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.



*/

//方法一，慢
//O(n^2)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0)
            return 0;
        int max=0;
        for(int i=0;i<heights.length;i++){
            //这个if是为了提高速度
            //如果当前height比后面的height小，那这种情况下算得的任何area肯定都不是最大值
            //因为后面的height更大，最起码长方形的宽可以增加一格，面积相应增加
            //所以只需要考虑heights[i]>heights[i+1]的情况
            if(i==heights.length-1 || heights[i]>heights[i+1]){
                int minHeight = heights[i];
                for(int j=i; j>=0;j--){
                    minHeight=Math.min(minHeight, heights[j]);
                    max = Math.max(max, minHeight*(i-j+1));
                }
            }
        }
        return max;
    }
    
}


//方法二，快
/O(n) using Stack
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }
}
