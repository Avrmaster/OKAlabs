package pr9;

import java.util.Scanner;

/**
 * 
 * ������ ���� ������� �������� ��������� ����. � ������ ������ ����� ��������
 * ����� � ���������. � ���� ���������� ���� �� �� ����������� ������ ��
 * ������. ��������� ����������� �� ������ ���, ��� �������� ������� ��
 * ������������� ���� ������� ������. ��� ���� ����� ������ �������� ����
 * ������. ����� ���
 * 
 * � ������� ����� ��������� ������� ����� n (2 < n < 10001) �� �������
 * ����������� k (1 < k < n), �� ������ �� ������. � ������� ����� ������ n
 * ����������� ����� � ������� ��������� - ���������� ����� (���������� ��
 * ����������� 10^9).
 * 
 * ������ ���
 * 
 * ������� ���� ����� - �������� ������� �� ������� ������� �
 * ������������ ��������.
 */

public class IceCream {
	static int n = 0;
	static int k = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();// shops
		k = sc.nextInt();// assictants
		int m[] = new int[n];
		for (int i = 0; i < m.length; i++) {
			m[i] = sc.nextInt();
		}

		// for (Long s : arr)
		// System.out.println(s);
		int Left = 0, Right = 1000000000;
		while (Left <= Right) {
			int Middle = (Left + Right) / 2;
			if (Check(m, Middle))
				Left = Middle + 1;
			else
				Right = Middle - 1;
		}
		System.out.println(Left - 1);

	}

	static boolean Check(int[] m, int Value) {
		int i, stall = 1, len = 0;
		for (i = 1; i < n; i++) {
			len += m[i] - m[i - 1];
			if (len >= Value) {
				len = 0;
				stall++;
			}
		}
		return stall >= k;
	}
}
