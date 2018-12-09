import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	class Node<Key, Value> {
		private Key key;
		private Value val;
		private Node left, right;
		private int count;

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val);
		int cmp = key.compareTo((Key) x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		if (cmp > 0)
			x.right = put(x.right, key, val);
		else if (cmp == 0)
			x.val = val;
		x.count = 1 + size(x.left) + size(x.right);
		return x;

	}

	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo((Key) x.key);
			if (cmp < 0)
				x = x.left;
			if (cmp > 0)
				x = x.right;
			if (cmp == 0)
				return (Value) x.val;
		}
		return null;
	}

	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("calls delete() with a null key");
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;

		int cmp = key.compareTo((Key) x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.count = size(x.left) + size(x.right) + 1;
		return x;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		else
			return min(x.left);
	}
	
	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		x.count = size(x.left) + size(x.right) + 1;
		return x;
	}

	public int size() {
		return size(root);

	}

	private int size(Node x) {
		if (x == null)
			return 0;
		return x.count;
	}

	public Key min() {// ���������� ���� � �������.
		Node x = root;
		while (x.left != null) {
			x = x.left;
		}
		return (Key) x.key;
	}

	public Key max() {// ������������ ���� � �������.
		Node x = root;
		while (x.right != null) {
			x = x.right;
		}
		return (Key) x.key;
	}

	public Key floor(Key key) {// ������������ ���� � �������, �� ����� ��� ������� ��������
		Node x = floor(root, key);
		if (x == null)
			return null;
		return (Key) x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo((Key) x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null)
			return null;
		return (Key) x.key;

	}

	private Node ceiling(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo((Key) x.key);
		if (cmp == 0)
			return x;
		if (cmp > 0)
			return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if (t != null)
			return t;
		else
			return x;
	}

	public int rank(Key key, Node x) {
		if (x == null)
			return 0;
		int cmp = key.compareTo((Key) x.key);
		if (cmp < 0)
			return rank(key, x.left);
		else if (cmp > 0)
			return 1 + size(x.left) + rank(key, x.right);
		else if (cmp == 0)
			return size(x.left);
		return 0;
	}

	public Iterable<Key> iterator() {
		Queue<Key> q = new Queue<Key>();
		inorder(root, q);
		return q;
	}

	private void inorder(Node x, Queue<Key> q) {
		if (x == null)
			return;
		inorder(x.left, q);
		q.enqueue((Key) x.key);
		inorder(x.right, q);
	}
}
