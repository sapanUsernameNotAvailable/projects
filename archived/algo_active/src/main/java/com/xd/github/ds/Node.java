package com.xd.github.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Node<T> {

     T data;
     
     private final Type type;
     private enum Type {
          BINARY, MULTI
     };

     List<Node<T>> neighbours;

     Node<T> left;
     Node<T> right;

     public Node(T data) {
          this.data = data;
          this.neighbours = new ArrayList<>();
          type = Type.MULTI;
     }
     
     public Node(T data, List<Node<T>> neighbours) {
          this.data = data;
          this.neighbours = new ArrayList<>(neighbours);
          type = Type.MULTI;
     }

     public Node(T data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
          type = Type.BINARY;
     }

     public T getData() {
          return data;
     }

     public void setData(T data) {
          this.data = data;
     }

     public Node<T> getLeft() {
          if (!type.equals(Type.BINARY)) throw new UnsupportedOperationException();
          return left;
     }

     public Node<T> getRight() {
          if (!type.equals(Type.BINARY)) throw new UnsupportedOperationException();
          return right;
     }

     public List<Node<T>> getNeighbours() {
          if (!type.equals(Type.MULTI)) throw new UnsupportedOperationException();
          return neighbours;
     }

     @Override
     public String toString() {
          return "Node{" + "data=" + data + '}';
     }

     @Override
     public int hashCode() {
          int hash = 7;
          hash = 71 * hash + Objects.hashCode(this.data);
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
          final Node<?> other = (Node<?>) obj;
          if (!Objects.equals(this.data, other.data)) {
               return false;
          }
          return true;
     }
}
