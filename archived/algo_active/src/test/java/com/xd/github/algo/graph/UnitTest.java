package com.xd.github.algo.graph;

import com.xd.github.ds.GraphNode;
import com.xd.github.ds.factory.GraphFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import junit.framework.Assert;
import org.junit.Test;

public class UnitTest {
    
    private final GraphFactory graphFactory = new GraphFactory();
    private final TopologicalSorter topologicalSorter = new TopologicalSorter();
    
    @Test
    public void testSampleGraphRun() {
        getBigSampleGraph();
    }
    
    @Test
    public void testSampleTopologicalSort() {
        List<Set<GraphNode<Integer>>> sortedGraph = topologicalSorter.sort(getBigSampleGraph());
        
        Set<GraphNode<Integer>> firstLevelNodes = new HashSet<>();
        Stream.of(7, 5, 3).forEach(i -> {
            firstLevelNodes.add(new GraphNode<>(i));
        });
        Set<GraphNode<Integer>> secondLevelNodes = new HashSet<>();
        Stream.of(11, 8).forEach(i -> {
            secondLevelNodes.add(new GraphNode<>(i));
        });
        Set<GraphNode<Integer>> thirdLevelNodes = new HashSet<>();
        Stream.of(2, 9, 10).forEach(i -> {
            thirdLevelNodes.add(new GraphNode<>(i));
        });
        List<Set<GraphNode<Integer>>> expectedGraph = new ArrayList<>(Arrays.asList(firstLevelNodes, secondLevelNodes, thirdLevelNodes));
        Assert.assertEquals(expectedGraph, sortedGraph);
    }

    /**
     * see https://en.wikipedia.org/wiki/Topological_sorting date 7 july 2015
     *
     * @return
     */
    private Set<GraphNode<Integer>> getBigSampleGraph() {
        int numberOfNodes = 8;
        Integer[] nodeValues = new Integer[]{7, 5, 3, 11, 8, 2, 9, 10};
        boolean[][] adjacencyMatrix = new boolean[][]{
            // 7     5       3      11    8     2       9       10
            {false, false, false, true, true, false, false, false,},// 7
            {false, false, false, true, false, false, false, false,},// 5
            {false, false, false, false, true, false, false, true,},// 3
            {false, false, false, false, false, true, true, true,},// 11
            {false, false, false, false, false, false, true, false,},// 8
            {false, false, false, false, false, false, false, false,},// 2
            {false, false, false, false, false, false, false, false,},// 9
            {false, false, false, false, false, false, false, false,}// 10
        };
        return graphFactory.getGraphFromAdjacencyMatrix(numberOfNodes, nodeValues, adjacencyMatrix);
    }
}
