import java.io.IOException;
import java.util.Comparator;
public class ExampleSort {

	public static void sort(Comparable[] a) {
		//��������� ����� ����������
		Heap.sort(a);
		//Merge.sort(a);
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) { // ����� ������� � ����� ������,
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i] + " ");
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) { // �������� ��������������� ��������� �������,
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) throws IOException { // ������ ����� �� ������������ �����, �� ���������� � �����.
		
		
	       FileArray farr = new FileArray();
	        String[] lines = farr.readLines("src/sortArray50.txt");
	        for (String line : lines) {
	            System.out.println(line);
	        }
	      //  In in = new In("rs1423.txt");
		//String[] � = In.readStrings();
   		sort(lines);
		assert isSorted(lines);
		 System.out.println("!!!!");
		show(lines);
	}

}
