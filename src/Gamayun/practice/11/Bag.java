

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
	
	private Node first = null;
	private int count = 0;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item=item;
		first.next=oldFirst;
		count++;
	}

	public int size() {
		return count;
	}

	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	
	private class BagIterator implements Iterator<Item>{
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current.next!=null;
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
