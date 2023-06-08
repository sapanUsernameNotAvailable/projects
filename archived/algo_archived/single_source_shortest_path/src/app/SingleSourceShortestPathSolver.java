package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Dijkstra's algorithm using priority queue
 * */
public class SingleSourceShortestPathSolver {

	Map<Vertex, Integer> vertexToSourceDistance = new HashMap<Vertex, Integer>();
	Map<Vertex, Vertex> nextToCurrentVertices = new HashMap<Vertex, Vertex>();
	Map<Vertex, Vertex> currentToPreviousVertices = nextToCurrentVertices; 
	PriorityQueue<Vertex> verticesByDistanceFromSource = new PriorityQueue<Vertex>(
			10, new Comparator<Vertex>() {
				@Override
				public int compare(Vertex v1, Vertex v2) {

					Integer v1Distance = vertexToSourceDistance.get(v1);
					Integer v2Distance = vertexToSourceDistance.get(v2);

					if (v2Distance == null || v1Distance < v2Distance) {
						return -1;
					} else if (v1Distance == null || v1Distance > v2Distance) {
						return +1;
					} else {
						return 0;
					}
				};
			});
	
	private void initPaths(final Vertex source) {
		vertexToSourceDistance.put(source, 0);
		verticesByDistanceFromSource.add(source);
		while (!verticesByDistanceFromSource.isEmpty()) {

			Vertex neighbour;
			int weight,distanceThroughCurrent;
			final Vertex current = verticesByDistanceFromSource.poll();
			for (Edge edge : current.getEdges()) {
				neighbour = edge.getOtherVertex(current);
				weight = edge.weight;
				distanceThroughCurrent = vertexToSourceDistance.get(current) + weight;
				if (vertexToSourceDistance.get(neighbour) == null
					|| distanceThroughCurrent < vertexToSourceDistance.get(neighbour)) {
					verticesByDistanceFromSource.remove(neighbour);
					vertexToSourceDistance.put(neighbour, distanceThroughCurrent);
					nextToCurrentVertices.put(neighbour,current);
					verticesByDistanceFromSource.add(neighbour);
				}
			}
		}
	}
	
	public List<Vertex> getShortestPath(final Vertex source, final Vertex target) {

		initPaths(source);
		
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex current = target; current != null; current = currentToPreviousVertices.get(current)) {
			path.add(current);
		}
		Collections.reverse(path);
		return path;
	}
}