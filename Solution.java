// Java program to print all the node to leaf path
  
/* A binary tree node has data, pointer to left child
   and a pointer to right child */
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
}
public class Solution {
    static TreeNode root;
    Stack s=new Stack();
    public int getLeafNodes(TreeNode root){
        if(root==null)
            return 0;
        else if((root.left==null) && (root.right==null)){
            s.push(root.val);
            return 1;
        }
        else 
            return getLeafNodes(root.left)+getLeafNodes(root.right);
    }
    public boolean getPath(TreeNode root,int key,ArrayList<Integer> path){
        if(root==null)
            return false;
        if((root.val==key)&& ((root.left==null) && (root.right==null))){
            path.add(root.val);
            return true;
        }
        boolean left_node=getPath(root.left,key,path);
        boolean right_node=getPath(root.right,key,path);
        if(left_node || right_node){
            path.add(root.val);
            return true;
        }
        return false;
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<Integer> al;
        ArrayList<ArrayList<Integer>> al1=new ArrayList<ArrayList<Integer>>();
        int sum;
        getLeafNodes(A);
        while(!s.empty()){
            int n=(int)s.pop();
            sum=0;
            al=new ArrayList<Integer>();
            getPath(A,n,al);
            // System.out.println(al);
            // System.out.println("check");
            for(Integer num: al){
                sum=sum+num;
            }
            if(sum == B){
                // System.out.println("check");
                Collections.reverse(al);
                al1.add(al);
                Collections.reverse(al1);
            }
        }
        return al1;
    }
    public static void main(String args[]) 
    {
        Solution s = new Solution();
        // tree.root = new Node(10);
        // tree.root.left = new Node(8);
        // tree.root.right = new Node(2);
        // tree.root.left.left = new Node(3);
        // tree.root.left.right = new Node(5);
        // tree.root.right.left = new Node(2);

        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        // tree.root.left.left=new Node(11);
        // tree.root.left.left.left=new Node(7);
        // tree.root.left.left.right=new Node(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        // tree.root.right.right=new Node(4);
        // tree.root.right.right.left=new Node(5);
        root.right.left.right=new TreeNode(5);
        System.out.println(s.pathSum(root,13));
         
        /* Let us test the built tree by printing Insorder traversal */
        // tree.printPaths(tree.root);
        // tree.getLeafNode(root);
        // tree.display();
        // tree.getLeafNode(22);
    }
}
 
// This code has been contributed by Mayank Jaiswal