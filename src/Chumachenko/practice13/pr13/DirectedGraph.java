package pr13;

import prinston.In;
import prinston.StdOut;

/**
 * �������� ��������� ���� ���� ���� ��� ���������� ������
 * 
 * �������� ����, �� ������ � ����� ��������� ������������ ���������� ����
 * �� �� ��� ������, �� ���������� ��������� ���� � ���� ��������� ��������,
 * ���� ���� �������
 */
public class DirectedGraph {

	/**
	 * �������� ����, ���� � ��������� ����
	 */
	public void checkEulerCycle(Digraph g) {
		Iterable<Integer> path = new EulerianCycle(g).cycle();

		if (path != null) {
			StdOut.print("Eulerian cycle:  ");
			for (int v : path)
				StdOut.print(v + " ");
		} else {
			StdOut.println("Eulerian cycle:   none");
		}
	}


	public static void main(String[] args) {
//		String fileName = "src/source3sinks2.txt";
//		String fileName = "src/hamiltonYes.txt";
		String fileName = "src/directedEulerYes.txt";
//		String fileName = "src/hamiltonNo.txt";
		Digraph g = new Digraph(new In(fileName));
		new DirectedGraph().checkEulerCycle(g);
		StdOut.println();

	}

}
