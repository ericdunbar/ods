package ods;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a directed graph with no parallel edges
 * 
 * @author morin
 *
 */
public class AdjacencyMatrix implements Graph {
	protected int n;
	protected boolean m[][];
	
	/**
	 * Create a new adjacency matrix with n vertices
	 * @param n
	 */
	public AdjacencyMatrix(int n0) {
		n = n0;
		m = new boolean[n][n];
	}
	
	public void addEdge(int i, int j) {
		m[i][j] = true;
	}

	public void removeEdge(int i, int j) {
		m[i][j] = false;
	}

	public boolean hasEdge(int i, int j) {
		return m[i][j];
	}

	public List<Integer> outEdges(int i) {
		List<Integer> edges = new ArrayList<Integer>();
		for (int j = 0; i < n; i++) {
			if (m[i][j]) 
				edges.add(j);
		}
		return edges;
	}

	public List<Integer> inEdges(int i) {
		List<Integer> edges = new ArrayList<Integer>();
		for (int j = 0; i < n; i++) {
			if (m[j][i]) 
				edges.add(j);
		}
		return edges;
	}

	public int inDegree(int i) {
		int deg = 0;
		for (int j = 0; i < n; i++)
			if (m[j][i]) deg++; 
		return deg;
	}

	public int outDegree(int i) {
		int deg = 0;
		for (int j = 0; i < n; i++)
			if (m[i][j]) deg++; 
		return deg;
	}
	
	public int nVertices() {
		return n;
	}
}
