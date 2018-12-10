package convexhull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import princetonlib.StdDraw;

/**
 * ����� ������ ��������
 * 
 * @author ������� �����, 4 �����, ���
 *
 */
public class ConvexHull {

	/**
	 * ����� �����, �� ������� � �����
	 */
	private Point2D[] arrayPoints;

	/**
	 * �������� �����
	 */
	private Point2D p;

	public static void main(String[] args) throws IOException {
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		ConvexHull convexHull = new ConvexHull();
		convexHull.run(new File("rs1423.txt"));
	}

	/**
	 * ������ ������� ���������� � �����, ����� �������� �����, ���������� ��
	 * �������� �����, ����������� ������ ��������
	 * 
	 * @param file ����, � ����� ������� �����
	 * @throws IOException
	 */
	private void run(File file) throws IOException {
		readPoints(file);
		MergeSort.sort(arrayPoints); // ������� ����� �� ����������
		p = arrayPoints[0]; // ����� ����� � ������������� ����� ��������
		MergeSort.sort(arrayPoints, p.POLAR_ORDER);
		findConvexHull();
	}

	/**
	 * ���������� �����, �� ��������� ������ ��������. ��������� ������ ��������
	 */
	private void findConvexHull() {
		ArrayList<Point2D> pointsToDraw = new ArrayList<>();
		for (int i = 0; i < arrayPoints.length; i++) { // ������������ � ArrayList
			pointsToDraw.add(arrayPoints[i]);
		}

		int count = 0;
		Point2D first; // ��� ����� ��� ����������� ccw
		Point2D second;
		Point2D third;

		while ((count + 2) != pointsToDraw.size()) {
			first = pointsToDraw.get(count);
			second = pointsToDraw.get(count + 1);
//			if (count + 2 == pointsToDraw.size()) //����� ��������� � ������ ������
//				third = pointsToDraw.get(0);
//			else
				third = pointsToDraw.get(count + 2);
			if (Point2D.ccw(first, second, third) > 0) //���� ����� 0, �� ������ � �����
				count++;
			else {
				pointsToDraw.remove(count + 1);
				if (count != 0)
					count--;
			}
		}

		for (int i = 0; i < pointsToDraw.size() - 1; i++) {
			pointsToDraw.get(i).drawTo(pointsToDraw.get(i + 1)); // ��������� �����
		}
		pointsToDraw.get(pointsToDraw.size() - 1).drawTo(pointsToDraw.get(0));
	}

	/**
	 * ���������� ����� � ����� � �����
	 * 
	 * @param file
	 * @throws IOException
	 */
	private void readPoints(File file) throws IOException {
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		arrayPoints = new Point2D[n];

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arrayPoints[i] = new Point2D(x, y);
			arrayPoints[i].draw();
		}
	}

}
