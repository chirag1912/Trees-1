//Challenges faced: Understand ing decl class variable prev is working while decl local variable is not working(1:24 min in BST vid lecture)
//TC: O(N)
//SC: O(h)  //height of the BST tree given;

class Solution {
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        // boolean isValid;
        
        isValid=true;
        inorder(root);
        return isValid;
    }
    
    public void inorder(TreeNode root){
        TreeNode prev=null;
        
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        if(prev!=null && prev.val>=root.val){
            isValid=false;
            return;
        }
        prev=root;    
        inorder(root.right);
    }
    
}
