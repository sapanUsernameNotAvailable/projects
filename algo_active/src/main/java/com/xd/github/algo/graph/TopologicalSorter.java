package com.xd.github.algo.graph;

import com.xd.github.ds.GraphNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopologicalSorter {

    /**
     * Sorts topologically
     * 
     * @param <T>
     * @param graphNodes see https://en.wikipedia.org/wiki/Topological_sorting 7 july 2015
     * https://en.wikipedia.org/wiki/File:Directed_acyclic_graph.png
     * @return sorted graph. For above graph, returns
     *      {7, 5, 3} {11,8} {2, 9, 10} 
     */
    public final <T> List<Set<GraphNode<T>>> sort(Set<GraphNode<T>> graphNodes) {
        
        List<Set<GraphNode<T>>> topologicallySortedResult = new ArrayList<>();
        
        Set<GraphNode<T>> independentNodes = getIndependentNodes(graphNodes);
        topologicallySortedResult.add(independentNodes);
        
        while (!graphNodes.isEmpty()) {
            independentNodes = removeOldIndependentNodesAndGetNewOnes(graphNodes, independentNodes);
            if (independentNodes.isEmpty()) {
                break;
            }
            topologicallySortedResult.add(independentNodes);
        }
        
        return topologicallySortedResult;
    }
    
    private <T> Set<GraphNode<T>> getIndependentNodes(Set<GraphNode<T>> graphNodes) {
        Set<GraphNode<T>> result = new HashSet<>();
        for (GraphNode<T> node : graphNodes) {
            if (node.hasNoIncomingDirection()) {
                result.add(node);
            }
        }
        return result;
    }
    
    private <T> Set<GraphNode<T>> removeOldIndependentNodesAndGetNewOnes(Set<GraphNode<T>> graphNodes, Set<GraphNode<T>> independentNodes) {
        Set<GraphNode<T>> independentNodeNeighbours = new HashSet<>();
        for (GraphNode<T> independentNode : independentNodes) {
            independentNodeNeighbours.addAll(independentNode.getNeighbours());
        }
        removeNodes(graphNodes, independentNodes);
        Set<GraphNode<T>> newIndependentNodes = new HashSet<>();
        for (GraphNode<T> independentNode : independentNodeNeighbours) {
            if (independentNode.hasNoIncomingDirection()) {
                newIndependentNodes.add(independentNode);
            }
        }
        return newIndependentNodes;
    }
    
    
    private <T> void removeNodes(Set<GraphNode<T>> graphNodes, Set<GraphNode<T>> nodesToRemove) {
        // 1. remove from graph set
        // 2. remove from neighbour refrences.
        graphNodes.removeAll(nodesToRemove);
        for (GraphNode<T> nodeToRemove : nodesToRemove) {
            for (GraphNode<T> neighbour : nodeToRemove.getNeighbours()) {
                neighbour.removeNeighbour(nodeToRemove);
            }
        }
    }
}