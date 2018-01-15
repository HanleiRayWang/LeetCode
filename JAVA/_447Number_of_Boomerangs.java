/*


Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

*/



//因为只需要求最后的可能排列数，因此使用DP，或者说一步一步累加
//如果需要具体求出所有排列，则需要用backtracking
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result=0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //O(n^2)
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j)
                    continue;
                //取到两点的间距
                int d = distance(points[i],points[j]);
                //如果第一次出现此间距，计数置1
                //如果之前出现过此间距，计数增1
                map.put(d, map.getOrDefault(d,0)+1);
            }
            
            //上面的for循环之后，得到了所有的距离排列统计
            //现在针对map的所有value做遍历并累加即可
            //val*(val-1)的意思是，如果以当前d为间距的一共有val个点，那么选中一个点作为中心点之后，有val-1中情况可以选择另外一个点
            for(int val : map.values())
                result += val * (val-1);
            
            //重新清空map，以方便下一次循环
            map.clear();
        }
        
        return result;
    }
    
    public int distance(int[] a, int[] b){
        int dx=a[0]-b[0];
        int dy=a[1]-b[1];
        return dx*dx + dy*dy;
    }
}
