/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.

*/

class Solution {
    public int search(int[] nums, int target) {
        
        int low=0, high=nums.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            //nums[high]是rotate点之后的最大值
            //如果nums[mid]比他大，那么说明mid落到了low~rotate点以内，也就是rotate点在mid~high之间
            //那么为了找到rotate点，需要把low=mid+1
            if(nums[mid]>nums[high])
                low=mid+1;
            //如果nums[mid]比他小，说明mid落到了rotate~high点以内，也就是rotate点在low~mid之间
            else
                high=mid;
        }
        
        //以下做正常的binary search
        int rotate=low;//也可以rotate=high;
        low=0; high=nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int realmid = (mid+rotate)%nums.length;
            if(nums[realmid]==target)
                return realmid;
            if(nums[realmid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}
