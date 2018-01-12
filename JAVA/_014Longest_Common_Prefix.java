/*

Write a function to find the longest common prefix string amongst an array of strings.

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        int len = Integer.MAX_VALUE;
        for(String str : strs)
            len = Math.min(str.length());
        int i=0;
        while(i<len){
            for(String str : strs)
                if(str.charAt(i)!=strs[0].charAt(i))
                    return strs[0].substring(0,i);
            i++;
        }
        return strs[0].substring(0,len);
    }
}
