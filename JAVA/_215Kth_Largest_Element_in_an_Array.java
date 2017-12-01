/*


Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.


*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int num : nums){
            if(queue.size()<k)
                queue.add(num);
            else if(queue.peek()<num){
                    queue.poll();
                    queue.add(num);
            }
        }
        return queue.poll();
    }
}

//网上的答案，一个意思
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int num : nums){
            queue.add(num);
            if(queue.size()>k)
                queue.poll();
        }
        return queue.peek();
    }
}
