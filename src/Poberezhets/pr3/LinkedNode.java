package MyLibrary;


import java.util.Iterator;

import java.util.NoSuchElementException;


/**
 * ������ ��������
 * ���� ����������� 2 ����� ���������
	-����
 * 
 * ���� � ��������� �����, �� �������� ��������� � �������� �������� �� � ������� ��� � � ����.
 * @author �������
 *
 * @param <Item>
 */



public class LinkedNode<Item> implements Iterable<Item> {
	private Node last = null;
	private Node first = null;
	private int count=0;
	
	private class Node{
		Item item;
		Node prev;
		Node next;
	}
	// ����������� ������� ����
		public void LinkedDeque() {
			
		}

		// �� �������?
		public boolean isEmpty() {
			return count==0;
			
		}

		// ������� �������� � ����
		public int size() {
			return count;
		}

		

		// ������ �� �������
		public void addFirst(Item item) {
			if(isEmpty()) {
				last = new Node();
				last.item=item;
				first=last;
				first.next=last;
				first.prev=last;
				last.next=first;
				last.prev=first;
			}else{
				Node oldFirst=first;
				first=new Node();
				first.item=item;
				oldFirst.prev=first;
				first.next=oldFirst;
				first.prev=last;
			}
			count++;

		}

		// ������ � �����
		public void addLast(Item item) {
			if(isEmpty()) {
				last = new Node();
				last.item=item;
				first=last;
				first.next=last;
				first.prev=last;
				last.next=first;
				last.prev=first;
			}else{
				Node oldLast = last;
				last = new Node();
				last.item=item;
				last.prev=oldLast;
				oldLast.next=last;
				last.next=first;
			}
			count++;
		}

		// ��������� � ��������� ������
		public Item removeFirst() {
			if (isEmpty())
				throw new NoSuchElementException();
			
			Item item=first.item;
			first=first.next;
			first.prev=last;
			count--;
			return item;
			
		}

		// ��������� � ��������� �������
		public Item removeLast() {
			if (isEmpty())
				throw new NoSuchElementException();
			
			Item item = last.item;
			last = last.prev;
			last.next=first;
			count--;
			return item;
			
		}

		public Item returnElement(int i) {
			return null;
			
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
