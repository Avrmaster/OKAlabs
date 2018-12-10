package library;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import princetonlib.StdRandom;

/**
 * ��������� ��������� ����� - �������� ����������� ���������� �����
 * 
 * @author ������� �����, 4 �����
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	protected Item[] s;
	protected int n = 0;

	/**
	 * �����������
	 */
	public RandomizedQueue() {
		s = (Item[]) new Object[10];
	}

	/**
	 * @return �� �������
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * @return ����� �����
	 */
	public int size() {
		return n;
	}

	/**
	 * ��������� ��������
	 * 
	 * @param item
	 */
	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException();
		if (n == s.length)
			resize(2 * s.length);
		s[n] = item;
		n++;
	}

	/**
	 * ���� ������ ������
	 * 
	 * @param capacity ������� ������ ������
	 */
	private void resize(int capacity) {
		s = Arrays.copyOf(s, capacity);
	}

	/**
	 * @return ��������� �������
	 */
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		n--;
		StdRandom.shuffle(s, 0, n);
		if (n == s.length / 4)
			resize(s.length / 2);
		return s[n];
	}

	/**
	 * @return ��������� �������, ���� �� �����������
	 */
	public Item sample() {
		if (isEmpty())
			throw new NoSuchElementException();
		int k = StdRandom.uniform(n);
		return s[k];
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}

	private class RandomizedQueueIterator implements Iterator<Item> {

		private int k;

		public RandomizedQueueIterator() {
			k = 0;
		}

		@Override
		public boolean hasNext() {
			return k < n;
		}

		@Override
		public Item next() {
			Item item = s[k];
			k++;
			return item;
		}

	}

	/**
	 * ��������� ������ � �������
	 */
	public void printRandomizedQueue() {
		Iterator<Item> it = this.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println("size = " + this.size());
	}

}
