package com.haoliang.algorithm.graph;

import java.util.*;

public class Graph01_GraphLearn {
    public static class Node {
        public String value;
        public int in;
        public int out;
        public List<Node> nextList;
        public List<Edge> edgeList;
    }
    public static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public static class Graph {
        public Map<Integer, Node> nodeMap;
        public Set<Edge> edgeSet;

        public Graph() {
            nodeMap = new HashMap<>();
            edgeSet = new HashSet<>();
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph();

    }
}
