
/**
 * ���� ���������� ��������
 * 
 * @author ������� �����, 4 �����, ���
 *
 */
public class InsertionSort {
	/**
	 * @param v
	 * @param w
	 * @return �� v ������ �� w
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * @param c
	 * @param v
	 * @param w
	 * @return �� v ������ �� w
	 */
	private static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}

	/**
	 * ����� � ����� a �������� �� ������� i �� ������� �� ������� j
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * ����� � ����� a �������� �� ������� i �� ������� �� ������� j
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * @param a
	 * @return �� ������������ ����� a
	 */
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	/**
	 * ���������� ������
	 * 
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
				else
					break;
		}
	}

	/**
	 * ���������� ������ a � �������� �� ������� l �� �������� �� ������� h
	 * 
	 * @param a
	 * @param l
	 * @param h
	 */
	public static void sort(Comparable[] a, int l, int h) {
		for (int i = l; i <= h; i++) {
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
				else
					break;
		}
	}

	/**
	 * ���������� ������ a � �������� �� ������� l �� �������� �� ������� h,
	 * �������������� ���������� c
	 * 
	 * @param a
	 * @param l
	 * @param h
	 * @param c
	 */
	public static void sort(Comparable[] a, int l, int h, Comparator c) {
		for (int i = l; i <= h; i++) {
			for (int j = i; j > 0; j--)
				if (less(c, a[j], a[j - 1]))
					exch(a, j, j - 1);
				else
					break;
		}
	}

	/**
	 * ���������� ������ a, �������������� ���������� c
	 * 
	 * @param a
	 * @param comparator
	 */
	public static void sort(Object[] a, Comparator comparator) {
		int n = a.length;
		for (int i = 0; i < n; i++)
			for (int j = i; j > 0 && less(comparator, a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
	}
}
