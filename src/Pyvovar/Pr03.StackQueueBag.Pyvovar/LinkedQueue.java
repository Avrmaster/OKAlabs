package library;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ����, �� �������� LinkedQueue, �������� ��������� � �����, ����������� �
 * �������
 * 
 * @author
 *
 * @param <Item>
 */
public class LinkedQueue<Item> {
	private Node first, last;
	private int count = 0;

	private class Node {
		Item item;
		Node next;
	}

	/**
	 * @param item �������, ���� ������� ������
	 */
	public void engueue(Item item) {
		if (item == null)
			throw new NullPointerException();
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		count++;
		if (isEmpty())
			first = last;
		else
			oldLast.next = last;
	}

	/**
	 * @return ��������� �������
	 */
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		Item item = first.item;
		first = first.next;
		count--;
		if (isEmpty())
			last = null;
		return item;
	}

	/**
	 * @return �� �������
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * @return �����
	 */
	public int size() {
		return count;
	}

	public Iterator<Item> iterator() {
		return new LinkedQueueIterator();
	}

	private class LinkedQueueIterator implements Iterator<Item> {
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

}
