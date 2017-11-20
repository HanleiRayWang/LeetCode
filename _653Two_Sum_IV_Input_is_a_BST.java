/*
Given a Binary Search Tree and a target number, 
return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

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
 
 
//方法一： O(n)time，O(n)space
//使用Hash把数值都存起来
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        return dfs(root, k, set);   
    }
    
    public boolean dfs(TreeNode root, int k, HashSet<Integer> set){
        if(root==null)
            return false;
        if(set.contains(k-root.val))
            return true;
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}

//方法二： O(n)time，O(n)space
//使用List按照顺序把Tree里的数据存起来
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        
        int i=0, j=list.size()-1;
        while(i<j){
            if(list.get(i)+list.get(j)==k)
                return true;
            if(list.get(i)+list.get(j)<k)
                i++;
            else
                j--;
        }
        return false;
    }
    
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
