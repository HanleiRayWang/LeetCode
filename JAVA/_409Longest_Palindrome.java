/*

Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

class Solution {
    public int longestPalindrome(String s) {
        int[] c = new int[128];
        for(int i=0;i<s.length();i++)
            c[s.charAt(i)]++;
        int len=0;
        int flag=0;
        for(int i=0;i<128;i++){
            if(c[i]%2==0)
                len+=c[i];
            else{
                len+=c[i]-1;
                flag=1;
            }   
        }
        if(flag==1)
            len+=1;
        return len;
    }
}
