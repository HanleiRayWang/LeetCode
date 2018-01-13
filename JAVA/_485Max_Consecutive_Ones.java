/*

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curLen=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
                curLen++;
            else{
                max = Math.max(max, curLen);
                curLen=0;
            }  
        }
        max = Math.max(max, curLen);
        //这最后一个max是用来处理corner-case的
        //比如输入nums为[1]的时候，max=0, curLen=1,必须有这一行才正确
        return max;
    }
}
