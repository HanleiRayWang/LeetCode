/*

An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

*/

//naive, O(mn)
class Solution {
    public int minArea(char[][] image, int x, int y) {
        int up=x, down=x;
        int left=y, right=y;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++)
                if(image[i][j]=='1'){
                    up = Math.min(up, i);
                    down = Math.max(down, i+1);
                    left = Math.min(left, j);
                    right = Math.max(right, j+1);
                }
        }  
        return (right-left)*(down-up);
    }
}


//DFS, O(mn)
class Solution {
    
    private int up, down, left, right;
    
    public int minArea(char[][] image, int x, int y) {
        if(image.length==0 || image[0].length==0)
            return 0;
        up = x;
        down = x;
        left = y;
        right = y;
        return (right-left)*(up-down);
        
    }
    
    private void dfs(char[][] image, int x, int y){
        if(x<0 || y<0 || x>=image.length || >=image[0].length || image[x][y]=='0')
            return ;
        image[x][y]='0';
        up = Math.min(top, x);
        down = Math.max(down, x+1);
        left = Math.min(left, y);
        right = Math.max(right, y+1);
        dfs(image, x-1, y);
        dfs(image, x+1, y);
        dfs(image, x, y-1);
        dfs(image, x, y+1);
    }
}


//binary search, O(mlgn+nlgm)
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchColumns(image, 0, y, 0, m, true);
        int right = searchColumns(image, y + 1, n, 0, m, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') ++k;
            if (k < bottom == whiteToBlack) // k < bottom means the column mid has black pixel
                j = mid; //search the boundary in the smaller half
            else
                i = mid + 1; //search the boundary in the greater half
        }
        return i;
    }
    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') ++k;
            if (k < right == whiteToBlack) // k < right means the row mid has black pixel
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}
