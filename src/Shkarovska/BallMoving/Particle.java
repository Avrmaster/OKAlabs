import java.awt.Color;
import java.util.Random;

public class Particle {
	private static final double INFINITY = Double.POSITIVE_INFINITY;

	private double rx, ry; // position
	private double vx, vy; // velocity
	private int count; // number of collisions so far
	private final double radius; // radius
	private final double mass; // mass
	private final Color color; // color

	public Particle() {
		rx = StdRandom.uniform(0.0, 1.0);
		ry = StdRandom.uniform(0.0, 1.0);
		vx = StdRandom.uniform(-0.005, 0.005);
		vy = StdRandom.uniform(-0.005, 0.005);
		radius = StdRandom.uniform(0.0095, 0.018);
		mass = StdRandom.uniform(0.1, 0.6);
		Random rand = new Random();
		color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
	}

	public void move(double dt) {
		rx += vx * dt;
		ry += vy * dt;
	}

	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(rx, ry, radius);
	}

	public int count() {
		return count;
	}

	public double timeToHit(Particle that) {
		if (this == that)
			return INFINITY;
		double dx = that.rx - this.rx;
		double dy = that.ry - this.ry;
		double dvx = that.vx - this.vx;
		double dvy = that.vy - this.vy;
		double dvdr = dx * dvx + dy * dvy;
		if (dvdr > 0)
			return INFINITY;
		double dvdv = dvx * dvx + dvy * dvy;
		if (dvdv == 0)
			return INFINITY;
		double drdr = dx * dx + dy * dy;
		double sigma = this.radius + that.radius;
		double d = (dvdr * dvdr) - dvdv * (drdr - sigma * sigma);
		if (d < 0)
			return INFINITY;
		return -(dvdr + Math.sqrt(d)) / dvdv;
	}

	public double timeToHitVerticalWall() {
		if (vx > 0)
			return (1.0 - rx - radius) / vx;
		else if (vx < 0)
			return (radius - rx) / vx;
		else
			return INFINITY;
	}

	public double timeToHitHorizontalWall() {
		if (vy > 0)
			return (1.0 - ry - radius) / vy;
		else if (vy < 0)
			return (radius - ry) / vy;
		else
			return INFINITY;
	}

	public void bounceOff(Particle that) {
		double dx = that.rx - this.rx;
		double dy = that.ry - this.ry;
		double dvx = that.vx - this.vx;
		double dvy = that.vy - this.vy;
		double dvdr = dx * dvx + dy * dvy; // dv dot dr
		double dist = this.radius + that.radius; // distance between particle centers at collison

		double magnitude = 2 * this.mass * that.mass * dvdr / ((this.mass + that.mass) * dist);

		double fx = magnitude * dx / dist;
		double fy = magnitude * dy / dist;

		this.vx += fx / this.mass;
		this.vy += fy / this.mass;
		that.vx -= fx / that.mass;
		that.vy -= fy / that.mass;

		this.count++;
		that.count++;
	}

	public void bounceOffVerticalWall() {
		vx = -vx;
		count++;
	}

	public void bounceOffHorizontalWall() {
		vy = -vy;
		count++;
	}
}