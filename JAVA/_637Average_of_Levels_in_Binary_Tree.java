/*

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.

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
    public List<Double> averageOfLevels(TreeNode root) {
    
        List<Double> result = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root==null)
            return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();         //记录当前层的节点数
            double sum=0.0;             //记录当前层的节点值之和
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            result.add(sum/n);
        }        

        return result;
    }
}
