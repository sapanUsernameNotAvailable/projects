package app;

import java.util.HashSet;
import java.util.Set;


/**
 * Uses : 
 * http://en.wikipedia.org/wiki/Topological_sorting
 * Dates : 
 * 29 sep 2014
 * */
public class GraphFactory {
	final Vertex v7;
	final Vertex v5;
	final Vertex v3;
	
	final Vertex v11;
	final Vertex v8;
	final Vertex v2;
	final Vertex v9;
	final Vertex v10;
	
	GraphFactory() {
		// vertices
		v7 = new Vertex(7);
		v5 = new Vertex(5);
		v3 = new Vertex(3);

		v8 = new Vertex(8);
		v11 = new Vertex(11);
		
		v2 = new Vertex(2);
		v9 = new Vertex(9);
		v10 = new Vertex(10);
		
		
		// edges
		initPair(v7, v11);
		initPair(v7, v8);
		initPair(v5, v11);
		initPair(v3, v8);
		initPair(v3, v10);
		
		initPair(v11, v2);
		initPair(v11, v9);
		initPair(v11, v10);
		initPair(v8, v9);
	}

	public Set<Vertex> getGraph() {
		Set<Vertex> graphVertices = new HashSet<Vertex>();
		graphVertices.add(v7);
		graphVertices.add(v5);
		graphVertices.add(v3);
		graphVertices.add(v11);
		graphVertices.add(v8);
		graphVertices.add(v2);
		graphVertices.add(v9);
		graphVertices.add(v10);
		return graphVertices;
	}
	
	private void initPair(Vertex previous, Vertex next) {
		previous.addNext(next);
		next.addPrevious(previous);
	}
}