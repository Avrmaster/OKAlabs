package meize;

 /** DFS realization
 * �� ��������� � �������. ���� � ������� ����������� ������ �����, �� ��������� ��� ����������� ������. ������ ������ � ��������, ��� �� ������ �����, �� ����.

�� �'��������� � ������� ������ � ���� � �� �� �����, ������� �������� � �����, ������ ����� �'��������� ���������.

���� ������ ������ ���� �� ����� �������������� ����� DFS � BFS, �� ��������� ������� ����, ������� �����, �� ������� �������� �����.

�� �� �������� ������� �������� � ������ �����. ��� ��������� DFS � BFS ����� ��������� � ����� ��� ���� � ������� ��������� �� ������.

�� �������� ������� ��������� ���������.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstPaths {

	private boolean[] marked;    
    private int[] edgeTo;        
    private final int s;     //������ ����� (�����)    
    
    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.getV()];
        marked = new boolean[G.getV()];
        dfs(G, s);
    }
    
    /**
     * ����� � �������
     * @param G - ����
     * @param v - dfs � ������� v
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    
    /**
     * �� �������� ���� � v � s, �� ������ �������������
     * @param v - ������� �� ��� ������ ����
     * @return true ���� � ����, false ���� ����
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    /**
     * ������� ���� �� s �� v; null ���� ����� ����
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
    	Scanner sc=new Scanner(new File("src/meize/first.txt"));
    	int lamp=sc.nextInt();
    	int v=sc.nextInt();
    	int edge=sc.nextInt();
    	Graph gr=new Graph(v);
    	
    	for(int i=0; i<edge;i++) {
    		int e=sc.nextInt();
    		int e1=sc.nextInt();
    		gr.addEdge(e, e1);
    	}
    	DepthFirstPaths dfs=new DepthFirstPaths(gr, lamp);
    	if(dfs.hasPathTo(0)) {
    		Stack path = (Stack) dfs.pathTo(0);
    	for(int weg:dfs.pathTo(0)) 
    		System.out.print(weg+" - ");
    	System.out.println(" DFS Path");
    	System.out.println("Amount of veges:"+ path.size());
    	System.out.println("Path`s lenght:"+ (path.size()-1));
    	}else {
    		System.err.println("No path found!");
    	}
    	
    }

    
    
}