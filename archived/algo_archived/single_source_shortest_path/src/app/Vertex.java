package app;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
	final int id;
	Set<Edge> edges = new HashSet<Edge>();
	
	public Vertex(int id) {
		this.id = id;
	}
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public Set<Edge> getEdges() {
		return edges;
	}
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		return id == ((Vertex)obj).id;
	}
	@Override
	public String toString() {
		return "Vertex [id=" + id + "]";
	}
}