package com.haoliang.algorithm.graph;

import java.util.*;

public class Graph03_AdjacencyMatrix {
    public static class Graph {
        // 顶点数
        public int vertexNum;
        // 边数
        public int edgeNum;
        // 顶点表
        public List<String> vertexList;
        // 邻接矩阵
        public int[][] adjacencyMatrix;

        public Graph(int vertexNum, int edgeNum) {
            this.vertexNum = vertexNum;
            this.edgeNum = edgeNum;
            this.vertexList = new ArrayList<>(vertexNum);
            this.adjacencyMatrix = new int[vertexNum][vertexNum];
        }

        public void addVertex(String vertex) {
            this.vertexList.add(vertex);
        }

        public void addEdge(int vexIndex, int adjacencyVexIndex, int weight) {
            this.adjacencyMatrix[vexIndex][adjacencyVexIndex] = weight;
            this.adjacencyMatrix[adjacencyVexIndex][vexIndex] = weight;
        }
    }

    public static void main(String[] args) {
        // 9个顶点，15条边
        Graph graph = new Graph(9, 15);
        // 初始化顶点
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        // 初始化边
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 5, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 6, 1);
        graph.addEdge(1, 8, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 8, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 6, 1);
        graph.addEdge(3, 7, 1);
        graph.addEdge(3, 8, 1);
        graph.addEdge(4, 5, 1);
        graph.addEdge(4, 7, 1);
        graph.addEdge(5, 6, 1);
        graph.addEdge(6, 7, 1);
    }
}
