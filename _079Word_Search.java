/*

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

*/


/*
一开始想用一个global的count计数，count=word.length()时即可返回true
但是，如上方例子中的SEE，count会得到4，因为以S出发，一共有4个char可以被match，因此这种方法不可取
XXXE
XXXS
XXEE
*/


class Solution {
    
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(dfs(board, i, j, word, 0))
                    return true;
            }  
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int start){
        if(start>=word.length())
            return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(start)!=board[i][j])
            return false;

        //可以开辟一个visited[][]， 但是这种方法节省空间
        //记录board[i][j]，那么之后改变board的值，再作为参数给入四个dfs
        char c = board[i][j];
        board[i][j]='#';
        start++;
        boolean result = dfs(board,i+1,j,word, start) || dfs(board,i-1,j,word, start) || 
                         dfs(board,i,j-1,word, start) || dfs(board,i,j+1,word, start);
        //一定要改回原值，不然就会出现在遍历中board值有#的情况
        board[i][j]=c;
        return result;
    }
}
