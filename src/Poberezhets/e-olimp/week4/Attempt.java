import java.util.Scanner;

/**
 * (Done) ��� ��������� ��� ���������������� ������ � �������� �� 1 �� n
 * (���������� ����� n �� �������� 106). ���� ������ ����������. ������� ��.
 * 
 * ����� ���
 * 
 * ������ ������ ����� n. ��� ����� n - 1 ������ ������, �� ����������.
 * 
 * ������ ���
 * 
 * ������� ����� �������� ������.
 * 
 * @author �������
 *
 */
public class Attempt {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();

		if (n < 1000000) {
			int res = 0;
			for (int j = 1; j <= n; j++) {
				res += j;
			}
			for (int i = 1; i < n; i++)
				res -= in.nextLong();

			System.out.println(res);
		}

	}

}