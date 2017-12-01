/*

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5
max. difference = 6-1 = 5

Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.

*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int max=0, temp=prices[0];
        //设置一个temp,记录到目前为止出现的最小值
        for(int i=0;i<prices.length;i++){
            if(prices[i]<temp)
                temp = prices[i];
            else
                max = Math.max(max, prices[i]-temp);
        }
        return max;
    }
}
