package sortByGrowth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * ���������� �� �������. ������ ����� ��������� ����� ���� � ����� �� a ��
 * b ����������
 * 
 * @author Rovnina Tetiana
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		new Main().sortPeople();
	}

	/**
	 * ��������� ������� ����� ��������� � ������� ��������
	 */
	private void sortPeople() throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("src/sortBygrowth/input.txt"));
		PrintWriter pw = new PrintWriter(new File("src/sortBygrowth/output.txt"));
		String s1, s2, s3;

		int x = 0;
		while ((s1 = bf.readLine()) != null && s1.trim().length() != 0) {
			s2 = bf.readLine(); // ������ � �������� ����� ���������
			s3 = bf.readLine(); // ��� ������, �� ��� ������

			String[] array = s3.split(" "); // ��������� ��������� � ������������ ������
			int min = Integer.parseInt(array[0]);
			int max = Integer.parseInt(array[1]);

			int sum = 0;
			StringTokenizer st = new StringTokenizer(s2);
			while (st.hasMoreTokens()) {// ���������� �� ������ � ������ ������
				x = Integer.parseInt(st.nextToken());
				if (x >= min && x <= max)
					sum++;
			}
			pw.printf("%d\n", sum);
		}
		bf.close();
		pw.close();

	}

}
