/*

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.


*/


//最佳方法，O(n)，没有brute，不sort，没有stack
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        //min记录从第一次递减开始，之后全部序列的最小值
        for(int i=1;i<nums.length;i++)
            if(nums[i]<nums[i-1])
                min = Math.min(min, nums[i]);
        //max记录从逆向第一次递增开始，之前全部序列的最大值
        for(int i=nums.length-2;i>=0;i--)
            if(nums[i]>nums[i+1])
                max = Math.max(max, nums[i]);
                
        //要注意，min和max并不是nums中全部数值的min和max，只是开始不符合递增nums的那个部分的min和max
        
        
        //确定了min和max之后，只要找到
        //nums中最左侧的不大于min的那个位置  --left
        //nums中最右侧的不小于max的那个位置  --right
        //图示可以参考方法五
        //https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/
        
        int left=0;
        while(left<nums.length && min>=nums[left])
            left++;
        
        int right=nums.length-1;
        while(right>=0 && max<=nums[right])
            right--;
        
        if(right<left)
            return 0;
        return right-left+1;
    }
}

//brute force, O(n^2)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length, right = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[j]<nums[i]){
                    right = Math.max(right, j);
                    left = Math.min(left, i);
                }
            }
        }
        if(right<left)
            return 0;
        else
            return right-left+1;
        
    }
}


//sort, O(nlgn)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = sorted.length, right = 0;
        for(int i=0;i<sorted.length;i++){
            if(sorted[i]!=nums[i]){
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        if(right<left)
            return 0;
        return right-left+1;
    }
}


//使用Stack，原理类似Leetcode239，O(n)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int left = nums.length, right = 0;
        
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i])
                left = Math.min(left, stack.pop());
            stack.push(i);
        }
        stack.clear();
        
        
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i])
                right = Math.max(right, stack.pop());
            stack.push(i);
        }
        
        
        if(right<left)
            return 0;
        return right-left+1;
    }
}
