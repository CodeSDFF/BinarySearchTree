
public class BST<E extends Comparable<E>> {
	// Root of the tree
	Node root;
	// Size of the tree
	int size;

	// Constructor for BST
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
		// Check for if the tree is empty

		if (root == null) {
			Node new_Node = new Node();
			new_Node.data = item;
			root = new_Node;
			return;
		}
		// Recursive helper method
		addHelper(root, item);
	}

	public void addHelper(Node root, E item) {
		int value = item.compareTo(root.data);
		// If the value is equal to zero, that means the item
		// is already on the tree so return
		
		if (value == 0) {
			System.out.println("Error: This item already exists in the tree");
			System.out.println();
			return;
		}
		// If the item is less than zero, go left
		
		if (value < 0) {
			// if there is no left leaf child, then create one
			
			if (root.left == null) {
				Node new_Node = new Node();
				root.left = new_Node;
				new_Node.data = item;
			}
			// if there is a left leaf, keep going down
			
			else {
				addHelper(root.left, item);
			}
		}
		// if the item is greater than 0 or root, go right
			
			else {
			// if there is not a right child, then make one
			
				if (root.right == null) {
				Node new_Node = new Node();
				root.right = new_Node;
				new_Node.data = item;
			}
			// if the right child (leaf) is found, keep going down
			else {
				addHelper(root.right, item);
			}
		}
		return;
	}

	public void search(E item) {
		// First try to find item in tree
		Node finder = searchHelper(root, item);
		if(finder == null) {
			System.out.println("This item cannot be located on tree");
		}
		else {
			System.out.println("The item you are searching for is " + finder.data);
		}
	}
	
	public Node searchHelper(Node root, E item) {
		// 1st check to see if item is in the tree or your first item
		if(root == null || root.data == item) {
			return root;
		}
		
		if(root.data.compareTo(item) > 0) {
			return searchHelper(root.left, item);
		}
			
			return searchHelper(root.right, item);
	}

	// number of elements inside tree
	public void size() {
		
		System.out.println("The size of the tree is: " + sizeHelper(root));
		System.out.println();
	}
	
	public int sizeHelper(Node root) {
	
		// Check to see if the tree exists
		if(root == null)
		return 0;
	
		// 
		else {
		return 1 + sizeHelper(root.left) + sizeHelper(root.right);
		}
	}
	// height of the tree
	public void height() {
		
		System.out.println("The height of the tree is: " + heightHelper(root));
		System.out.println();
	}
	
	public int heightHelper(Node root) {
		//Check for height of zero
		
		if(root == null)
			return 0;
		
		else {
			int heightLeft = heightHelper(root.left);
			int heightRight = heightHelper(root.right);
			
			if (heightLeft > heightRight) {
				return heightLeft + 1;
			}
			else {
				return heightRight + 1;
			}
		}
	}

	// minimum of subtree starting at root
	public void min() {
		System.out.println("The minimum value found in this tree is: " + minHelper(root));
		System.out.println();
		
	}

	public E minHelper(Node root) {
	// goes down left to find the leftmost leaf
		
		while(root.left != null) {
			root = root.left;
		}
		return (root.data);
	}
	
	public void max() {
		System.out.println("The maximum value found in this tree is: " + maxHelper(root));
		System.out.println();
	}
	
	public E maxHelper (Node root) {
	// goes down right to find the rightmost leaf
		
		while(root.right != null) {
			root = root.right;
		}
		return (root.data);
	}

	// successor of node with element item and the head of
	// the subtree is at root
	public void successor(E item) {
		
		if(root == null) {
			System.out.println("The item does not have a successor...bummer");
		}
		else {
			System.out.println("The successor of " + item + " is " + root.data);
			System.out.println();
			successorHelper(root, item);
		}
	}
	
	public Node successorHelper(Node root, E item) {
		Node new_Node = new Node();
		
		Node successor = searchHelper(root, item);
		if(successor == null) {
			return null;
		}
		
		if(successor.right != null) {
			
			new_Node = successor.right;
			
			while(new_Node.left != null) {
				
				new_Node = new_Node.left;
				return new_Node;
			}
		} else {
			Node ancestor = new Node();
			ancestor = root;
			
			while(ancestor != successor) {
				if(ancestor.left != null) {
					new_Node = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}
			return new_Node;
		}
		return new_Node;
	}

	public void predecessor(E item) {
		return;
	}
	
	public Node predecessorHelper(Node Root, E item) {
		return null;
	}

	// different traversal functions of the tree
	public void preorder() {
		//Check for empty tree
		
		if(root == null) {
			System.out.println("The tree is empty");
		}
		
		preorderHelper(root);
	}
	
	public void preorderHelper(Node root) {
		
		if(root != null) {
			
			System.out.println(root.data);
			preorderHelper(root.left);
			preorderHelper(root.right);
		}
	}

	public void inorder() {
		//Check for empty tree
		
		if(root == null) {
			System.out.println("The tree is empty");
		}
		inorderHelper(root);
	}

	public void inorderHelper(Node root) {
		
		if(root != null) {
			
			inorderHelper(root.left);
			System.out.println(root.data);
			inorderHelper(root.right);
		}
	}
	
	public void postorder() {
		// Check for empty tree
		
		if(root == null) {
			System.out.println("The tree is empty");

		}
		postorderHelper(root);

	}
	public void postorderHelper(Node root) {
		
		if(root != null) {
			
			postorderHelper(root.left);
			postorderHelper(root.right);
			System.out.println(root.data);

		}
	}

	// deletes the item from the tree
	public void delete(E item) {
		
		deleteHelper(root, item);
		System.out.println(item + " deleted.");
	}
	
	//Deletes the item from the tree.
	public Node deleteHelper(Node root, E item) {
		return null;
	}


	// remove all from the tree
	public void clearAll() {
		clearAllHelper(root);
		System.out.println("Your tree is empty");
	}
	
	public void clearAllHelper(Node root) {
		
		if(root != null) {
			clearAllHelper(root.left);
			clearAllHelper(root.right);
			root = null;
			
			System.out.println("Your tree is now clear");
		}
	}

	// check if tree is empty
	public boolean isEmpty() {
		if(root != null) {
			System.out.println("The tree is not empty.");
			System.out.println();
		}
		else {	
			if(root == null) {
				System.out.println("The tree is empty.");
				System.out.println();
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// check each of the methods using at least 2 different tests
		// edge cases, all situations
		// Bonus: implement GUI version
		
		BST <Integer> newTree = new BST <Integer>();
		newTree.isEmpty();
		newTree.add(6);
		newTree.add(8);
		newTree.add(4);
		newTree.add(17);
		newTree.isEmpty();
		newTree.add(14);
		newTree.add(44);
		newTree.add(57);
		newTree.add(3);
		newTree.add(84);
		newTree.size();
		newTree.height();
		newTree.add(20);
		newTree.min();
		newTree.max();
		newTree.successor(17);
		newTree.successor(4);
		newTree.inorder();
		System.out.println();
		newTree.preorder();
		System.out.println();
		newTree.postorder();
		System.out.println();
		newTree.clearAll();
		newTree.isEmpty();	
	}
}
