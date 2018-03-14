
public class BST<E extends Comparable <E>> {
	// root of the tree
	Node root;
	// size of the tree
	int size;

	BST() {
		root = null;
		size = 0;
	}

	class Node {
		Node left;
		Node right;
		E data;

		Node() {
			left = null;
			right = null;
			data = null;
		}
	}

	public void add(E item) {
		//Check for if the tree is empty
		if(root== null) {
			Node new_Node = new Node();
			new_Node.data = item;
			root = new_Node;
			return;
		}
		// code for add, maybe useful to have recursive helper method
		addHelper(root, item);
	}

	public void addHelper(Node root, E item) {
		int value = item.compareTo(root.data);
		if (value == 0)
			return;
		if (value < 0) {
			if (root.left.data == null) {
			}
		}
	}

	public Node search(E item) {
	// return Node that you find, null is just placeholder
		return null;
	}

	// number of elements inside tree
	public void size() {
		
		}

	// height of the tree
	public void height() {

	}

	// minimum of subtree starting at root
	public E min(Node root) {
		return null;
	}

	public E max(Node root) {
		return null;
	}

	// successor of node with element item and the head of
	// the subtree is at root
	public Node successor(Node root, E item) {
		return null;
	}

	public Node predecessor(Node root, E item) {
		return null;
	}
	
	//different traversal functions of the tree
	public void preorder() {

	}

	public void inorder() {

	}

	public void postorder() {

	}

	// deletes the item from the tree
	public void delete(E item) {

	}

	// remove all from the tree
	public void clearAll() {

	}

	// check if tree is empty
	public void isEmpty() {

	}
	public static void main(String[] args) {
		//check each of the methods using at least 2 different tests
		//edge cases, all situations
		//Bonus: implement GUI version
	}
}
