/*

Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

*/



class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0))
            return false;
        int reverted = 0;
        while(x>reverted){
            reverted = reverted*10+x%10;
            x/=10;
        }
        return x==reverted || x==reverted/10;
        //注意这里只能是x==reverted/10，因为只允许x<reverted，并且因为是reverse了x的一半
    }
}

