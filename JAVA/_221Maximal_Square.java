/*

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.


*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return max;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(matrix[i][j]!='0'){
                    dp[i][j]+=1;
                    if(dp[i+1][j+1]!=0 && dp[i+1][j]!=0 && dp[i][j+1]!=0)
                        dp[i][j]+=Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
            

        return max*max;
    }
}
