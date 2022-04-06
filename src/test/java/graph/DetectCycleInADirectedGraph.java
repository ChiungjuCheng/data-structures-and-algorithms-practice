package graph;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Detect cycle in a directed graph
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1/?page=2&curated[]=5&sortBy=submissions#
 * @author User
 *
 */
public class DetectCycleInADirectedGraph {
	private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	private static final int V = 5;

	@BeforeAll
	static void creatGraph() {

		for (int i = 0; i < V + 1; i++) {
			adj.add(new ArrayList<Integer>());
		}

		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(3).add(3);
	}

	@Test
	void test() {
		assertTrue(isCyclic(V, adj));
	}

	// Function to detect cycle in a directed graph.
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		return dfsRec(V, adj);
	}

	private boolean dfsRec(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean hasVistited[] = new boolean[V];

		for (int currentRoot = 0; currentRoot < V; currentRoot++) {
			if (!hasVistited[currentRoot]) {
				Set<Integer> inProcess = new HashSet<>();
				inProcess.add(currentRoot);
				if (dfsRecUtil(adj, currentRoot, hasVistited, inProcess)) {
					return true;
				}

			}
		}

		return false;
	}

	private boolean dfsRecUtil(ArrayList<ArrayList<Integer>> adj, int currentRoot, boolean hasVistited[],
			Set<Integer> inProcess) {

		if (inProcess.contains(currentRoot) && hasVistited[currentRoot]) {
			return true;
		}

		hasVistited[currentRoot] = true;

		for (Integer adjecent : adj.get(currentRoot)) {
			if (!hasVistited[adjecent]) {
				inProcess.add(adjecent);
				if (dfsRecUtil(adj, adjecent, hasVistited, inProcess)) {
					return true;
				}
				inProcess.remove(adjecent);
			} else {
				if (inProcess.contains(adjecent)) {
					return true;
				}
			}
		}

		return false;
	}
}
