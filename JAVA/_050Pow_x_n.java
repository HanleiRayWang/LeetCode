/*
Implement pow(x, n).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

*/

//recursive, 这个方法
//1.不需要检查Integer.MIN_VALUE时的情况
//2.不需要检查x=0时的情况（已经包括在n%2==0中）
class Solution {
    public double myPow(double x, int n) {

        if(n==0)
            return 1;

        double half= myPow(x, n/2);
        if(n%2==0)
            return half*half;
        //如果n为负数，需要将x翻转至分母
        else if(n<0)
            return half*half*(1/x);
        return half*half*x;
        
    }
}

