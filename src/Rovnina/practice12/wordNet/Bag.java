package wordNet;

import java.util.Iterator;

/**
 * мішок, елементи можна лише додавати
 * 
 * @author Rovnina Tetiana
 */
public class Bag<Item> implements Iterable<Item> {

	private Node first = null;
	private int count = 0;

	private class Node {
		Item item;
		Node next;
	}

	/**
	 * додати елемент
	 */
	public void add(Item item) throws NullPointerException {
		if (item == null) // викидаємо помилку, якщо елемент пустий
			throw new NullPointerException();

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		count++;
	}

	/**
	 * @return кількість елементів
	 */
	public int size() {
		return count;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
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
			throw new UnsupportedOperationException();
		}
	}

}
