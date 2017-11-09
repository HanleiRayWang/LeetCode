/*
Implement pow(x, n).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

*/

//recursive
class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0){
            n=-n;
            x=1/x;
        }
        
        double half= pow(x*x, n/2);
        return (n%2==0)? half : half*x;
    }
}
