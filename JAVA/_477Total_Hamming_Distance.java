/*

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2
Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.

*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        int result =0;
        for(int i=0;i<32;i++){
            int one=0, zero=0;
            for(int j=0;j<nums.length;j++){
                //注意这里只能使用 ！=0 不能使用 ==1
                //因为&出来的结果为1，2，4，8，16等对应该位的数值并不是1
                if( (nums[j] & (1<<i)) !=0 )
                    one++;
                else zero++;
            }
            result+=one*zero;
        }
        return result;
    }

}
