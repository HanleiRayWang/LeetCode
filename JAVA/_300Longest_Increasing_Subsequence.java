/*

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

*/

// O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2)
            return nums.length;
        
        // This will be our array to track longest sequence length
        int[] T = new int[nums.length];
        for(int i=0;i<T.length;i++)
            T[i]=1;
        
        
        // Mark one pointer at i. For each i, start from j=0.
        for(int i=1;i<nums.length;i++)
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i])// It means next number contributes to increasing sequence.
                    T[i]=Math.max(T[i],T[j]+1);

        int result = 1;
        for(int i=0;i<T.length;i++)
            result=Math.max(result, T[i]);
        return result;
    }
}


// O(nlgn)
/*
  (1) if x is larger than all tails, append it, increase the size by 1
  (2) if tails[i-1] < x <= tails[i], update tails[i]
*/
public int lengthOfLIS(int[] nums) {

    //tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i]
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
        int i = 0, j = size;
        while (i != j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
                i = m + 1;
            else
                j = m;
        }
        tails[i] = x;
        if (i == size) ++size;
    }
    return size;
}
