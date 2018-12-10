package library;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ����, �� ������ LinkedStack, �������� ��������� �� ����������� � ����
 * @author 
 *
 * @param <Item>
 */
public class LinkedStack<Item> implements Iterable<Item>{
	
	private Node first = null;
	private int count=0;
	
	private class Node{
		Item item;
		Node next;
	}
	
	/**
	 * @param item �������, ���� ������� ������
	 */
	public void push(Item item) {
		if (item == null)
			throw new NullPointerException();
		Node oldFirst = first;
		first = new Node();
		first.item=item;
		first.next=oldFirst;
		count++;
	}

	/**
	 * @return ��������� �������
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException();
		Item item = first.item;
		first = first.next;
		count--;
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

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current!=null;
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
