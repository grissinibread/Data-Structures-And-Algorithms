package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeightedGraph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        Node from;
        Node to;
        int weight;

        public Edge(Node from, Node to, Integer weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "-->" + to;
        }
    }

    private HashMap<String, Node> nodes = new HashMap<>();
    private HashMap<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if(fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if(toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }
}
