/*
Given two sparse matrices A and B, return the result of AB.
You may assume that A's column number is equal to B's row number.

Example:
A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |


C[ i ][ 0 ]=A[ i ][0]*B[0][0] + A[i][1]*B[1][0] + A[i][2]*B[2][0] + ... A[i][k]B[k][0] .... A[i][K]*B[K][0]
C[ i ][ 1 ]=A[ i ][0]*B[0][1] + A[i][1]*B[1][1] + A[i][2]*B[2][1] + ... A[i][k]B[k][1] .... A[i][K]*B[K][1]
C[ i ][ 2 ]=A[ i ][0]*B[0][2] + A[i][1]*B[1][2] + A[i][2]*B[2][2] + ... A[i][k]B[k][2] .... A[i][K]*B[K][2]
C[ i ][ 3 ]=A[ i ][0]*B[0][3] + A[i][1]*B[1][3] + A[i][2]*B[2][3] + ... A[i][k]B[k][3] .... A[i][K]*B[K][3]
C[ i ][ 4 ]=A[ i ][0]*B[0][4] + A[i][1]*B[1][4] + A[i][2]*B[2][4] + ... A[i][k]B[k][4] .... A[i][K]*B[K][4]
C[ i ][ 5 ]=A[ i ][0]*B[0][5] + A[i][1]*B[1][5] + A[i][2]*B[2][5] + ... A[i][k]B[k][5] .... A[i][K]*B[K][5]
...
C[ i ][ nB ]=A[ i ][0]*B[0][nB] + A[i][1]*B[1][nB] + A[i][2]*B[2][nB] + ... A[i][k]B[k][nB] .... A[i][K]*B[K][nB]


//如果按照正常的矩阵乘法算法，应该写如下结果
//对于每个result都是单独一次算完
    public int[][] multiply(int[][] A, int[][] B) {
        int a=A.length, b=A[0].length,c=B[0].length;
        int[][] result = new int[a][c];
        for(int i=0;i<a;i++){
            for(int j=0;j<c;j++){
                int sum=0;
                for(int k=0;k<b;k++){
                    sum+=A[i][k]*B[k][j];
                }
                result[i][j]=sum;
            }
        }
        return result;
    }

//但是如果是sparse metrix有很多0，这时候就可以采取分步计算的方法
//先计算A[i][0]*B[0][01234567....],这样就可以先判断A[i][0]是否为0,可以简化计算

*/

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int a=A.length, b=A[0].length,c=B[0].length;
        int[][] result = new int[a][c];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                //循环每个A中的元素
                if(A[i][j]!=0){
                    //以Aij为基础，将需要用到Aij的计算都完成
                    for(int k=0;k<c;k++)
                        result[i][k]+=A[i][j]*B[j][k];
                }
            }
        }
        return result;
    }
}
