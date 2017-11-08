/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

*/



class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()<2)
            return true;
        
        //不要忘记了全部变成lowercase
        s=s.toLowerCase();
        
        int i=0,j=s.length()-1;
        while(i<=j){
            if(!isAlphaNumeric(s.charAt(i)))
                i++;
            else if(!isAlphaNumeric(s.charAt(j)))
                j--;
            else{
                if(s.charAt(i)!=s.charAt(j))
                    return false;
                i++;j--;
            }
        }
        return true;

    }
    
    public boolean isAlphaNumeric(Character c){
        if(c>='0' && c<='9')
            return true;
        if(c>='a' && c<='z')
            return true;
        if(c>='A' && c<='Z')
            return true;
        return false;
    }
}
