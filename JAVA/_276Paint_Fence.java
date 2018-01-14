/*

There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

*/


class Solution {
    public int numWays(int n, int k) {
        if(n==0)
            return 0;
        else if(n==1)
            return k;
        
        //diff代表之前的两个post颜色不同
        //same代表之前的两个post颜色相同
        int diffColorCounts = k * (k-1);
        int sameColorCounts = k;
        
        for (int i = 3; i <= n; i++) {
            int temp = diffCase;

            /**
             * To every diffCase we can add a new post with the same color as the last one to not generate violation - no
             * more than 2 adjacent fence posts have the same color.
             */
            sameCase = temp;
        }
        for(int i=2;i<n;i++){
            int temp = diffColorCounts;
            //如果新加入的post与之前的post颜色不同(不管之前的那俩是diff还是same)，那么到目前为止，一共有(diff+same)*(k-1)种情况
            diffColorCounts = (diffColorCounts+sameColorCounts)*(k-1);
            //如果新加入的post与之前的post颜色相同
            //因为no more than 2 adjacent same所以这种情况只能是之前那俩颜色diff的时候才能
            //如果之前那俩颜色same新加入的又same就有一连三个颜色相同了
            //那么多到目前为止，一共有原始diff即temp种情况
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }
}
