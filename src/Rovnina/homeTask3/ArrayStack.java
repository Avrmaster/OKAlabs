import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ���� ��������� ����� �����
 * 
 * @author Rovnina Tetiana
 */
public class ArrayStack<Item> implements Iterable<Item> {

	protected Item[] s;
	protected int n = 0;

	/**
	 * ��������� ����� �����
	 */
	public ArrayStack() {
		s = (Item[]) new Object[1];
	}

	/**
	 * ������ ������� � �����
	 */
	public void push(Item item) throws NullPointerException {
		if (item == null) // �������, ���� ������� ������
			throw new NullPointerException();

		if (n == s.length)// ��������� �����, ���� �������
			resize(2 * s.length);
		s[n++] = item;
	}

	/**
	 * �������� � ��������� �������
	 */
	public Item pop() throws NoSuchElementException {
		if (isEmpty())// �������, ���� ����� ������
			throw new NoSuchElementException();

		Item item = s[--n];

		if (n > 0 && n == s.length / 4)// �������� ����� ������, ���� �������
			resize(s.length / 2);

		return item;
	}

	/**
	 * @return �� ������� �����?
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * @return ������� ��������
	 */
	public int size() {
		return n;
	}

	/**
	 * ������ ����� ������
	 */
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
			copy[i] = s[i];
		s = copy;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = n;

		@Override
		public boolean hasNext() {
			return i > 0;
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
