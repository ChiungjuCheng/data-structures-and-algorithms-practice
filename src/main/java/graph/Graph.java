package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * DFS Recursion
 * https://www.geeksforgeeks.org/java-program-for-depth-first-search-or-dfs-for-a-graph/
 */
public class Graph {
	private int V; // number of nodes

	private LinkedList<Integer> adj[]; // adjacency list

	// Constructor
	public Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList();
		}
	}

	// Function to add an edge into the graph
	void addEdge(int node, int w) {
		adj[node].add(w); // Add w to v\'s list.
	}

	public LinkedList<Integer>[] getAdj() {
		return adj;
	}

	public void bfsIterative() {
		boolean hasVistited[] = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		hasVistited[0] = true;

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			System.out.print(currentNode + " ");

			for (Integer adjecent : adj[currentNode]) {

				if (!hasVistited[adjecent]) {
					queue.offer(adjecent);
					hasVistited[adjecent] = true;
				}

			}
		}

	}

	/**
	 * BFS Recursion
	 */
	public void bfsRec() {
		boolean hasVistited[] = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		hasVistited[0] = true;

		bfsRecUtil(queue, hasVistited);

	}

	private void bfsRecUtil(Queue<Integer> queue, boolean hasVistited[]) {

		if (queue.isEmpty()) {
			return;
		}

		int currentNode = queue.poll();
		System.out.print(currentNode + " ");

		for (Integer adjecent : adj[currentNode]) {

			if (!hasVistited[adjecent]) {
				queue.offer(adjecent);
				hasVistited[adjecent] = true;
			}

		}

		bfsRecUtil(queue, hasVistited);
	}

	/**
	 * preorder DFS
	 */
	public void dfsIterative() {
		boolean hasVistited[] = new boolean[V];

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		hasVistited[0] = true;

		while (!stack.isEmpty()) {
			int currentRoot = stack.pop();
			System.out.print(currentRoot + " ");

			for (int adjcent : adj[currentRoot]) {
				if (!hasVistited[adjcent]) {
					hasVistited[adjcent] = true;
					stack.push(adjcent);

				}
			}

		}

	}

	/**
	 * DFS recursive method
	 * 
	 * @param adj
	 */
	public void dfsRec(LinkedList<Integer>[] adj) {
		boolean hasVistited[] = new boolean[V];

		// 避免圖片為not connected
		for (int currentRoot = 0; currentRoot < V; currentRoot++) {
			if (!hasVistited[currentRoot]) {
				dfsRecUtil(adj, currentRoot, hasVistited);
			}
		}
	}

	private void dfsRecUtil(LinkedList<Integer>[] adj, int currentRoot, boolean hasVistited[]) {

		System.out.print(currentRoot + " ");
		hasVistited[currentRoot] = true;
		for (Integer adjecent : adj[currentRoot]) {
			if (!hasVistited[adjecent]) {
				dfsRecUtil(adj, adjecent, hasVistited);
			}
		}

	}

}
