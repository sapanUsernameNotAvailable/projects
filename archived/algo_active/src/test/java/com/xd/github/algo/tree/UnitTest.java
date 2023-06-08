package com.xd.github.algo.tree;

import com.xd.github.algo.graph.Traverser;
import com.xd.github.ds.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

     private static final Traverser traverser = new Traverser();

     @Test
     public void bfsTest() {
          List<Node<String>> output = traverser.bfsTraverse(getGraph());
          List<Node<String>> expected = new ArrayList<>(Arrays.asList(new Node<>("a"), new Node<>("b"),
                  new Node<>("c"), new Node<>("d"),
                  new Node<>("e"), new Node<>("f"),
                  new Node<>("g"), new Node<>("h")));
          Assert.assertEquals(expected,output);
     }
     
     @Test
     public void dfsTest() {
          List<Node<String>> output = traverser.dfsTraverse(getGraph());
          List<Node<String>> expected = new ArrayList<>(Arrays.asList(new Node<>("a"), new Node<>("b"),
                  new Node<>("d"), new Node<>("e"),
                  new Node<>("h"), new Node<>("c"),
                  new Node<>("f"), new Node<>("g")));
          Assert.assertEquals(expected,output);
     }
     
     
     @Test
     public void inOrderTest() {
          List<Node<String>> output = traverser.inOrder(getTree());
          List<Node<String>> expected = new ArrayList<>(Arrays.asList(new Node<>("d"), new Node<>("b"),
                  new Node<>("h"), new Node<>("e"),
                  new Node<>("a"), new Node<>("f"),
                  new Node<>("c"), new Node<>("g")));
          Assert.assertEquals(expected,output);
     }

     @Test
     public void postOrderTest() {
          List<Node<String>> output = traverser.postOrder(getTree());
          List<Node<String>> expected = new ArrayList<>(Arrays.asList(new Node<>("d"), new Node<>("h"),
                  new Node<>("e"), new Node<>("b"),
                  new Node<>("f"), new Node<>("g"),
                  new Node<>("c"), new Node<>("a")));
          Assert.assertEquals(expected,output);
     }

     /**
      * Returns graph<br/>
      *
      *      a
      *     / \
      *    b   c
      *   /|   |\
      *  d e   f g
      *   /
      *  h
      * 
      * @return graph
      */
     private Node<String> getGraph() {

          // eg. TLRRL : start from THE root then move left, right, right, left
          // left subTree
          final Node<String> TLL = new Node("d");
          final Node<String> TLRL = new Node("h");
          final Node<String> TLR = new Node("e", Arrays.asList(TLRL));
          final Node<String> TL = new Node("b", Arrays.asList(TLL, TLR));

          // right subTree
          final Node<String> TRL = new Node("f");
          final Node<String> TRR = new Node("g");
          final Node<String> TR = new Node("c", Arrays.asList(TRL, TRR));

          // root
          final Node<String> T = new Node("a", Arrays.asList(TL, TR));

          return T;
     }
     
     /**
      * Returns tree<br/>
      *
      *      a
      *     / \
      *    b   c
      *   /|   |\
      *  d e   f g
      *   /
      *  h
      * 
      * @return tree
      */
     private Node<String> getTree() {

          // eg. TLRRL : start from THE root then move left, right, right, left
          // left subTree
          final Node<String> TLL = new Node("d", null, null);
          final Node<String> TLRL = new Node("h", null, null);
          final Node<String> TLR = new Node("e", TLRL, null);
          final Node<String> TL = new Node("b", TLL, TLR);

          // right subTree
          final Node<String> TRL = new Node("f", null, null);
          final Node<String> TRR = new Node("g", null, null);
          final Node<String> TR = new Node("c", TRL, TRR);

          // root
          final Node<String> T = new Node("a", TL, TR);

          return T;
     }
     
}
