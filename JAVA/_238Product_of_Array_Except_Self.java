/*

Given an array of n integers where n > 1, nums, 
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).
Solve it with constant space complexity.
For example, given [1,2,3,4], return [24,12,8,6].
Note: The output array does not count as extra space for the purpose of space complexity analysis.

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0]=1;
        for(int i=1;i<nums.length;i++)
            result[i]=result[i-1]*nums[i-1];
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}


/*

[1,2,3,4]为例
先正序
          1                2                 3                  4
          x                1                1,2               1,2,3
          |right=2,3,4     |right=3,4        |right=4           |right=1
          V                V                 V                  V
        2,3,4            1,3,4             1,2,4              1,2,3

*/
