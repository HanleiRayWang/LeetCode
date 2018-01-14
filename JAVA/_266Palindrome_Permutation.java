/*

Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] c = new int[256];
        for(int i=0;i<s.length();i++)
            c[s.charAt(i)]++;
        int count=0;
        for(int i=0;i<256;i++){
            if(c[i]%2==1){
                if(count!=0)
                    return false;
                count++;
            }
        }
        return true; 
    }
}
