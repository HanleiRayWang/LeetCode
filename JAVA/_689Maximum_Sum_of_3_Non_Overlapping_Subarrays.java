/*

In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example:
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Note:
nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).

*/

//O(n),以中段位置做循环
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i=0;i<n;i++)
            sum[i+1]=sum[i]+nums[i];
        
        //posLeft的
        int[] posLeft = new int[n];
        //i表示中段的开始位置
        for(int i=k, total=sum[k]-sum[0];i<n-2*k;i++){
        
            //左段 [i-k,i)
            //但是为了方便计算，sum最前面加入了sum[0]=0
            //所以左段应该是sum[i+1]-sum[i+1-k]
            //注意是 >total
            if(sum[i+1]-sum[i+1-k]>total){
                total = sum[i+1]-sum[i+1-k];
                posLeft[i]=i+1-k;
            }else
                posLeft[i]=posLeft[i-1];
        }

        
        int[] posRight = new int[n];
        //i表示右段的开始位置
        for(int i=n-k, total=sum[n]-sum[n-k];i>=2*k;i--){
            //右段 [i,i+k)
            //注意是 >=total
            if(sum[i+k]-sum[i]>=total){
                total= sum[i+k]-sum[i];
                posRight[i] = i;
            }else
                posRight[i]=posRight[i+1];
        }
        
        int max = 0;
        int[] answer = new int[3];
        for(int i=k;i<=n-2*k;i++){
            //左段 [l,l+k)
            //中段 [i,i+k)
            //右段 [r,r+k)
            int l = posLeft[i-1];
            int r = posRight[i+k];
            int total = (sum[l+k]-sum[l])+(sum[i+k]-sum[i])+(sum[r+k]-sum[r]);
            if(total>max){
                max = total;
                answer[0]=l;
                answer[1]=i;
                answer[2]=r;
            }
        }
        return answer;
        
    }
}
