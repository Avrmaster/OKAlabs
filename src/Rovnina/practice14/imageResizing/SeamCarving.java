package imageResizing;

import java.awt.Color;
import graphs.AcyclicSP;
import graphs.DirectedEdge;
import graphs.EdgeWeightedDigraph;
import prinston.Picture;

/**
 * @author Rovnina Tetiana IPZ, 5 group 
 *
 */
public class SeamCarving {
	private Picture picture;
	private static double[][] energyMatrix;
	private static Color[][] colorMatrix;
	private EdgeWeightedDigraph graph;

	public SeamCarving(Picture picture) {
		this.picture = picture;
		createColorMatrix();
		createEnergyMatrix();
		createGraph();

	}

	/**
	 * �������� ���� � ��������
	 */
	private void createGraph() {
		int size = width() * height() + 2;
		graph = new EdgeWeightedDigraph(size);

		for (int row = 0; row < height() - 1; row++) {
			for (int col = 0; col < width(); col++) {
				int v = getIndex(row, col);
				// 2 �������
				int w = getIndex(row + 1, col);
				double weight = energyMatrix[row + 1][col];
				graph.addEdge(new DirectedEdge(v, w, weight));

				// 1 �������
				if (col != 0) {
					w = getIndex(row + 1, col - 1);
					weight = energyMatrix[row + 1][col - 1];
					graph.addEdge(new DirectedEdge(v, w, weight));
				}

				// 3 �������
				if (col != width() - 1) {
					w = getIndex(row + 1, col + 1);
					weight = energyMatrix[row + 1][col + 1];
					graph.addEdge(new DirectedEdge(v, w, weight));
				}
			}
		}
		// �'����� � ������ �������� �������
		int v = 0;
		int w = 0;
		int weight = 1000;
		for (int col = 0; col < width(); col++) {
			w = getIndex(0, col);
			graph.addEdge(new DirectedEdge(v, w, weight));
		}

		// �'����� � ������ ������� �������
		w = size - 1;
		weight = 0;
		for (int col = 0; col < width(); col++) {
			v = getIndex(height() - 1, col);
			graph.addEdge(new DirectedEdge(v, w, weight));
		}

	}

	/**
	 * @return ������ �������� � �������
	 */
	private int getIndex(int row, int col) {
		return row * width() + col + 1;
	}

	/**
	 * @return ��������
	 */
	public Picture picture() {
		return picture;
	}

	/**
	 * @return ������ ��������
	 */
	public int width() {
		return picture.width();
	}

	/**
	 * @return ������ ��������
	 */
	public int height() {
		return picture.height();
	}

	/**
	 * @return ������ ������ � ����� x ������� y
	 */
	public double energy(int x, int y) {
		if (x == 0 || x == (height() - 1) || y == 0 || y == (width() - 1))
			return 1000;

		int redX = colorMatrix[x + 1][y].getRed() - colorMatrix[x - 1][y].getRed();
		int greenx = colorMatrix[x + 1][y].getGreen() - colorMatrix[x - 1][y].getGreen();
		int blueX = colorMatrix[x + 1][y].getBlue() - colorMatrix[x - 1][y].getBlue();
		double dx = redX * redX + greenx * greenx + blueX * blueX;

		int redY = colorMatrix[x][y + 1].getRed() - colorMatrix[x][y - 1].getRed();
		int greenY = colorMatrix[x][y + 1].getGreen() - colorMatrix[x][y - 1].getGreen();
		int blueY = colorMatrix[x][y + 1].getBlue() - colorMatrix[x][y - 1].getBlue();
		double dy = redY * redY + greenY * greenY + blueY * blueY;

		return Math.sqrt(dx + dy);
	}

	/**
	 * ��������� ������� ����㳿 ������
	 */
	public void createEnergyMatrix() {
		energyMatrix = new double[height()][width()];
		for (int row = 0; row < height(); row++)
			for (int col = 0; col < width(); col++)
				energyMatrix[row][col] = energy(row, col);
	}

	/**
	 * ��������� ������� �������
	 */
	public void createColorMatrix() {
		colorMatrix = new Color[height()][width()];
		for (int row = 0; row < height(); row++)
			for (int col = 0; col < width(); col++)
				colorMatrix[row][col] = picture.get(col, row);
	}

	/**
	 * @return ����� ������� �� ����� ��������
	 */
	private int[] findVerticalSeam() {
		AcyclicSP acyclic = new AcyclicSP(graph, 0);

		int[] path = new int[height()];
		int i = height();
		for (int p : acyclic.pathTo(graph.V() - 1)) {
			if (i != height())
				path[i] = getCol(p, i);
			i--;
		}

		return path;
	}
	
	
	/**
	 * @return ����� �������
	 */
	private int getCol(int indx, int row) {
		return indx - 1 - (row * width());
	}

	

	/**
	 * ������� ����� ������� � ��������
	 */
	private void removeVerticalSeam(int[] seam) {
		if (seam == null || seam.length == 0)
			return;

		Color[][] tempColor = new Color[height()][width() - 1];

		for (int row = 0; row < height(); row++) {
			for (int col = 0, i = 0; col < width(); col++) {
				if (col != seam[row]) {
					tempColor[row][i] = colorMatrix[row][col];
					i++;
				}
			}
		}
		colorMatrix = tempColor;
	}

	/**
	 * ������� ���� ��������, � ��� �� ����� ����, �� ���� ������� ����㳿
	 */
	private void createPicture(int w, int h) {
		Picture pic = new Picture(w, h);
		for (int row = 0; row < h; row++)
			for (int col = 0; col < w; col++)
				pic.set(col, row, colorMatrix[row][col]);

		picture = pic;
		createEnergyMatrix();
		createGraph();
	}

	
	/**
	 * @return ����� �����
	 */
	public String graphToString() {
		String str = "";
		for (int i = 0; i < graph.V(); i++) {
			for (DirectedEdge edg : graph.adj(i))
				str += edg.toString();

			str += "\n";
		}
		return str;
	}


	/**
	 * @return ����������� �������
	 */
	public String energyToString() {
		String str = "";
		for (int i = 0; i < height(); i++) {
			for (int j = 0; j < width(); j++) {
				str += ((int) energyMatrix[i][j] + " ");
			}
			str += "\n";
		}
		return str;
	}

	/**
	 * @return ������� �������
	 */
	public String pictureToString() {
		String str = "";
		for (int i = 0; i < height(); i++) {
			for (int j = 0; j < width(); j++) {
				str += (colorMatrix[i][j] + " ");
			}
			str += "\n";
		}
		return str;
	}

	/**
	 * ������� �������� �� ����� �� w
	 */
	public void cutPicture(int w) {
		if (w == width())
			throw new IllegalArgumentException("������ �������� �� ���� ���� ������� �� 1 ������");

		for (int i = 0; i < w; i++) {
			int[] seam = findVerticalSeam();
			removeVerticalSeam(seam);
			createPicture(width() - 1, height());
		}
	}

	public static void main(String[] args) {
		//SeamCarving sc = new SeamCarving(new Picture("img/12x10.png"));
		SeamCarving sc = new SeamCarving(new Picture("img/tom&jery.jpg"));
		// SeamCarving sc = new SeamCarving(new Picture("img/mcorp.jpg"));
		//SeamCarving sc = new SeamCarving(new Picture("img/timon.jpg"));
		sc.picture().show();
		sc.cutPicture(300);
		sc.picture().show();
	}

}