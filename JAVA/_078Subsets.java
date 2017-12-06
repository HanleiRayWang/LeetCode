/*

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int num : nums){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> line : result){
                List<Integer> a = new ArrayList<Integer>(line);
                a.add(num);
                temp.add(a);
            }
            result.addAll(temp);
        }
        return result;
    }
}

