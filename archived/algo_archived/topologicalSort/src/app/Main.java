package app;

import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<Vertex>  graph = new GraphFactory().getGraph();
		List<Vertex> sortedGraph = new TopoSorter().getSortedGraph(graph);
		System.out.println(sortedGraph);
	}
}
