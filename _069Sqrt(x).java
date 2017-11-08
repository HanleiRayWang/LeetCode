/*

Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.

*/


class Solution {
    public int mySqrt(int x) {
        
        if(x==0)
            return x;
        
        int left=1, right=x;
        while(true){
            int mid=left+(right-left)/2;
            
            //写成 mid>x/mid 而不是 mid*mid>x 是为了防止mid*mid形成integer overflow
            if(mid> x/mid)
                right=mid-1;
            else{
                if(mid+1>x/(mid+1))
                    return mid;
                left=mid+1;
            }
        }
    }
}
