/*

Given two non-empty binary trees s and t, 
check whether tree t has exactly the same structure and node values with a subtree of s. 
A subtree of s is a tree consists of a node in s and all of this node's descendants. 
The tree s could also be considered as a subtree of itself.

*/



class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        
        //如果s与t相同
        if(isSameTree(s,t)) return true;
        
        //如果t在s的左支或者右支
        return isSubTree(s.left,t) || isSubTree(s.right,t);
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
