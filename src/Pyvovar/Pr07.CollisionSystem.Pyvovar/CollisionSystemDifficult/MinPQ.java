package CollisionSystemDifficult;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import princetonlib.StdIn;
import princetonlib.StdOut;

/**
 * ��������� ����� � ���������
 *
 * @param <Key>
 */
public class MinPQ<Key> {
	private Key[] pq; 
	private int n;

	/**
	 * ����������� �������� ����� �� ������� ��������
	 *
	 * @param initCapacity �������
	 */
	public MinPQ(int initCapacity) {
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}

	/**
	 * ����������� ����� (����������� ��� ���������)
	 */
	public MinPQ() {
		this(1);
	}

	/**
	 * @return �� ������� �����
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
	 * ���� ������� �����
	 * 
	 * @param capacity ���� �������
	 */
	private void resize(int capacity) {
		assert capacity > n;
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i <= n; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}

	/**
	 * ��������� ��������
	 *
	 * @param x �������, �� ������� ������
	 */
	public void insert(Key x) {
		// double size of array if necessary
		if (n == pq.length - 1)
			resize(2 * pq.length);

		// add x, and percolate it up to maintain heap invariant
		pq[++n] = x;
		swim(n);
	}

	/**
	 * ��������� ���������� �������� �� ���������� ����
	 *
	 * @return ��������� �������
	 */
	public Key delMin() {
		if (isEmpty())
			throw new NoSuchElementException("Priority queue underflow");
		Key min = pq[1];
		exch(1, n--);
		sink(1);
		pq[n + 1] = null;
		if ((n > 0) && (n == (pq.length - 1) / 4))
			resize(pq.length / 2);
		return min;
	}

	/**
	 * ��������� ��������
	 * 
	 * @param k
	 */
	private void swim(int k) {
		while (k > 1 && greater(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	/**
	 * ��������� ��������
	 * 
	 * @param k
	 */
	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && greater(j, j + 1))
				j++;
			if (!greater(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	/**
	 * @param i
	 * @param j
	 * @return �� ������ i �� j
	 */
	private boolean greater(int i, int j) {
		return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
	}

	/**
	 * ��� �������� ������ ������
	 * 
	 * @param i
	 * @param j
	 */
	private void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

}