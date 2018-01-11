/*

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //hashmap中放‘字符-位置’
        int max = 0;
        for(int i=0, j=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i))+1);
                //如果有重复的字符，那么j指向的是上一个重复字符的位置
                //注意这两个重复字符不一定是一样的，因此需要使用Math.max选中最靠近当前位置的那个重复点
                //即保证s字符串中从j到i位置没有重复字符
            map.put(s.charAt(i), i);        //每次都要更新
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
