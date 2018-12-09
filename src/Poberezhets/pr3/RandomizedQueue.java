package MyLibrary;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * 
 * @author �������
 *
 * @param <Item>
 */

public class RandomizedQueue<Item> implements Iterable<Item> {
	protected Item[] s;
	protected int n = 0;
	protected int count = 0;

	// ����������� ������� ����
	public RandomizedQueue() {
		s = (Item[]) new Object[1];
		s[0] = null;
	}

	// �� �������?
	public boolean isEmpty() {
		return n == 0;
	}

	// ������� �������� � ����
	public int size() {
		return n;
	}

	// ������� �������� ���������� ��� ������
	public int amount() {
		return count;
	}

	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
			copy[i] = s[i];
		s = copy;
	}

	// ������ �� ������� count++ !!!
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException();

		if (n == 0) {
			//System.out.println(n + "zz");
			s[n] = item;
			n++;
			count++;
		} else {
			if (n == s.length)
				resize(2 * s.length);
			// System.out.println(s.length+" c11");
			for (int i = 1; i < s.length; i++) {
				// System.out.println(s.length+" d11");
				if (s.length == 2 && i == 1) {
					Item[] copy = (Item[]) new Object[s.length];
					copy[0] = item;
					copy[1] = s[0];
					s = copy;
					n++;
					count++;
					break;
				} else if (i == 1 && s[i] != null) {
					//System.out.println(s.length + " aaaaaa");
					Item[] copy = (Item[]) new Object[s.length];
					copy[0] = item;
					// System.out.println("dodano1");
					for (int j = 1; j < copy.length; j++)
						copy[j] = s[j - 1];
					s = copy;
					n++;
					count++;
					break;
				} else {
					//System.out.println(s.length + " dfff11");
					if (s[i] != null) {
						s[i - 1] = item;
						count++;
						n++;
						// System.out.println("dodano1");
						break;
					}
				}
			}
		}

	}

	// ������ � �����
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();
		if (n == s.length)
			resize(2 * s.length);
		if (n == 0) {
			s[n] = item;
			n++;
			count++;
		} else {
			// System.out.println(s.length);
			for (int i = s.length - 2; i >= 0; i--) {
				if (s[i] != null) {
					s[i + 1] = item;
					n++;
					count++;
					break;
				}
			}
		}
	}

	public Item returnElement(int i) {
		return s[i];
	}

	// ��������� � ��������� ������
	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		int i = 0;
		for (i = 0; i < s.length; i++) {
			if (s[i] != null) {
				n--;
				s[i] = null;
				break;
			}
		}
		return s[i];
	}

	// ��������� � ��������� �������
	public Item removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();

		// System.out.println(n);
		for (int i = s.length - 1; i >= 0; i--) {
			if (s[i] != null) {
				n--;
			//	System.out.println(count + "===" + s[i]);
				return s[i] = null;
			}
		}
		return null;
	}

	// �������� � ��������� ���������� �������
	public Item dequeue() {
		int r = 0;
		while (true) {
			r = (int) (Math.random() * n);
			//System.out.println(r);
			if (s[r] != null)
				break;
		}
		return s[r] = null;

	}

	// ��������� ��� �� �������� ���������� �������
	public Item sample() {
		int r = 0;
		while (true) {
			r = (int) (Math.random() * n);
			//System.out.println(r);
			if (s[r] != null)
				break;
		}
		return s[r];
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{

		private int i=count;
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return s[--i];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}