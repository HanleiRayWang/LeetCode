/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/

//recursive
class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length()==0)
            return "";
        
        //统计各字符出现的次数
        int[] count = new int[26];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;
        
        int pos=0;
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            
            //找到最小的字符，因为要保证smallest in lexicographical order
            if(current<s.charAt(pos))
                pos=i;
            //给当前的字符count减一
            count[current-'a']--;
            //如果count=0说明在charAt(i)之后不会再出现当前字符，那么说明必须在result中加入charAt(i)，因此在此处break
            if(count[current-'a']==0)
                break;
        }
        
        //首先是最小字符s.charAt(pos)，然后要把剩余s.substring(pos+1)中全部的s.charAt(pos)字符全去掉
        //然后将该字符串作为参数调用removeDuplicateLetters
        return s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }
}
