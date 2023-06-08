package app;

import java.util.HashSet;
import java.util.Set;

public class Vertex {

	int id;
	Set<Vertex> previous = new HashSet<>();
	Set<Vertex> next = new HashSet<>();

	public Vertex(int id) {
		this.id = id;
	}

	public void addPrevious(Vertex vertex) {
		previous.add(vertex);
	}

	public void addNext(Vertex vertex) {
		next.add(vertex);
	}

	public Set<Vertex> getPrevious() {
		return previous;
	}

	public Set<Vertex> getNext() {
		return next;
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + "]";
	}
}