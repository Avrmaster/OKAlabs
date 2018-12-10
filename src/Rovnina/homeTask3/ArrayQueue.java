import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ����� � ��������� ���������. ��������� �������� � �������, ������ �
 * �����. ���� �� ����� �� ���� ������, � �� ������� ���������� ����, ��
 * ������ �������� �� �������
 * 
 * @author Rovnina Tetiana
 */
public class ArrayQueue<Item> implements Iterable<Item> {

	private Item[] array;
	private int n = 0;
	private int head = 0;
	private int tail = 0;

	public ArrayQueue() {
		array = (Item[]) new Object[1];
	}

	/**
	 * @return �� �������?
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
	 * ������ ������� � �����
	 */
	public void enqueue(Item item) throws NullPointerException {
		if (item == null) // �������� �������, ���� ���������� ���������� ������ ������ �������
			throw new NullPointerException();

		if (n == array.length && head == 0 || tail == head && head != 0)// �������� ����� ������, ���� �������
			resize(2 * array.length);

		if (tail == array.length && head != 0)// ���� �� ������� ���� �����, �� �������� �� �������
			tail = 0;

		array[tail++] = item;
		n++;
	}

	/**
	 * �����, ���� ����� ����� ������
	 */
	private void resize(int size) {
		Item[] copy = (Item[]) new Object[size];

		if (tail == head) {// ������������ �����, ���� head ��������� ���� ��������
			int j = 0;
			for (int i = head; i < array.length; i++, j++) // ������� �������� ������� ������
				copy[j] = array[i];

			for (int i = 0; i < tail; i++, j++)// �������� ���� ������
				copy[j] = array[i];

			head = 0;
			tail = n;
		} else
			System.arraycopy(array, head, copy, 0, n);

		array = copy;
	}

	/**
	 * �������� � ��������� ������� � �������
	 */
	public Item dequeue() throws NoSuchElementException {
		if (n == 0) // �������� �������, ���� ����� �������
			throw new NoSuchElementException();

		if (head == array.length)// ���� head ����������� � ���� ������
			head = 0;

		Item item = array[head];
		array[head] = null;
		n--;
		head++;

		if (n > 0 && n == array.length / 4)// �������� ����� ������, ���� �������
			resize(array.length / 2);

		return item;
	}

	/*
	 * ��������� �������� �� ��������� � ���������� ������
	 * 
	 */
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {

			int i = 0;

			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public Item next() {
				return array[i++];
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

	}
}