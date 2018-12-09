//��������� ��������� ����� Percolation
//public class Percolation { 
//public Percolation(int N) 
//// ��������� ������� N-��-N, � ���� ������������� �ᒺ����� 
//public int getOpenedCount()
//������ � ��������� ������� �������� ������
//public void open(int i, int j) 
//// ������� �ᒺ�� (row i, column j) ���� �� �� �� �������� 
//public boolean isOpened(int i, int j) 

//public boolean percolates() 
//// �� ������ �������? 
//}
public class Percolation {
	int[][] matrix;
	WeightedQuickUnionUF f;
	int n;
	int top = 0;
	int bottom;

	double counter = 0;

	public Percolation(int N) 
	{
		this.n = N;
		matrix = new int[N][N];

		f = new WeightedQuickUnionUF(N * N + 2);
		unionMatrix();
		while (!percolates()) 
		{
			open((int) (Math.random() * n), (int) (Math.random() * n));
		}

	}

	public void unionMatrix() 
	{
		bottom = (n * n + 1);
		for (int i = 1; i <= n; i++) 
		{
			f.union(top, i);
			f.union(bottom, n * n + 1 - i);
		}

	}


	public double getCounter() 
	{
		return counter;
	}

	public void setCounter(int counter) 
	{
		this.counter = counter;
	}

	// ������� �ᒺ�� (row i, column j) ���� �� �� �� ��������
	public void open(int i, int j) 
	{
		if (matrix[i][j] == 0)
		{
			matrix[i][j] = 1;
			counter++;
			if (i > 0)
				if (isOpened(i-1,j))
					f.union((n * j + i + 1), (n * j + i + 1) - 1);

			if (i < (n - 1))
				if (isOpened(i+1,j))
					f.union((n * j + i + 1), (n * j + i + 1) + 1);
			if (j > 0)
				if (isOpened(i,j-1))
					f.union((n * j + i + 1), (n * j + i + 1) - n);
			if (j < (n - 1))
				if (isOpened(i,j+1))
					f.union((n * j + i + 1), (n * j + i + 1) + n);

		}

	}

	// �� ������� �ᒺ�� (row i, column j)?
	public boolean isOpened(int i, int j) {
		if (matrix[i][j] == 0)
			return false;
		return true;
	}

	// �� ������ �������?
	public boolean percolates() 
	{
		if (f.connected(top, bottom)) 
		{
			// System.out.println("t");
			return true;

		}
		return false;

	}

	public static void main(String[] args) 
	{

		Percolation p = new Percolation(100);

	}
}
