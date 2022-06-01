package com.haoliang.course.junior.chap06;

public class GraphGenerator {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0}
        };
        Graph graph = createGraph(matrix);
        System.out.println(graph.edges.size());
        System.out.println(graph.nodes.size());
    }

    public static Graph createGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

}
