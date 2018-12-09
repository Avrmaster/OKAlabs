package Practice4;

import java.util.Comparator;

import lib.StdDraw;

public class Point implements Comparable<Point> {

	public final Comparator<Point> SLOPE_ORDER = new SOrder();

	private final int x;
	private final int y;

	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	/**
	 * slopeTo() ������� ���䳺�� �� ���� ������ (x0,y0) � that ������ (x1,y1), ��
	 * ������������ �� �������� (y1-y0)/(x1-x0). �������� ��� ������, �� �
	 * �������������� ��� �� ���������� 0, ������������ ��� ���������
	 * ������������, ���������� ������� (�� ������ � �����), �� ���������
	 * ������������.
	 * 
	 * @param that
	 * @return if (this.y - that.y == 0) { if (this.x - that.x == 0) { return
	 *         Double.NEGATIVE_INFINITY; } return +0; } else if (this.x - that.x ==
	 *         0) { return Double.POSITIVE_INFINITY; } return (that.y - this.y) /
	 *         (double) (that.x - this.x);
	 */
	public double slopeTo(Point that) {
		if (this.y - that.y == 0) {
            if (this.x - that.x == 0) {
                return Double.NEGATIVE_INFINITY;
            }
            return +0;
        } else if (this.x - that.x == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return (that.y - this.y) / (double) (that.x - this.x);
	}

	// compareTo() �� ���������� ����� �� �� y-������������.
	// ����� (x0,y0) ����� �� ����� (x1,y1), ��� � ����� ���, ���� y0<y1 ���
	// y0=y1 � x0<x1.
	public int compareTo(Point that) {
		if (this.y < that.y)
			return -1;
		if (this.y > that.y)
			return 1;
		if (this.x < that.x)
			return -1;
		if (this.x > that.x)
			return 1;
		return 0;
	}

	private class SOrder implements Comparator<Point> {
		/**
		 * SLOPE_ORDER comparator �� ���������� ����� �� ���䳺�����, �� ����
		 * ���������� � ���������� ������ (x0,y0).
		 * 
		 * ��������� ����� (x1,y1) ����� �� ����� (x2,y2), ��� � ����� ���, ����
		 * ����� (y1-y0)/(x1-x0) �����, �� ����� (y2-y0)/(x2-x0).
		 */
		public int compare(Point p, Point q) {
			double difference = slopeTo(p) - slopeTo(q);
			if (difference > 0)
				return 1;
			if (difference < 0)
				return -1;

			return 0;
		}
	}
	@Override
    public boolean equals(Object o) {
        Point that = (Point) o;
        if(this.x == that.x && this.y == that.y) return true;
        return false;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}
}