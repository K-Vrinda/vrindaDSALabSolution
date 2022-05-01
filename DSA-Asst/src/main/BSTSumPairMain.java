package main;

import java.util.HashSet;
import java.util.Scanner;

public class BSTSumPairMain {
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

	static boolean helper(Node root, int sum, HashSet<Integer> uniqueNodesBST) {
		if (root == null) {
			return false;
		}

		if (helper(root.left, sum, uniqueNodesBST)) {
			return true;
		}

		if (uniqueNodesBST.contains(sum - root.data)) {
			System.out.println("Pair is (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		}
		else {
			uniqueNodesBST.add(root.data);
		}

		return helper(root.right, sum, uniqueNodesBST);
	}

	static void isPairPresent(Node root, int sum){
		HashSet<Integer> uniqueNodesBST = new HashSet<Integer>();

		if (!helper(root, sum, uniqueNodesBST)) {
			System.out.println("Nodes not found");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter sum: ");
		int sum = scanner.nextInt(); 
		Node root = null;
		
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);

		isPairPresent(root, sum);
		scanner.close();
	}
}