package Practice4;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import lib.StdDraw;

/**
 * Fast. ���� �������� ����� ������� �������� ������. ��� ����� p ���������
 * ����� �������, �� ���� ���� ������ � ����� � 4 ��� ����� ����� �� ����
 * �����.
 * 
 * ������� ��� p �� ��� �������. ��� ����� ���� ����� q ��������� ����� �� p.
 * ³�������� ����� �� �������, �� ���� ������� � p ���������� �� ���� 3 (���
 * �����) ������ ����� � ������������ ������, �� ����� ��������� ����� ��
 * p. ���� ���, �� ����� ����� � p ��������. ������������ ����� ������ ��
 * ����� � N �����, � ���� ����� �� ���������� ��������. �������� ��������
 * Fast.java, �� ������ ��� ��������. ������� ��������� ���� ������ �
 * ��������� ������� �� ���� N2logN � ��������������� ������ ������������ N.
 * 
 * @author �������
 *
 */

public class Fast {
	private static final String file = "D://words3.txt";
	private static final String file1 = "D://grid6x6.txt";
	private static final String file2 = "D://horizontal100.txt";
	private static final String file3 = "D://input6.txt";
	private static final String file4 = "D://input8.txt";
	private static final String file5 = "D://input40.txt";
	private static final String file6 = "D://input50.txt";
	private static final String file7 = "D://input56.txt";
	private static final String file8 = "D://input100.txt";
	private static final String file9 = "D://input400.txt";
	private static final String file10 = "D://rs1423.txt";
	public static void main(String[] args) throws IOException {
		Fast brute = new Fast();
		brute.drawPoints(brute.fast(brute.readPoint(file10)));

	}

	/**
	 * for(int k=0; k<slopes.length-1;k++) {
				System.out.println(slopes[k]+"----"+points[k]);
				if(slopes[k]==slopes[k+1]) {
					StdDraw.setXscale(0, 32768);
					StdDraw.setYscale(0, 32768);
					points[k].drawTo(points[k+1]);
					
				}else {
					System.out.println("...");
				}
			}
			
			
	 * ������� ��� p �� ��� �������. ��� ����� ���� ����� q ��������� ����� �� p.
	 * ³�������� ����� �� �������, �� ���� ������� � p ���������� �� ���� 3 (���
	 * �����) ������ ����� � ������������ ������, �� ����� ��������� ����� ��
	 * p. ���� ���, �� ����� ����� � p ��������. ������������ ����� ������ ��
	 * ����� � N �����, � ���� ����� �� ���������� ��������.
	 * 
	 */
	private HashSet<HashSet<Point>> fast(Point[] points) {
		HashSet<HashSet<Point>> combinations = new HashSet<HashSet<Point>>();
		int length = points.length;
		for (int i = 0; i < length; i++) {
			Point p = points[i];
			Double[] slopes = new Double[length];
			for (int j = 0; j < length; j++) {
				slopes[j] = p.slopeTo(points[j]);
			}
			ShellSort1.sort(slopes, points);
			double baseNumber = slopes[0];
			HashSet<Point> combination = new HashSet<Point>();
			combination.add(p);
			for (int j = 0; j < length; j++) {
				if (baseNumber == slopes[j]) {
					combination.add(points[j]);
				} else {
					if (combination.size() >= 3) {
						combination.add(p);
						combinations.add(combination);
						
					}
					combination = new HashSet<Point>();
					combination.add(p);
					baseNumber = slopes[j];
				}
				if (j == length - 1) {
					if (combination.size() >= 4) {
						combinations.add(combination);
					}
				}

			}
		}
		return combinations;
	}
	public void drawPoints(HashSet<HashSet<Point>> combinations) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for(HashSet hs: combinations) {
            Point[] pointsArray = new Point[hs.size()];
            int i = 0;
            for (Object j : hs) {
                Point p = (Point) j;
                pointsArray[i] = p;
                i++;
            }
            FirstSort.sort(pointsArray);
            pointsArray[0].drawTo(pointsArray[pointsArray.length-1]);

        }
    }
	private Point[] readPoint(String fileName) {
		Point[] points = null;
		try {
			Scanner in = new Scanner(new File(fileName));
			int n = in.nextInt();
			points = new Point[n];
			for (int i = 0; i < n; i++)
				points[i] = new Point(in.nextInt(), in.nextInt());

		} catch (IOException e) {
			System.out.println("No file found");
		}

		return points;
	}

}
