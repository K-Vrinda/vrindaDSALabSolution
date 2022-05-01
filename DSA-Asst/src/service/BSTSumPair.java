package service;

import java.util.HashSet;
//moving this class to main class as getting issues after declaring node class as static

public class BSTSumPair {
	static class Node {
        int data;
        Node left, right;
};
    static Node createNewNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }
 
    static Node insert(Node root, int key){
        if (root == null) {
            return createNewNode(key);
        }
        if (key > root.data) {
        	root.right = insert(root.right, key);
        }else {
           	root.left = insert(root.left, key);
        }
        return root;
    }
	public BSTSumPair() {}
 
    public boolean helper(Node root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
 
        if (helper(root.left, sum, set)) {
            return true;
        }
 
        if (set.contains(sum - root.data)) {
            System.out.println("Pair is (" + (sum - root.data) + ", " + root.data + ")");
            return true;
        }
        else {
            set.add(root.data);
        }
        
        return helper(root.right, sum, set);
    }
 
    public void isPairPresent(Node root, int sum){
        HashSet<Integer> set = new HashSet<Integer>();
        
        if (!helper(root, sum, set)) {
            System.out.println("Nodes not found");
        }
    }
}
