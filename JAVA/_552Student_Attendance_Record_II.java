/*

Given a positive integer n, return the number of all possible attendance records with length n, 
which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

A student attendance record is a string that only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8 
Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times. 
Note: The value of n won't exceed 100,000.

*/



/*

分析：
1.整个字符串没有A出现
  1）字符串以P结尾(P在i位置)
    dp[i]=dp[i-1]
  2）字符串以L结尾,需要排除以‘PLLL’结尾的情况,最后一个L在i位置
    dp[i]=dp[i-1]-dp[i-4]
    
这一步计算之后，dp[n]中存储的数值就是没有A出现时所有可能的情况数量
新设一个long sum = dp[n];

2.整个字符串有一次A出现
  形式如，[1...i-1] A [i+1...n] ，A在i位置
  可能的情况数量=dp[i-1]*dp[n-i]
  这里等式的右侧都是不存在A的数值，通过第一步计算已经存储在dp[]中
  所以需要另外
*/



class Solution {
    private long M = 1000000007;
    public int checkRecord(int n) {
        
        long[] dp = new long[n<4?4:n+1];
        
        //without A
        dp[0]=1;
        dp[1]=2;
        dp[2]=4;
        dp[3]=7;//exclude 'LLL'
        for(int i=4;i<=n;i++)
            //dp[i]=(dp[i-1] + (dp[i-1]-dp[i-4]))%M;
            dp[i]=(2*dp[i-1])%M + (M-dp[i-4])%M;
        long sum = dp[n];
        
        //with A
        for(int i=1;i<=n;i++)
            sum+=(dp[i-1]*dp[n-i])%M;
        return (int)(sum%M);
    }
}
