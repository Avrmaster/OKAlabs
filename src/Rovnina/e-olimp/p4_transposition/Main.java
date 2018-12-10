package transposition;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ������������. ������ �����������, �� ���������� � n ����������� �����.
 * ���������, �� � ���� ������������� ������ n ����������� �����
 * 
 * @author Rovnina Tetiana
 *
 */
public class Main {
	public static void main(String[] args) {
		new Main().isTransposition();
	}

	/**
	 * ���������, �� �� ������������
	 */
	private void isTransposition() {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out, true);
		TreeSet<Integer> set = new TreeSet<>();
		int n = sc.nextInt();
		int x = 0;
		if (n >= 1 && n <= 10000) {
			for (int i = 0; i < n; i++) {
				x = sc.nextInt();
				if (x < 2000000)
					set.add(x);// ���������� ������
			}

			Integer[] array = new Integer[0];
			array = set.toArray(array); // ���������� ��� ��� � �����

			if (array[array.length - 1] == n && array.length == n && array[0] == 1)
				out.printf("%d\n", 0);
			else
				out.printf("%d\n", binarySearch(array));
		}
	}

	/**
	 * ������� �����. ������ � ��������� �������� ��������
	 */
	private int binarySearch(Integer[] array) {
		int lo = 0, hi = array.length - 1, mid = 0;
		while (lo <= hi) {
			mid = (hi + lo) / 2;
			if (array[mid] == mid + 1)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		if (array[mid] == mid + 1)
			return mid + 2;
		else
			return mid + 1;
	}
}
