/*

Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.

*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()<1)
            return 0;
            
        //map中存放各字符的最近一次出现的位置
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        //low和high指出了符合题目要求的substring的范围
        int low=0, high=0;
        
        //result是最终的substring长度
        int result = 0;
        
        //用high遍历整个字符串
        while(high<s.length()){
        
            //如果map.size()<2，说明当前字符串还没出现第二个字符
            //如果map.size()=2，说明当前字符串还没出现第三个字符，虽然需要判断新字符是否已经存在在map里，但是可以留到第二个if那边去判断
            if(map.size()<=2){
                char c = s.charAt(high);
                map.put(c,high);
                high++;
            }
            
            
            //map.size()>2，说明当前字符串已经有三个字符，那么需要找到出现在最左侧的那个字符并删除，同时更新low和result的数值
            if(map.size()>2){
                int leftMost = s.length();
                for(int index : map.values())
                    leftMost = Math.min(leftMost, index);
                char c = s.charAt(leftMost);
                map.remove(c);
                low = leftMost+1;
            }
            result = Math.max(result, high-low);
        }
        return result;
    }
}
