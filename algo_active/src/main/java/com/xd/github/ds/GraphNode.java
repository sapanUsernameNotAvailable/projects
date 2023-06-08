package com.xd.github.ds;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class GraphNode<T> {

    T data;
    Map<GraphNode<T>, Direction> neighbours;

    public GraphNode(T data) {
        this.data = data;
        neighbours = new HashMap<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Set<GraphNode<T>> getNeighbours() {
        return neighbours.keySet();
    }

    public void setNeighbours(Map<GraphNode<T>, Direction> neighbours) {
        this.neighbours = neighbours;
    }
    public void addNeighbour(GraphNode<T> neighbour, Direction direction) {
        this.neighbours.put(neighbour, direction);
    }
    
    public boolean hasNoIncomingDirection() {
        for (Map.Entry<GraphNode<T>, Direction> neighbour : neighbours.entrySet()) {
            if (neighbour.getValue().equals(Direction.INWARD)) {
                return false;
            }
        }
        // no incoming edge
        return true;
    }
    
    public void removeNeighbour(GraphNode<T> neighbour) {
        this.neighbours.remove(neighbour);
    }

    @Override
    public String toString() {
        String neighbourData = "";
        for (Map.Entry<GraphNode<T>, Direction> nodeToDirection : neighbours.entrySet()) {
            neighbourData += nodeToDirection.getKey().getData().toString() + ":" + nodeToDirection.getValue().toString() + " ";
        }
        return MessageFormat.format("[ GraphNode : data={0}, neighbours={1} ]", new Object[] {data, neighbourData});
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GraphNode<?> other = (GraphNode<?>) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }
}