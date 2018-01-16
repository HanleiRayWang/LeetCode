/*

Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

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

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> s1 = new Stack<Integer>();//predecessors
        Stack<Integer> s2 = new Stack<Integer>();
        
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        
        while(k-- >0){
            if(s1.isEmpty())
                result.add(s2.pop());
            else if(s2.isEmpty())
                result.add(s1.pop());
            else if(Math.abs(s1.peek()-target)<Math.abs(s2.peek()-target))
                result.add(s1.pop());
            else
                result.add(s2.pop());
        }
    }
    
    public void inorder(TreeNode node, double target, boolean reverse, Stack<Integer> stack){
        if(node==null)
            return;
        inorder(reverse?node.right:node.left, target, reverse, stack);
        
        //early termination, no need to traverse the whole tree
        if((reverse && node.val<=target) || (!reverse && root.val>target))
            return;
        
        //track the current node value
        stack.push(node.val);
        inorder(reverse?node.left:node.right, target, reverse, stack);
    }
}
