package maze;


/**
 * клас, що створює граф
 *
 */
public class Graph {
	
	private final int V;
	private Bag<Integer>[] adj;
	
	/**
	 * Створюємо порожній граф розмірності V 
	 * ініціалізуємо масив порожніми списками типу Bag
	 * @param V - кількість вершин
	 */
	public Graph(int V){
		this.V=V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v=0; v<V; v++)
			adj[v] = new Bag<Integer>();
	}
	
	/**
	 * додаємо ребро між двома вершинами
	 * @param v - вершина
	 * @param w - вершина
	 */
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	/**
	 * @param v - вершина графу
	 * @return - ступінь вершини графу v
	 */
	public int degree(int v){
		int degree = 0;
		for (int w : adj(v))
			degree++;
		return degree;
	}
	
	/**
	 * ітератор по вершинам суміжним з вершиною v
	 * @param v - вершина
	 * @return - ітератор по мішку суміжних з v вершин
	 */
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V() {
		return V;
	}
}
