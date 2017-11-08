/*

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
Example 1:
Input: "aba"   Output: True
Example 2:
Input: "abca"  Output: True
Explanation: You could delete the character 'c'.

Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


*/

class Solution {
    public boolean validPalindrome(String s) {

        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            i++;j--;
        }
        return true;
    }
    
    public boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;right--;
        }
        return true;
    }
}
