package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopoSorter {

	public List<Vertex> getSortedGraph(Set<Vertex> graph) {
		List<Vertex> sortedResult  = new ArrayList<Vertex>();

		Set<Vertex> verticesWithOutgoingEdgesOnly;
		while (!graph.isEmpty()) {
			// Can be improved if I fetch next generation vertices with no incoming edges from current such edges,
			// instead of iterating over the entire graph.
			// That simple change will improve complexity to O(n), but I'll pick it up after brushing up other algos. (I'm sleepy, excuse my excuse.)
			verticesWithOutgoingEdgesOnly = getVerticesWithOutgoingEdgesOnly(graph);
			sortedResult.addAll(verticesWithOutgoingEdgesOnly);
			removeVerticesFromGraph(graph, verticesWithOutgoingEdgesOnly);
		}
		return sortedResult;
	}

	private Set<Vertex> getVerticesWithOutgoingEdgesOnly(Set<Vertex> graphVertices) {
		Set<Vertex> result = new HashSet<Vertex>();
		for (Vertex vertex : graphVertices) {
			if (vertex.getPrevious().isEmpty()) {
				result.add(vertex);
			}
		}
		return result;
	}
	
	private void removeVerticesFromGraph(Set<Vertex> graph, Set<Vertex> verticesToBeRemoved) {
		for (Vertex toBeRemoved : verticesToBeRemoved) {
			for (Vertex child : toBeRemoved.getNext()) {
				child.getPrevious().remove(toBeRemoved);
			}
		}
		graph.removeAll(verticesToBeRemoved);
	}
}