package app;

public class Edge {
	final Vertex foo;
	final Vertex bar;
	final int weight;

	public Edge(Vertex foo, Vertex bar, int weight) {
		this.foo = foo;
		this.bar = bar;
		this.weight = weight;
	}
	
	// Function exists because this is not a directed graph.
	public Vertex getOtherVertex(Vertex inc) {
		if (inc.equals(foo)) {
			return bar;
		}else if (inc.equals(bar)) {
			return foo;
		} else {
			throw new IllegalArgumentException(
					"inc : " + inc.id + ", "
					+ "foo : " + foo.id + ", " 
					+ "bar : " + bar.id + ", "
					+ "edge weight : " + weight);
		}
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Edge [foo=" + foo.getId() + ", bar=" + bar.getId() + ", weight=" + weight + "]";
	}
}