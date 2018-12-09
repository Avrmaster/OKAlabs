package CollisionSystemSimple;

import java.util.Random;

import princetonlib.StdDraw;
import princetonlib.StdRandom;

/**
 * ��������� ���, ��� �������� �� �����泺 � ������
 * 
 * @author ������� �����, 4 �����, ���
 *
 */
public class Ball {
	private double rx, ry; // position
	private double vx, vy; // velocity
	private final double radius; // radius

	public Ball(double rx, double ry, double vx, double vy, double radius) {
		this.rx = rx;
		this.ry = ry;
		this.vx = vx;
		this.vy = vy;
		this.radius = radius;
	}

	/**
	 * ��� ������ �� ������� � ������
	 * 
	 * @param dt         ������� ����
	 * @param screenSize ����� ����
	 */
	public void move(double dt, int screenSize) {
		if ((rx + vx * dt < 0) || (rx + vx * dt > screenSize)) {
			vx = -vx;
		}
		if ((ry + vy * dt < 0) || (ry + vy * dt > screenSize)) {
			vy = -vy;
		}
		rx = rx + vx * dt;
		ry = ry + vy * dt;
	}

	/**
	 * ����� ������
	 */
	public void draw() {
		StdDraw.filledCircle(rx, ry, radius);
	}

	/**
	 * @param screenSize
	 * @return ���� � �������������, �������� ��������
	 */
	static public Ball randomBall(int screenSize) {
		Random rand = new Random();
		double rx0 = StdRandom.uniform(0.0, screenSize);
		double ry0 = StdRandom.uniform(0.0, screenSize);
		double vx0 = StdRandom.uniform(-0.5, 0.5);
		double vy0 = StdRandom.uniform(-0.5, 0.5);
		return new Ball(rx0, ry0, vx0, vy0, 0.3);
	}
}
