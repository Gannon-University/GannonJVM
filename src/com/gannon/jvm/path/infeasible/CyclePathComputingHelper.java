package com.gannon.jvm.path.infeasible;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.jung.graph.Graph;

//http://stackoverflow.com/questions/12367801/finding-all-cycles-in-undirected-graphs
public class CyclePathComputingHelper {
	private int[][] graph;
	private Graph<FNode, FEdge> jungGraph;
	private List<int[]> cycles = new ArrayList<int[]>();

	public CyclePathComputingHelper(int[][] graph) {
		super();
		this.graph = graph;
	}

	public CyclePathComputingHelper(Graph<FNode, FEdge> jungGraph) {
		super();
		this.jungGraph= jungGraph;
		List<FEdge> edges = new ArrayList<FEdge>(jungGraph.getEdges());
		graph = new int[jungGraph.getEdgeCount()][2];
		for (int i = 0; i < graph.length; i++) {
			ArrayList<FNode> nodes = new ArrayList<FNode>(
					jungGraph.getIncidentVertices(edges.get(i)));
			graph[i][0] = nodes.get(0).getId();
			graph[i][1] = nodes.get(1).getId();
		}
	}

	public List<int[]> computingAllCycles() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				//System.out.println("["+i +" "+ j+"]");
				findNewCycles(new int[] { graph[i][j] });
			}
		}
		return cycles;
	}

	public List<CyclePath> computingCyclePaths() {
		cycles=computingAllCycles();
		List<CyclePath> cycleGraphs = new ArrayList<CyclePath>();
		for (int j=0;j< cycles.size();j++) {
			int[] path=cycles.get(j);
			CyclePath g=new CyclePath(j, path, jungGraph);
			cycleGraphs.add(g);
		}
		return cycleGraphs;
	}

	private void findNewCycles(int[] path) {
		int n = path[0];
		int x;
		int[] sub = new int[path.length + 1];

		for (int i = 0; i < graph.length; i++)
			for (int y = 0; y <= 1; y++)
				if (graph[i][y] == n)
				// edge refers to our current node
				{
					x = graph[i][(y + 1) % 2];
					if (!visited(x, path))
					// neighbor node not on path yet
					{
						sub[0] = x;
						System.arraycopy(path, 0, sub, 1, path.length);
						// explore extended path
						findNewCycles(sub);
					} else if ((path.length > 2)
							&& (x == path[path.length - 1]))
					// cycle found
					{
						int[] p = normalize(path);
						int[] inv = invert(p);
						if (isNew(p) && isNew(inv)) {
							cycles.add(p);
						}
					}
				}
	}

	// check of both arrays have same lengths and contents
	private Boolean equals(int[] a, int[] b) {
		Boolean ret = (a[0] == b[0]) && (a.length == b.length);

		for (int i = 1; ret && (i < a.length); i++) {
			if (a[i] != b[i]) {
				ret = false;
			}
		}

		return ret;
	}

	// create a path array with reversed order
	private int[] invert(int[] path) {
		int[] p = new int[path.length];

		for (int i = 0; i < path.length; i++) {
			p[i] = path[path.length - 1 - i];
		}

		return normalize(p);
	}

	// rotate cycle path such that it begins with the smallest node
	private int[] normalize(int[] path) {
		int[] p = new int[path.length];
		int x = smallest(path);
		int n;

		System.arraycopy(path, 0, p, 0, path.length);

		while (p[0] != x) {
			n = p[0];
			System.arraycopy(p, 1, p, 0, p.length - 1);
			p[p.length - 1] = n;
		}

		return p;
	}

	// compare path against known cycles
	// return true, iff path is not a known cycle
	private Boolean isNew(int[] path) {
		Boolean ret = true;

		for (int[] p : cycles) {
			if (equals(p, path)) {
				ret = false;
				break;
			}
		}

		return ret;
	}

	public void o(String s) {
		System.out.println(s);
	}

	// return the int of the array which is the smallest
	private int smallest(int[] path) {
		int min = path[0];

		for (int p : path) {
			if (p < min) {
				min = p;
			}
		}

		return min;
	}

	// check if vertex n is contained in path
	private Boolean visited(int n, int[] path) {
		Boolean ret = false;

		for (int p : path) {
			if (p == n) {
				ret = true;
				break;
			}
		}

		return ret;
	}


}