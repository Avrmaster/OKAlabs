

import java.util.Stack;

//import princeton.lib.In;
//import princeton.lib.StdOut;

//import ua.com.oka.lib.Graph;

public class DepthFirstPaths {

	private boolean[] marked;    
    private int[] edgeTo;        
    private final int s;  // lampa       
    
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
     * �� ��������� ���� � v � s, �� ������ �������������
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
    
    private static final String testFile = "tinyCG.txt";
    
   
}
