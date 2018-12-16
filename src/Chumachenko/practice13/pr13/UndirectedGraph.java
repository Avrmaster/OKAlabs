package pr13;

import prinston.In;
import prinston.StdOut;

/**
 * �������� ��������� ���� ��� ���������� ��� ������������ ������
 * 
 * �������� ����, �� ������ � ����� ��������� ������������ ������������ ����
 * �� �� ��� ������, �� ���������� ��������� ���� � ���� ��������� ��������,
 * ���� ���� �������
 */
public class UndirectedGraph {

	/**
	 * �������� �� �� ���� g ���� ������ � ����� ��� ����
	 */
	public void checkEulerCycle(Graph g) {
		EulerianGraph eg = new EulerianGraph(g, new In("src/coordinates.txt"));
		Iterable<Integer> path = new EulerianCycle(g).cycle();

		if (path != null) {
			StdOut.print("Eulerian cycle:  ");
			for (int v : path)
				StdOut.print(v + " ");

			eg.showPath(path);
		} else {
			StdOut.println("Eulerian cycle:   none");
			eg.showGraph();
		}
	}

	/**
	 * �������� �� �� ���� g ���� ������ � ����� ��� ����
	 */
	public void checkHamiltonCycle(Graph g) {
		EulerianGraph eg = new EulerianGraph(g, new In("src/coordinates.txt"));
		HamiltonianCycle hm = new HamiltonianCycle(g);

		if (hm.hasHamiltonCycle(0)) {
			StdOut.print("Hamilton cycle:  ");
			for (int v : hm.cycle())
				StdOut.print(v + " ");
			
			eg.showGraph();
			eg.showPath(hm.cycle());
		} else {
			StdOut.println("Hamilton cycle:   none");
			eg.showGraph();
		}
	}

	public static void main(String[] args) {
//		String fileName = "src/source3sinks2.txt";
	//	String fileName = "src/hamiltonYes.txt";
		String fileName = "src/eulerYes.txt";
//		String fileName = "src/hamiltonNo.txt";
		Graph g = new Graph(new In(fileName));

		new UndirectedGraph().checkEulerCycle(g);
		StdOut.println();
		new UndirectedGraph().checkHamiltonCycle(g);
	}

}
