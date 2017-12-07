/*

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

public class Solution{
    public List<List<Integer>> threeSum(int[] nums){
      
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
      
        for(int i=0;i<nums.length;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low = i+1, high = nums.length-1;
                while(low<high){
                    //三个数的index分别是i，low，high
                    int sum= nums[i]+nums[low]+nums[high];
                    if(sum==0){
                        result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        
                        //用两个while，跳过重复的元素
                        while(low<high && nums[low]==nums[low+1])
                            low++;
                        while(low<high && nums[high-1]==nums[high])
                            high--;
                      
                        //单独分别各收紧两端
                        low++;
                        high--;
                    }else if(sum<0)
                        low++;
                    else high--;
                }
            }
        }
        return result;
    }
}
