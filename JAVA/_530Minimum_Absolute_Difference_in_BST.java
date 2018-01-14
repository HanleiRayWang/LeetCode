/*

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.

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
 
 
 //iterative, O(nlgn)
class Solution {
    public int getMinimumDifference(TreeNode root) {
        int diff=Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
        }
        int[] array = new int[list.size()];
        for(int i=0;i<list.size();i++)
            array[i]=list.get(i);
        Arrays.sort(array);
        for(int i=0;i<array.length-1;i++)
            diff=Math.min(diff, array[i+1]-array[i]);
        return diff;
        
    }
}



//recursive, O(n)
/*
The most common idea is to first inOrder traverse the tree 
and compare the delta between each of the adjacent values.
It’s guaranteed to have the correct answer because it is a BST thus inOrder traversal values are sorted.
*/
class Solution {

    int diff = Integer.MAX_VALUE;
    TreeNode prev = null;
    
    //inorder traverse
    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return diff;
        getMinimumDifference(root.left);
        if(prev!=null)
            diff=Math.min(diff, root.val-prev.val);
        prev=root;
        getMinimumDifference(root.right);
        return diff;
    }
}
