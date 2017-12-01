/*

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

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
 
 
//recursive
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root!=null)
            search(root,"",result);
        return result;
    }
    
    public void search(TreeNode root, String path, List<String> result){
        if(root.left==null && root.right==null)
            result.add(path+root.val);
        if(root.left!=null)
            search(root.left,path+root.val+"->",result);
        if(root.right!=null)
            search(root.right,path+root.val+"->",result);
    }
}


//non-recursive
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root==null)
            return result;
        if(root.left==null && root.right==null){
            result.add(root.val+"");
            return result;
        }
        if(root.left!=null)
            for(String str : binaryTreePaths(root.left))
                result.add(root.val+"->"+str);
        
        if(root.right!=null)
            for(String str : binaryTreePaths(root.right))
                result.add(root.val+"->"+str);
            
        return result;
    }
}
