/*

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

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
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max=0;
    
    
    public int[] findMode(TreeNode root) {
        List<Integer> list =new LinkedList<Integer>();
        inorderTraverse(root);
        
        for(int key : map.keySet()){
            if(map.get(key)==max)
                list.add(key);
        }
        
        int[] result = new int[list.size()];
        for(int i=0;i<result.length;i++)
            result[i]=list.get(i);
        return result;
    }
    
    public void inorderTraverse(TreeNode node){
        if(node==null)
            return ;
        inorderTraverse(node.left);
        if(!map.containsKey(node.val))
            map.put(node.val,1);
        else
            map.put(node.val, map.get(node.val)+1);
        max = Math.max(max, map.get(node.val));
        inorderTraverse(node.right);
    }
}
