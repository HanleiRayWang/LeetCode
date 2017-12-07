/*

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]

*/

class Solution {
    public int maximumSwap(int num) {
        //把num变成char数组
        char[] digits = Integer.toString(num).toCharArray();
        
        //buckets记录每个digit最后的出现位置
        int[] buckets = new int[10];
        for(int i=0;i<digits.length;i++)
            buckets[digits[i]-'0']=i;
        
        for(int i=0;i<digits.length;i++){
            for(int j=9;j>digits[i]-'0';j--){//比digits[i]大
                if(buckets[j]>i){//出现在digits[i]的后面
                    char temp = digits[i];
                    digits[i]=digits[buckets[j]];
                    digits[buckets[j]]=temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
