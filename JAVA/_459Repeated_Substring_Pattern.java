/*

Given a non-empty string check if it can be constructed by taking a substring of it 
and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

*/


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()<2)
            return false;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(0)){
                if(s.length()%i!=0)
                    continue;
                String temp = s.substring(0,i);
                System.out.println(temp);
                int j=0;
                while(j<s.length()/i){
                    if(!s.substring(j*i,j*i+i).equals(temp))
                        break;
                    j++;
                } 
                if(j==s.length()/i)
                    return true;
            }
        }
        return false;
    }
}
