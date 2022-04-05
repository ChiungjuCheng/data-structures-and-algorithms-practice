package graph;

import java.util.LinkedList;

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

	public void dfsRec(LinkedList<Integer>[] adj) {
		boolean hasVistited[] = new boolean[V];

		// 避免圖片為not connected
		for (int currentRoot = 0; currentRoot < V; currentRoot++) {
			if (!hasVistited[currentRoot]) {
				dfsUtil(adj, currentRoot, hasVistited);
			}
		}
	}

	public void dfsUtil(LinkedList<Integer>[] adj, int currentRoot, boolean hasVistited[]) {

		System.out.print(currentRoot + " ");
		hasVistited[currentRoot] = true;
		for (Integer adjecent : adj[currentRoot]) {
			if (!hasVistited[adjecent]) {
				dfsUtil(adj, adjecent, hasVistited);
			}
		}

	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.dfsRec(g.getAdj());
	}

}
