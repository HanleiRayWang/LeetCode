/*

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.

*/

class NumMatrix {
    /*
      思路就是创建一个colsum二维数组（或者rowsum）
      每个点上存储每一列的累加（或者每一行）
      update的复杂度就是O(n),sumRegion的复杂度就是O(m)
      如果使用rowsum
      update的复杂度就是O(m),sumRegion的复杂度就是O(n)
      
    */

    
    //We use colSums[i][j] = the sum of ( matrix[0][j], matrix[1][j], matrix[2][j],…,matrix[i - 1][j] ).
    int[][] colSums;
    int[][] matrix;
    int m;
    int n;
    
    public NumMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        //存下matrix才能在update中使用，这里的this.matrix只是个指针而已
        colSums = new int[m+1][n];
        
        
        // colSums[i][j] = colSums[i][0] + rowSums[i][1] + ... + rowSums[i][j]
        for(int i=1;i<=m;i++)
            for(int j=0;j<n;j++)
                colSums[i][j]=colSums[i-1][j]+matrix[i-1][j];
    }
    
    //O(n)
    public void update(int row, int col, int val) {
        for(int i=row+1; i<colSums.length; i++)
            colSums[i][col] = colSums[i][col]-matrix[row][col]+val;
        matrix[row][col]=val;
            
    }
    
    
    //O(m)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result=0;
        for(int j=col1; j<=col2;j++)
            result+= colSums[row2+1][j]-colSums[row1][j];
        return result;
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
