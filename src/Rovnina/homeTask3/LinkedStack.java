import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ���� ��������� ����� ������
 * 
 * @author Rovnina Tetiana
 */
public class LinkedStack<Item> implements Iterable<Item> {

	private Node first = null;
	private int count = 0;

	private class Node {
		Item item;
		Node next;
	}

	/**
	 * ���� ������� � �����
	 */
	public void push(Item item) throws NullPointerException {
		if (item == null) // �������� �������, ���� ������� ������
			throw new NullPointerException();

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		count++;
	}

	/**
	 * ������� � ������� ������� � �������
	 */
	public Item pop() throws NoSuchElementException {
		if (isEmpty())//�������, ���� ���� ������
			throw new NoSuchElementException();

		Item item = first.item;
		first = first.next;
		count--;
		return item;
	}

	/**
	 * @return �� ������?
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * @return ������� ��������
	 */
	public int size() {
		return count;
	}

	/*
	 * ��������� �������� �� ���������
	 * 
	 */
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

	}

}
