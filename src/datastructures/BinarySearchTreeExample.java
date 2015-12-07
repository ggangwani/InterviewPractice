package datastructures;

public class BinarySearchTreeExample {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(BinarySearchTree.MODE.PREORDER);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(20);
		tree.insert(10);
		tree.insert(15);
		System.out.println(tree);
		tree.setMode(BinarySearchTree.MODE.INORDER);
		System.out.println(tree);
		tree.setMode(BinarySearchTree.MODE.POSTORDER);
		System.out.println(tree);
		System.out.println("Min Tree value: " + tree.findMinimum());
		System.out.println("Max Tree value: " + tree.findMaximum());

	}

}

class BinarySearchTree {

	class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}

	}

	public static enum MODE {
		PREORDER, INORDER, POSTORDER
	};

	private Node root;
	private MODE mode;
	
	public BinarySearchTree(MODE mode){
		this.mode = mode;
	}
	
	public void setMode(MODE mode) {
		this.mode = mode;
	}

	public void insert(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
		} else {
			insertNode(root, node);
		}
	}

	private void insertNode(BinarySearchTree.Node root,
			BinarySearchTree.Node node) {

		if (node.value < root.value) {
			if (root.left == null) {
				root.left = node;
			} else {
				insertNode(root.left, node);
			}
		} else if (node.value > root.value) {
			if (root.right == null) {
				root.right = node;
			} else {
				insertNode(root.right, node);
			}
		}
	}
	
	/**
	 * Returns the minimum value in the Binary Search Tree. Leaf node in left most subtree is the minimum
	 * @return
	 */
	public int findMinimum(){
		Node rootNode = root;
		while(rootNode.left != null){
			rootNode = rootNode.left;
		}
		return rootNode.value;
	}
	
	/**
	 * Returns the maximum value in the Binary Search Tree. Leaf node in the right most subtree is the maximum
	 * @return
	 */
	public int findMaximum(){
		Node rootNode = root;
		while(rootNode.right != null){
			rootNode = rootNode.right;
		}
		return rootNode.value;
	}

	@Override
	public String toString() {
		switch (mode) {
		case PREORDER:
			return preorder();
		case INORDER:
			return inorder();
		case POSTORDER:
			return postorder();
		default:
			return "NO MODE SET";
		}
	}

	private String preorder() {
		StringBuilder display = new StringBuilder();
		preorder(root, display);
		return "PREORDER: " + display.toString();
	}
	
	private void preorder(Node root, StringBuilder text){
		text.append(root.value + " ");
		if(root.left != null){
			preorder(root.left, text);
		}
		if(root.right != null){
			preorder(root.right, text);
		}
	}

	private String inorder() {
		StringBuilder display = new StringBuilder();
		inorder(root, display);
		return "INORDER: " + display.toString();
	}
	
	private void inorder(Node root, StringBuilder text) {
		if(root.left != null){
			inorder(root.left, text);
		}
		text.append(root.value + " ");
		if(root.right != null){
			inorder(root.right, text);
		}
	}

	private String postorder() {
		StringBuilder display = new StringBuilder();
		postorder(root, display);
		return "POSTORDER: " + display.toString();
	}
	
	private void postorder(Node root, StringBuilder text) {
		if(root.left != null){
			postorder(root.left, text);
		}
		if(root.right != null){
			postorder(root.right, text);
		}
		text.append(root.value + " ");
	}

}
