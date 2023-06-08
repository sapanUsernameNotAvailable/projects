package app;

public class Main {

	public static void main(String[] args) {

		Vertex source =  new GraphFactory().getGraph();
		Vertex target =  new GraphFactory().getTarget();
		SingleSourceShortestPathSolver singleSourceShortestPathSolver = new SingleSourceShortestPathSolver();
		System.out.println(singleSourceShortestPathSolver.getShortestPath(source, target));
	}
}
