public class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg.equals("�������"))
			Insertion.sort(a);
		if (alg.equals("�����"))
			Selection.sort(a);
		if (alg.equals("�����"))
			Shell.sort(a);
		if (alg.equals("�������"))
			Merge.sort(a);
		if (alg.equals("�������"))
			Quick.sort(a);
		if (alg.equals("�������������"))
			Heap.sort(a);
		return timer.elapsedTime();
	}

	public static double timeRandomlnput(String alg, int N, int T) { // alg ��������� �������� ���������� T ���������
																		// �������� ������ N.
		double total = 0.0;
		Double[] � = new Double[N];
		for (int t = 0; t < T; t++) { // ���������� ������ ������������ (��������� � ���������� �������).
			for (int i = 0; i < N; i++) {�[i] = StdRandom.uniform();}
				
			total += time(alg, �);
		}
		return total;
	}

	public static void main(String[] args) {
		String algl = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double tl = timeRandomlnput(algl, N, T); // ����� ����� ��� algl
		double t2 = timeRandomlnput(alg2, N, T); // ����� ����� ��� alg2
		System.out.printf("��� %d ��������� Doubles\n %s �", N, algl);
		StdOut.printf(" %.lf ��� �������, ��� %s\n", t2 / tl, alg2);
	}
	// 
}