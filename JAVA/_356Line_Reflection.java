/*

Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

*/

class Solution {
    public boolean isReflected(int[][] points) {


        HashSet<String> set = new HashSet<String>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            max = Math.max(max, points[i][0]);
            min = Math.min(min, points[i][0]);
            String str = points[i][0] + "," + points[i][1];
            set.add(str);
        }
        int sum = max+min;
        for(int i=0;i<points.length;i++){
            String str = (sum-points[i][0]) + "," + points[i][1];
            if(!set.contains(str))
                return false;
        }
        return true;
    }
}
