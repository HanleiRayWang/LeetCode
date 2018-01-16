/*

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

*/


//traverse
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
    
    List<Integer> list = new LinkedList<Integer>();
    
    public int closestValue(TreeNode root, double target) {
        
        inorderTraverse(root);
        double delta = Double.MAX_VALUE;
        int result = 0;
        for(int i=0;i<list.size();i++){
            if(Math.abs(list.get(i)-target)<delta){
                delta = Math.abs(list.get(i)-target);
                result = list.get(i);
            }
        }
        return result;
    }
    
    public void inorderTraverse(TreeNode node){
        if(node==null)
            return;
        inorderTraverse(node.left);
        list.add(node.val);
        inorderTraverse(node.right);
    }
}



//recursion,利用了BST的性质
class Solution {
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target<a ? root.left : root.right;
        if(kid==null)
            return a;
        int b = closestValue(kid, target);
        if(Math.abs(a-target)<Math.abs(b-target))
            return a;
        return b;
    }
}
