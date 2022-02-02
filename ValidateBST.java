//Doing with Iterative Version:
//Two conditions: of while outer -> while(!stack.isEmpty() || !root==null){}    //No reason given as such
                        // inner-> while( !root=null) stack.push(root); root=root.left;
                        //  root=stack.pop() print(root); root=root.right;
class Solution {
    public boolean isValidBST(TreeNode root) {
     
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack=new Stack<>();
        
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            System.out.println(root.val);
            root=root.right;
        }
        return true;
    }
}



//Recursion:    For everytime a null is encountered the root value os printed; as going to left is not possible and right both being null;
//will make the root val to be printed and then makes it go right after printing the parent root node value;
//as inorder traversal;
//For leaf nodes get prited then parent root node and then the one on the right leaf as nul null return for root.left and root.right;

public boolean isValidBST(TreeNode root) {
        
        if(root==null){
            return false;
        }
        isValidBST(root.left);
        System.out.println(root.val);
        isValidBST(root.right);
        
        return true;
    }



//Challenges faced: Understand ing decl class variable prev is working while decl local variable is not working(1:24 min in BST vid lecture)
//TC: O(N)
//SC: O(h)  //height of the BST tree given;

class Solution {
    boolean isValid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        if(root==null){
            return false;
        }
        //So for doing the recursive call need to create one func() which if doesnot return is fine;
        isValid=true;
        inorder(root);  
        return isValid;
    }
    
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);         //in case of leaf node both these left/right will return;
             //else control moves to lleft side of the tree, value then right side of the tree;
        // System.out.println(root.val);
        
        if(prev!=null && prev.val>=root.val){
            isValid=false;
            return;
        }
        prev=root;
        inorder(root.right);
    }
}
