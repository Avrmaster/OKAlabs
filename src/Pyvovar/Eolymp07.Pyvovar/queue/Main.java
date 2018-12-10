package queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * � ����������� ������ �� ����������� ������ ������ k ���, ����� ����� ��
 * ��� ������ ����. �������������� ���������� ��������� �����. ��������, ����
 * �� ���� ����, ����� k ������ � ����� �������� �� ���. ���� ������� ��
 * �����. �� ����� ����-������ ���� ��������� � �������� ���� ����������,
 * �������� ������ � ����� �������� �� ���� ����. ��� ������������ �� ��� ��,
 * ���� �� ���� ��������� ��� �볺���.
 * 
 * �������� ���, �� ���� ���� ��������� ��� �볺���.
 * 
 * @author ������� �����, 4 �����, ���
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	/**
	 * ���������� � ����� �� �����, ������ ����� �������
	 * 
	 * @throws IOException
	 */
	private void run() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("src\\queue\\input.txt")));
		PrintWriter pw = new PrintWriter(new File("src\\queue\\output.txt"));
		while (true) {
			String s1 = br.readLine();
			if (s1 == null)
				break;
			StringTokenizer token = new StringTokenizer(s1);
			int n = Integer.parseInt(token.nextToken());
			int k = Integer.parseInt(token.nextToken());
			long[] array = new long[n];
			s1 = br.readLine();
			token = new StringTokenizer(s1);
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(token.nextToken());
			}
			if (k > n)
				k = n;
			long res = timeQueue(k, array);
			pw.println(res);
		}
		pw.close();
		br.close();
	}

	/**
	 * @param k     ������� ���
	 * @param array ����� � ����� �������������� ������� �볺���
	 * @return ��� �������������� �볺���
	 */
	private long timeQueue(int k, long[] array) {
		for (int i = k; i < array.length; i++) {
			array[findIndexMin(k, array)] += array[i];
		}

		return array[findIndexMax(k, array)];
	}

	/**
	 * @param k     ������� ���
	 * @param array ����� � ����� �������������� ������� �볺���
	 * @return ������������ ��� �� ���� �� ���
	 */
	private int findIndexMax(int k, long[] array) {
		int resIndex = 0;
		for (int i = 1; i < k; i++) {
			if (array[i] > array[resIndex])
				resIndex = i;
		}
		return resIndex;
	}

	/**
	 * @param k ������� ���
	 * @param array ����� � ����� �������������� ������� �볺���
	 * @return ��������� ��� �� ���� �� ���
	 */
	private int findIndexMin(int k, long[] array) {
		int resIndex = 0;
		for (int i = 1; i < k; i++) {
			if (array[i] < array[resIndex])
				resIndex = i;
		}
		return resIndex;
	}

}
