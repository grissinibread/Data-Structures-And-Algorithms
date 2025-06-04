import graphs.Graph;
import heaps.Heap;
import heaps.MaxHeap;
import tries.Trie;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode("Booty");
        graph.addNode("Cheeks");
        graph.addNode("on");
        graph.addNode("a");
        graph.addNode("Cob");

        graph.addEdge("Booty", "Cheeks");
        graph.addEdge("Booty", "on");
        graph.addEdge("Booty", "a");
        graph.addEdge("Booty", "Cob");

        graph.traverseDepthFirst("Booty");

        graph.print();
    }
}