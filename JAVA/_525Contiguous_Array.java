/*

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000.

*/

class Solution {
    public int findMaxLength(int[] nums) {
        
        //HashMap 用于存储的key-value
        //key表示当前 （0的个数-1的个数）
        //value表示    对应差值所在的位置
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result=0;
        int zero=0, one=0;
        
        //因为要返回长度，所以（0的个数-1的个数）==0 时，result=i+1,所以在最开始要放入(key-value)---(0-1)
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
                one++;
            else zero++;
            
            //如果map中出现过现在的（0的个数-1的个数），说明从map中的那个value点开始到i这个subarray，0、1个数是相同的
            if(map.containsKey(zero-one))
                result=Math.max(result, i-map.get(zero-one));
            else
                map.put(zero-one, i);
            
        }
        return result;
        
    }
}
