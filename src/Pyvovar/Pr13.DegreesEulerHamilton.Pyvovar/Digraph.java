package practice;

import java.util.Vector;

import princetonlib.In;

/**
 * Орієнтований граф
 * 
 * @author Пивовар Олена, 4 група, ІПЗ
 */
public class Digraph {

	private final int V;
	private int E;
	private Vector<Integer>[] adj;

	/**
	 * Створюємо порожній орграф розмірності V ініціалізуємо масив порожніми
	 * списками типу Vector
	 * 
	 * @param V - кількість вершин
	 */
	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Vector<Integer>[]) new Vector[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Vector<Integer>();
	}

	/**
	 * Створюємо діграф із файлу
	 */

	public Digraph(In in) {
		super();
		V = in.readInt();
		adj = new Vector[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Vector<Integer>();

		int e = 0;
		while (in.hasNextLine()) {
			int from = in.readInt();
			int to = in.readInt();
			addEdge(from, to);
			e++;
		}

		this.E = e;
	}

	/**
	 * додаємо орієнтоване ребро з v в w
	 * 
	 * @param v - вершина
	 * @param w - вершина
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	/**
	 * @param v - вершина графу
	 * @return - ступінь вершини графу v
	 */
	public int degree(int v) {
		int degree = 0;
		for (int w : adj(v))
			degree++;
		return degree;
	}

	/**
	 * ітератор по вершинам суміжним з вершиною v
	 * 
	 * @param v - вершина
	 * @return - ітератор по мішку суміжних з v вершин
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	/**
	 * @return кількість вершин
	 */
	public int V() {
		return V;
	}

	/**
	 * @return кількість ребер
	 */
	public int E() {
		return E;
	}

	/**
	 * Перевертаємо граф (напрямок кожного пебра змінюється на протилежний)
	 *
	 * @return the reverse of the digraph
	 */
	public Digraph reverse() {
		Digraph reverse = new Digraph(V);
		for (int v = 0; v < V; v++) {
			for (int w : adj(v)) {
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}

	/**
	 * @param v
	 * @param w
	 * @return чи з'єднуються v та w лише 1 ребром
	 */
	public boolean oneEdje(int v, int w) {
		for (int vector : adj(v)) {
			if (vector == w)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < V; i++) {
			for (int v : adj(i)) {
				sb.append(i).append("->").append(v).append("\n");
			}
		}
		return sb.toString();
	}
}
