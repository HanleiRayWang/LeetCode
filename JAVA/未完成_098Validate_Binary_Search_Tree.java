/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.

Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 







/*
错误的做法
因为只能确定当前点的左右子点的大小关系，整体上的大小就无法track了
比如
      5
      /\
     2  8
    /\  /\
   1 10 3  12
   这种情况，10节点和3节点就无法被判断出来不符合BST
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null)
            return root.val<root.right.val && isValidBST(root.right);
        if(root.right==null)
            return root.val>root.left.val && isValidBST(root.left);
        return root.val<root.right.val && root.val>root.left.val && isValidBST(root.left) && isValidBST(root.right)  ;
    }
}
