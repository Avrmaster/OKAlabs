package pr10;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Tester_dictionary {
	public static void main(String[] args) throws IOException {
		SearchDictionary d = new SearchDictionary("d.txt");
		d.fillDictionary();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("������� ������ �������");
			System.out.println("1.������� �� �����");
			System.out.println("2.������� �����");
			System.out.println("3.������� �����-������");
			System.out.println("4.�������� �����");
			System.out.println("5.������ �����");
			System.out.println("6.������� ������� ���");
			int x=0;
			try {
			x = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				System.err.println("bad input");
				continue;
			}
			switch (x) {
			case 1:
				d.toString();
				break;
			case 2:
				System.out.println("������ �����:");
				d.printWord(sc.nextLine());
				break;
			case 3:
				System.out.println("������ ������� ����� ��� ������:");
				d.printJoker(sc.nextLine());
				break;
			case 4:
				System.out.println("������ ����� ��� ���������:");
				d.delWord(sc.nextLine());
				break;
			case 5:
				System.out.println("������ �����, ��� ������� ������ �� ��������:");
				d.addWord(sc.nextLine());
				break;
			case 6:
				System.out.println("ʳ������ ���: "+d.countWords());
				
				break;
			default:
				return;

			}

		}

		// while(true) {
		// System.out.println("������ ����� �� ���������:");
		// d.printWord(StdIn.readString());
		//
		// System.out.println("������ ����� ��� ������:");
		// d.delWord(StdIn.readString());
		// }

	}

}
