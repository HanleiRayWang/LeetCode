/*

Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].



*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int index=-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(index!=-1)
                    return false;
                index=i;
            }   
        }
        //index==-1说明整个nums单调递增
        //index==0说明nums[0]比nums[1]大，肯定可以通过修改nums[0]达成单调递增序列
        //index==nums.length-2说明nums[len-2]比nums[len-1]大，肯定可以通过修改nums[len-1]达成单调递增序列
        if(index==-1 || index==0 || index==nums.length-2)
            return true;
            
        //剩下的情况就只有，nums中只有一处递减数对，那么只有以下两种情况才可能成功
        if(nums[index-1]<=nums[index+1] || nums[index]<=nums[index+2])
            return true;
        return false;
                
    }
}
