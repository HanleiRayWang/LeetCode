/*

Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

*/

//参考Leetcode159,几乎完全相同的题目

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length()==0)
            return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int low=0, high=0;
        int result=0;
        while(high<s.length()){
            if(map.size()<=k){
                char c = s.charAt(high);
                map.put(c,high);
                high++;
            }
            if(map.size()>k){
                int leftMost = s.length()-1;
                for(int index : map.values())
                    leftMost = Math.min(leftMost, index);
                map.remove(s.charAt(leftMost));
                low = leftMost+1;
            }
            result = Math.max(result, high-low);
        }
        return result;
    }
}
