/*


Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


*/


class Solution {
    public int subarraySum(int[] nums, int k) {
    
        int sum=0;
        
        //key是sum，value是个数
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //先放入(0,1)，有一个subarray的和是0
        map.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            //首先要注意到nums当中有正有负，因此和为x的subarray可能会有很多种
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
                
            //把每次的从头开始的累加和放入map
            if(!map.containsKey(sum))
                map.put(sum,1);
            else
                map.put(sum, map.get(sum)+1);
        }
        return count;
    }
}
