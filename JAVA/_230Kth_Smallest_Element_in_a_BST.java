/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?

*/


//方法一
//Inorder Traversal, traverse到第K的时候输出
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            k--;
            if(k==0)
                break;
            root=root.right;
        }
        
        
        return root.val;
    }
}


// 方法二，更优解
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count=count(root.left);
        if(k<=count)
            return kthSmallest(root.left, k);
        else if(k>count+1)
            return kthSmallest(root.right, k-1-count);//1 si counted as current node
//      else 就只可能是k==count+1的情况
        return root.val;
    }
    
    public static int count(TreeNode root){
        if(root==null)
            return 0;
        return 1+count(root.left)+count(root.right);
    }
}
