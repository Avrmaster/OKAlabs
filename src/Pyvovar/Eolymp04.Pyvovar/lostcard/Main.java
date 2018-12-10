package lostcard;

import java.util.Scanner;

/**
 * ��� ��������� ��� ���������������� ������ � �������� �� 1 �� n (����������
 * ����� n �� �������� 106). ���� ������ ����������. ������� ��.
 * 
 * @author Olena Pyvovar
 *
 */
public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 1; i < n; i++) {
				sum1 += in.nextInt();
				sum2 += i;
			}
			sum2 += n;
			sum2 -= sum1;
			System.out.println(sum2);
		}
	}

}
