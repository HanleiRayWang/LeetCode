/*

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

*/



//Time: O(n), Space: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || k<=0)
			return new int[0];
        int[] result = new int[nums.length-k+1];
        
        //deque里面存储每个num的位置，不是存储num
        //使用双端队列，deque最大size为k，并且deque中index指向的数值单调递减
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i=0;i<nums.length;i++){
            
            //remove numbers out of range k
            //要注意deque并不是所有的数值的index都放
            //只放在k范围内，以k范围内最大值开始，单调递减的部分
            //因此这里不能使用deque.size()==k,只能根据deque.peek()来判断deque时候已经达到了size==k
            if(!deque.isEmpty() && deque.peek()==i-k)
                deque.poll();
            
            //remove smaller numbers in k range as they are useless
            //这个while保证了deque里index指向的数值单调递减
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
                deque.pollLast();
            
            //上面的while保证了当前nums[i]可以安全的压入deque并且是deque中最小的数值
            deque.offer(i);
            if(i>=k-1)
                result[i-k+1]=nums[deque.peek()];
        }
        return result;
    }
}
