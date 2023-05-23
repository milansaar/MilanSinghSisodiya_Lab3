package com.greatlearning.lab3.Q2;

import java.util.HashSet;

class Node {
    int key;
    Node left, right;
    
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BSTPairSum {
    Node root;
    
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
    
    boolean isPairPresent(Node root, int targetSum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (isPairPresent(root.left, targetSum, set)) {
            return true;
        }
        if (set.contains(targetSum - root.key)) {
            System.out.println("Pair found (" + (targetSum - root.key) + ", " + root.key + ")");
            return true;
        } else {
            set.add(root.key);
        }
        return isPairPresent(root.right, targetSum, set);
    }
    
    void findPair(int sum) {
        HashSet<Integer> set = new HashSet<>();
        if (!isPairPresent(root, sum, set)) {
            System.out.println("Nodes are not found.");
        }
    }
    
    public static void main(String[] args) {
        BSTPairSum tree = new BSTPairSum();
        tree.root = new Node(40);
        tree.root.left = new Node(20);
        tree.root.right = new Node(60);
        tree.root.left.left = new Node(10);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(50);
        tree.root.right.right = new Node(70);
        
        System.out.print("Inorder traversal of the BST: ");
        tree.inorder(tree.root);
        
        int sum = 130;
        System.out.println("\nPair with sum " + sum + ": ");
        tree.findPair(sum);
    }
}
