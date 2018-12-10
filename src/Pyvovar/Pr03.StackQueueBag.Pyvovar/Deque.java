package library;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ��������� ���� - ��������� �����, �� �������� �������� �� �������� �� �
 * �������, ��� � � ����
 * 
 * @author ������� �����, 4 �����
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

	private Node first, last;
	private int count = 0;

	private class Node {
		Item item;
		Node previous;
		Node next;
	}

	/**
	 * ����������� ������� ����
	 */
	public Deque() {
		first = new Node();
		first.next = null;
		first.previous = null;
		last = new Node();
		last.next = null;
		last.previous = null;
	}

	/**
	 * @return �� �������
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * @return ������� �������� � ����
	 */
	public int size() {
		return count;
	}

	/**
	 * ������ �� �������
	 * 
	 * @param item
	 */
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException();
		else {
			Node newItem = new Node();
			newItem.next = first;
			newItem.previous = null;
			newItem.item = item;
			first.previous = newItem;
			first = newItem;
			if (isEmpty()) {
				first = newItem;
				last = newItem;
			}
			count++;
		}
	}

	/**
	 * ������ � �����
	 * 
	 * @param item
	 */
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();
		else {
			Node newItem = new Node();
			newItem.previous = last;
			newItem.next = null;
			newItem.item = item;
			last.next = newItem;
			last = newItem;
			if (isEmpty()) {
				first = newItem;
				last = newItem;
			}
			count++;
		}
	}

	/**
	 * ��������� � ��������� ������
	 * 
	 * @return ������
	 */
	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		else {
			count--;
			Node oldFirst = first;
			first = oldFirst.next;
			if (!isEmpty())
				first.previous = null;
			return oldFirst.item;
		}
	}

	/**
	 * ��������� � ��������� �������
	 * 
	 * @return �������
	 */
	public Item removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		else {
			count--;
			Node oldLast = last;
			last = oldLast.previous;
			if (!isEmpty())
				last.next = null;
			return oldLast.item;
		}
	}

	@Override
	public Iterator<Item> iterator() { // ��������� �������� �� ���������
		return new DequeIterator();
	}

	/**
	 * ���� ��� ��������� ���������
	 *
	 */
	private class DequeIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {

		}
	}

	/**
	 * ��������� ���� � �������
	 */
	public void printDeque() {
		Iterator<Item> it1 = this.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next() + " ");
		}
		System.out.println("size = " + this.size());
	}

	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		deque.addLast(7);
		deque.addLast(8);
		deque.addLast(9);
		deque.addFirst(3);
		deque.addFirst(2);
		deque.addFirst(1);
		deque.printDeque();

		deque.removeFirst();
		deque.removeLast();
		deque.addLast(1);
		deque.addLast(0);
		deque.printDeque();

		deque.removeFirst();
		deque.removeLast();
		deque.printDeque();

//		deque.addFirst(null);
//		deque.addLast(null);

		deque.removeFirst();
		deque.removeLast();
		deque.removeLast();
		deque.removeFirst();
		deque.printDeque();

//		deque.removeFirst();

		deque.addLast(4);
		deque.addFirst(3);
		deque.addFirst(2);
		deque.addFirst(1);
		deque.printDeque();
	}

}
