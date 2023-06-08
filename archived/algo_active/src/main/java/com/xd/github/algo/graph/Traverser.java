package com.xd.github.algo.graph;

import com.xd.github.ds.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Traverser {

    // aka level-order traversal
     public <T> List<Node<T>> bfsTraverse(final Node<T> rootNode) {

          final List<Node<T>> resultList = new ArrayList<>();
          final List<Node<T>> processQueue = new ArrayList<>(Arrays.asList(rootNode));

          while (!processQueue.isEmpty()) {
               final Node processNode = processQueue.remove(0);
               resultList.add(processNode);
               processQueue.addAll(processNode.getNeighbours());
          }

          return resultList;
     }

     public <T> List<Node<T>> dfsTraverse(final Node<T> rootNode) {

          // base case
          if (rootNode.getNeighbours().isEmpty()) {
               return new ArrayList<>(Arrays.asList(rootNode));
          }

          // recursion
          final List<Node<T>> result = new ArrayList<>(Arrays.asList(rootNode));
          for (Node neighbour : rootNode.getNeighbours()) {
               result.addAll(dfsTraverse(neighbour));
          }

          return result;
     }

     public <T> List<Node<T>> inOrder(Node<T> root) {
          
          List<Node<T>> result = new ArrayList<>();
          
          Node<T> left = root.getLeft();
          if (left != null) {
               result.addAll(inOrder(left));
          }
          
          result.add(root);
          
          Node<T> right = root.getRight();
          if (right != null) {
               result.addAll(inOrder(right));
          }
          return result;
     }

     public <T> List<Node<T>> postOrder(Node<T> root) {
          
          List<Node<T>> result = new ArrayList<>();
          
          Node<T> left = root.getLeft();
          if (left != null) {
               result.addAll(postOrder(left));
          }
          
          Node<T> right = root.getRight();
          if (right != null) {
               result.addAll(postOrder(right));
          }

          result.add(root);

          return result;
     }

}