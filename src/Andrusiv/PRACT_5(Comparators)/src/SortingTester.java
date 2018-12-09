import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SortingTester {

	private static Student[] st = new Student[77];
	private static final String file = "students";
	private static Scanner scn;

	public static void main(String[] args) {

		
		readArray();
		SelectionSort.sort(st,Student.stg);
		System.out.println("-----���������� ������� int-----(���������)");
		for (int i = 0; i < st.length; i++)
			System.out.print(st[i]);

		System.out.println("\n \n-----Shell sort int-----(�����������)");

		readArray();
		ShellSort.sort(st,Student.stg);
		for (int i = 0; i < st.length; i++)
			System.out.print(st[i]);

		System.out.println("\n \n-----���������� �������� String-----(���������)");

		readArray();
		InsertionSort.sort(st,Student.stn);
		for (int i = 0; i < st.length; i++)
			System.out.print(st[i]);
		
		System.out.println("\n \n-----���������� ������� string-----(���������)");
		
		readArray();
		MergeSort.sort(st,Student.stn);
		for (int i = 0; i < st.length; i++)
			System.out.print(st[i]);

	}

	private static void readArray() {
		try {
			scn = new Scanner(new FileReader(file));
		} catch (FileNotFoundException fnf) {
			System.out.println("File not found");
			return;
		}

		for (int i = 0; i < st.length; i++) {
			st[i] = new Student(scn.next(), scn.nextInt());

		}

	}

}
