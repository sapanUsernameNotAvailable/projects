package app;

/**
 * graph structure as per :
 * http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm 
 * Dated : 27 sep 2014
 * */
public class GraphFactory {
	final Vertex one;
	final Vertex two;
	final Vertex three;
	final Vertex four;
	final Vertex five;
	final Vertex six;

	GraphFactory() {
		// vertices
		one = new Vertex(1);
		two = new Vertex(2);
		three = new Vertex(3);
		four = new Vertex(4);
		five = new Vertex(5);
		six = new Vertex(6);

		// edges
		initPair(one, two, 7);
		initPair(one, three, 9);
		initPair(one, six, 14);

		initPair(two, four, 15);
		initPair(two, three, 10);

		initPair(three, four, 11);
		initPair(three, six, 2);

		initPair(four, five, 6);
		initPair(six, five, 9);
	}

	public Vertex getGraph() {
		return one;
	}
	
	public Vertex getTarget() {
		return five;
	}

	private void initPair(Vertex foo, Vertex bar, int weight) {
		Edge connectingEdge = new Edge(foo, bar, weight);
		foo.addEdge(connectingEdge);
		bar.addEdge(connectingEdge);
	}
}