package com.haoliang.algorithm.graph;

import java.util.*;

public class Graph02_AdjacencyList {
    public static class Vertex {
        public String data;
        public Edge head;

        public Vertex(String data) {
            this.data = data;
        }
    }

    public static class Edge {
        // 顶点索引
        public int vertexIndex;
        // 邻接顶点索引
        public int adjacencyVertexIndex;
        // 权重
        public int weight;
        // 下一条边
        public Edge next;

        public Edge(int vertexIndex, int adjacencyVertexIndex, int weight) {
            this.vertexIndex = vertexIndex;
            this.adjacencyVertexIndex = adjacencyVertexIndex;
            this.weight = weight;
        }
    }

    public static class Graph {
        // 顶点数
        public int vexNum;
        // 边数
        public int edgeNum;
        // 邻接表
        public List<Vertex> vertexList;

        public Graph(int vexNum, int edgeNum) {
            this.vexNum = vexNum;
            this.edgeNum = edgeNum;
            this.vertexList = new ArrayList<>();
        }

        public void addVertex(Vertex vertex) {
            this.vertexList.add(vertex);
        }

        public void addEdge(Edge edge) {
            int vertexIndex = edge.vertexIndex;
            int adjacencyVertexIndex = edge.adjacencyVertexIndex;
            Vertex vertex = this.vertexList.get(vertexIndex);
            Vertex adjacencyVertex = this.vertexList.get(adjacencyVertexIndex);

            edge.next = vertex.head;
            vertex.head = edge;

            Edge nextEdge = new Edge(adjacencyVertexIndex, vertexIndex, 1);
            nextEdge.next = adjacencyVertex.head;
            adjacencyVertex.head = nextEdge;
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(9, 15);
        // 初始化顶点
        graph.addVertex(new Vertex("A"));
        graph.addVertex(new Vertex("B"));
        graph.addVertex(new Vertex("C"));
        graph.addVertex(new Vertex("D"));
        graph.addVertex(new Vertex("E"));
        graph.addVertex(new Vertex("F"));
        graph.addVertex(new Vertex("G"));
        graph.addVertex(new Vertex("H"));
        graph.addVertex(new Vertex("I"));
        // 初始化边
        graph.addEdge(new Edge(0, 1, 1));
        graph.addEdge(new Edge(0, 5, 1));
        graph.addEdge(new Edge(1, 2, 1));
        graph.addEdge(new Edge(1, 6, 1));
        graph.addEdge(new Edge(1, 8, 1));
        graph.addEdge(new Edge(2, 3, 1));
        graph.addEdge(new Edge(2, 8, 1));
        graph.addEdge(new Edge(3, 4, 1));
        graph.addEdge(new Edge(3, 6, 1));
        graph.addEdge(new Edge(3, 7, 1));
        graph.addEdge(new Edge(3, 8, 1));
        graph.addEdge(new Edge(4, 7, 1));
        graph.addEdge(new Edge(4, 5, 1));
        graph.addEdge(new Edge(5, 6, 1));
        graph.addEdge(new Edge(6, 7, 1));

    }
}
