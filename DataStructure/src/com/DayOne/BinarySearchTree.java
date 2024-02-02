package com.DayOne;

public class BinarySearchTree {
	public static class Node{
		int Data;
		Node left;
		Node right;
		
		public Node (int Data) {
			this.Data =Data;
			this.left=null;
			this.right=null;
		}
	}
	public Node root;
	public BinarySearchTree() {
		root=null;
	}
	
	public void insert(int Data) {
		Node newNode =new Node(Data);
		
		if(root==null) {
			root = newNode;
			return;
		}
		else {
			Node current =root ,parent =null;
			
			while(true) {
				parent=current;
				
				if(Data<current.Data) {
					current =current.left;
					if(current ==null) {
						parent.left= newNode;
						return;
					}
				}
				else {
					current =current.right;
					if(current ==null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	public Node minNode(Node root) {
		if(root.left !=null)
			return minNode(root.left);
		else
			return root;
	}
	
	public Node deleteNode(Node node , int value) {
		if(node==null) {
			return null;
		}
		else {
			if(value<node.Data)
				node.left=deleteNode(node.left , value);
			
			else if(value> node.Data)
				node.right= deleteNode(node.right ,value);
			else 
				if(node.left ==null && node.right==null)
					node =null;
				else if(node.left ==null) 
					node =node.right;
				else if(node.right==null)
					node= node.left;
				else {
					Node temp = minNode(node.right);
					node.Data= temp.Data;
					node.right= deleteNode(node.right ,temp.Data);
			
			}
		}
		return node;
	}

	public void inorderTraversal(Node node) {
		if(root ==null) {
			System.out.println("Tree is empty");
			return ;
		}
		else {
			if(node.left !=null) {
				inorderTraversal(node.left);
			}
				
			System.out.println(node.Data+ "");
			if(node.right !=null) {
				inorderTraversal(node.right);
			}
		}
	}
	public static void main (String[] args ) {
		
		BinarySearchTree bt =new BinarySearchTree();
		bt.insert(50);
		bt.insert(70);
		bt.insert(65);
		bt.insert(85);
		bt.insert(10);
		bt.insert(5);
		
		System.out.println("Binary Search Tree After Insertion");
		bt.inorderTraversal(bt.root);
		
		Node deleteNode =null;
		deleteNode =bt.deleteNode(bt.root, 65);
		System.out.println("Binary Search Tree After Deleting Node");
		bt.inorderTraversal(bt.root);
		
		
		
	}
}
