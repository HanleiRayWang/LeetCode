/*


The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

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
class Solution {
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.val;
        if(root.left==null)
            return Math.max(rob(root.right),root.val+rob(root.right.left)+rob(root.right.right));
        if(root.right==null)
            return Math.max(rob(root.left),root.val+rob(root.left.left)+rob(root.left.right));
        int a = root.val+rob(root.left.left)+rob(root.left.right)+rob(root.right.left)+rob(root.right.right);
        int b = rob(root.left)+rob(root.right);
        return Math.max(a,b);
    }
}
