/*

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=0;
                while(j<needle.length()){
                    if(haystack.charAt(i+j)!=needle.charAt(j))
                        break;
                    j++;
                }
                if(j==needle.length())
                    return i;
            }
        }
        return -1;
    }
}

//一种elegent的写法，白眼翻到天上去~
class Solution {
    public int strStr(String haystack, String needle) {
      for (int i = 0; ; i++) {
        for (int j = 0; ; j++) {
          if (j == needle.length())
              return i;
          if (i + j == haystack.length())
              return -1;
          if (needle.charAt(j) != haystack.charAt(i + j)) 
              break;
        }
      }
    }
}
