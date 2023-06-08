package com.xd.github.ds.factory;

import com.xd.github.ds.Direction;
import com.xd.github.ds.GraphNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class GraphFactory {

    /**
     * Converts adjacency matrix type data to set of nodes representing a graph.
     *
     * for 3 -> 4 \ / (downward arrows) 5
     *
     * @param <T> data type of graph node
     * @param numberOfNodes eg : 5
     * @param nodeValues eg : [3, 4, 5]
     * @param adjacencyMatrix eg :
     *
     * [// 3 4 5 [false, true, true], // 3 [false, false, true], // 4 [false,
     * false, false] // 5 ]
     * @return
     */
    public <T> Set<GraphNode<T>> getGraphFromAdjacencyMatrix(int numberOfNodes, T[] nodeValues, boolean[][] adjacencyMatrix) {
        List<GraphNode<T>> graphNodes = new ArrayList<>();
        Stream.of(nodeValues).forEach(value -> {
            graphNodes.add(new GraphNode<>(value));
        });
        for (int fromNodeIndex = 0;
                fromNodeIndex < adjacencyMatrix.length;
                fromNodeIndex++) {
            for (int toNodeIndex = 0;
                    toNodeIndex < adjacencyMatrix.length;
                    toNodeIndex++) {

                GraphNode<T> fromNode = graphNodes.get(fromNodeIndex);
                GraphNode<T> toNode = graphNodes.get(toNodeIndex);

                if (adjacencyMatrix[fromNodeIndex][toNodeIndex]) {
                    fromNode.addNeighbour(toNode, Direction.OUTWARD);
                    toNode.addNeighbour(fromNode, Direction.INWARD);
                }
            }
        }
        return new HashSet<>(graphNodes);
    }
}
