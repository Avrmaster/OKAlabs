package pr3;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lib.StdIn;

/**
 * DONE
 * � �������� ��������� ������ � N ������. 
 * ����� � ��� �� ������ ����. 
 * ��� ����� ������� ��� �������� ������ �����, 
 * ���� �������� ��������� �������� ����� ������� ������ �������. 
 * ��� �� ���������� �����, ��� ��� ����� � �� �������� ��������, 
 * ��������� ������ ������������� ���� �� ���� ������.
   Task:�������� �������� ��� ���������� �������� ������� �������������.

 * @author �������
 *
 */

public class Ballon {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int _N=in.nextInt();
		Map<Integer,Integer> baloon_map=new HashMap<Integer,Integer>();
		if(_N>=1&&_N<=100000) {
			for(int i=0;i<_N;i++) {
				int r=in.nextInt();
				if(r>=1&&r<=9) {
				Integer map_integer=baloon_map.get(r);
				baloon_map.put(r, map_integer == null ? 1 : map_integer + 1);
				}
			}
			int max=0;
			for (int value : baloon_map.values()) {
			   max=Math.max(max, value);
			}
			System.out.println((_N-max));
		}
	}
	
	

	
}
